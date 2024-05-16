<%-- 
    Document   : chat
    Created on : Apr 8, 2024, 2:44:32 AM
    Author     : lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        /* Your custom styles here */
        body {
            background-color: #262626; /* Dark background color */
            font-family: Arial, sans-serif;
        }
        .chat-container {
            width: 60%;
            margin: auto;
            padding: 20px;
            background-color: #333; /* Dark background color for the chat container */
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
            color: #fff; /* Text color inside the chat container */
        }
        .message-container {
            margin-top: 20px;
            overflow: auto;
            max-height: 300px;
        }
        .message {
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 10px;
            font-weight: bold; /* Bold font */
            font-size: 14px; /* Adjusted font size */
        }
        .user-message {
            background-color: #4CAF50; /* Green background color for user messages */
            text-align: left;
            color: #fff; /* Text color for user messages */
        }
        .chatbot-message {
            background-color: #3498db; /* Blue background color for chatbot messages */
            text-align: right;
            color: #fff; /* Text color for chatbot messages */
        }
        .input-container {
            margin-top: 20px;
            display: flex;
        }
        #userInput {
            flex: 1;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        #submitBtn {
            margin-left: 10px;
            padding: 8px 15px;
            background-color: #3498db; /* Blue background color for the submit button */
            color: #fff; /* Text color for the submit button */
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .voice-btn {
            margin-left: 10px;
            padding: 8px 15px;
            background-color: #3498db;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
    </head>
    <body>
        <div class="container text-center">
        <h1 style="font-weight: bold; font-size: 24px;">Crime Chatbot</h1>
        <hr>
        <div class="chat-container" id="messageContainer">
            <!-- Welcome message with increased font size -->
            <div class="message chatbot-message" style="font-size: 18px;">Crime Chatbot: Hello! How can I assist you today?</div>
            <!-- User and chatbot messages will be dynamically added here -->
        </div>
        <div class="input-container">
            <input type="text" id="userInput" class="form-control" placeholder="Type your message...">
            <button id="submitBtn" class="btn btn-primary">Submit</button>
            <button class="voice-btn btn btn-secondary">Start Voice</button>
        </div>
        
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="script.js"></script> <!-- Include your JavaScript file -->
    <script src="allcomponet/script.js" type="text/javascript"></script>
    </body>
</html>
