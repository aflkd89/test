package auth.service;

public class AuthInfo {

	private Long memberno;
	private String memberid;
	private String name;
	private String power;

	public AuthInfo(Long memberno, String memberid, String name, String power) {
		this.memberno = memberno;
		this.memberid = memberid;
		this.name = name;
		this.power = power;
	}

	public Long getMemberno() {
		return memberno;
	}

	public String getMemberid() {
		return memberid;
	}

	public String getName() {
		return name;
	}

	public String getPower() {
		return power;
	}
	

}
