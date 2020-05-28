package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import auth.controller.LoginController;
import auth.service.AuthService;
import item.controller.ItemController;
import item.service.ItemService;
import item.service.impl.ItemServiceImpl;
import member.controller.ChangePwdController;
import member.controller.LogoutController;
import member.controller.RegisterController;
import member.dao.MemberDao;
import member.service.ChangePasswordService;
import member.service.MemberRegisterService;


@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegSvc;
	@Autowired
	private AuthService authService;
	@Autowired
	private ChangePasswordService changePasswordService;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private ItemServiceImpl itemServiceImpl;


	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}

	@Bean
	public LoginController loginController() {
		LoginController controller = new LoginController();
		controller.setAuthService(authService);
		return controller;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController controller = new ChangePwdController();
		controller.setChangePasswordService(changePasswordService);
		return controller;
	}
	
	@Bean
	public ItemController itemController() {
		ItemController itemController = new ItemController();
		itemController.setItemServiceImpl(itemServiceImpl);
		return itemController;
	}
	
//	@Bean
//	public AdminLoginController adminLoginController() {
//		AdminLoginController adminLoginController = new AdminLoginController();
//		adminLoginController.setAuthService(authService);
//		return adminLoginController;
//	}
//	
//	@Bean
//	public MemberListController memberListController() {
//		MemberListController controller = new MemberListController();
//		controller.setMemberDao(memberDao);
//		return controller;
//	}
//	
//	@Bean
//	public MemberDetailController memberDetailController() {
//		MemberDetailController controller = new MemberDetailController();
//		controller.setMemberDao(memberDao);
//		return controller;
//	}
}
