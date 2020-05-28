package common;

public class Sql {

	//아이디로 회원조회
	static String select_from_member_by_id = "select * from member where memberid = ?";
	//회원 등록
	static String insert_into_member_using_MemberCst = "inset into member values(?,?,?,?)";


// con.prepareStatement(Sql.insert_into_member_using_MemberCst,String[]{"id"});

	
	static String update_member_name_password_by_email = 
			"update MEMBER set NAME = :name, PASSWORD = :password where EMAIL = :email";
	//dao에서 이렇게 사용
//	public void update(Member member) {
//		SqlParameterSource paramMap = new BeanPropertySqlParameterSource(member); 
//		System.out.println("update member: " + member);
//		namedParameterJdbcTemplate.update(GupagSql.update_member_name_password_by_email, paramMap);
//		 	
//	}
	
	
	public static String insert_into_item = "insert into item(item_code, item_name, item_detail, price, stock) values(?, ?, ?, ?, ?)";
	
	public static String select_from_item_code = "select count(*) from item where item_code = :itemCode";

//	public int countOfActorsByFirstName(String firstName) {
//
//	    String sql = "select count(*) from T_ACTOR where first_name = :first_name";
//
//	    SqlParameterSource namedParameters = new MapSqlParameterSource("first_name", firstName);
//
//	    return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters, Integer.class);
//	}

}
