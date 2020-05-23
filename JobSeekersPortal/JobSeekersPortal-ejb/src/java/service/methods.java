/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 * @author Ashwin Antony
 */
@Stateless
public class methods implements methodsRemote {

    String URL = "jdbc:mysql://localhost:3306/db_jobseekers";
    String USER = "root";
    String PASSWD = "root";

    List<jobList> listProviderOpenJobs;
    List<jobList> listProviderClosedJobs;
    List<jobList> listAllJobs;
    List<jobList> listByKeywords;
    List<jobList> listByJobID;
    List<freelancerInfo> listFreelancerProfile;
    List<jobList> listAllOpenJobs;
    List<jobList> listAllClosedJobs;
    List<freelancerInfo> listAllProviders;
    List<freelancerInfo> listAllFreelancers;

    /**
     * Get the value of jobPay
     *
     * @return the value of jobPay
     */
    public List<jobList> getListPreviousOpenJobs() {
        return listProviderOpenJobs;
    }

    /**
     * Set the value of listProviderOpenJobs
     *
     * @param listProviderOpenJobs new value of listProviderOpenJobs
     */
    public void setListPreviousOpenJobs(List<jobList> listProviderOpenJobs) {
        this.listProviderOpenJobs = listProviderOpenJobs;
    }

    /**
     * Get the value of jobPay
     *
     * @return the value of jobPay
     */
    public List<jobList> getListPreviousClosedJobs() {
        return listProviderClosedJobs;
    }

    /**
     * Set the value of listProviderClosedJobs
     *
     * @param listProviderClosedJobs new value of listProviderClosedJobs
     */
    public void setListPreviousClosedJobs(List<jobList> listProviderClosedJobs) {
        this.listProviderClosedJobs = listProviderClosedJobs;
    }

    /**
     * Get the value of jobPay
     *
     * @return the value of jobPay
     */
    public List<jobList> getListAllJobs() {
        return listAllJobs;
    }

    /**
     * Set the value of listAllJobs
     *
     * @param listAllJobs new value of listAllJobs
     */
    public void setListAllJobs(List<jobList> listAllJobs) {
        this.listAllJobs = listAllJobs;
    }

    /**
     * Get the value of jobPay
     *
     * @return the value of jobPay
     */
    public List<jobList> getListByKeywords() {
        return listByKeywords;
    }

    /**
     * Set the value of listByKeywords
     *
     * @param listByKeywords new value of listByKeywords
     */
    public void setListByKeywords(List<jobList> listByKeywords) {
        this.listByKeywords = listByKeywords;
    }

    /**
     * Get the value of listByJobID
     *
     * @return the value of listByJobID
     */
    public List<jobList> getListByJobID() {
        return listByJobID;
    }

    /**
     * Set the value of listByJobID
     *
     * @param listByJobID new value of listByJobID
     */
    public void setListByJobID(List<jobList> listByJobID) {
        this.listByJobID = listByJobID;
    }

    /**
     * Get the value of listFreelancerProfile
     *
     * @return the value of listFreelancerProfile
     */
    public List<freelancerInfo> getListFreelancerProfile() {
        return listFreelancerProfile;
    }

    /**
     * Set the value of listFreelancerProfile
     *
     * @param listFreelancerProfile new value of listFreelancerProfile
     */
    public void setListFreelancerProfile(List<freelancerInfo> listFreelancerProfile) {
        this.listFreelancerProfile = listFreelancerProfile;
    }

    /**
     * Get the value of listAllOpenJobs
     *
     * @return the value of listAllOpenJobs
     */
    public List<jobList> getListAllOpenJobs() {
        return listAllOpenJobs;
    }

    /**
     * Set the value of listAllOpenJobs
     *
     * @param listAllOpenJobs new value of listAllOpenJobs
     */
    public void setListAllOpenJobs(List<jobList> listAllOpenJobs) {
        this.listAllOpenJobs = listAllOpenJobs;
    }

