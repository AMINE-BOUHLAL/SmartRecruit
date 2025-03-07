<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SmartRecruit - Job Portal</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            line-height: 1.6;
        }
        .header {
            background-color: #4CAF50;
            color: white;
            padding: 10px 0;
            position: sticky;
            top: 0;
            z-index: 100;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .header h1 {
            margin: 0;
            padding-left: 20px;
            font-size: 24px;
        }
        .nav-links {
            display: flex;
            margin-right: 20px;
        }
        .nav-links a {
            color: white;
            text-decoration: none;
            padding: 0 15px;
            font-size: 16px;
        }
        .nav-links a:hover {
            text-decoration: underline;
        }
        .job-list {
            max-height: calc(100vh - 80px);
            overflow-y: scroll;
            padding: 20px;
        }
        .job-item {
            max-width: 800px;
            margin: 15px auto;
            padding: 15px;
            border: 1px solid #ddd;
            border-radius: 12px;
            background-color: white;
        }
        .job-title {
            text-decoration: none;
            color: #2196F3;
            transition: color 0.3s ease;
        }
        .job-title:hover {
            color: #4CAF50;
            text-decoration: underline;
        }
        .job-item p {
            margin: 5px 0;
            color: #666;
        }
        /* Custom Scrollbar */
        .job-list::-webkit-scrollbar {
            width: 10px;
        }
        .job-list::-webkit-scrollbar-track {
            background: #f1f1f1;
        }
        .job-list::-webkit-scrollbar-thumb {
            background: #4CAF50;
            border-radius: 5px;
        }
        .job-list::-webkit-scrollbar-thumb:hover {
            background: #2196F3;
        }
    </style>
</head>
<body>
<div class="header">
    <h1>SmartRecruit - Job Portal</h1>
    <div class="nav-links">
        <a href="index.html">Home</a>
        <a href="offers.html">Offers</a>
        <a href="logout.html">Log Out</a>
    </div>
</div>

<div class="job-list">
    <div class="job-item">
        <a href="AboutOffer.jsp" class="job-title"><h3>Web Developer</h3></a>
        <p>Location: Paris</p>
        <p>Experience: 2-3 years</p>
        <p>Fullstack development using Java and JavaScript</p>
    </div>


</div>
</body>
</html>