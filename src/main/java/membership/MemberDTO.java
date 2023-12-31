package membership;

public class MemberDTO {

	//멤버변수
	private String name;	//이름
	private String id;		//아이디
	private String pass;	//비밀번호
	private String telephone;//전화번호
	private String mobile;	//핸드폰번호
	private String email;	//이메일
	private String open_email;//이메일 수신 여부
	private String zipcode;	//우편번호
	private String addr1;	//기본주소
	private String addr2;	//상세주소
	
	
	//getter / setter 정의
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOpen_email() {
		return open_email;
	}
	public void setOpen_email(String open_email) {
		this.open_email = open_email;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	
}
