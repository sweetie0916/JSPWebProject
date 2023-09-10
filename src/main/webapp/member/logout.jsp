<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
//로그아웃 처리1 : session영역의 속성명을 지정해서 삭제한다. 
session.removeAttribute("UserId");
session.removeAttribute("UserName");
session.removeAttribute("UserEmail");

//로그아웃 처리 후 로그인 페이지로 '이동'한다. 
response.sendRedirect("login.jsp");
%>