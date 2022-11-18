<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %><%@ page import="java.util.*, java.lang.*" %><%@ page import="java.text.*, java.net.InetAddress" %>
<c:set var="path1" value="${request.getContextPath() }" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <jsp:include page="/head.jsp" />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>군산 문화 관광</title>
    <!-- 제이쿼리 -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <!-- 부트스트랩  -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    <!-- 타이핑 플러그인 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&display=swap" rel="stylesheet">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Jua&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <style>
      .carousel-inner>.carousel-item>img {
        width: 640px;
        height: 720px;
      }
      .container {
    margin-top: 50px;
}

      .h3,
      h3 {
        font-size: 50px;
        font-family: 'Jua' !important;
      }

      .h1,
      h1 {
        font-size: 80px;
        padding-bottom: 300px;
        font-family: 'Nanum Pen Script' !important;
      }
    </style>
  </head>
  <jsp:include page="/header.jsp" />
  <body>
    <div class="container">
      <div id="demo" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
          <!-- 슬라이드 쇼 -->
          <div class="carousel-item active">
            <!--가로-->
            <img class="d-block w-100" src="img/1.gif" alt="First slide">
            <div class="carousel-caption d-none d-md-block">
              <h3>근대역사와 해양중심의 도시! <br>명품관광 군산으로 오세요! </h3>
              <br>
              <h1>Go! 군산 군도</h1>
            </div>
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/2.gif" alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
              <h3>근대역사와 해양중심의 도시! <br>명품관광 군산으로 오세요! </h3>
              <br>
              <h1>은파호수공원</h1>
            </div>
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/3.gif" alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
              <h3>근대역사와 해양중심의 도시! <br>명품관광 군산으로 오세요! </h3>
              <br>
              <h1>군산근대역사박물관</h1>
            </div>
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/4.gif" alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
              <h3>근대역사와 해양중심의 도시! <br>명품관광 군산으로 오세요! </h3>
              <br>
              <h1>월명공원</h1>
            </div>
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/5.gif" alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
              <h3>근대역사와 해양중심의 도시! <br>명품관광 군산으로 오세요! </h3>
              <br>
              <h1>새만금방조제</h1>
            </div>
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/6.gif" alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
              <h3>근대역사와 해양중심의 도시! <br>명품관광 군산으로 오세요! </h3>
              <br>
              <h1>철새조망대</h1>
            </div>
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/7.jpg" alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
              <h3>근대역사와 해양중심의 도시! <br>명품관광 군산으로 오세요! </h3>
              <br>
              <h1>초원사진관</h1>
            </div>
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/8.jpg" alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
              <h3>근대역사와 해양중심의 도시! <br>명품관광 군산으로 오세요! </h3>
              <br>
              <h1>경암동 철길마을</h1>
            </div>
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="img/9.jpg" alt="Second slide">
            <div class="carousel-caption d-none d-md-block">
              <h3>근대역사와 해양중심의 도시! <br>명품관광 군산으로 오세요! </h3>
              <br>
              <h1>군산3.1운동 100주년 기념관</h1>
            </div>
          </div>
          <!-- / 슬라이드 쇼 끝 -->
          <!-- 왼쪽 오른쪽 화살표 버튼 -->
          <a class="carousel-control-prev" href="#demo" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <!-- <span>Previous</span> -->
          </a>
          <a class="carousel-control-next" href="#demo" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <!-- <span>Next</span> -->
          </a>
          <!-- / 화살표 버튼 끝 -->
          <!-- 인디케이터 -->
          <ul class="carousel-indicators">
            <li data-target="#demo" data-slide-to="0" class="active"></li>
            <!--0번부터시작-->
            <li data-target="#demo" data-slide-to="1"></li>
            <li data-target="#demo" data-slide-to="2"></li>
            <li data-target="#demo" data-slide-to="3"></li>
            <li data-target="#demo" data-slide-to="4"></li>
            <li data-target="#demo" data-slide-to="5"></li>
            <li data-target="#demo" data-slide-to="6"></li>
            <li data-target="#demo" data-slide-to="7"></li>
            <li data-target="#demo" data-slide-to="8"></li>
            <li data-target="#demo" data-slide-to="9"></li>
          </ul>
          <!-- 인디케이터 끝 -->
        </div>
      </div>
      <script>
        $('.carousel').carousel({
          interval: 2000 //기본 5초
        })
      </script>
  </body>
</html>