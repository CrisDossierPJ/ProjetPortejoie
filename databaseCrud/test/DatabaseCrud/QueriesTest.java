/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseCrud;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author attiac
 */
public class QueriesTest {

    public QueriesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDatatab method, of class Queries.
     */
    /**
     * Test of randomRequest method, of class Queries.
     */
    @Test
    public void testRandomRequest() throws Exception {
        System.out.println("randomRequest");
        String dbName = "databaseCrud";
        String sqlRequest = "SELECT * FROM employe";
        String tableName = "employe";
        Queries instance = new Queries();
        String expResult = "<h1 style=\"color:red;\">SELECT * FROM employe</h1><h2> Historique : </h2><ul><li>SELECT * FROM<table border=\"1\"><tr><td style=\"background-color: yellow\">NumEmploye</td><td style=\"background-color: yellow\">nomEmploye</td><td style=\"background-color: yellow\">addressEmploye</td><td style=\"background-color: yellow\">SuburbEmploye</td><td style=\"background-color: yellow\">StateEmploye</td><td style=\"background-color: yellow\">CodePostEmploye</td><td style=\"background-color: yellow\">AnneNaissEmploy</td><td style=\"background-color: yellow\">NumMaisEmploye</td><td style=\"background-color: yellow\">numTravEmploye</td><td style=\"background-color: yellow\">numPortabEmploye</td><td style=\"background-color: yellow\">EmailEmploye</td></tr></table>";
        String result = instance.randomRequest(dbName, sqlRequest, tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createTableHtml method, of class Queries.
     */
    @Test
    public void testCreateTableHtml() throws Exception {
        System.out.println("createTableHtml");
        String dbName = "databaseCrud";
        String tableName = "employe";
        Queries instance = new Queries();
        String expResult = "<h1 style=\"color:red;\">SELECT * FROM employe</h1><h2> Historique : </h2><ul><li>SELECT * FROM<table border=\"1\"><tr><td style=\"background-color: yellow\">NumEmploye</td><td style=\"background-color: yellow\">nomEmploye</td><td style=\"background-color: yellow\">addressEmploye</td><td style=\"background-color: yellow\">SuburbEmploye</td><td style=\"background-color: yellow\">StateEmploye</td><td style=\"background-color: yellow\">CodePostEmploye</td><td style=\"background-color: yellow\">AnneNaissEmploy</td><td style=\"background-color: yellow\">NumMaisEmploye</td><td style=\"background-color: yellow\">numTravEmploye</td><td style=\"background-color: yellow\">numPortabEmploye</td><td style=\"background-color: yellow\">EmailEmploye</td></tr></table>";
        String result = instance.createTableHtml(dbName, tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //  fail("The test case is a prototype.");
    }

    /**
     * Test of generateHtmlFile method, of class Queries.
     */
    @Test
    public void testGenerateHtmlFile() throws Exception {
        System.out.println("generateHtmlFile");
        String content = "test";
        Queries instance = new Queries();
        String expResult = "C:\\Users\\attiac\\Documents\\NetBeansProjects\\FEZZ\\reponseRequete.html";
        String result = instance.generateHtmlFile(content);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of reqSelect method, of class Queries.
     */
    @Test
    public void testReqSelect() throws Exception {
        System.out.println("reqSelect");
        String dbName = "databaseCrud";
        String tableName = "employe";
        Queries instance = new Queries();
        String expResult = "SELECT NumEmploye,nomEmploye,addressEmploye,SuburbEmploye,StateEmploye,CodePostEmploye,AnneNaissEmploy,NumMaisEmploye,numTravEmploye,numPortabEmploye,EmailEmploye FROM employe WHERE 1";
        String result = instance.reqSelect(dbName, tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of reqUpdate method, of class Queries.
     */
    @Test
    public void testReqUpdate() throws Exception {
        System.out.println("reqUpdate");
        String dbName = "databaseCrud";
        String tableName = "employe";
        Queries instance = new Queries();
        String expResult = "UPDATE employe SET NumEmploye=[value-1],nomEmploye=[value-2],addressEmploye=[value-3],SuburbEmploye=[value-4],StateEmploye=[value-5],CodePostEmploye=[value-6],AnneNaissEmploy=[value-7],NumMaisEmploye=[value-8],numTravEmploye=[value-9],numPortabEmploye=[value-10],EmailEmploye=[value-11]";
        String result = instance.reqUpdate(dbName, tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of reqSelectAll method, of class Queries.
     */
    @Test
    public void testReqSelectAll() throws Exception {
        System.out.println("reqSelectAll");
        String tableName = "employe";
        Queries instance = new Queries();
        String expResult = "SELECT * FROM employe";
        String result = instance.reqSelectAll(tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of reqDelete method, of class Queries.
     */
    @Test
    public void testReqDelete() {
        System.out.println("reqDelete");
        String tableName = "employe";
        Queries instance = new Queries();
        String expResult = "DELETE FROM employe WHERE 1";
        String result = instance.reqDelete(tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of reqInsert method, of class Queries.
     */
    @Test
    public void testReqInsert() throws Exception {
        System.out.println("reqInsert");
        String dbName = "databaseCrud";
        String tableName = "employe";
        Queries instance = new Queries();
        String expResult = "INSERT INTO employe( NumEmploye,nomEmploye,addressEmploye,SuburbEmploye,StateEmploye,CodePostEmploye,AnneNaissEmploy,NumMaisEmploye,numTravEmploye,numPortabEmploye,EmailEmploye) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7],[value-8],[value-9],[value-10],[value-11])";
        String result = instance.reqInsert(dbName, tableName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        // fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Queries.
     *
     * @Test public void testAdd() throws Exception { System.out.println("add");
     * Employee Emploi = null; Queries instance = new Queries();
     * instance.add(Emploi); // TODO review the generated test code and remove
     * the default call to fail. fail("The test case is a prototype."); }
     */
    /**
     * Test of retrieve method, of class Queries.
     *
     * @Test public void testRetrieve() throws Exception {
     * System.out.println("retrieve"); Employee Emploi = null; String Entree =
     * ""; Queries instance = new Queries(); HashMap<String, String> expResult =
     * null; HashMap<String, String> result = instance.retrieve(Emploi, Entree);
     * assertEquals(expResult, result); // TODO review the generated test code
     * and remove the default call to fail. fail("The test case is a
     * prototype."); }
     */
    /**
     * Test of delete method, of class Queries.
     *
     * @Test public void testDelete() throws Exception {
     * System.out.println("delete"); Employee Emploi = null; Queries instance =
     * new Queries(); instance.delete(Emploi); // TODO review the generated test
     * code and remove the default call to fail. fail("The test case is a
     * prototype."); }
     */
    /**
     * Test of update method, of class Queries.
     *
     * @Test public void testUpdate() throws Exception {
     * System.out.println("update"); Employee Emploi = null; Queries instance =
     * new Queries(); instance.update(Emploi); // TODO review the generated test
     * code and remove the default call to fail. fail("The test case is a
     * prototype."); }
     */
}
