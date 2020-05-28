package member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import auth.service.AuthInfo;
import member.service.ChangePasswordService;
import member.service.ChangePwdCommand;
import member.service.ChangePwdCommandValidator;
import member.service.WrongIdPasswordException;



@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {

	private ChangePasswordService changePasswordService;

	public void setChangePasswordService(
			ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}

	@GetMapping
	public String form(
			@ModelAttribute("command") ChangePwdCommand pwdCmd) {
		return "edit/changePwdForm";
	}

	@PostMapping
	public String submit(
			@ModelAttribute("command") ChangePwdCommand pwdCmd,
			Errors errors,
			HttpSession session) {
		new ChangePwdCommandValidator().validate(pwdCmd, errors);
		if (errors.hasErrors()) {
			return "edit/changePwdForm";
		}
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		try {
			changePasswordService.changePassword(
					authInfo.getMemberid(),
					pwdCmd.getCurrentPassword(),
					pwdCmd.getNewPassword());
			return "edit/changedPwd";
		} catch (WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
			return "edit/changePwdForm";
		}
	}
}
