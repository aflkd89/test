package member.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import member.dao.MemberDao;
import member.dto.Member;

@Service("memberRegSvc")
public class MemberRegisterService {

	private MemberDao memberDao;

	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public String register(RegisterRequest req) {
		Member member = memberDao.selectById(req.getMemberid());
		if (member != null) {
			throw new DuplicateMemberException("dup email " + req.getMemberid());
		}
		Member newMember = new Member(
				req.getMemberid(),  req.getName(), req.getPassword(),
				LocalDateTime.now());
		memberDao.insert(newMember);
		return newMember.getMemberid();
	}
}
