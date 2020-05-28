package member.dto;

import java.time.LocalDateTime;
import java.util.Date;

import member.service.WrongIdPasswordException;

public class Member {

	private long memberno;
	private String memberid;
	private String name;
	private String password;
	private LocalDateTime regdate;
	private String power;

	public Member(String memberid, String name, 
			String password, LocalDateTime regdate) {
		this.memberid = memberid;
		this.name = name;
		this.password = password;
		this.regdate = regdate;
	}

	



	public long getMemberno() {
		return memberno;
	}



	public void setMemberno(long memberno) {
		this.memberno = memberno;
	}



	public String getMemberid() {
		return memberid;
	}



	public String getName() {
		return name;
	}



	public String getPassword() {
		return password;
	}



	public LocalDateTime getRegdate() {
		return regdate;
	}


	public String getPower() {
		return power;
	}



	public void setPower(String power) {
		this.power = power;
	}


	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}


}
