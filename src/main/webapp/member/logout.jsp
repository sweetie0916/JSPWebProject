<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
//�α׾ƿ� ó��1 : session������ �Ӽ����� �����ؼ� �����Ѵ�. 
session.removeAttribute("UserId");
session.removeAttribute("UserName");
session.removeAttribute("UserEmail");

//�α׾ƿ� ó�� �� �α��� �������� '�̵�'�Ѵ�. 
response.sendRedirect("login.jsp");
%>