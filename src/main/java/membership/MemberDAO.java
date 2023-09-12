package membership;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

public class MemberDAO extends JDBConnect {

		//생성자 메서드 정의 
		//매개변수가 4개인 부모의 생성자를 호출하여 DB연결
		public MemberDAO(String drv, String url, String id, String pw) {
			super(drv, url, id, pw);
		}
		
		//application내장객체를 인수로 전달한 후 DB연결
	    public MemberDAO(ServletContext application) {
	        super(application);
	    }
	
	//회원정보 입력을 위한 메서드 정의 
	public int registInsert(MemberDTO dto) {
		int result = 0;
		String query = "INSERT INTO regist_member VALUES ("
				+ " ?,?,?,?,?,?,"
				+ " ?,?,?,? )";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPass());
			psmt.setString(4, dto.getTelephone());
			psmt.setString(5, dto.getMobile());
			psmt.setString(6, dto.getEmail());
			psmt.setString(7, dto.getOpen_email());
			psmt.setString(8, dto.getZipcode());
			psmt.setString(9, dto.getAddr1());
			psmt.setString(10, dto.getAddr2());
		
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	 
	//아이디 중복확인을 위한 메서드 정의 
	public boolean idOverlap(String id) {
		//초기값은 true로 설정. 중복된 아이디가 없는 경우
		boolean retValue = true;
		//중복된 아이디가 있는지 확인하기 위한 쿼리문
		String sql = "SELECT COUNT(*) FROM regist_member WHERE id=?";
		try {
			//prepared객체 생성 및 인파라미터 설정
			psmt = con.prepareStatement(sql);
			psmt.setString(1, id);
			//select계열의 쿼리문이므로 반환타입은 ResultSet
			rs = psmt.executeQuery();
			//count()함수를 사용하므로 결과는 무조건 0 혹은 1
			//따라서 if()문을 사용할 필요없이 next()를 호출한다. 
			rs.next();
			int result = rs.getInt(1);
			//중복된 아이디가 있어 1이 반환되면 false를 반환한다. 
			if(result==1)
				retValue = false;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		//중복된 아이디가 없다면 0이므로 true를 반환한다. 
		return retValue;
	}
	
	/* 사용자가 입력한 아이디, 패스워드를 통해 회원테이블을 select한후
    존재하는 회원정보인 경우 DTO객체에 레코드를 담아 반환한다. */
    public MemberDTO getMemberDTO(String uid, String upass) {
    	
    	//회원인증을 위한 쿼리문을 실행한 후 회원정보를 저장하기 위해 생성
    	MemberDTO dto = new MemberDTO();
    	/* 로그인 폼에서 입력한 아이디, 비번을 통해 인파라미터를 설정할 수
    	있도록 쿼리문을 작성 */
    	String query = "SELECT * FROM regist_member WHERE id=? AND pass=?"; 

        try {
        	//쿼리문 실행을 위한 prepared객체 생성
            psmt = con.prepareStatement(query);
            //인파라미터를 설정
            psmt.setString(1, uid);     
            psmt.setString(2, upass);  
            //쿼리문을 실행한 후 ResultSet객체를 통해 결과 반환 
            rs = psmt.executeQuery();  

            //반환된 ResultSet객체에 정보가 있는지 확인한다. 
            if (rs.next()) {
            	//회원정보가 있다면 DTO객체에 저장한다. 
                dto.setId(rs.getString("id"));
                dto.setPass(rs.getString("pass"));
                dto.setName(rs.getString("name"));
                dto.setEmail(rs.getString("email"));
            }
        }
		catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
    
    //아이디 찾기
    public String getMemberId(String uname, String uemail) {
    	String id = null;
    	String query = " SELECT id FROM regist_member WHERE name=? AND email=? ";
    	try {
    		psmt = con.prepareStatement(query);
    		psmt.setString(1, uname);
    		psmt.setString(2, uemail);
    		rs = psmt.executeQuery();
    		
    		if (rs.next()) {
    			id = rs.getString("id");
    		}
    	}  catch (Exception e) {
    			e.printStackTrace();
    	}
    	
    	return id;
    }
    
    //비밀번호 찾기
    public String getMemberPw(String uid, String uname, String uemail) {
		String pw = null;
		String query = " SELECT pass FROM regist_member WHERE id=? AND name=? AND email=? ";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, uname);
			psmt.setString(3, uemail);
			rs = psmt.executeQuery();
			
			if (rs.next()) {
				pw = rs.getString("pass");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pw;
	}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}