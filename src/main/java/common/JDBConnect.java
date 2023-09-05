package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletContext;

// DB연결을 위한 클래스 생성
public class JDBConnect {
	
	// 멤버변수 : DB연결, 쿼리문 실행 및 전송, 결과셋 반환
    public Connection con;
    public Statement stmt;  
    public PreparedStatement psmt;  
    public ResultSet rs;
    
    //인자생성자2 : JSP에서 application 내장객체를 매개변수로 전달한다.
    public JDBConnect(ServletContext application) {
    	// Java클래스의 메서드내에서 web.xml을 접근한다.
    	String driver = application.getInitParameter("OracleDriver"); 
        String url = application.getInitParameter("OracleURL");
        String id = application.getInitParameter("OracleId");
        String pwd = application.getInitParameter("OraclePwd");
        
        try {
            Class.forName(driver);  
            con = DriverManager.getConnection(url, id, pwd);

            System.out.println("DB 연결 성공(인자생성자2)");
        }
        catch (Exception e) {            
            e.printStackTrace();
        }
    }
        
     
    //자원반납
    public void close() { 
        try {
            if (rs != null) rs.close(); 
            if (stmt != null) stmt.close();
            if (psmt != null) psmt.close();
            if (con != null) con.close(); 

            System.out.println("JDBC 자원 해제");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
