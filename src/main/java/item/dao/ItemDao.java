package item.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import common.Sql;
import item.dto.Item;



public class ItemDao {
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private JdbcTemplate jdbcTemplate;
	private RowMapper<Item> memRowMapper = 
			new RowMapper<Item>() {
				@Override
				public Item mapRow(ResultSet rs, int rowNum)
						throws SQLException {
					Item item = new Item(
							rs.getString("item_name"),
							rs.getString("item_detail"),
							rs.getInt("price"),
							rs.getInt("stock"));
					item.setItemCode(rs.getString("item_code"));
					item.setItemNo(rs.getInt("item_no"));
					return item;
				}
			};
	
	@Autowired
	public ItemDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int insert(final Item item) {
		
		//String sql = "insert into item(item_code, item_name, item_detail, price, stock) values(?, ?, ?, ?, ?)";
		int result = jdbcTemplate.update(Sql.insert_into_item, item.getItemCode(), item.getItemName(), item.getItemDetail(), item.getPrice(), item.getStock());
		
		System.out.println(result + "개 행 삽입 성공!");
		return result;

	}
	
	public int selectByCode(String itemCode) {
		SqlParameterSource paramMap = new MapSqlParameterSource("itemCode",itemCode);
		return namedParameterJdbcTemplate.queryForObject(Sql.select_from_item_code, paramMap, Integer.class);
		
	}
}
