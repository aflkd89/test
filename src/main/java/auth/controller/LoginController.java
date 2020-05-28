package auth.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import auth.service.AuthInfo;
import auth.service.AuthService;
import auth.service.LoginCommand;
import auth.service.LoginCommandValidator;
import member.service.WrongIdPasswordException;


@Controller
//@RequestMapping("/login")
public class LoginController {
    private AuthService authService;

    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String form(LoginCommand loginCommand,
    		@CookieValue(value = "REMEMBER", required = false) Cookie rCookie) {
		if (rCookie != null) {
			loginCommand.setMemberid(rCookie.getValue());
			loginCommand.setRememberId(true);
		}
    	return "login/loginForm";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST )
    public String submit(
    		LoginCommand loginCommand, Errors errors, HttpSession session,
    		HttpServletResponse response) {
    	//System.out.println(loginCommand.getMemberid() + " / " + loginCommand.getPassword());
        new LoginCommandValidator().validate(loginCommand, errors);
        if (errors.hasErrors()) {
        	System.out.println("hasErrors");
            return "login/loginForm";
        }
        try {
            AuthInfo authInfo = authService.authenticate(
                    loginCommand.getMemberid(),
                    loginCommand.getPassword());
            
            session.setAttribute("authInfo", authInfo);

			Cookie rememberCookie = 
					new Cookie("REMEMBER", loginCommand.getMemberid());
			rememberCookie.setPath("/");
			if (loginCommand.isRememberId()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);

            return "login/loginSuccess";
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "login/loginForm";
        }
    }
    
    
    //관리자 로그인
    
    @RequestMapping(value = "/admin", method=RequestMethod.GET)
    public String adminForm(LoginCommand loginCommand, @CookieValue(value = "REMEMBER", required = false) Cookie rCookie, HttpSession session) {
		
    	//로그인 한 회원 세션 삭제
    	if(session.getAttribute("authInfo") != null ) {
    		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
    		if(authInfo.getPower().equals("normal")) {
				System.out.println(session.getAttribute("authInfo"));
				session.invalidate();
				
				if (rCookie != null) {
					loginCommand.setMemberid(rCookie.getValue());
					loginCommand.setRememberId(true);
				}
				return "admin/adminLoginForm";
    		}
		}
    
    	return "admin/adminHome";
    }
    
    @RequestMapping(value = "/admin", method = RequestMethod.POST )
    public String adminSubmit(
    		LoginCommand loginCommand, Errors errors, HttpSession session,
    		HttpServletResponse response) {
        new LoginCommandValidator().validate(loginCommand, errors);
        if (errors.hasErrors()) {
            return "admin/adminLoginForm";
        }
        try {
            AuthInfo authInfo = authService.authenticate(
                    loginCommand.getMemberid(),
                    loginCommand.getPassword());
            
            session.setAttribute("authInfo", authInfo);

			Cookie rememberCookie = 
					new Cookie("REMEMBER", loginCommand.getMemberid());
			rememberCookie.setPath("/");
			if (loginCommand.isRememberId()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				rememberCookie.setMaxAge(0);
			}
			response.addCookie(rememberCookie);

            return "admin/adminHome";
        } catch (WrongIdPasswordException e) {
            errors.reject("idPasswordNotMatching");
            return "admin/adminLoginForm";
        }
    }
}
