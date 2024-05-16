<%@ page import="java.sql.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="org.json.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Crime Report Visualization</title>
   <style>
        body {
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
        }

        #crimeChartContainer {
            margin: 0 auto;
            width: 80%;
            height: 50vh;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 20px;
            padding: 20px;
            box-sizing: border-box;
            border-radius: 8px;
            display: flex;
            justify-content: space-between; /* Adjust as needed */
        }

        .chart-container canvas {
            width: 45%; /* Adjust the width as needed */
        }

        .data-table {
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            overflow: hidden;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    
        <div id="crimeChartContainer">
            <h4>Area-wise Crime Distribution Chart</h4>
            <canvas id="areaCrimeChart" width="30" height="20"></canvas>
            
            <h4>Type-wise Crime Distribution Chart</h4>
            <canvas id="typeCrimeChart" width="10" height="20"></canvas>
        </div>

    <%-- Fetch data and create charts server-side --%>
    <%
        String city = request.getParameter("city");
        String start_date = request.getParameter("start_date");
        String end_date = request.getParameter("end_date");

        JSONArray areaCrimeData = new JSONArray();
        JSONArray typeCrimeData = new JSONArray();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crime_report", "root", "111");

            // Area-wise crime count query
            String areaQuery = "SELECT area, COUNT(*) AS count FROM Complaint WHERE incident_city=? AND date BETWEEN ? AND ? GROUP BY area";

            try (PreparedStatement statement = con.prepareStatement(areaQuery)) {
                statement.setString(1, city);
                statement.setString(2, start_date);
                statement.setString(3, end_date);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String crimeArea = resultSet.getString("area");
                        int count = resultSet.getInt("count");

                        // Create a JSON object for each crime area and count
                        JSONObject crimeObject = new JSONObject();
                        crimeObject.put("crimeArea", crimeArea);
                        crimeObject.put("count", count);

                        // Add the JSON object to the areaCrimeData array
                        areaCrimeData.put(crimeObject);
                    }
                }
            }

            // Type-wise crime count query
            String typeQuery = "SELECT type_of_crime, COUNT(*) AS count FROM Complaint WHERE incident_city=? AND date BETWEEN ? AND ? GROUP BY type_of_crime";

            try (PreparedStatement statement = con.prepareStatement(typeQuery)) {
                statement.setString(1, city);
                statement.setString(2, start_date);
                statement.setString(3, end_date);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String crimeType = resultSet.getString("type_of_crime");
                        int count = resultSet.getInt("count");

                        // Create a JSON object for each crime type and count
                        JSONObject crimeObject = new JSONObject();
                        crimeObject.put("crimeType", crimeType);
                        crimeObject.put("count", count);

                        // Add the JSON object to the typeCrimeData array
                        typeCrimeData.put(crimeObject);
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            out.println(ex);
        }
    %>

    <%-- Create the bar chart using Chart.js for area-wise data --%>
    <div style="width: 80%; margin: auto;">
        
        <canvas id="areaCrimeChart" width="30" height="50"></canvas>
    </div>

    <%-- Create the pie chart using Chart.js for type-wise data --%>
    <div style="width: 20%; margin: auto;">
       
        <canvas id="typeCrimeChart" width="20" height="30"></canvas>
    </div>
    
    <div class="data-table">
        <h2>Crime Data Table</h2>
        <table border="1">
            <thead>
                <tr>
                    <th>Crime Area</th>
                    <th>Area_Crime_Count</th>
                    <th>Crime Type</th>
                    <th>Type_Crime_Count</th>
                </tr>
            </thead>
            <tbody>
                <%-- Iterate over the maximum length to display both area-wise and type-wise data --%>
                <% int maxLength = Math.max(areaCrimeData.length(), typeCrimeData.length()); %>
                <% for (int i = 0; i < maxLength; i++) { %>
                    <tr>
                        <%-- Display area-wise data if available --%>
                        <% if (i < areaCrimeData.length()) { %>
                            <td><%= areaCrimeData.getJSONObject(i).getString("crimeArea") %></td>
                            <td><%= areaCrimeData.getJSONObject(i).getInt("count") %></td>
                        <% } else { %>
                            <td></td>
                            <td></td>
                        <% } %>

                        <%-- Display type-wise data if available --%>
                        <% if (i < typeCrimeData.length()) { %>
                            <td><%= typeCrimeData.getJSONObject(i).getString("crimeType") %></td>
                            <td><%= typeCrimeData.getJSONObject(i).getInt("count") %></td>
                        <% } else { %>
                            <td></td>
                            <td></td>
                        <% } %>
                    </tr>
                <% } %>
            </tbody>
        </table>
    </div>

    <script>
        // Parse the areaCrimeData JSON array from JSP for area-wise chart
        var areaCrimeData = <%= areaCrimeData.toString() %>;

        // Extract labels (crime areas) and data (number of reported crimes)
        var areaCrimeLabels = areaCrimeData.map(function(item) {
            return item.crimeArea;
        });

        var areaCrimeCounts = areaCrimeData.map(function(item) {
            return item.count;
        });

        var areaCrimeChartCanvas = document.getElementById('areaCrimeChart').getContext('2d');

        new Chart(areaCrimeChartCanvas, {
            type: 'bar',
            data: {
                labels: areaCrimeLabels,
                datasets: [{
                    label: 'Number of Reported Crimes',
                    data: areaCrimeCounts,
                    backgroundColor: 'rgba(75, 192, 192, 0.6)',
                    borderColor: 'rgba(75, 192, 192, 1)',
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true
                    }
                }
            }
        });

        // Parse the typeCrimeData JSON array from JSP for type-wise chart
        var typeCrimeData = <%= typeCrimeData.toString() %>;

        // Extract labels (crime types) and data (number of reported crimes)
        var typeCrimeLabels = typeCrimeData.map(function(item) {
            return item.crimeType;
        });

        var typeCrimeCounts = typeCrimeData.map(function(item) {
            return item.count;
        });

        var typeCrimeChartCanvas = document.getElementById('typeCrimeChart').getContext('2d');

        new Chart(typeCrimeChartCanvas, {
            type: 'pie',
            data: {
                labels: typeCrimeLabels,
                datasets: [{
                    label: 'Number of Reported Crimes',
                    data: typeCrimeCounts,
                    backgroundColor: ['rgba(75, 192, 192, 0.6)', 'rgba(255, 99, 132, 0.6)', 'rgba(255, 205, 86, 0.6)', /* Add more colors if you have more crime types */],
                    borderColor: ['rgba(75, 192, 192, 1)', 'rgba(255, 99, 132, 1)', 'rgba(255, 205, 86, 1)', /* Add more colors if you have more crime types */],
                    borderWidth: 1
                }]
            },
            options: {
//                responsive: true,
//                maintainAspectRatio: false, // Adjust as needed
            }
        });
    </script>
    
    <script>
    console.log('Area Crime Data:', <%= areaCrimeData.toString() %>);
    console.log('Type Crime Data:', <%= typeCrimeData.toString() %>);
</script>
</body>
</html>
