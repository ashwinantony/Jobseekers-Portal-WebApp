/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 *
 * @author Ashwin Antony
 */
public class freelancerInfo {

    private int userID;
    private String firstName;
    private String lastName;
    private String userEmail;
    private String skills;
    private String userMessage;
    private double accountBalance;

    /**
     * Get the value of accountBalance
     *
     * @return the value of accountBalance
     */
    public double getAccountBalance() {
        return accountBalance;
    }

    /**
     * Set the value of accountBalance
     *
     * @param accountBalance new value of accountBalance
     */
    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    /**
     * Get the value of userID
     *
     * @return the value of userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Set the value of userID
     *
     * @param userID new value of userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the value of userEmail
     *
     * @return the value of userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Set the value of userEmail
     *
     * @param userEmail new value of userEmail
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Get the value of skills
     *
     * @return the value of skills
     */
    public String getSkills() {
        return skills;
    }

    /**
     * Set the value of skills
     *
     * @param skills new value of skills
     */
    public void setSkills(String skills) {
        this.skills = skills;
    }

    /**
     * Get the value of userMessage
     *
     * @return the value of userMessage
     */
    public String getUserMessage() {
        return userMessage;
    }

    /**
     * Set the value of userMessage
     *
     * @param userMessage new value of userMessage
     */
    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
}
