package auth.service;

import member.dao.MemberDao;
import member.dto.Member;
import member.service.WrongIdPasswordException;

public class AuthService {

	private MemberDao memberDao;

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public AuthInfo authenticate(String memberid, String password) {
		Member member = memberDao.selectById(memberid);
		
		if (member == null) {
			throw new WrongIdPasswordException();
		}
		if (!member.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(member.getMemberno(), member.getMemberid(),
				member.getName(), member.getPower());
	}

}
