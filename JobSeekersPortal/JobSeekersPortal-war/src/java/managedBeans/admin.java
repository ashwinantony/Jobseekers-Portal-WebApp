/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import service.*;

/**
 * @author Ashwin Antony
 */
@Named(value = "admin")
@RequestScoped

public class admin implements Serializable {

    @EJB
    methodsRemote methods;

    private int jobID;
    private int userID;
    private String userEmail;
    private String firstName;
    private String lastName;
    private String userPassword;
    private String userRole;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String addUser() {
        String pageType = methods.addNewUser(firstName, lastName, userEmail, userPassword, userRole);
        return pageType;
    }

    public List viewAllOpenJobs() {
        return methods.getAllOpenJobs();

    }

    public List viewAllClosedJobs() {
        return methods.getAllClosedJobs();

    }

    public List viewAllProviders() {
        return methods.getAllProviders();

    }

    public List viewAllFreelancers() {
        return methods.getAllFreelancers();

    }

    public String admindeleteJobs() {
        String pageType = methods.adminDeleteJob(jobID);
        return pageType;
    }

    public String dAdminUsers() {
        String pageType = methods.adminDeleteUser(userID);
        return pageType;
    }

    public admin() {
    }
}
