document.getElementById("submitBtn").addEventListener("click", function() {
    submitUserMessage();
});

document.querySelector(".voice-btn").addEventListener("click", function() {
    startVoiceRecognition();
});

function submitUserMessage() {
    var userInput = document.getElementById("userInput").value;
    if (userInput.trim() !== "") {
        displayMessage("User", userInput);
        makeAjaxRequest(userInput.toLowerCase());
        document.getElementById("userInput").value = "";
    }
}

function makeAjaxRequest(userInput) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            var response = xhr.responseText;
            displayMessage("Crime Chatbot", response);
        }
    };
    xhr.open("POST", "CrimeChatbot", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.send("userInput=" + encodeURIComponent(userInput));
}

function displayMessage(sender, message) {
    var messageContainer = document.getElementById("messageContainer");
    var messageDiv = document.createElement("div");
    messageDiv.className = "message " + (sender === "User" ? "user-message" : "chatbot-message");
    message = message.replace("Crime Chatbot:", "");
    messageDiv.innerHTML = sender + ": " + message;
    messageContainer.appendChild(messageDiv);
    messageContainer.scrollTop = messageContainer.scrollHeight;
}

function startVoiceRecognition() {
    var recognition = new webkitSpeechRecognition() || new SpeechRecognition();
    recognition.lang = 'en-US';
    recognition.onresult = function (event) {
        var voiceInput = event.results[0][0].transcript.trim().toLowerCase();
        document.getElementById("userInput").value = voiceInput;
        processVoiceInput(voiceInput);
    };
    recognition.onerror = function (event) {
        console.error('Voice recognition error:', event.error);
    };
    recognition.start();
}

function processVoiceInput(voiceInput) {
    displayMessage("User", voiceInput);
    makeAjaxRequest(voiceInput);
}