/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Ashwin Antony
 */
@Remote
public interface methodsRemote {

    String authenticate(String userEmail, String userPassword);

    String addNewJob(String title, String Description, double pay, String keywords, String userEmail);

    List<jobList> getProviderOpenJobs(String userEmail);

    List<jobList> getProviderClosedJobs(String userEmail);

    String deleteJob(int jobID);

    List<jobList> viewAllJobs();

    List<jobList> searchByKeywords(String providedKeyword);

    List<jobList> searchByJobID(int jobID);

    void applyJob(String freelancerEmailID, int jobID);

    void revokeAppliedJob(String freelancerEmailID, int jobID);

    List<freelancerInfo> showFreelancerProfile(String freelancerEmailID);

    String editFreelancerProfile(String firstName, String lastName, String skills, String freelancerMessage, String email);

    List<String> viewApplicants(int jobID);

    void assignJob(String freelancerEmailID, int jobID);

    void markCompleteAndPay(int jobID);

    List<jobList> getAllOpenJobs();

    List<jobList> getAllClosedJobs();

    String adminDeleteJob(int jobID);

    List<freelancerInfo> getAllProviders();

    List<freelancerInfo> getAllFreelancers();

    String adminDeleteUser(int userID);

    String addNewUser(String firstName, String lastName, String email, String password, String userRole);

}
