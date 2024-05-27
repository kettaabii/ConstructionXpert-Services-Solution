<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>@import url("https://fonts.googleapis.com/css2?family=Fredoka+One&display=swap");

    * {
        box-sizing: border-box;
        margin: 0;
        padding: 0;
        font-family: sans-serif;
    }

    body {
        background-color: #bfbdbd;
    }



    p {
        margin-top: 5%;
        margin-bottom: 5%;
        width: 100%;
        text-align: center;
        border-bottom: 1px solid #000;
        line-height: 0.1em;
    }



    input {
        margin-bottom: 3%;
    }

    input:last-of-type {
        margin-bottom: 0;
    }

    input,
    button {
        padding: 3%;
        margin: 3%;
        width: 100%;
    }

    .login-container {
        display: flex;
        flex-direction: column;
        gap: 15px;
        background-color: white;
        padding: 7%;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        /* horizontal align */
        width: 40vw;
        margin-left: 30vw;
        /* vertical align */
        height: 70vh;
        margin-top: 15vh;
        border-radius: 8px;
    }



    button:hover {
        cursor: pointer;
        opacity: 0.8;
        transition: 0.3s;
    }






    </style>
</head>
<body>
<div class = "login-container">
    <form action="login" method="post" class="form">
    <div id= "main">
        <img style="width: 300px;" src="https://i.ibb.co/h16QN6C/Construction-Xpert.png"
             alt="">

        <input type="text" name="username" id="username" placeholder = "Username"></input>
        <input id = "password" type ="password" name="password" placeholder = "Password"></input>

        <button type="submit" value="Login" class="sign">Sign in</button>
    </div>
    </form>
</div>
