package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class AdminAuthCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if(session != null) {
			Object adminAuthInfo = session.getAttribute("adminAuthInfo");
			if(adminAuthInfo != null) {
				return true;
			}
		}
		response.sendRedirect(request.getContextPath() + "/admin");
		return false;
	}
}
