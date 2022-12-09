<%--
  Created by IntelliJ IDEA.
  User: hyunsoolim
  Date: 2022/12/06
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>index</title>
  <style>
    html, body { margin: 0; padding: 0; height: 100%;}
    header { width: 100%; height: 7%; background-color: royalblue; color: white;}
    nav { width: 100%; height: 3%; float: left; background-color: mediumpurple; color: white;}
    section { width: 100%; height: 85%; float: left; background-color: darkgray;}
    footer { width: 100%; height: 5%; clear: both; background-color: royalblue; color: white; text-align: center;}
    h1 { text-align: center; }
    h2 { text-align: center; }
    a { color: white; }
  </style>
</head>
<body>
<header>
  <h1>쇼핑몰 회원관리 ver 1.0</h1>
</header>
<nav>
  <a href="registration.do">회원등록</a>
  <a href="list.do">회원목록조회/수정</a>
  <a href="sales.do">회원매출조회</a>
  <a href="index.jsp">홈으로.</a>
</nav>
<section>
  <h2>쇼핑몰 회원관리 프로그램</h2>
  쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작서하는 프로그램이다.<br>
  프로그램 작성 순서<br>
  s1.회원정보 테이블을 생성한다.<br>
  2.매출정보 테이블을 생성한다.<br>
  3.회원정보, 매출정보 테이블에 제시된 문제지의 참조데이터를 추가 생성한다.<br>
  4.회원정보 입력 화면프로그램을 작성한다.<br>
  5.회원정보 조회 프로그램을 작성한다.<br>
  6.회원매출정보 조회 프로그램을 작성한다.
</section>
<footer>
  <h3>HRD KOREA Copyright © 2016 All rights reserved Human Resources Development Service of Korea.</h3>
</footer>
</body>
</html>
