<%--
  Created by IntelliJ IDEA.
  User: hyunsoolim
  Date: 2022/12/06
  Time: 5:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>insert</title>
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
      <h2>홈쇼핑 회원 등록</h2>
      <table width="800" border="1">
        <form action="insert.do" method="post">
          <tr>
            <td>회원번호(자동발생)</td>
            <td><input type="text" value="${custNo}" name="custNo" size="20"></td>
          </tr>
          <tr>
            <td>회원성명</td>
            <td><input type="text" name="custName" size="20"></td>
          </tr>
          <tr>
            <td>회원전화</td>
            <td><input type="text" name="phone" size="30"></td>
          </tr>
          <tr>
            <td>회원주소</td>
            <td><input type="text" name="address" size="50"></td>
          </tr>
          <tr>
            <td>가입일자</td>
            <td><input type="text" name="joinDate" size="20"></td>
          </tr>
          <tr>
            <td>고객등급[A:VIP,B:일반,C:직원]</td>
            <td><input type="text" name="grade" size="20"></td>
          </tr>
          <tr>
            <td>도시코드</td>
            <td><input type="text" name="city" size="20"></td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit" value="등록">
            <input type="button" value="조회"></td>
          </tr>
        </form>
      </table>
    </section>
    <footer>
      <h3>HRD KOREA Copyright © 2016 All rights reserved Human Resources Development Service of Korea.</h3>
    </footer>
  </body>
</html>
