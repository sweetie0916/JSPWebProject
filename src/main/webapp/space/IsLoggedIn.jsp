<%@page import="utils.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
/*
�α��� üũ�� ���� ���Ϸ� ���ǿ����� UserId��� �Ӽ����� ������
JS�� ���â(alert)�� ��� �� �α��� �������� �̵�(location)�Ѵ�. 
�α����� �ʿ��� ��� ������ ��ܿ� include ���þ ���� ���Խ�ų
�����̴�. 
*/
if (session.getAttribute("UserId") == null) {
    JSFunction.alertLocation("�α��� �� �̿����ֽʽÿ�.",
                             "../member/login.jsp", out);
    /* JSP�� Tomcat���� Java�� ��ȯ�Ǹ� ��ũ��Ʈ���� �ۼ��� �ڵ�� 
    _jspService()�޼��� ���ο� ����ȴ�. ���� return�� �ش� �޼�����
    ������ �����Ѵٴ� �ǹ̸� ������. return������ ������ ������� �ʴ´�.*/
	return;
}
%>