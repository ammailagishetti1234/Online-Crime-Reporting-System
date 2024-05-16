/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/CrimeChatbot")
public class CrimeChatbot extends HttpServlet {

    private final Map<String, String> questionAnswerMap;

    public CrimeChatbot() {
        super();
        questionAnswerMap = new HashMap<>();
        initializeQuestionAnswerMap();
    }


    private void initializeQuestionAnswerMap() {
        questionAnswerMap.put("hi", "Hello! How can I assist you?");
        questionAnswerMap.put("hello", "Hello! How can I assist you?");
        questionAnswerMap.put("what is fir?", "FIR stands for First Information Report. It is a written document prepared by the police when they receive information about the commission of a cognizable offense.");
        questionAnswerMap.put("how can i register a complaint?", "You can register a complaint by filling out the complaint registration form on our website.");
        questionAnswerMap.put("tell me about the charge sheet.", "A charge sheet is a formal document accusing someone of a crime. It contains details of the offense, evidence, and names of the accused.");
        questionAnswerMap.put("what are the types of crimes?", "Common types of crimes include theft, burglary, assault, robbery, fraud, cybercrime, homicide, and drug offenses.");
        questionAnswerMap.put("how can i track the status of my complaint?", "You can track the status of your complaint by logging into your account on our website or contacting the local police station.");
        questionAnswerMap.put("how can I log in as a user?", "You can log in as a user using your registered email and password on the login page.");
        questionAnswerMap.put("how do I add a complaint?", "After logging in, go to the 'Add Complaint' section and fill out the complaint form with details and evidence.");
        questionAnswerMap.put("how can I update the status of a complaint?", "As an admin, you can update the status of a complaint in the admin panel by selecting the complaint and choosing the appropriate status.");
        questionAnswerMap.put("how do I register an FIR?", "To register an FIR, you need to be an authorized police officer. After investigating a complaint, you can register an FIR through the admin panel.");
        questionAnswerMap.put("how can I assign police to a particular case?", "In the admin panel, you can assign police officers to a case by selecting the case and assigning officers.");
        questionAnswerMap.put("how do I generate a case report?", "Once a case is completed, you can generate a case report through the admin panel, which includes details of the complaint, FIR, chargesheet, and police actions.");
        questionAnswerMap.put("what is the format of a crime report?", "A crime report typically includes details of the complaint, FIR, chargesheet, police actions, and other relevant information in a standardized format for documentation and analysis.");
        questionAnswerMap.put("how can I view updates on my complaint, FIR, and chargesheet?", "As a user, you can view updates on your complaint, FIR, and chargesheet by logging into your account and checking the status section.");
        questionAnswerMap.put("how do I add evidence to my complaint?", "When registering a complaint, you can upload evidence files along with the complaint form. Make sure to provide clear and relevant evidence to support your case.");
        questionAnswerMap.put("what should I do if I forgot my password?", "If you forgot your password, you can use the 'Forgot Password' option on the login page to reset your password.");
        questionAnswerMap.put("how can I contact support for assistance?", "You can contact our support team via email or phone for assistance with any issues or queries related to the online crime reporting system.");
        questionAnswerMap.put("how work this website", "The online crime reporting system comprises two modules: one for users and the other for administrators. Users can log in using their registered email and password to access the system. They have the capability to add complaints along with detailed evidence. On the admin side, administrators oversee the entire process. They can view user complaints, update their statuses, register FIRs (First Information Reports), and record chargesheets. Before registering FIRs and chargesheets, admins have the responsibility of assigning police officers to specific cases. Once a case is resolved, a comprehensive case report is generated. This report contains all the relevant information, including complaints, FIRs, chargesheets, and details about police involvement, presented in a standardized format known as the crime report. Users have the ability to track the status updates of their complaints, FIRs, and chargesheets through the system.");
        questionAnswerMap.put("How to use FIR module?", "To utilize the FIR feature in the online crime reporting system, administrators play a pivotal role in registering FIRs for reported incidents. The process starts with administrators accessing the system and reviewing user complaints. Upon verification and assessment of the complaint details, administrators proceed to register FIRs for the reported incidents. Before registering an FIR, administrators assign police officers to the respective cases to initiate investigations. Once assigned, the FIR is generated and includes essential information such as the FIR number, dates of occurrence, and a detailed description of the incident. This registered FIR serves as the official document that initiates the legal process for addressing the reported crime within the system.");
        questionAnswerMap.put("Where can users and administrators access information about the complaints filed within the online crime reporting system?", "Users and administrators can view information about filed complaints within the online crime reporting system through designated sections of the platform. For users, upon logging into their accounts using their registered email and password, they can access a dashboard or section specifically dedicated to viewing the status and details of their filed complaints. Here, users can track updates on the progress of their complaints, including any changes in status or actions taken by the administration. On the administrator side, access to information about complaints is typically available through an administrative dashboard or panel. Administrators can log in using their credentials and navigate to the section dedicated to managing complaints. Here, they can review all filed complaints, including details such as the nature of the complaint, dates of submission, and any accompanying evidence provided by the users. This centralized platform allows administrators to efficiently manage and address reported incidents within the system.");
        questionAnswerMap.put("hi", "Hello! How can I assist you?");
        questionAnswerMap.put("what is fir?", "FIR stands for First Information Report. It is a written document prepared by the police when they receive information about the commission of a cognizable offense.");
        questionAnswerMap.put("how can i register a complaint?", "You can register a complaint by filling out the complaint registration form on our website.");
    questionAnswerMap.put("tell me about the charge sheet.", "A charge sheet is a formal document accusing someone of a crime. It contains details of the offense, evidence, and names of the accused.");
    questionAnswerMap.put("what are the types of crimes?", "Common types of crimes include theft, burglary, assault, robbery, fraud, cybercrime, homicide, and drug offenses.");
    questionAnswerMap.put("how can i track the status of my complaint?", "You can track the status of your complaint by logging into your account on our website or contacting the local police station.");
    questionAnswerMap.put("how can I log in as a user?", "You can log in as a user using your registered email and password on the login page.");
    questionAnswerMap.put("how can I add a complaint?", "After logging in, go to the 'Add Complaint' section and fill out the complaint form with details and evidence.");
    questionAnswerMap.put("how can I update the status of a complaint?", "As an admin, you can update the status of a complaint in the admin panel by selecting the complaint and choosing the appropriate status.");
    questionAnswerMap.put("how do I register an FIR?", "To register an FIR, you need to be an authorized police officer. After investigating a complaint, you can register an FIR through the admin panel.");
    questionAnswerMap.put("how can I assign police to a particular case?", "In the admin panel, you can assign police officers to a case by selecting the case and assigning officers.");
    questionAnswerMap.put("how do I generate a case report?", "Once a case is completed, you can generate a case report through the admin panel, which includes details of the complaint, FIR, chargesheet, and police actions.");
    questionAnswerMap.put("what is the format of a crime report?", "A crime report typically includes details of the complaint, FIR, chargesheet, police actions, and other relevant information in a standardized format for documentation and analysis.");
    questionAnswerMap.put("how can I view updates on my complaint, FIR, and chargesheet?", "As a user, you can view updates on your complaint, FIR, and chargesheet by logging into your account and checking the status section.");
    questionAnswerMap.put("how do I add evidence to my complaint?", "When registering a complaint, you can upload evidence files along with the complaint form. Make sure to provide clear and relevant evidence to support your case.");
    questionAnswerMap.put("what should I do if I forgot my password?", "If you forgot your password, you can use the 'Forgot Password' option on the login page to reset your password.");
    questionAnswerMap.put("how can I contact support for assistance?", "You can contact our support team via email or phone for assistance with any issues or queries related to the online crime reporting system.");
    questionAnswerMap.put("how work this website?", "The online crime reporting system comprises two modules: one for users and the other for administrators. Users can log in using their registered email and password to access the system. They have the capability to add complaints along with detailed evidence. On the admin side, administrators oversee the entire process. They can view user complaints, update their statuses, register FIRs (First Information Reports), and record chargesheets. Before registering FIRs and chargesheets, admins have the responsibility of assigning police officers to specific cases. Once a case is resolved, a comprehensive case report is generated. This report contains all the relevant information, including complaints, FIRs, chargesheets, and details about police involvement, presented in a standardized format known as the crime report. Users have the ability to track the status updates of their complaints, FIRs, and chargesheets through the system.");
    questionAnswerMap.put("How to use FIR module?", "To utilize the FIR feature in the online crime reporting system, administrators play a pivotal role in registering FIRs for reported incidents. The process starts with administrators accessing the system and reviewing user complaints. Upon verification and assessment of the complaint details, administrators proceed to register FIRs for the reported incidents. Before registering an FIR, administrators assign police officers to the respective cases to initiate investigations. Once assigned, the FIR is generated and includes essential information such as the FIR number, dates of occurrence, and a detailed description of the incident. This registered FIR serves as the official document that initiates the legal process for addressing the reported crime within the system.");
    questionAnswerMap.put("Where can users and administrators access information about the complaints filed within the online crime reporting system?", "Users and administrators can view information about filed complaints within the online crime reporting system through designated sections of the platform. For users, upon logging into their accounts using their registered email and password, they can access a dashboard or section specifically dedicated to viewing the status and details of their filed complaints. Here, users can track updates on the progress of their complaints, including any changes in status or actions taken by the administration. On the administrator side, access to information about complaints is typically available through an administrative dashboard or panel. Administrators can log in using their credentials and navigate to the section dedicated to managing complaints. Here, they can review all filed complaints, including details such as the nature of the complaint, dates of submission, and any accompanying evidence provided by the users. This centralized platform allows administrators to efficiently manage and address reported incidents within the system.");
   questionAnswerMap.put("where i add complaint", "You can add a complaint by filling out the complaint registration form on our website.");
   questionAnswerMap.put("add complaint", "You can add a complaint by filling out the complaint registration form on our website.");

    }

     private String generateChatbotResponse(String userQuestion) {
    // Look for keywords in the user's question and retrieve the corresponding answer
    for (Map.Entry<String, String> entry : questionAnswerMap.entrySet()) {
        String question = entry.getKey().toLowerCase();
        if (userQuestion.toLowerCase().contains(question) || question.contains(userQuestion.toLowerCase())) {
            return entry.getValue();
        }
    }

    // If no specific keyword is found, provide a default response
    return "I'm sorry, I couldn't understand. Please ask another question.";

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Get user input from the request parameter
            String userMessage = request.getParameter("userInput");

            // Process user message and get chatbot reply
            String chatbotReply = generateChatbotResponse(userMessage);

            // Send the chatbot reply as the response
            out.print("Crime Chatbot: " + chatbotReply);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Crime Chatbot Servlet";
    }
}