<%@ page import="modals.Task" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="shortcut icon" href="./images/logo.png">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <style>@import url('https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;500;600;700;800;900&family=Poppins:wght@300;400;500;600;700;800&display=swap');

    :root{
        --color-primary: rgba(255, 137, 18, 0.78);
        --color-danger: #ff7782;
        --color-success: #41f1b6;
        --color-warning: #ffbb55;
        --color-white: #fff;
        --color-info: #7d8da1;
        --color-dark: #363949;
        --color-light: rgba(132, 139, 200, 0.18);
        --color-dark-varient: #677483;
        --color-background: #f6f6f9;

        --card-border-radius: 1rem;
        --border-radius-1: 0.4rem;
        --border-radius-2: 1.2rem;

        --card-padding: 1.8rem;
        --box-shadow: 0 2rem 3rem var(--color-light)
    }



    *{
        margin:0;
        padding: 0;
        text-decoration: none;
        list-style: none;
        box-sizing: border-box;
    }

    html{
        font-size: 14px;
        scroll-behavior: smooth;
    }
    body{
        font-family: 'Poppins', sans-serif;
        font-size: .88rem;
        background: var(--color-background);
        user-select: none;
        overflow-x: hidden;
        color: var(--color-dark);
    }
    *{
        color: var(--color-dark);
    }
    img{
        display: block;
        width: 100%;
    }
    h1{
        font-weight: 800;
        font-size: 1.8rem;
    }
    h2{font-size: 1.4rem;}
    h3{font-size: .87rem;}
    h4{font-size: .8rem;}
    h5{font-size: .77rem;}
    small{font-size: .75rem;}





    .container{
        position: relative;
        display: grid;
        width: 93%;
        margin: 0 3rem;
        gap: 1.8rem;
        grid-template-columns: 14rem auto ;
        padding-top: 4rem;
    }
    header h3{font-weight: 500;}
    header{
        position: fixed;
        width: 100vw;
        z-index: 1000;
        background-color: var(--color-background);
    }
    header.active{box-shadow: var(--box-shadow);}
    header .logo{
        display: flex;
        gap: .8rem;
        margin-right: auto;
    }
    header .logo img{
        width: 230px;
        height: auto;
    }

    header,
    header .navbar{
        display: flex;
        align-items: center;
        justify-content: flex-end;
        padding: 0 3rem;
        color: var(--color-info);
    }
    header .navbar a{
        display: flex;
        margin-left: 2rem;
        gap: 1rem;
        align-items: center;
        justify-content: space-between;
        position: relative;
        height: 3.7rem;
        transition: all 300ms ease;
        padding: 0 2rem;
    }
    header .navbar a:hover {
        padding-top: 1.5rem;
    }
    header .navbar a.active{
        background: var(--color-light);
        color: var(--color-primary);
    }
    header .navbar a.active::before{
        content: "";
        background-color: var(--color-primary);
        position: absolute;
        height: 5px;
        width: 100%;
        left: 0;top: 0;
    }





    /* Profile section  */
    :root {
        --bg-default: rgba(255, 137, 18, 0.78);
        --bg-search: #ffffff;
        --bg-hover: rgba(255, 137, 18, 0.78);
        --bg-item-active: rgba(255, 137, 18, 0.78);
        --text-color: #232222;
        --placeholder-color: #bfbdbd;
        --text-badge: #f5f5f5;
        --invert-black: 0%;
    }

































    .sidebar-header img {
        width: 40px;
        height: 40px;
    }

    .sidebar-header span {
        display: inline-block;
        margin-left: 16px;
        font-size: 1.5rem;
        font-weight: 500;
    }

    .search {
        background-color: var(--bg-search);

        border-radius: 16px;
        border: 1px solid orange;
        padding: 8px;
        display: flex;
        align-items: center;
    }

    .search input[type="text"] {

        color: var(--text-color);
    }

    .search input[type="text"]::placeholder {
        color: var(--placeholder-color);
    }

    .sidebar-group-title {
        margin-bottom: 0;
        margin-top: 24px;
    }

    .menu-section .sidebar-group-title {
        margin-bottom: 12px;
    }



    .sidebar-item {
        display: flex;
        align-items: center;
        height: 32px;
        padding: 8px;
        border-radius: 16px;
        position: relative;

        transition: all ease-in-out 150ms;
    }

    .sidebar-item:hover {
        background-color: var(--bg-hover);
    }

    .sidebar-item input[type="radio"] {
        all: unset;
        position: absolute;
        inset: 0;
        cursor: pointer;
        z-index: 99;
    }



    .sidebar-item span {
        display: inline-block;
        margin-left: 16px;
    }



    .sidebar-item:has(input[type="radio"]:checked) {
        background-color: var(--bg-item-active);
    }







    .group-section .sidebar-group-title {
        margin-bottom: 12px;
    }

    .group-section .sidebar-item {
        cursor: pointer;
    }








    .theme-container .theme {
        display: flex;
        align-items: center;
        position: relative;
        width: 50%;
        padding: 8px;
        border-radius: 8px;

        transition: all ease-in-out 150ms;
    }

    .theme-container .theme:hover {
        background-color: var(--bg-default);
    }

    .theme-container .theme:has(input[type="radio"]:checked) {
        background-color: var(--bg-hover);
    }

    .theme-container .theme input[type="radio"] {
        all: unset;
        inset: 0;
        position: absolute;
        cursor: pointer;
        z-index: 99;
    }

    .theme-container .theme span {
        display: inline-block;
        margin-left: 16px;
    }

    .user-info-container {
        display: flex;
        align-items: center;
        margin-top: 32px;
    }

    .user-info-container .user-avatar {
        width: 40px;
        height: 40px;
        border-radius: 50%;
        object-fit: cover;
    }

    .user-info-container .user-info {
        display: flex;
        flex-direction: column;
        margin-left: 16px;
    }

    .user-info-container .user-info p {
        margin: 0;
        margin-bottom: 8px;
    }

    .user-info-container .logout {
        margin-left: auto;
        cursor: pointer;
    }

    /* Home Section  */
    main{
        position: relative;
        margin-top: 1.4rem;
    }
    main .projects{
        display: grid;
        grid-template-columns: repeat(5, 1fr);
        gap: 1.6rem;
    }
    main .ressources{
        display: grid;
        grid-template-columns: repeat(1, 1fr);
        gap: 1.6rem;
    }
    main .main-container{
        background-color: var(--color-white);
        padding: var(--card-padding);
        border-radius: var(--card-border-radius);
        margin-top: 1rem;
        box-shadow: var(--box-shadow);
        transition: all 300ms ease;

    }
    main .projects > div{
        background-color: var(--color-white);
        padding: var(--card-padding);
        border-radius: var(--card-border-radius);
        margin-top: 1rem;
        box-shadow: var(--box-shadow);
        transition: all 300ms ease;
    }
    main .projects > div:hover{
        box-shadow: none;
    }
    main .projects > div span{
        background-color: var(--color-primary);
        padding: .5rem;
        border-radius: 50%;
        color: var(--color-white);
        font-size: 1.5rem;
    }


    main .projects h3{
        margin: 1rem 0 0.6rem;
        font-size: 1rem;
    }
    main .projects .progress{
        position: relative;
        width: 89px;
        height: 89px;
        border-radius: 50%;
        margin: auto;
    }
    main .projects svg circle{
        fill: none;
        stroke: var(--color-primary);
        stroke-width: 8;
        stroke-linecap: round;
        transform: translate(5px, 5px);
        stroke-dasharray: 110;
        stroke-dashoffset: 92;
    }
    main .projects .eg svg circle{
        stroke-dashoffset: 25;
        stroke-dasharray: 210;
    }
    main .projects .mth svg circle{
        stroke-dashoffset: 7;
        stroke-dasharray: 210;
    }
    main .projects .cs svg circle{
        stroke-dashoffset: 35;
        stroke-dasharray: 210;
    }
    main .projects .cg svg circle{
        stroke-dashoffset: 0;
        stroke-dasharray: 210;
    }
    main .projects .net svg circle{
        stroke-dashoffset: 5;
        stroke-dasharray: 210;
    }
    main .projects .progress .number{
        position: absolute;
        top: 0;left: 0;
        height: 100%;
        width: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    main .projects small{
        margin-top: 1rem;
        display: block;
    }
    main .Overview{
        display: flex;
        flex-wrap: wrap;
        margin-top: 1rem;
        gap: 1rem;

    }
    main .Overview h2{
        margin-bottom: .8rem;
    }
    main .Overview .card{

        background-color: var(--color-white);
        width: 23.6%;
        border-radius: var(--card-border-radius);
        padding: var(--card-padding);
        text-align: center;
        box-shadow: var(--box-shadow);
        transition: all 300ms ease;
    }






    /* MEDIA QUERIES  */
    @media screen and (max-width: 1200px) {
        html{font-size: 12px;}
        .container{
            grid-template-columns: 13rem auto ;
        }
        header{position: fixed;}
        .container{padding-top: 4rem;}
        header .logo h2{display: none;}
        header .navbar h3{display: none;}
        header .navbar a{width: 4.5rem; padding: 0 1rem;}

        main .projects{
            grid-template-columns: repeat(2, 1fr);
            gap: 1;
        }

    }


    @media screen and (max-width: 768px) {
        html {
            font-size: 10px;
        }

        header {
            padding: 0 .8rem;
        }

        .container {
            width: 100%;
            grid-template-columns: 1fr;
            margin: 0;
        }

        header #profile-btn {
            display: inline;
        }

        header .navbar {
            padding: 0;
        }

        header .navbar a {
            margin: 0 .5rem 0 0;
        }

        header .theme-toggler {
            margin: 0;
        }

        aside {
            position: absolute;
            top: 4rem;
            left: 0;
            right: 0;
            background-color: var(--color-white);
            padding-left: 2rem;
            transform: translateX(-100%);
            z-index: 10;
            width: 18rem;
            height: 100%;
            box-shadow: 1rem 3rem 4rem var(--color-light);
            transition: all 2s ease;
        }

        aside.active {
            transform: translateX(0);
        }

        main {
            padding: 0 2rem;
        }

        main .timetable {
            position: relative;
            margin: 3rem 0 0 0;
            width: 100%;
        }
    }
    </style>
