/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseCrud;

/**
 *
 * @author attiac
 */
public class Employee {

    //Creating here a new Object 'Employee'
    //Initialisation of the variables
    int nbEmployee;
    String nomEmployee;
    String addEmployee;
    String suburb;
    String state;
    int postCode;
    String anneeNaiss;
    int numMais;
    int numTrav;
    int numPort;
    String email;

    /**
     *
     */
    public Employee() {
    }

    /**
     *
     * @param nbEmployee
     */
    public Employee(int nbEmployee) {
        this.nbEmployee = nbEmployee;
    }

    /**
     *
     * @param nomEmployee
     */
    public Employee(String nomEmployee) {
        this.nomEmployee = nomEmployee;
    }

    /**
     *
     * @param nbEmployee
     * @param nomEmployee
     * @param addEmployee
     * @param suburb
     * @param state
     * @param postCode
     * @param anneeNaiss
     * @param numMais
     * @param numTrav
     * @param numPort
     * @param email
     */
    public Employee(int nbEmployee, String nomEmployee, String addEmployee, String suburb, String state, int postCode, String anneeNaiss, int numMais, int numTrav, int numPort, String email) {
        this.nbEmployee = nbEmployee;
        this.nomEmployee = nomEmployee;
        this.addEmployee = addEmployee;
        this.suburb = suburb;
        this.state = state;
        this.postCode = postCode;
        this.anneeNaiss = anneeNaiss;
        this.numMais = numMais;
        this.numTrav = numTrav;
        this.numPort = numPort;
        this.email = email;
    }

    /**
     *
     * @return
     */
    public int getNbEmployee() {
        return nbEmployee;
    }

    public void setNbEmployee(int nbEmployee) {
        this.nbEmployee = nbEmployee;
    }

    /**
     *
     * @return
     */
    public String getNomEmployee() {
        return nomEmployee;
    }

    public void setNomEmployee(String nomEmployee) {
        this.nomEmployee = nomEmployee;
    }

    /**
     *
     * @return
     */
    public String getAddEmployee() {
        return addEmployee;
    }

    public void setAddEmployee(String addEmployee) {
        this.addEmployee = addEmployee;
    }

    /**
     *
     * @return
     */
    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public int getPostCode() {
        return postCode;
    }

    public void setPostCode(int postCode) {
        this.postCode = postCode;
    }

    /**
     *
     * @return
     */
    public String getAnneeNaiss() {
        return anneeNaiss;
    }

    public void setAnneeNaiss(String anneeNaiss) {
        this.anneeNaiss = anneeNaiss;
    }

    /**
     *
     * @return
     */
    public int getNumMais() {
        return numMais;
    }

    public void setNumMais(int numMais) {
        this.numMais = numMais;
    }

    /**
     *
     * @return
     */
    public int getNumTrav() {
        return numTrav;
    }

    public void setNumTrav(int numTrav) {
        this.numTrav = numTrav;
    }

    /**
     *
     * @return
     */
    public int getNumPort() {
        return numPort;
    }

    public void setNumPort(int numPort) {
        this.numPort = numPort;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
