	package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import member.dto.Member;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;
	private RowMapper<Member> memRowMapper = 
			new RowMapper<Member>() {
				@Override
				public Member mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Member member = new Member(rs.getString("member_id"),
							rs.getString("member_name"),
							rs.getString("member_pw"),
							rs.getTimestamp("regdate").toLocalDateTime());
					member.setMemberno(rs.getLong("member_no"));
					member.setPower(rs.getString("power"));
					return member;
				}
			};

	@Autowired
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Member selectById(String email) {
		List<Member> results = jdbcTemplate.query(
				"select * from member where member_id = ?",
				memRowMapper, email);

		return results.isEmpty() ? null : results.get(0);
	}

	public void insert(final Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
				PreparedStatement pstmt = con.prepareStatement(
						"insert into member (memberid, name, password, regdate) " +
								"values (?, ?, ?, ?)",
						new String[] { "memberno" });
				// 인덱스 파라미터 값 설정
				pstmt.setString(1, member.getMemberid());
				pstmt.setString(2, member.getName());
				pstmt.setString(3, member.getPassword());
				pstmt.setTimestamp(4,
						Timestamp.valueOf(member.getRegdate()));
				// 생성한 PreparedStatement 객체 리턴
				return pstmt;
			}
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setMemberno(keyValue.longValue());
	}

	public void update(Member member) {
		jdbcTemplate.update(
				"update MEMBER set NAME = ?, PASSWORD = ? where memberid = ?",
				member.getName(), member.getPassword(), member.getMemberid());
	}

	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from MEMBER",
				memRowMapper);
		return results;
	}

	public int count() {
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;
	}

	public List<Member> selectByRegdate(LocalDateTime from, LocalDateTime to) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where REGDATE between ? and ? " +
						"order by REGDATE desc",
				memRowMapper,
				from, to);
		return results;
	}

	public Member selectByNo(Long memNo) {
		List<Member> results = jdbcTemplate.query(
				"select * from MEMBER where memberno = ?",
				memRowMapper, memNo);

		return results.isEmpty() ? null : results.get(0);
	}

}
