<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Details</title>
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
    <div class="logo" title="ProjectManagementSystem">
        <img src="https://i.ibb.co/h16QN6C/Construction-Xpert.png" alt="">

    </div>
    <div class="navbar">
        <a href="Dashboard" >
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

        <a href="logout">
            <span class="material-icons-sharp" onclick="">logout</span>
            <h3>Logout</h3>
        </a>
    </div>



</header>
<div class="container">
    <aside>



        <div class="user-info-container">

            <img
                    src="<%=session.getAttribute("profile")%>"
                    alt=""
                    srcset=""
                    class="user-avatar"
            />
            <div class="user-info">
                <br /><span></span>
                <p><%=session.getAttribute("username")%></p>
                <span>Admin</span>
            </div>
            <img src="icons/log-out.svg" alt="" class="logout svg-icon" />
        </div>
        </nav>
    </aside>

    <main>


        <div class="titles" style="display: flex;align-items: center;">
            <h2>Add project </h2> <h3>Ressources</h3></div>

        <div class="main-container">

            <div class="ressource-container" style="border:1px solid orange;border-radius: 6px;display: flex; flex-direction: column; gap:1rem;">
                <h1 style="background-color: orange">Project Details </h1>
                <div class="project-header" style="display: flex;align-items: baseline;justify-content:space-between; padding: 1rem;" >
                    <h1>${projectData.project.projectName}</h1>
                    <p>${projectData.project.description} </p>
                </div>
                <div class="project-body" style="display: flex;align-items: baseline;justify-content:space-around;" >
                    <p>${projectData.project.dateDebut}  </p>
                    <p> ${projectData.project.dateFin}</p>
                    <p>budjet</p>
                </div>
                <div class="project-bottom" style="display: flex;justify-content:right; padding: 1rem;" >
                   <a href="Editproject?projectId=${projectData.project.id}"> <input  type="button" style="display: inline-block;color: #ffffff; text-align: center;vertical-align: middle;  border: 1px solid transparent;  background: #f36f2e;  font-size: 1rem;  line-height: 1.5;  cursor: pointer;  width: 8rem;  height: 2rem;border-radius: 50px;" value="Edit "></a>

                </div>
                <div class="project-progression" style="background-color: lightgrey; box-shadow: black;border-radius: 8px;padding:2rem;width: 80%;margin-left: 6rem;display: flex;justify-content: space-between;align-items: center;">
                    <div>
                        <h2> Progression </h2>
                        <h3>Tasks Done :${projectData.doneTasks}</h3>
                        <h3>All Tasks:${projectData.totalTasks}</h3>
                    </div>
                    <div class="progress-container" style="height: 1.5rem; width:32rem;background-color: white; border-radius: 1rem;">
                        <div class="bar" style="height: 1.5rem; width:15rem;background-color: #2aaf1e; border-radius: 1rem;"></div>
                    </div>
                </div>

                <div class="tasks">
                    <h1 style="background-color: orange">Tasks Details </h1>
                    <div class="card-task-container" style="display:grid; grid-template-columns: 14rem 14rem 14rem 14rem; gap:2rem;padding: 1rem;">
                        <c:forEach var="task" items="${projectData.tasks}">
                            <div class="task-card" style="background-color: lightgray; border-radius: 8px;display: flex;flex-direction: column;padding: 1rem;gap: 2rem;">

                                <h1>${task.title}</h1>
                                <p>${task.description}</p>
                                <p> ${task.status} </p>
                                <c:if test="${task.assignedEmployee ne null}">
                                <div style="display:flex;justify-content: space-between">
                                    <p>${task.assignedEmployee.employeeName} </p>
                                    <img style=" width: 40px;height: 40px;border-radius: 50%;object-fit: cover;"
                                         src="${task.assignedEmployee.picture}"
                                         alt=""
                                         srcset=""
                                         class="employee-avatar"
                                    />
                                </div>
                                </c:if>
                                <div class="card-task-footer" style="display:flex;justify-content: center;">

                                    <a href="EditTask?taskId=${task.idTask}"><input type="button" style="display: inline-block;color: #ffffff; text-align: center;vertical-align: middle;  border: 1px solid transparent;  background: #f36f2e;  font-size: 1rem;  line-height: 1.5;  cursor: pointer;  width: 8rem;  height: 2rem;border-radius: 50px;" value="Edit "></a>
                                </div>
                            </div>
                        </c:forEach>


                    </div>
                </div>
            </div>
        </div>

    </main>

</div></body>
</html>
