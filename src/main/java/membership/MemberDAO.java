package membership;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

//JDBC를 위한 클래스를 상속하여 DB에 연결한다.
public class MemberDAO extends JDBConnect {

	//생성자 메서드 정의
	//매개변수가 4개인 부모의 생성자를 호출하여 DB연결
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	//application내장객체를 인수로 전달한 후 DB연결
	public MemberDAO(ServletContext app) {
		super(app);
	}
	
	/* 사용자가 입력한 아이디, 패스워드를 통해 회원테이블을 select한 후 
	존재하는 회원정보인 경우 DTO객체에 레코드를 담아 반환한다. */
	public MemberDTO getMemberDTO(String uid, String upass) {
	
		MemberDTO dto = new MemberDTO();
		
		String query = ""
}
