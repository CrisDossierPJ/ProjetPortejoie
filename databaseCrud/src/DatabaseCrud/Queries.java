/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseCrud;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.Vector;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 *
 * @author attiac
 */
public class Queries {

    //Creating the object of Queries
    //Initialization of the variables
    Connection connexion = null;
    Statement state = null;
    ResultSet resultSet = null;
    private Object[][] datatab;
    String err = "";
    private String[] colname;
    ResourceBundle bundle = ResourceBundle.getBundle("domaine.properties.config");
    String nomBdd = bundle.getString("bdd.name");
    String identifiant = bundle.getString("bdd.login");
    String pass = bundle.getString("bdd.password");
    String histoReq = "<ul>";

    public Object[][] getDatatab() {
        return datatab;
    }

    public String[] getColname() {
        return colname;
    }

    public Queries() {

        //Connection at the database
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Le pilote JDBC MySQL a été chargé");
            connexion = DriverManager.getConnection("jdbc:mysql://localhost/" + nomBdd, identifiant, pass);

        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * The function RandomRequest is applying a SQL query
     *
     * @param dbName
     * @param sqlRequest
     * @return html <table> </table>
     * @throws SQLException
     */
    public String getErr() {
        return err;
    }

    public void miseEnPlace() throws SQLException {
        connexion = DriverManager.getConnection("jdbc:mysql://localhost/", identifiant, pass);

        PreparedStatement creationdatabase = connexion.prepareStatement("CREATE DATABASE IF NOT EXISTS `" + nomBdd + "` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci");

        creationdatabase.executeUpdate();
        connexion = DriverManager.getConnection("jdbc:mysql://localhost/" + nomBdd, identifiant, pass);
        PreparedStatement stmt = connexion.prepareStatement(
                "CREATE TABLE IF NOT EXISTS `employe` ( `NumEmploye` int(11) NOT NULL AUTO_INCREMENT, `nomEmploye` varchar(100) NOT NULL, `addressEmploye` varchar(255) NOT NULL, `SuburbEmploye` varchar(255) NOT NULL, `StateEmploye` varchar(255) NOT NULL, `CodePostEmploye` int(11) NOT NULL, `AnneNaissEmploy` int(11) NOT NULL, `NumMaisEmploye` int(11) NOT NULL, `numTravEmploye` int(11) NOT NULL, `numPortabEmploye` int(11) NOT NULL, `EmailEmploye` varchar(100) NOT NULL, PRIMARY KEY (`NumEmploye`) ) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=128 ;"
        );

        stmt.executeUpdate();
        if (reqSelect(nomBdd, "employe") == null) {
            PreparedStatement remplissageTable = connexion.prepareStatement("INSERT INTO `employe`(`nomEmploye`, `addressEmploye`, `SuburbEmploye`, `StateEmploye`, `CodePostEmploye`, `AnneNaissEmploy`, `NumMaisEmploye`, `numTravEmploye`, `numPortabEmploye`, `EmailEmploye`) VALUES ('Test','Test','Test','Lyon',69008,1996,0761585776,0761585776,0761585776,'employe@Test.com')"
            );
            remplissageTable.executeUpdate();
        }

    }

    public String randomRequest(String dbName, String sqlRequest, String tableName) throws SQLException, IOException {

        connexion = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, identifiant, pass);
        PreparedStatement stmt = connexion.prepareStatement(sqlRequest);

        //err = "";
        String[] tab = sqlRequest.split(" ");
        histoReq += "<li>" + sqlRequest;
        if ("SELECT".equals(tab[0]) || "select".equals(tab[0])) {

            resultSet = stmt.executeQuery();

            ResultSetMetaData resultMeta = resultSet.getMetaData();
            String[] Response = new String[resultMeta.getColumnCount()];
            //Object data[][] = new Object[getResultSet()][][];
            Vector<Object[]> datas = new Vector();
            Object test[] = null;

            /* err += "<h1 style=\"color:red;\">" + sqlRequest + "</h1>";
            err += "<h2> Historique : </h2>" + histoReq + "</ul";
            err += "<table border=\"1\">";
            err = err + "<tr>";*/
            //System.out.println(getResultSet());
            for (int k = 1; k < resultMeta.getColumnCount() + 1; k++) {
                //  err = err + "<td style=\"background-color: yellow\">" + resultMeta.getColumnName(k) + "</td>";
                Response[k - 1] = resultMeta.getColumnName(k);
            }
            // err = err + "</tr>";

            while (resultSet.next() == true) {
                Object[] tempdata = new Object[resultMeta.getColumnCount()];
                //  err = err + "<tr>";
                for (int j = 1; j < resultMeta.getColumnCount() + 1; j++) {
                    //  err = err + "<td>" + resultSet.getObject(j).toString() + "</td>";
                    tempdata[j - 1] = resultSet.getObject(j).toString();

                }
                //  err = err + "</tr>";
                datas.add(tempdata);
            }

            datatab = datas.toArray(new Object[datas.size()][]);
            colname = Response;
            //   err += "</table>";

        } else {
            stmt.executeUpdate(sqlRequest);
        }
        //generateHtmlFile(err);
        if ("".equals(tableName)) {
            return null;
        } else {
            return createTableHtml(dbName, tableName);

        }

    }

