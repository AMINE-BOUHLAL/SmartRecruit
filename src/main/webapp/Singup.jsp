<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        form {
            width: 400px;
            padding: 25px;
        }

        h2 {
            text-align: center;
            margin-bottom: 25px;
            font-size: 26px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            font-size: 16px;
        }

        input[type="text"],
        input[type="email"],
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            border: 1.5px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 15px;
        }

        button {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<form action="/submit" method="POST">
    <h2>Sign Up</h2>
    <div>

        <input type="text" id="name" name="name" placeholder="Enter your name" required>
    </div>
    <div>

        <input type="text" id="surname" name="surname" placeholder="Enter your surname" required>
    </div>
    <div>

        <input type="email" id="email" name="email" placeholder="Enter your email" required>
    </div>
    <div>

        <select id="role" name="role" required>
            <option value="" disabled selected>Select your role</option>
            <option value="admin">Admin</option>
            <option value="recruteur">Recruteur</option>
            <option value="candidat">Candidat</option>
        </select>
    </div>
    <button type="submit">Sign Up</button>
</form>
</body>
</html>