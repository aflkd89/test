package config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import interceptor.AdminAuthCheckInterceptor;
import interceptor.AuthCheckInterceptor;


@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureDefaultServletHandling(
			DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/", ".jsp");
	}

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		// /admin접속시 로그인 체크 -> 로그인form / admin홈
//		registry.addViewController("/admin").setViewName("admin/adminHome");
//	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(authCheckInterceptor())
			.addPathPatterns("/edit/**")
			.excludePathPatterns("/edit/help/**");
		
//		registry.addInterceptor(adminAuthCheckInterceptor())
//		.addPathPatterns("/admin/**").excludePathPatterns("/admin/adminLogin/**");
	}

	@Bean
	public AuthCheckInterceptor authCheckInterceptor() {
		return new AuthCheckInterceptor();
	}
	
//	//관리자 로그인 체크
//	@Bean
//	public AdminAuthCheckInterceptor adminAuthCheckInterceptor() {
//		return new AdminAuthCheckInterceptor();
//	}
	
	

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("message.label");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}

}