    public String createTableHtml(String dbName, String tableName) throws SQLException {

        String sqlRequest = "SELECT * FROM " + tableName;
        connexion = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, identifiant, pass);
        PreparedStatement stmt = connexion.prepareStatement(sqlRequest);

        err = " <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">"
                + "<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script><script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script><script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>"
                + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">"
                + "<div class=\"col-xs-8\">"
                + "<div class=\"table-responsive\">"
                + "<table class = \"table table-hover table-dark\">";
        String[] tab = sqlRequest.split(" ");
        resultSet = stmt.executeQuery();

        ResultSetMetaData resultMeta = resultSet.getMetaData();
        String[] Response = new String[resultMeta.getColumnCount()];
        //Object data[][] = new Object[getResultSet()][][];
        Vector<Object[]> datas = new Vector();
        Object test[] = null;

        // histoReq += "<li>" + sqlRequest;
        err += "<h1 style=\"color:red;\">" + sqlRequest + "</h1>";
        err += "<h2> Historique : </h2>" + histoReq;
        //  err += "<table border=\"1\">";
        err = err + "<tr>"
                + "<thead>";
        //System.out.println(getResultSet());
        for (int k = 1; k < resultMeta.getColumnCount() + 1; k++) {
            err = err + "<th scope = \"col\">" + resultMeta.getColumnName(k) + "</td>";
            Response[k - 1] = resultMeta.getColumnName(k);
        }
        err += "</thead>";
        err = err + "</tr>";
        err += "<tbody>";

        while (resultSet.next() == true) {
            Object[] tempdata = new Object[resultMeta.getColumnCount()];
            err = err + "<tr>";
            for (int j = 1; j < resultMeta.getColumnCount() + 1; j++) {
                err = err + "<td>" + resultSet.getObject(j).toString() + "</td>";
                tempdata[j - 1] = resultSet.getObject(j).toString();

            }
            err = err + "</tr>";
            datas.add(tempdata);
        }

        datatab = datas.toArray(new Object[datas.size()][]);
        colname = Response;
        err += "</tbody>";
        err += "</table>";