    /**
     * Get the value of listAllClosedJobs
     *
     * @return the value of listAllClosedJobs
     */
    public List<jobList> getListAllClosedJobs() {
        return listAllClosedJobs;
    }

    /**
     * Set the value of listAllClosedJobs
     *
     * @param listAllClosedJobs new value of listAllClosedJobs
     */
    public void setListAllClosedJobs(List<jobList> listAllClosedJobs) {
        this.listAllClosedJobs = listAllClosedJobs;
    }

    /**
     * Get the value of listAllProviders
     *
     * @return the value of listAllProviders
     */
    public List<freelancerInfo> getListAllProviders() {
        return listAllProviders;
    }

    /**
     * Set the value of listAllProviders
     *
     * @param listAllProviders new value of listAllProviders
     */
    public void setListAllProviders(List<freelancerInfo> listAllProviders) {
        this.listAllProviders = listAllProviders;
    }

    /**
     * Get the value of listAllFreelancers
     *
     * @return the value of listAllFreelancers
     */
    public List<freelancerInfo> getListAllFreelancers() {
        return listAllFreelancers;
    }

    /**
     * Set the value of listAllFreelancers
     *
     * @param listAllFreelancers new value of listAllFreelancers
     */
    public void setListAllFreelancers(List<freelancerInfo> listAllFreelancers) {
        this.listAllFreelancers = listAllFreelancers;
    }

    // method to authenticate user login
    @Override
    public String authenticate(String userEmail, String userPassword) {
        String pageType = "";

        try {
            PreparedStatement ps;
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT email, password, user_role, user_id FROM table_user WHERE email = ? ");
            ps.setString(1, userEmail);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String typeOfUser = rs.getString("user_role");
                String checkEmail = rs.getString("email");
                String checkPassword = rs.getString("password");

                // Credential Validation Code in Login Page
                if (checkEmail.equals(userEmail) && checkPassword.equals(userPassword)) {
                    if (typeOfUser.equals("Provider")) {
                        // Go to Job provider page
                        pageType = "provider-page";
                    } else if (typeOfUser.equals("Admin")) {
                        // Go to Admin page
                        pageType = "admin-home";
                    } else {
                        // Go to freelancer page
                        pageType = "freelancer-home";
                    }
                } else {
                    // Password match not found for given email -- Go to index page displaying Login error
                    pageType = "Invalid user credentials-index";
                }
            } else {
                // Email match not found -- Go to index page displaying Login error
                pageType = "Invalid user credentials-index";
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            System.out.println(" Login error ---> " + ex.getMessage());
        }
        return pageType;
    }

    // method to post new job - by Provider
    @Override
    public String addNewJob(String title, String description, double pay, String keywords, String userEmail) {
        try {
            PreparedStatement ps;
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            String record = "INSERT INTO table_job_details (title, description, payment, keywords, added_user, status, assigned_email) VALUES (?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(record);
            ps.setString(1, title);
            ps.setString(2, description);
            ps.setDouble(3, pay);
            ps.setString(4, keywords);
            ps.setString(5, userEmail);
            ps.setString(6, "open");
            ps.setString(7, "none");

            ps.executeUpdate();

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Error -->" + ex.getMessage());
        }

        String pageType = "provider-page";
        return pageType;
    }

    // method to add new user - by admin
    @Override
    public String addNewUser(String firstName, String lastName, String email, String password, String userRole
    ) {

        try {
            PreparedStatement ps;
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            String record = "INSERT INTO table_user (first_name, last_name, email, password, user_role, skills, message, balance) VALUES (?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(record);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, userRole);
            ps.setString(6, "Unavialable");
            ps.setString(7, "Unavialable");
            ps.setDouble(8, 0.00);

            ps.executeUpdate();

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            System.out.println("Error --->" + ex.getMessage());
        }

        String pageType = "admin-home";
        return pageType;
    }

