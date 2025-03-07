<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Job Offer</title>
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
        textarea,
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 16px;
            border: 1.5px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 15px;
        }

        textarea {
            resize: vertical;
            height: 100px;
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
            background-color: #2196F3;
        }
    </style>
</head>
<body>
<form action="add-offer" method="post">
    <h2>ADD Offer</h2>

    <div>
        <input type="text" id="titre" name="titre" placeholder="title" required>
    </div>
    <div>
        <textarea id="description" name="description" placeholder="description" required></textarea>
    </div>
    <div>
        <input type="text" id="applicationDate" name="datePublication" placeholder="application date D/M/Y" required>
    </div>
    <div>
        <select id="location" name="location" required>
            <option value="" disabled selected>location</option>
            <option value="Casablanca">Casablanca</option>
            <option value="Rabat">Rabat</option>
            <option value="Marrakech">Marrakech</option>
            <option value="Fes">Fes</option>
            <option value="Tangier">Tangier</option>
            <option value="Agadir">Agadir</option>
            <option value="Meknes">Meknes</option>
            <option value="Oujda">Oujda</option>
            <option value="Tetouan">Tetouan</option>
            <option value="Kenitra">Kenitra</option>
            <option value="Beni Mellal">Beni Mellal</option>
        </select>
    </div>
    <div>
        <select id="expérience" name="expérience" required>
            <option value="" disabled selected>Experience</option>
            <option value="0-1 years">0-1 years</option>
            <option value="1-3 years">1-3 years</option>
            <option value="3-5 years">3-5 years</option>
            <option value="5+ years">5+ years</option>
        </select>
    </div>

    <button type="submit">Save</button>
</form>
</body>
</html>
