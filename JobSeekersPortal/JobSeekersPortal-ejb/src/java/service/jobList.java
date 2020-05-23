/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

/**
 * @author Ashwin Antony
 */
public class jobList {

    private int jobID;
    private String jobTitle;
    private String jobDescription;
    private double jobPay;
    private String jobStatus;
    private String addedUser;
    private String assignedEmail;

    /**
     * Get the value of jobPay
     *
     * @return the value of jobPay
     */
    public double getJobPay() {
        return jobPay;
    }

    /**
     * Set the value of jobPay
     *
     * @param jobPay new value of jobPay
     */
    public void setJobPay(double jobPay) {
        this.jobPay = jobPay;
    }

    /**
     * Get the value of jobDescription
     *
     * @return the value of jobDescription
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * Set the value of jobDescription
     *
     * @param jobDescription new value of jobDescription
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * Get the value of jobTitle
     *
     * @return the value of jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Set the value of jobTitle
     *
     * @param jobTitle new value of jobTitle
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Get the value of jobID
     *
     * @return the value of jobID
     */
    public int getJobID() {
        return jobID;
    }

    /**
     * Set the value of jobID
     *
     * @param jobID new value of jobID
     */
    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    /**
     * Get the value of jobStatus
     *
     * @return the value of jobStatus
     */
    public String getJobStatus() {
        return jobStatus;
    }

    /**
     * Set the value of jobStatus
     *
     * @param jobStatus new value of jobStatus
     */
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
    
    /**
     * Get the value of addedUser
     *
     * @return the value of addedUser
     */
    public String getAddedUser() {
        return addedUser;
    }

    /**
     * Set the value of addedUser
     *
     * @param addedUser new value of addedUser
     */
    public void setAddedUser(String addedUser) {
        this.addedUser = addedUser;
    }
    
    /**
     * Get the value of assignedEmail
     *
     * @return the value of assignedEmail
     */
    public String getAssignedEmail() {
        return assignedEmail;
    }

    /**
     * Set the value of assignedEmail
     *
     * @param assignedEmail new value of assignedEmail
     */
    public void setAssignedEmail(String assignedEmail) {
        this.assignedEmail = assignedEmail;
    }
}
