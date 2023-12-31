<%@page import="utils.JSFunction"%>
<%@page import="membership.MemberDAO"%>
<%@page import="membership.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//폼값받기
String name = request.getParameter("name");			
String id = request.getParameter("id");				
String pass = request.getParameter("pass");			
String telephone = request.getParameter("tel1")	
		 +"-"+request.getParameter("tel2")	
		 +"-"+request.getParameter("tel3");
String mobile = request.getParameter("mobile1")
		 +"-"+request.getParameter("mobile2")
		 +"-"+request.getParameter("mobile3");				 
String email = request.getParameter("email_1")+"@"+request.getParameter("email_2");
String open_email = request.getParameter("open_email");
String zipcode = request.getParameter("zipcode");
String addr1 = request.getParameter("addr1");
String addr2 = request.getParameter("addr2");

// DTO객체에 저장하기
MemberDTO dto = new MemberDTO();

dto.setName(name);
dto.setId(id);
dto.setPass(pass);
dto.setTelephone(telephone);
dto.setMobile(mobile);
dto.setEmail(email);
dto.setOpen_email(open_email);
dto.setZipcode(zipcode);
dto.setAddr1(addr1);
dto.setAddr2(addr2);

// DAO객체 생성 및 insert처리
MemberDAO dao = new MemberDAO(application);
int result = dao.registInsert(dto);
System.out.println("JSP="+result);

if 	(result==1){
   	out.println("입력성공");
	JSFunction.alertLocation("회원가입성공", "login.jsp", out);
}
else{
	out.println("입력실패");
	JSFunction.alertBack("회원가입실패", out);
	
}
%>