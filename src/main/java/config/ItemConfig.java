package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import item.dao.ItemDao;
import item.service.impl.ItemServiceImpl;

@Configuration
@EnableTransactionManagement
public class ItemConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource);
		return tm;
	}
	
	@Bean
	public ItemDao itemDao() {
		return new ItemDao(dataSource);
	}
	
	@Bean
	public ItemServiceImpl itemServiceImpl() {
		return new ItemServiceImpl(itemDao());
	}
}
