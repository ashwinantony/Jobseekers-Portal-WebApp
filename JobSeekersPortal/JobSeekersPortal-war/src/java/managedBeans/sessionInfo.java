/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.servlet.http.HttpSession;
import service.*;

/**
 *
 * @author Ashwin Antony
 */
@Named(value = "sessionInfo")
@SessionScoped
@ManagedBean
public class sessionInfo implements Serializable {

    private String email;
    private String password;
    private String title;
    private String desc;
    private double pay;
    private String keywords;
    private String firstName;
    private String lastName;
    private String skills;
    private String userMessage;
    private int searchByJobID;
    private String secEmail;
    private int jobID;
    private int secJobID;
    private int thirdJobID;
    private String invalidMessage;

    @Resource(mappedName = "mydes")
    private Queue mydes;
    @Inject
    @JMSConnectionFactory("java:comp/DefaultJMSConnectionFactory")
    private JMSContext context;

    private void sendJMSMessageToMydes(String messageData) {
        context.createProducer().send(mydes, messageData);
    }

    public void send(String ss) {
        this.sendJMSMessageToMydes(ss);
    }

    /**
     * Get the value of invalidMessage
     *
     * @return the value of invalidMessage
     */
    public String getInvalidMessage() {
        return invalidMessage;
    }

    /**
     * Set the value of invalidMessage
     *
     * @param invalidMessage new value of invalidMessage
     */
    public void setInvalidMessage(String invalidMessage) {
        this.invalidMessage = invalidMessage;
    }

    /**
     * Get the value of thirdJobID
     *
     * @return the value of thirdJobID
     */
    public int getThirdJobID() {
        return thirdJobID;
    }

    /**
     * Set the value of thirdJobID
     *
     * @param thirdJobID new value of jobthirdJobIDPay
     */
    public void setThirdJobID(int thirdJobID) {
        this.thirdJobID = thirdJobID;
    }

    /**
     * Get the value of searchByJobID
     *
     * @return the value of searchByJobID
     */
    public int getSearchByJobID() {
        return searchByJobID;
    }

    /**
     * Set the value of searchByJobID
     *
     * @param searchByJobID new value of searchByJobID
     */
    public void setSearchByJobID(int searchByJobID) {
        this.searchByJobID = searchByJobID;
    }

    /**
     * Get the value of secJobID
     *
     * @return the value of secJobID
     */
    public int getSecJobID() {
        return secJobID;
    }

    /**
     * Set the value of secJobID
     *
     * @param secJobID new value of secJobID
     */
    public void setSecJobID(int secJobID) {
        this.secJobID = secJobID;
    }

    /**
     * Get the value of secEmail
     *
     * @return the value of secEmail
     */
    public String getSecEmail() {
        return secEmail;
    }

    /**
     * Set the value of secEmail
     *
     * @param secEmail new value of secEmail
     */
    public void setSecEmail(String secEmail) {
        this.secEmail = secEmail;
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
     * @param firstName new value of jobPfirstNameay
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
     * Set the value of joblastNamePay
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @EJB
    methodsRemote methods;

    /**
     * Get the value of keywords
     *
     * @return the value of keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * Set the value of keywords
     *
     * @param keywords new value of keywords
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * Get the value of pay
     *
     * @return the value of pay
     */
    public double getPay() {
        return pay;
    }

    /**
     * Set the value of pay
     *
     * @param pay new value of pay
     */
    public void setPay(double pay) {
        this.pay = pay;
    }

    /**
     * Get the value of desc
     *
     * @return the value of desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Set the value of desc
     *
     * @param desc new value of desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Get the value of title
     *
     * @return the value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Set the value of title
     *
     * @param title new value of title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String check() {
        String pageType = methods.authenticate(email, password);

        if (pageType.equals("")) {
            pageType = "index";
        }

        String temp = pageType;

        if (temp.equals("Invalid user credentials-index")) {
            String[] message = temp.split("-");
            this.invalidMessage = message[0];
            return message[1];
        }
        return pageType;
    }

    public String postJob() {
        String pageType = methods.addNewJob(title, desc, pay, keywords, email);
        return pageType;
    }

    public List viewOpenJobs() {
        return methods.getProviderOpenJobs(email);

    }

    public List viewClosedJobs() {
        return methods.getProviderClosedJobs(email);

    }

    public String dJobs() {
        String pageType = methods.deleteJob(jobID);
        return pageType;
    }

    public List browseOpenJobs() {
        return methods.viewAllJobs();
    }

    public List searchById() {
        return methods.searchByJobID(searchByJobID);
    }

    public List searchByKey() {
        return methods.searchByKeywords(keywords);
    }

    public void jobApply() {
        send("job applied : " + email + " requested for job ID: " + jobID);
        methods.applyJob(email, jobID);
    }

    public void jobRevoke() {
        send("job request revoked : " + email + " revoked request for job ID: " + jobID);
        methods.revokeAppliedJob(email, jobID);
    }

    public List viewFprofile() {
        return methods.showFreelancerProfile(email);
    }

    public List fProfile() {
        return methods.showFreelancerProfile(secEmail);
    }

    public String editFProfile() {
        String pageType = methods.editFreelancerProfile(firstName, lastName, skills, userMessage, email);
        return pageType;
    }

    public List vApplicants() {
        return methods.viewApplicants(jobID);
    }

    public void assignJob() {
        send("job closed : " + secEmail + " requested for job ID: " + jobID + "has been accpeted by job provider");
        methods.assignJob(secEmail, jobID);
    }

    public void completeAndPay() {
        methods.markCompleteAndPay(secJobID);
    }

    public String userLogout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        return "/index?faces-redirect=true";
    }

    public sessionInfo() {
    }
}
