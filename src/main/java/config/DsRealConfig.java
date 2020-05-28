package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("real")	//배포 시 적용될 설정 - web.xml에서 dev->real
public class DsRealConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		//실제 서비스 상황에서는 db 경로가 외부 서버일 가능성이 높다(서버 instance가 다를수도 있고)
		ds.setUrl("jdbc:mysql://realdb/project1?characterEncoding=utf8");
		//특정 ip(WAS ip)에서 접근할 수 있는 user 생성하여 사용
		ds.setUsername("root");
		ds.setPassword("admin");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
		return ds;
	}
}
