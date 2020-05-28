package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")	//web.xml에 설정한 이름 - 개발 시에 설정할 프로파일(설정)ㄴ
public class DsDevConfig {
//DataSource 설정(connectionPool)
	
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/project1?characterEncoding=utf8&serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("admin");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setMinIdle(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
}