</head>
<body>
<header>
    <div class="logo" title="University Management System">
        <img src="https://i.ibb.co/h16QN6C/Construction-Xpert.png" alt="">

    </div>
    <div class="navbar">
        <a href="#" >
            <span class="material-icons-sharp">home</span>
            <h3>Home</h3>
        </a>
        <a href="#" >
            <span class="material-icons-sharp">home_work</span>
            <h3>Projects</h3>
        </a>
        <a href="#" class="active">
            <span class="material-icons-sharp">construction</span>
            <h3>Ressources</h3>
        </a>
        <a href="password.html">
            <span class="material-icons-sharp">today</span>
            <h3>Today</h3>
        </a>
        <a href="#">
            <span class="material-icons-sharp" onclick="">logout</span>
            <h3>Logout</h3>
        </a>
    </div>
    <div id="profile-btn">
        <span class="material-icons-sharp">person</span>
    </div>


</header>
<div class="container">
    <aside>

        <section class="menu-section">
            <p class="sidebar-group-title">Menu</p>
            <div class="sidebar-item">
                <input type="radio" name="sidebar-item" checked />
                <span class="material-icons-sharp">add_circle</span>
                <span>New Project</span>
            </div>
            <div class="sidebar-item">
                <input type="radio" name="sidebar-item" />
                <span class="material-icons-sharp">add_circle</span>
                <span>New Task</span>
                <span class="badge">
            12
          </span>
            </div>
            <div class="sidebar-item">
                <input type="radio" name="sidebar-item" />
                <span class="material-icons-sharp">group</span>
                <span>Team</span>
            </div>





        </section>


        <div class="user-info-container">
            <img
                    src="https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8Mnx8cmFuZG9tJTIwcGVyc29ufGVufDB8fDB8fHww&w=1000&q=80"
                    alt=""
                    srcset=""
                    class="user-avatar"
            />
            <div class="user-info">
                <p>Guilherme Sartori</p>
                <span>meu.email@gmail.com</span>
            </div>
            <img src="icons/log-out.svg" alt="" class="logout svg-icon" />
        </div>
        </nav>
    </aside>

    <main>
        <div class="titles" style="display: flex;align-items: center;">
            <h2>Add project </h2> <h3>Ressources</h3></div>

        <div class="main-container">
            <div class="ressource-container" style="border:1px solid orange;border-radius: 6px;display: flex; flex-direction: column; ">
                <h1 style="background-color: orange">Ressources</h1>


                <form action="addRessourceTask" method="POST">
                <div class="ressources" style=" margin-top: 2rem; display: grid; grid-template-columns: 13rem auto auto auto;column-gap:1rem; ">


                        <input hidden="hidden" value="${taskId}" name="taskId">
                        <input hidden="hidden" value="${projectId}" name="projectId">

                        <c:forEach var="ressource" items="${ressourcelist}">
                        <div class="card-res" style="background-color: #f6f6f9;display:flex; flex-direction:column;padding: 1rem;border-radius: 8px; ">

                            <div class="ressource-card-head" style="display: flex; justify-content: space-between;">
                                <h2>${ressource.resourceName} </h2>
                            </div>
                            <div class="ressource-card-body" >
                                <p>${ressource.resourceDescription}</p>
                                <p>Available Quantity :${ressource.quantity} </p>
                            </div>
                            <div class="footer-card" style="display: flex;justify-content: space-between;">
                                <input style="width: 40%;" type="number" id="quantity_${ressource.resourceId}"  >
                                <input type="checkbox" id="resource_${ressource.resourceId}" name="resources" value="${ressource.resourceId}">
                                <label for="resource_${ressource.resourceId}">Select</label>
                            </div>

                        </div>
                        </c:forEach>







                </div>
                    <input style="display: inline-block;color: #ffffff; text-align: center;vertical-align: middle;  border: 1px solid transparent;  background: #f36f2e;  font-size: 1rem;  line-height: 1.5;  cursor: pointer;  width: 10rem;  height: 3rem;border-radius: 50px;" type="submit" value="Submit">

                </form>
            </div>

        </div>
    </main>


</div>
<script>

</script>

</body>
</html>