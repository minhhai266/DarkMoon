<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>${pageTitle}</title>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
            <meta name="theme-color" content="#0A0806">
        </head>

        <body>
            <canvas id="sandstorm"></canvas>

            <div class="fog-container">
                <div class="fog fog1"></div>
                <div class="fog fog2"></div>
                <div class="fog fog3"></div>
            </div>
            <!-- NAVBAR -->
            <nav class="navbar" role="navigation" aria-label="Main navigation">
                <a href="/" class="navbar-brand">MOON BLIGHT</a>

                <ul class="navbar-nav">
                    <li class="nav-item "><a data-target="home" href="/" class="nav-down ${activePage == 'home' ? 'active' : ''}">Trang chủ</a></li>
                    <li class="nav-item "><a data-target="story"  class="nav-down ${activePage == 'story' ? 'active' : ''}">Cốt truyện</a></li>
                    <li class="nav-item "><a data-target="character"  class="nav-down ${activePage == 'characters' ? 'active' : ''}">Nhân vật</a></li>
                    <!-- <li class="nav-item"><a href="/enemies" class="${activePage == 'enemies' ? 'active' : ''}">Quái vật</a></li>
                    <li class="nav-item"><a href="/weapons" class="${activePage == 'weapons' ? 'active' : ''}">Vũ khí</a></li> -->
                    <li class="nav-item "><a data-target="world"  class="nav-down ${activePage == 'world' ? 'active' : ''}">Thế giới</a></li>
                    <li class="nav-item "><a data-target="news"  class="nav-down ${activePage == 'news' ? 'active' : ''}">Tin tức</a></li>
                    <li class="nav-item "><a href="/aboutUs"  class=" ${activePage == 'community' ? 'active' : ''}">Về Chúng Tôi</a></li>
                </ul>

                <a href="/support" class="navbar-cta">Support</a>
                <button class="hamburger" id="hamburger" aria-label="Toggle menu" aria-expanded="false">
                    <span></span>
                    <span></span>
                    <span></span>
                </button>
            </nav>

            <!-- MOBILE MENU -->
            <div class="mobile-menu" id="mobileMenu" aria-hidden="true">
                <ul class="mobile-menu-list">
                    <li><a data-target="home"  class="nav-down ${activePage == 'home' ? 'active' : ''}">Trang chủ</a></li>
                    <li><a data-target="story"  class="nav-down ${activePage == 'story' ? 'active' : ''}">Cốt truyện</a></li>
                    <li><a data-target="character"  class="nav-down ${activePage == 'characters' ? 'active' : ''}">Nhân vật</a></li>
                    <!-- <li><a class="nav-down" href="/enemies" class="nav-down ${activePage == 'enemies' ? 'active' : ''}">Quái vật</a></li>
                    <li><a class="nav-down" href="/weapons" class="nav-down ${activePage == 'weapons' ? 'active' : ''}">Vũ khí</a></li> -->
                    <li><a data-target="world"   class="nav-down ${activePage == 'world' ? 'active' : ''}">Thế giới</a></li>
                    <li><a data-target="news"   class="nav-down ${activePage == 'news' ? 'active' : ''}">Tin tức</a></li>
                    <li><a href="/aboutUs"   class=" ${activePage == 'community' ? 'active' : ''}">Về Chúng Tôi</a></li>
                    <li><a data-target="support"   class="nav-down ${activePage == 'support' ? 'active' : ''}">Support</a></li>

                </ul>
            </div>