        return err;
    }

    public String generateHtmlFile(String content) throws IOException {
        Document doc = Jsoup.parse(content);

        String str = doc.toString();
        // byte data[] = str;
        /* BufferedWriter writer = new BufferedWriter(new FileWriter("reponseRequete.html"));
        writer.writer.write(str);
        writer.close();*/
        System.out.println(err);
        File file = new File("reponseRequete.html");
        /* if (file.exists()) {
            //System.out.println("SALUT");
            file.delete();
        }*/

        file.createNewFile();
        PrintWriter writer = new PrintWriter(file);
        writer.print("");
        //writer.println(str);
        writer.print(str);
        writer.close();

        return file.getAbsolutePath();

    }

    public String reqSelect(String dbName, String tableName) throws SQLException {
        connexion = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, identifiant, pass);
        PreparedStatement stmt = connexion.prepareStatement("SELECT * FROM " + tableName);
        resultSet = stmt.executeQuery();
        ResultSetMetaData resultMeta = resultSet.getMetaData();
        String nomCol = "";

        while (resultSet.next()) {
            for (int i = 1; i < resultMeta.getColumnCount() + 1; i++) {

                nomCol = nomCol + resultMeta.getColumnName(i) + ",";

            }
            nomCol = nomCol.substring(0, nomCol.length() - 1);
            String req = "SELECT " + nomCol + " FROM " + tableName + " WHERE 1";
            System.out.println(req);
            return req;
        }
        return null;

    }

    public String reqUpdate(String dbName, String tableName) throws SQLException {
        connexion = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, identifiant, pass);
        PreparedStatement stmt = connexion.prepareStatement("SELECT * FROM " + tableName);
        resultSet = stmt.executeQuery();
        ResultSetMetaData resultMeta = resultSet.getMetaData();
        String nomCol = "";
        while (resultSet.next()) {
            for (int i = 1; i < resultMeta.getColumnCount() + 1; i++) {

                nomCol = nomCol + resultMeta.getColumnName(i) + "=[value-" + i + "],";

            }
            nomCol = nomCol.substring(0, nomCol.length() - 1);
            String req = "UPDATE " + tableName + " SET " + nomCol;
            System.out.println(req);
            return req;
        }
        return null;
    }

    public String reqSelectAll(String tableName) throws SQLException {

        String req = "SELECT * FROM " + tableName;

        return req;
    }

    public String reqDelete(String tableName) {
        String req = "DELETE FROM " + tableName + " WHERE 1";
        return req;
    }

    public String reqInsert(String dbName, String tableName) throws SQLException {
        connexion = DriverManager.getConnection("jdbc:mysql://localhost/" + dbName, identifiant, pass);
        PreparedStatement stmt = connexion.prepareStatement("SELECT * FROM " + tableName);
        System.out.println("Salut");
        resultSet = stmt.executeQuery();
        ResultSetMetaData resultMeta = resultSet.getMetaData();
        String nomCol = "";
        String values = "";
        while (resultSet.next()) {
            for (int i = 1; i < resultMeta.getColumnCount() + 1; i++) {
                nomCol = nomCol + resultMeta.getColumnName(i) + ",";
                values = values + "[value-" + i + "],";

            }
            nomCol = nomCol.substring(0, nomCol.length() - 1);
            values = values.substring(0, values.length() - 1);
            String req = "INSERT INTO " + tableName + "( " + nomCol + ") VALUES (" + values + ")";
            System.out.println(req);
            return req;

        }

        return null;

    }

    /**
     *
     * @param Emploi
     * @throws SQLException
     */
    public void add(Employee Emploi) throws SQLException {
        Statement statement = connexion.createStatement();
        System.out.println(Emploi.getNbEmployee());
        statement.executeUpdate("INSERT INTO `" + nomBdd + "`.`employe` "
                + "(`nomEmploye`, `addressEmploye`, `SuburbEmploye`, `StateEmploye`, `CodePostEmploye`, `AnneNaissEmploy`, "
                + "`NumMaisEmploye`, `numTravEmploye`, `numPortabEmploye`, `EmailEmploye`) "
                + "VALUES ('" + Emploi.getNomEmployee() + "', '" + Emploi.getAddEmployee() + "',"
                + " '" + Emploi.getSuburb() + "', '" + Emploi.getState() + "', '" + Emploi.getPostCode() + "', '" + Emploi.getAnneeNaiss() + "',"
                + " '" + Emploi.getNumMais() + "', '" + Emploi.getNumTrav() + "', '" + Emploi.getNumPort() + "', '" + Emploi.getEmail() + "');");
        statement.close();
        connexion.close();
    }

    /**
     *
     * @param Emploi
     * @param Entree
     * @return
     * @throws SQLException
     */
    public HashMap<String, String> retrieve(Employee Emploi, String Entree) throws SQLException {
        HashMap<String, String> map = new HashMap();
        Statement statement = connexion.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM `" + nomBdd + "`.`employe` WHERE `" + Entree + "` =" + Emploi.getNbEmployee());

        // loop through the result set
        while (rs.next()) {
            map.put("NumEmploye", "" + rs.getString("NumEmploye"));
            map.put("nomEmploye", rs.getString("nomEmploye"));
            map.put("addressEmploye", rs.getString("addressEmploye"));
            map.put("SuburbEmploye", rs.getString("SuburbEmploye"));
            map.put("StateEmploye", rs.getString("StateEmploye"));
            map.put("CodePostEmploye", rs.getString("CodePostEmploye"));
            map.put("AnneNaissEmploy", rs.getString("AnneNaissEmploy"));
            map.put("NumMaisEmploye", rs.getString("NumMaisEmploye"));
            map.put("numTravEmploye", rs.getString("numTravEmploye"));
            map.put("numPortabEmploye", rs.getString("numPortabEmploye"));
            map.put("EmailEmploye", rs.getString("EmailEmploye"));
        }
        //System.out.println(map);
        statement.close();
        //connexion.close();
        return map;
    }

    /**
     *
     * @param Emploi
     * @throws SQLException
     */
    public void delete(Employee Emploi) throws SQLException {
        Statement statement = connexion.createStatement();
        statement.executeUpdate("DELETE FROM `" + nomBdd + "`.`employe` WHERE `NumEmploye` =" + Emploi.getNbEmployee() + ";");
        statement.close();
        connexion.close();
    }

    /**
     *
     * @param Emploi
     * @throws SQLException
     */
    public void update(Employee Emploi) throws SQLException {
        Statement statement = connexion.createStatement();
        String RequSQL = "UPDATE `employe` SET `nomEmploye`='" + Emploi.getNomEmployee() + "',"
                + "`addressEmploye`='" + Emploi.getAddEmployee() + "',`SuburbEmploye`='" + Emploi.getSuburb() + "',"
                + "`StateEmploye`='" + Emploi.getState() + "',`CodePostEmploye`='" + Emploi.getPostCode() + "',`AnneNaissEmploy`='" + Emploi.getAnneeNaiss() + "',"
                + "`NumMaisEmploye`='" + Emploi.getNumMais() + "',`numTravEmploye`='" + Emploi.getNumTrav() + "',"
                + "`numPortabEmploye`='" + Emploi.getNumPort() + "',`EmailEmploye`='" + Emploi.getEmail() + "' WHERE `NumEmploye` ='" + Emploi.getNbEmployee() + "'";

        System.out.println(RequSQL);
        statement.executeUpdate(RequSQL);
        /*statement.executeUpdate("UPDATE `employe` SET `nomEmploye`=\"[value-2]\",`addressEmploye`=\"[value-3]\",`SuburbEmploye`=\"[value-4]\",`StateEmploye`=\"[value-5]\",`CodePostEmploye`=666,`AnneNaissEmploy`=777,`NumMaisEmploye`=888,`numTravEmploye`=999,`numPortabEmploye`=1010,`EmailEmploye`=\"[value-11]\" WHERE `NumEmploye`=45");*/
        statement.close();
        connexion.close();
    }

}
