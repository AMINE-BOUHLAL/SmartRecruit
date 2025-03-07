<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Candidat Sign Up</title>
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

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        .custom-file-upload {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            border: 1.5px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 15px;
            display: inline-block;
            background-color: white;
            text-align: left;
            cursor: pointer;
        }

        button, .custom-file-upload {
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            border: none;
            font-weight: bold;
            text-align: center;
        }

        button:hover, .custom-file-upload:hover {
            background-color: #2196F3;
        }

        /* Hide the default file input */
        input[type="file"] {
            display: none;
        }
        button {
            width: 100%;
            border-radius: 5px;
            font-size: 15PX;

        }
    </style>
</head>
<body>
<form action="candidat-create" method="post" enctype="multipart/form-data">
    <h2>CANDIDAT </h2>

    <div>
        <input type="text" id="nom" name="nom" placeholder="Enter your name" required>
    </div>
    <div>
        <input type="text" id="prenom" name="prenom" placeholder="Enter your surname" required>
    </div>
    <div>
        <input type="email" id="email" name="email" placeholder="Enter your email" required>
    </div>
    <div>
        <input type="tel" id="tel" name="tel" placeholder="Enter your telephone" required>
    </div>
    <div>
        <label for="cv" class="custom-file-upload">Upload  CV </label>
        <input type="file" id="cv" name="cv" accept=".pdf, .jpg, .png" required>
    </div>

    <button type="submit">Postuler</button>
</form>
</body>
</html>
