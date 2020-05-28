package auth.service;

public class LoginCommand {

	private String memberid;
	private String password;
	private boolean rememberId;

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isRememberId() {
		return rememberId;
	}

	public void setRememberId(boolean rememberId) {
		this.rememberId = rememberId;
	}

}
