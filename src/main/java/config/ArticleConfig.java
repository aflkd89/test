package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import article.service.WriteArticleService;

@Configuration
@EnableTransactionManagement
public class ArticleConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource);
		return tm;
	}
	
//	@Bean 
//	public WriteArticleService writeArticleSvc() {
//		WriteArticleService mwaSvc = new WriteArticleService();
//		mwaSvc.setArticleDao(articleDao());
//	}
	
}