    // providerPage.xhtml
    // method to list Provider specified Open jobs
    @Override
    public List<jobList> getProviderOpenJobs(String userEmail
    ) {
        listProviderOpenJobs = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT job_id, title, description, payment FROM table_job_details WHERE added_user = ? AND status = ?");
            ps.setString(1, userEmail);
            ps.setString(2, "open");

            rs = ps.executeQuery();

            while (rs.next()) {
                jobList j = new jobList();

                j.setJobID(rs.getInt("job_id"));
                j.setJobTitle(rs.getString("title"));
                j.setJobDescription(rs.getString("description"));
                j.setJobPay(rs.getDouble("payment"));

                listProviderOpenJobs.add(j);
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listProviderOpenJobs;
    }

    // method to list all Open jobs
    @Override
    public List<jobList> getAllOpenJobs() {
        listAllOpenJobs = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT job_id, title, description, payment, added_user FROM table_job_details WHERE status = ?");
            ps.setString(1, "open");
            rs = ps.executeQuery();

            while (rs.next()) {
                jobList j = new jobList();
                j.setJobID(rs.getInt("job_id"));
                j.setJobTitle(rs.getString("title"));
                j.setJobDescription(rs.getString("description"));
                j.setJobPay(rs.getDouble("payment"));
                j.setAddedUser(rs.getString("added_user"));
                listAllOpenJobs.add(j);
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAllOpenJobs;
    }

    // method to list Provider specified Closed jobs
    @Override
    public List<jobList> getProviderClosedJobs(String userEmail
    ) {
        listProviderClosedJobs = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT job_id, title, description, payment, assigned_email  FROM table_job_details WHERE added_user = ? AND status = ?");
            ps.setString(1, userEmail);
            ps.setString(2, "closed");

            rs = ps.executeQuery();

            while (rs.next()) {
                jobList j = new jobList();

                j.setJobID(rs.getInt("job_id"));
                j.setJobTitle(rs.getString("title"));
                j.setJobDescription(rs.getString("description"));
                j.setJobPay(rs.getDouble("payment"));
                j.setAssignedEmail(rs.getString("assigned_email"));

                listProviderClosedJobs.add(j);
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listProviderClosedJobs;
    }

    // method to list all closed/Completed jobs
    @Override
    public List<jobList> getAllClosedJobs() {
        listAllClosedJobs = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT job_id, title, description, payment, status, added_user FROM table_job_details WHERE status = ? OR status = ?");
            ps.setString(1, "closed");
            ps.setString(2, "completed");

            rs = ps.executeQuery();

            while (rs.next()) {
                jobList j = new jobList();

                j.setJobID(rs.getInt("job_id"));
                j.setJobTitle(rs.getString("title"));
                j.setJobDescription(rs.getString("description"));
                j.setJobPay(rs.getDouble("payment"));
                j.setJobStatus(rs.getString("status"));
                j.setAddedUser(rs.getString("added_user"));

                listAllClosedJobs.add(j);
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAllClosedJobs;
    }

    // method to list all job providers details
    @Override
    public List<freelancerInfo> getAllProviders() {
        listAllProviders = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT user_id, first_name, last_name, email FROM table_user WHERE user_role = ?");
            ps.setString(1, "Provider");
            rs = ps.executeQuery();

            while (rs.next()) {
                freelancerInfo fi = new freelancerInfo();

                fi.setUserID(rs.getInt("user_id"));
                fi.setFirstName(rs.getString("first_name"));
                fi.setLastName(rs.getString("last_name"));
                fi.setUserEmail(rs.getString("email"));

                listAllProviders.add(fi);
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAllProviders;
    }

    // method to list all Freelancers details
    @Override
    public List<freelancerInfo> getAllFreelancers() {
        listAllFreelancers = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT user_id, first_name, last_name, email FROM table_user WHERE user_role = ?");
            ps.setString(1, "Freelancer");
            rs = ps.executeQuery();

            while (rs.next()) {
                freelancerInfo fi = new freelancerInfo();

                fi.setUserID(rs.getInt("user_id"));
                fi.setFirstName(rs.getString("first_name"));
                fi.setLastName(rs.getString("last_name"));
                fi.setUserEmail(rs.getString("email"));

                listAllFreelancers.add(fi);
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAllFreelancers;
    }

    // method to delete Open job from Database - by Provider
    @Override
    public String deleteJob(int jobID
    ) {
        try {

            PreparedStatement ps;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("DELETE FROM table_job_details WHERE job_id = ? AND status = ?");
            ps.setInt(1, jobID);
            ps.setString(2, "open");

            ps.executeUpdate();

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        String pageType = "provider-page";
        return pageType;
    }

    // method to delete any job from database - by Admin
    @Override
    public String adminDeleteJob(int jobID
    ) {
        try {

            PreparedStatement ps, ps1;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("DELETE FROM table_job_details WHERE job_id = ?");
            ps.setInt(1, jobID);

            ps1 = conn.prepareStatement("DELETE FROM table_assigned_jobs WHERE job_id = ?");
            ps1.setInt(1, jobID);

            ps.executeUpdate();
            ps1.executeUpdate();

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        String pageType = "view-job-on-database";
        return pageType;
    }

    // method to delete user from database - by Admin
    @Override
    public String adminDeleteUser(int userID
    ) {
        try {

            PreparedStatement ps, ps1, ps2;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT email FROM table_user WHERE user_id = ?");
            ps.setInt(1, userID);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Delete user from table_user USING user_id
                String freelancerEmail = rs.getString("email");
                ps1 = conn.prepareStatement("DELETE FROM table_user WHERE user_id = ?");
                ps1.setInt(1, userID);
                ps1.executeUpdate();

                // Delete user from table_assigned_jobs USING email - For Freelancers
                ps2 = conn.prepareStatement("DELETE FROM table_assigned_jobs WHERE freelancer_email = ?");
                ps2.setString(1, freelancerEmail);
                ps2.executeUpdate();
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        String pageType = "admin-home";
        return pageType;
    }

    // method to list all Open jobs
    @Override
    public List<jobList> viewAllJobs() {
        listAllJobs = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT job_id, title, description, payment FROM table_job_details WHERE status = ?");
            ps.setString(1, "open");

            rs = ps.executeQuery();

            while (rs.next()) {
                jobList j = new jobList();

                j.setJobID(rs.getInt("job_id"));
                j.setJobTitle(rs.getString("title"));
                j.setJobDescription(rs.getString("description"));
                j.setJobPay(rs.getDouble("payment"));

                listAllJobs.add(j);
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAllJobs;
    }

    // method to view job details by provided Keywords
    @Override
    public List<jobList> searchByKeywords(String providedKeyword
    ) {
        listByKeywords = new ArrayList<>();

        try {

            System.out.println("provided Keywords======*******========>" + providedKeyword);
            PreparedStatement ps = null;
            ResultSet rs = null;

            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            if (!providedKeyword.equals("")) {
                ps = conn.prepareStatement("SELECT job_id, title, description, payment FROM table_job_details WHERE status = ? AND keywords LIKE ?");
                ps.setString(1, "open");
                ps.setString(2, "%" + providedKeyword + "%");

                rs = ps.executeQuery();

                while (rs.next()) {
                    jobList j = new jobList();
                    j.setJobID(rs.getInt("job_id"));
                    j.setJobTitle(rs.getString("title"));
                    j.setJobDescription(rs.getString("description"));
                    j.setJobPay(rs.getDouble("payment"));
                    listByKeywords.add(j);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e);
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listByKeywords;
    }

    // method to view job details by provided Job ID
    @Override
    public List<jobList> searchByJobID(int jobID
    ) {
        listByJobID = new ArrayList<>();

        try {

            PreparedStatement ps;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT job_id, title, description, payment FROM table_job_details WHERE job_id = ? AND status = ?");
            ps.setInt(1, jobID);
            ps.setString(2, "open");

            rs = ps.executeQuery();

            while (rs.next()) {
                jobList j = new jobList();

                j.setJobID(rs.getInt("job_id"));
                j.setJobTitle(rs.getString("title"));
                j.setJobDescription(rs.getString("description"));
                j.setJobPay(rs.getDouble("payment"));

                listByJobID.add(j);
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listByJobID;

    }

    // method to apply for Open job - by Freelancer
    @Override
    public void applyJob(String freelancerEmailID, int jobID
    ) {

        try {

            PreparedStatement ps, ps1, ps2;
            ResultSet rs, rs2;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps1 = conn.prepareStatement("INSERT INTO table_assigned_jobs (job_id, freelancer_email) VALUES (?,?)");

            // Check -> JobID with status Open is present in Job table
            ps2 = conn.prepareStatement("SELECT job_id FROM table_job_details WHERE job_id = ? AND status = ?");
            ps2.setInt(1, jobID);
            ps2.setString(2, "open");
            rs2 = ps2.executeQuery();

            // Job ID is present with Open status
            if (rs2.next()) {
                ps = conn.prepareStatement("SELECT * FROM table_assigned_jobs WHERE job_id = ? AND freelancer_email = ?");
                ps.setInt(1, jobID);
                ps.setString(2, freelancerEmailID);

                rs = ps.executeQuery();

                // User has not applied for this Job earlier
                if (!rs.next()) {
                    ps1.setInt(1, jobID);
                    ps1.setString(2, freelancerEmailID);
                    ps1.executeUpdate();
                }
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // method to revoke applied Open job - by Freelancer
    @Override
    public void revokeAppliedJob(String freelancerEmail, int jobID
    ) {
        try {

            PreparedStatement ps;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("DELETE FROM table_assigned_jobs WHERE job_id = ? AND freelancer_email = ?");
            ps.setInt(1, jobID);
            ps.setString(2, freelancerEmail);
            ps.executeUpdate();

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // method to list freelancer profiles
    @Override
    public List<freelancerInfo> showFreelancerProfile(String freelancerEmailID
    ) {
        listFreelancerProfile = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT user_id, first_name, last_name, email, skills, message, balance FROM table_user WHERE email = ? AND user_role = ?");
            ps.setString(1, freelancerEmailID);
            ps.setString(2, "Freelancer");

            rs = ps.executeQuery();

            while (rs.next()) {
                freelancerInfo fi = new freelancerInfo();

                fi.setUserID(rs.getInt("user_id"));
                fi.setFirstName(rs.getString("first_name"));
                fi.setLastName(rs.getString("last_name"));
                fi.setUserEmail(rs.getString("email"));
                fi.setSkills(rs.getString("skills"));
                fi.setUserMessage(rs.getString("message"));
                fi.setAccountBalance(rs.getDouble("balance"));

                listFreelancerProfile.add(fi);
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listFreelancerProfile;
    }

    // method to edit Freelancer Profile - by Freelancer
    @Override
    public String editFreelancerProfile(String firstName, String lastName, String skills, String freelancerMessage, String email
    ) {
        try {
            PreparedStatement ps, psExisitingFreelanderDetail;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            psExisitingFreelanderDetail = conn.prepareStatement("SELECT * FROM table_user WHERE email = ?");
            psExisitingFreelanderDetail.setString(1, email);

            rs = psExisitingFreelanderDetail.executeQuery();
            if (rs.next()) {
                ps = conn.prepareStatement("UPDATE table_user SET first_name= ?, last_name = ?, skills = ?, message = ? WHERE email = ?");

                // Update columns where new value is provided else keep the existing value itself
                if (!firstName.equals("")) {
                    ps.setString(1, firstName);
                } else {
                    ps.setString(1, rs.getString("first_name"));
                }

                if (!lastName.equals("")) {
                    ps.setString(2, lastName);
                } else {
                    ps.setString(2, rs.getString("last_name"));
                }

                if (!skills.equals("")) {
                    ps.setString(3, skills);
                } else {
                    ps.setString(3, rs.getString("skills"));
                }

                if (!freelancerMessage.equals("")) {
                    ps.setString(4, freelancerMessage);
                } else {
                    ps.setString(4, rs.getString("message"));
                }

                ps.setString(5, email);
                ps.executeUpdate();
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }

        String pageType = "freelancer-profile";
        return pageType;
    }

    // method to list freelancer Email IDs who has applied for Open jobs - in Provider Page
    @Override
    public List<String> viewApplicants(int jobID
    ) {
        List<String> listFreelancerEmailIDs = new ArrayList<>();

        try {
            PreparedStatement ps;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            ps = conn.prepareStatement("SELECT freelancer_email FROM table_assigned_jobs WHERE job_id = ?");
            ps.setInt(1, jobID);

            rs = ps.executeQuery();

            while (rs.next()) {
                listFreelancerEmailIDs.add(rs.getString("freelancer_email"));
            }

        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listFreelancerEmailIDs;
    }

    // method to Assign the job to applied Freelancer
    @Override
    public void assignJob(String freelancerEmailID, int jobID
    ) {
        try {
            PreparedStatement ps, ps1, ps2;
            ResultSet rs;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            // Check if Freelancer has applied for specified Job ID
            ps = conn.prepareStatement("SELECT * FROM table_assigned_jobs WHERE freelancer_email = ? AND job_id = ?");
            ps.setString(1, freelancerEmailID);
            ps.setInt(2, jobID);
            rs = ps.executeQuery();

            if (rs.next()) {
                ps1 = conn.prepareStatement("UPDATE table_job_details SET assigned_email = ?, status = ? WHERE job_id = ?");
                ps1.setString(1, freelancerEmailID);
                ps1.setString(2, "closed");
                ps1.setInt(3, jobID);
                ps1.executeUpdate();

                ps2 = conn.prepareStatement("DELETE FROM table_assigned_jobs WHERE freelancer_email = ? AND job_id = ?");
                ps2.setString(1, freelancerEmailID);
                ps2.setInt(2, jobID);
                ps2.executeUpdate();
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // method to Mark job as Completed and proceed with Payment - by Provider
    @Override
    public void markCompleteAndPay(int jobID
    ) {
        double jobPayment, freelancerBalance, updatedBalance;
        String freelancerEmailID;

        try {
            PreparedStatement ps1, ps2, ps3, ps4;
            ResultSet rs2;

            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWD);

            // Mark job as 'Completed'
            ps1 = conn.prepareStatement("UPDATE table_job_details SET status = ? WHERE job_id = ?");
            ps1.setString(1, "completed");
            ps1.setInt(2, jobID);
            ps1.executeUpdate();

            // Fetch job details of provided job ID
            ps2 = conn.prepareStatement("SELECT payment,assigned_email FROM table_job_details WHERE job_id = ?");
            ps2.setInt(1, jobID);

            rs2 = ps2.executeQuery();

            // If job is present in database DO
            if (rs2.next()) {
                jobPayment = rs2.getDouble("payment");
                freelancerEmailID = rs2.getString("assigned_email");

                // Fetch balance of freelancer
                ps3 = conn.prepareStatement("SELECT balance FROM table_user WHERE email = ?");
                ps3.setString(1, freelancerEmailID);
                ResultSet rs3 = ps3.executeQuery();

                // If user is present in database DO
                if (rs3.next()) {
                    freelancerBalance = rs3.getDouble("balance");
                    updatedBalance = jobPayment + freelancerBalance;

                    // Update balance of freelancer in database
                    ps4 = conn.prepareStatement("UPDATE table_user SET balance = ? WHERE email = ?");
                    ps4.setDouble(1, updatedBalance);
                    ps4.setString(2, freelancerEmailID);

                    ps4.executeUpdate();
                }
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException thrown!" + e.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(methods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
