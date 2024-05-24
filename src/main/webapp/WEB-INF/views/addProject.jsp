<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <style>@import url("https://fonts.googleapis.com/css2?family=Roboto:wght@400;700;900&display=swap");

    * {
        margin: 0;
        padding: 0;
        box-sizing: 0;
        font-family: "Roboto", sans-serif;
    }

    .container {
        max-width: 1280px;
        margin: 0 auto;
        position: relative;
    }

    .header {
        display: flex;
        align-items: center;
        flex-direction: column;
        min-width: 100%;
        /* height: 100vh; */
        margin-bottom: 50px;
    }

    .header::before {
        content: "";
        position: absolute;
        top: 0;
        left: 0;
        z-index: -1;
        width: 100%;
        height: 650px;
        background-image: url(https://i.ibb.co/c67BKdY/Design-sans-titre-1.png);
        background-size: cover;
        opacity: 0.9;
        clip-path: polygon(0 0, 100% 0%, 100% 25%, 0 50%);
    }

    .navbar {
        display: flex;
        justify-content: space-around;
        align-items: center;
        width: 100%;
        color: #fff;
        padding: 20px 120px;
        margin-bottom: 30px;
    }

    .navbar__menu {
        display: flex;
        align-items: center;
        justify-content: space-between;
        list-style: none;
    }

    .navbar__menu li {
        margin: 0 20px;
        cursor: pointer;
    }

    .navbar__logo .logonav {
        width:200px;
        height:auto;
        margin: 0 10px;
    }

    .navbar__signin button {
        padding: 5px 15px;
        border: none;
        border-radius: 45px;
        color: #fff;
        font-size: 14px;
        font-weight: bold;
        background-color: rgba(255, 255, 255, 0.42);
        cursor: pointer;
    }

    .header__info {
        display: flex;
        justify-content: space-around;
        padding: 0 50px;
    }

    .header__info--description {
        max-width: 50%;
    }

    .header__info--description h1 {
        font-size: 62px;
        font-weight: 900;
        color: #2e2e2e;
        margin-bottom: 10px;
    }

    .header__info--description p {
        color: #4e4e4e;
        line-height: 1.5;
        margin-bottom: 20px;
    }

    .header__info .btn {
        padding: 5px 10px;
        margin-right: 15px;
        background: none;
        border: none;
        font-weight: 700;
        font-size: 16px;
        cursor: pointer;
    }

    .header__info .btn-black {
        color: #fff;
        background-color: #2e2e2e;
        border-radius: 15px;
        padding: 5px 15px;
    }

    .header__info--image {
        width: 35%;
        height: auto;

    }

    .header__info--image img {
        width: 500px;
        height: auto;
    }

    .header__companies {
        display: flex;
        justify-content: space-around;
        align-items: center;
        flex-wrap: wrap;
        max-width: 600px;
        height: 100%;
        margin: 50px;
        padding: 0 100px;
    }
    .header__companies .header__companies--img {
        width: 100px;
        height: 100px;
        margin: 15px 25px;
        object-fit: contain;
    }

    .main__info::before {
        content: "";
        position: absolute;
        width: 100%;
        height: 500px;
        z-index: -1;
        background-color: #274b70;
        background-position: center;
        clip-path: polygon(0 25%, 100% 0%, 100% 75%, 0% 100%);
    }

    .main {
        display: flex;
        width: 100%;
        position: relative;
        margin-top: 100px;
        flex-direction: column;
    }

    .main__info {
        display: flex;
        justify-content: space-around;
        align-items: center;
        margin-bottom: 120px;
        padding: 0 100px;
    }

    .main__description {
        width: 60%;
    }

    .main__image {
        width: 30%;
        height: auto;
    }

    .main__image img {
        width: 367px;
        height:200px ;

        filter: drop-shadow(0 0 15px rgba(0, 0, 0, 0.6));
    }

    .main__description h2 {
        color: #f9f9f9;
        font-size: 36px;
        font-weight: 700;
        margin-bottom: 20px;
    }

    .main__description p {
        color: #f9f9f9;
        font-size: 18px;
        margin-bottom: 20px;
    }

    .main__description .btn-blue {
        padding: 10px;
        background: rgba(18, 212, 255, 0.78);
        border-radius: 45px;
        border: none;
        color: #fff;
        font-weight: bold;
        cursor: pointer;
    }



    .main__pictures img {
        width: 50%;
        height: 200px;
        object-fit: cover;
    }

    .footer {
        display: flex;
        justify-content: center;
        align-items: center;
        width: 100%;
        /* height: 100vh; */
        flex-direction: column;
    }

    .footer__title {
        text-align: center;
        font-size: 36px;
        font-weight: 900;
        margin: 50px;
        max-width: 838px;
    }

    .footer__images {
        display: flex;
        justify-content: space-around;
        align-items: center;
        margin: 50px;
        flex-wrap: wrap;
    }

    .footer__image {
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
        text-align: center;
        height: 200px;
        width: 190px;
        margin: 15px;
    }

    .footer__image img {
        width: 80px;
    }

    .footer__image h3 {
        margin: 15px;
        font-weight: bold;
    }

    .footer__image p {
        font-size: 18px;
    }

    .footer__image p span {
        color: #2fdf84;
        font-weight: bold;
    }

    .footer__logo {
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        margin: 50px;
    }

    .footer__logo--title {
        font-size: 36px;
        color: #656565;
        font-weight: 900;
        text-align: center;
    }

    .footer__logo--title::after {
        content: "";
        width: 239px;
        height: 25px;
        display: block;
        background-color: #2fdf84;
        margin: 0 auto;
    }

    .footer__logo p {
        color: #ababab;
        margin: 5px;
        font-size: 14px;
    }
    </style>
    <title>Landing Page Workshop</title>
</head>

<body>
<div class="container">
    <header class="header">
        <nav class="navbar">
            <div class="navbar__logo"><img class="logonav" src="https://i.ibb.co/h16QN6C/Construction-Xpert.png"></div>
            <ul class="navbar__menu">
                <li>Products</li>
                <li>Developers</li>
                <li>Company</li>
                <li>Pricing</li>
            </ul>
            <div class="navbar__signin">
                <button>Sign in</button>
            </div>
        </nav>
        <div class="header__info">
            <div class="header__info--description">
                <h1>Xpert Construction Service</h1>
                <p>
                    Build <strong>Right</strong> or concret
                </p>
                <div class="header__buttons">
                    <button class="btn btn-black">Login</button>
                    <button class="btn">More info &gt;</button>
                </div>
            </div>
            <div class="header__info--image">
                <img src="https://i.ibb.co/DL9xMKx/Design-sans-titre-2.png"  alt="" />
            </div>
        </div>
        <div class="header__companies">
            <img
                    src="https://www.amigoscode.dev/assets/thumbnails/courses/intellij.webp"
                    alt=""
                    class="header__companies--img"
            />
            <img  class="header__companies--img"
                  src="https://info.payara.fish/hubfs/jakarta%20ee-1.jpg"
                  alt=""

            />
            <img
                    src="https://assets-global.website-files.com/5dc9a42a673bd99449f9d6ae/6123bb3b5648224271227089_Screen-Shot-2018-11-19-at-8.43.27-PM.png"
                    alt=""
                    class="header__companies--img"
            />
            <img
                    src="https://logos-world.net/wp-content/uploads/2020/02/Canva-Logo.png"
                    alt=""
                    class="header__companies--img"
            />
            <img
                    src="https://www.syloe.com/wp-content/uploads/2020/08/apache-tomcat.jpg"
                    alt=""
                    class="header__companies--img"
            />
            <img
                    src="https://www.team-ever.com/wp-content/uploads/2017/08/WampServer-logo.png"
                    alt=""
                    class="header__companies--img"
            />
            <img
                    src="https://upload.wikimedia.org/wikipedia/commons/9/95/PhpMyAdmin_logo.png"
                    alt=""
                    class="header__companies--img"
            />
            <img
                    src="https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi-t-BzoxWdjI4D9n1VcF98oTwISkU9dpqIVfErP4ROycIpfkTQuRBuR-Q06vo-zdSs4YjuVS_aVJFUc816y27sFxHGtyolPh_T4elLK3X6q3CDUmhx-Gcj_ZaV5SPWUUneizS3LzbjCk0IDnlU0aeA3BcpIPYDfUxJhq1RIya-E1hDuSYUEVe1-X_mDOk/s750/enaa.png"
                    alt=""
                    class="header__companies--img"
            />
        </div>
    </header>
    <main class="main">
        <div class="main__info">
            <div class="main__description">
                <h2>Constuction Xpert Services  - Streamlining Construction Company Operations</h2>
                <p>
                    comprehensive platform designed to efficiently manage tasks and projects for construction companies of all sizes.
                    From scheduling and resource allocation to progress tracking and communication,
                </p>
                <button class="btn btn-blue">Read the docs &gt;</button>
            </div>
            <div class="main__image">
                <img src="https://i.ibb.co/DL9xMKx/Design-sans-titre-2.png" alt="" />
            </div>
        </div>


    </main>
    <footer class="footer">
        <h2 class="footer__title">
            A tecnology-Your Ultimate Construction Management Solution
        </h2>


        <div class="footer__logo">
            <h2 class="footer__logo--title">ConstructionXpert Services</h2>
            <p>2024 | Mohammed Amin EL KETTABI | ENAA</p>
        </div>
    </footer>
</div>
</body>
</html>
