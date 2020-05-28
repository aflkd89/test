package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import auth.service.AuthService;
import member.dao.MemberDao;
import member.service.ChangePasswordService;
import member.service.MemberRegisterService;


@Configuration
@EnableTransactionManagement
public class MemberConfig {
	
	//@Autowired - DsDevConfig 등의 config에서 등록한 DataSource 가져옴
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource);
		return tm;
	}

	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource);
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}

	@Bean
	public ChangePasswordService changePwdSvc() {
		ChangePasswordService pwdSvc = new ChangePasswordService();
		pwdSvc.setMemberDao(memberDao());
		return pwdSvc;
	}
	

	
	@Bean
	public AuthService authService() {
		AuthService authService = new AuthService();
		authService.setMemberDao(memberDao());
		return authService;
	}
}
