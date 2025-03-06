<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .login-container {
            width: 100%;
            max-width: 400px;
            padding: 20px;
            text-align: center;
        }
        .login-container h1 {
            color: #333;
            margin-bottom: 30px;
        }
        .input-wrapper {
            margin-bottom: 20px;
        }
        .input-wrapper input {
            width: 100%;
            padding: 12px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .login-btn {
            width: 100%;
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            margin-bottom: 15px;
        }
        .signup-btn {
            width: 100%;
            padding: 12px;
            background-color: #2196F3;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h1>Welcome </h1>
    <form action="login" method="post">
        <div class="input-wrapper">
            <input type="text" placeholder="email" name="email" required>
        </div>
        <div class="input-wrapper">
            <input type="password" placeholder="Password"  name="password" required>
        </div>
        <button type="submit" class="login-btn">Login</button>
       <a href="Singup.jsp"> <button type="button" class="signup-btn" >Sign Up</button></a>
    </form>
</div>
</body>
</html>