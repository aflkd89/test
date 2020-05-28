package member.service;

import org.springframework.transaction.annotation.Transactional;

import member.dao.MemberDao;
import member.dto.Member;

public class ChangePasswordService {

	private MemberDao memberDao;

	@Transactional
	public void changePassword(String memberid, String oldPwd, String newPwd) {
		Member member = memberDao.selectById(memberid);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

}
