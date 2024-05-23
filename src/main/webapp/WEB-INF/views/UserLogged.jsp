<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="modals.Project" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student Dashboard</title>
    <link rel="shortcut icon" href="./images/logo.png">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Sharp" rel="stylesheet">
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

        --card-border-radius: 2rem;
        --border-radius-1: 0.4rem;
        --border-radius-2: 1.2rem;

        --card-padding: 1.8rem;
        --box-shadow: 0 2rem 3rem var(--color-light)
    }

    .dark-theme{
        --color-background: #181a1e;
        --color-white: #202528;
        --color-dark: #edeffd;
        --color-dark-varient: #a3bdcc;
        --color-light: rgba(0,0,0,0.4);
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

    .text-muted{color: var(--color-info);}
    p{color: var(--color-dark-varient);}
    b{color: var(--color-dark);}

    .primary{color: var(--color-primary);}
    .danger{color: var(--color-danger);}
    .success{color: var(--color-success)}
    .warning{color: var(--color-warning);}

    .container{
        position: relative;
        display: grid;
        width: 93%;
        margin: 0 3rem;
        gap: 1.8rem;
        grid-template-columns: 14rem auto 23rem;
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
    header #profile-btn{
        display: none;
        font-size: 2rem;
        margin: .5rem 2rem 0 0;
        cursor: pointer;
    }
    header .theme-toggler{
        background: var(--color-light);
        display: flex;
        justify-content: space-between;
        align-items: center;
        height: 1.6rem;
        width: 4.2rem;
        cursor: pointer;
        border-radius: var(--border-radius-1);
        margin-right: 2rem;
    }
    header .theme-toggler span{
        font-size: 1.2rem;
        width: 50%;
        height: 100%;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    header .theme-toggler span.active{
        background-color: var(--color-primary);
        color: white;
        border-radius: var(--border-radius-1);
    }

    /* Profile section  */
    :root {
        --bg-default: rgba(255, 137, 18, 0.78);
        --bg-search: #ffffff;
        --bg-hover: rgba(255, 137, 18, 0.78);
        --bg-item-active: rgba(255, 137, 18, 0.78);
        --text-color: white;
        --placeholder-color: #dadada;
        --text-badge: #f5f5f5;
        --invert-black: 0%;
    }






    aside .sidebar {
        background-color: var(--bg-default);
        width: 280px;
        height: fit-content;
        border-radius: 16px;
        padding: 16px;
        position: relative;

        transition: all ease-in-out 300ms;
    }

    .sidebar.open {
        width: 80px;
    }

    .sidebar.open {
        width: 60px;
    }

    .sidebar.open .sidebar-header {
        justify-content: center;
    }

    .sidebar.open .sidebar-header span {
        display: none;
    }

    .sidebar.open .open-close-menu {
        transform: rotate(180deg);
    }

    .sidebar.open .search {
        justify-content: center;
    }

    .sidebar.open .search input {
        display: none;
    }

    .sidebar.open .sidebar-group-title {
        text-align: center;
    }

    .sidebar.open .sidebar-item {
        justify-content: center;
    }

    .sidebar.open .sidebar-item span {
        display: none;
    }

    .sidebar.open .group-section .sidebar-item img:last-of-type {
        display: none;
    }

    .sidebar.open .theme-container {
        justify-content: center;
    }

    .sidebar.open .theme-container .theme:not(:has(input[type="radio"]:checked)) {
        display: none;
    }

    .sidebar.open .theme-container .theme span {
        display: none;
    }

    .sidebar.open .user-info-container .user-info,
    .sidebar.open .user-info-container .svg-icon {
        display: none;
    }

    .open-close-menu {
        all: unset;
        width: 32px;
        height: 32px;
        background-color: #1d66e6;
        border-radius: 50%;
        display: flex;
        align-items: center;
        justify-content: center;
        position: absolute;

        top: 44px;
        right: -16px;

        cursor: pointer;

        transition: all ease-in-out 150ms;
    }

    .open-close-menu:hover {
        background-color: #1450ba;
    }

    .sidebar-header {
        display: flex;
        align-items: center;
        margin-top: 24px;
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
        margin-top: 40px;
        border-radius: 16px;

        padding: 8px;
        display: flex;
        align-items: center;
    }

    .search input[type="text"] {
        all: unset;
        width: 100%;
        margin-left: 8px;
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

    .svg-icon {
        filter: invert(var(--invert-black));
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

    .sidebar-item:not(:first-of-type) {
        margin-top: 16px;
    }

    .sidebar-item span {
        display: inline-block;
        margin-left: 16px;
    }

    .sidebar-item span.badge {
        margin-left: auto;
        margin-right: 16px;
        background-color: #c73428;
        padding: 4px 8px;
        border-radius: 8px;
        color: var(--text-badge);
    }

    .sidebar-item:has(input[type="radio"]:checked) {
        background-color: var(--bg-item-active);
    }

    .sidebar-item:has(input[type="radio"]:checked)::before {
        content: "";
        width: 8px;
        height: 40px;
        background-color: #c73428;
        position: absolute;
        left: -16px;
        border-top-right-radius: 50%;
        border-bottom-right-radius: 50%;
    }

    .sidebar-item:has(input[type="radio"]:checked) span {
        font-weight: 500;
    }



    .group-section .sidebar-group-title {
        margin-bottom: 12px;
    }

    .group-section .sidebar-item {
        cursor: pointer;
    }

    .group-section .sidebar-item img:first-of-type {
        width: 24px;
        height: 24px;
        padding: 4px;
        border-radius: 50%;
        background-color: #2aaf1e;
        object-fit: contain;
    }

    .group-section .sidebar-item img:last-of-type {
        margin-left: auto;
    }

    .group-section .sidebar-item:nth-of-type(2) img:first-of-type {
        background-color: #2b3ee4;
    }

    .group-section .sidebar-item:nth-of-type(3) img:first-of-type {
        background-color: #ec2222;
    }

    .group-section .sidebar-item:nth-of-type(4) img:first-of-type {
        background-color: #e1e42b;
    }

    .theme-container {
        display: flex;
        margin-top: 32px;
        background-color: var(--bg-search);
        border-radius: 8px;
        padding: 8px;
        justify-content: space-between;
        gap: 8px;
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
        grid-template-columns: repeat(8, 2fr);
        gap: 1.6rem;
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
            grid-template-columns: 13rem auto 20rem;
        }
        header{position: fixed;}
        .container{padding-top: 4rem;}
        header .logo h2{display: none;}
        header .navbar h3{display: none;}
        header .navbar a{width: 4.5rem; padding: 0 1rem;}

        main .projects{
            grid-template-columns: repeat(2, 1fr);
            gap: 1rem;
        }
        main .timetable{
            width: 150%;
            position: absolute;
            padding: 4rem 0 0 0;
        }
    }


    @media screen and (max-width: 768px){
        html{font-size: 10px;}
        header{padding: 0 .8rem;}
        .container{width: 100%; grid-template-columns: 1fr;margin: 0;}
        header #profile-btn{display: inline;}
        header .navbar{padding: 0;}
        header .navbar a{margin: 0 .5rem 0 0;}
        header .theme-toggler{margin: 0;}
        aside{
            position: absolute;
            top: 4rem;left: 0;right: 0;
            background-color: var(--color-white);
            padding-left: 2rem;
            transform: translateX(-100%);
            z-index: 10;
            width:18rem;
            height: 100%;
            box-shadow: 1rem 3rem 4rem var(--color-light);
            transition: all 2s ease;
        }
        aside.active{
            transform: translateX(0);
        }
        main{padding: 0 2rem;}
        main .timetable{
            position: relative;
            margin: 3rem 0 0 0;
            width: 100%;
        }
        main .timetable table{
            width: 100%;
            margin: 0;
        }
        .right{
            width: 100%;
            padding: 2rem;
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
        <a href="index.html" class="active">
            <span class="material-icons-sharp">home</span>
            <h3>Home</h3>
        </a>
        <a href="timetable.html">
            <span class="material-icons-sharp">home_work</span>
            <h3>Projects</h3>
        </a>
        <a href="exam.html">
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
    <div class="theme-toggler">
        <span class="material-icons-sharp active">light_mode</span>
        <span class="material-icons-sharp">dark_mode</span>
    </div>

</header>
<div class="container">
    <aside>
        <div class="search">
            <span class="material-icons-sharp">today</span>
            <input type="text" placeholder="Search..." />
        </div>
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
        <h1>Projects :</h1>
        <div class="projects">
            <c:forEach var="projectData" items="${projectsData}">
                <div class="eg"  data-done-tasks="${projectData.doneTasks}"
                     data-total-tasks="${projectData.totalTasks}">

                    <h3>${projectData.project.projectName}</h3>
                    <p>${projectData.project.budget}</p>
                    <h2 class>${projectData.doneTasks}/${projectData.totalTasks}
                    </h2>
                    <div class="progress">
                        <svg>
                            <circle class="progressCircle" cx="38" cy="38" r="36"></circle>
                        </svg>
                        <div class="number">
                            <p class="percentage"><!-- Percentage will be displayed here --></p>
                        </div>
                    </div>
                    <small class="text-muted">Last 24 Hours</small>
                </div>
            </c:forEach>
        </div>


        <h1 style="margin-top: 1rem;">Overview</h1>
        <div class="Overview">

            <div class="card">
                <div class="headcard" style="display: flex; justify-content: space-between;">
                    <h2>Tasks</h2>
                    <span class="material-icons-sharp">more_horiz</span>
                </div>
                <div class="bodycard" style="display:flex;">

                    <h1>${overallTasks}</h1>
                    <h5>Tasks</h5>
                </div>

            </div>
            <div class="card">
                <h1>123</h1>
                <h5>Tasks</h5>
            </div>
            <div class="card">
                <h1>123</h1>
                <h5>Tasks</h5>
            </div>
            <div class="card">
                <h1>123</h1>
                <h5>Tasks</h5>
            </div>


        </div>
    </main>

</div>

<script>
    var egElements = document.querySelectorAll(".eg");

    egElements.forEach(function(egElement) {
        var doneTasks = parseInt(egElement.getAttribute("data-done-tasks"));
        var totalTasks = parseInt(egElement.getAttribute("data-total-tasks"));
        var progress = (doneTasks / totalTasks) * 100;

        var progressCircle = egElement.querySelector(".progressCircle");
        console.log("progressCircle:", progressCircle);

        if (progressCircle) {
            var circumference = 2 * Math.PI * parseFloat(progressCircle.getAttribute("r"));

            progressCircle.style.strokeDasharray = `${circumference * (progress / 100)} ${circumference}`;
            console.log("strokeDasharray:", progressCircle.style.strokeDasharray);
        } else {
            console.error("Progress circle not found.");
        }

        var percentageElement = egElement.querySelector(".percentage");
        console.log("percentageElement:", percentageElement);
        percentageElement.textContent = progress.toFixed(2) + "%";
    });
</script>

</body>
</html>