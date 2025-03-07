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
            text-align: center;
            padding: 20px 0;
            position: sticky;
            top: 0;
            z-index: 100;
        }
        .job-list {
            max-height: calc(100vh - 120px);
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
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease;
        }
        .job-item:hover {
            transform: scale(1.02);
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
</div>

<div class="job-list">
    <div class="job-item">
        <a href="AboutOffer" class="job-title"><h3>Web Developer</h3></a>
        <p>Location: Paris</p>
        <p>Experience: 2-3 years</p>
        <p>Fullstack development using Java and JavaScript</p>
    </div>


</div>
</body>
</html>