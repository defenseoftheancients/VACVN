package com.vacvn.filter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;



@WebListener
public class FilterConfigurator implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		
		FilterRegistration.Dynamic authenticationRegistration = context.addFilter("authenticationFilter", new AuthenticationFilter());
		authenticationRegistration.setAsyncSupported(true);
		authenticationRegistration.addMappingForUrlPatterns(null, false, "/admin/home", "/admin/user", "/admin/vaccine", "/admin/admin",
				"/admin/vaccinationschedule");
		
//		, "/user", "/vaccine", "/admin", "/vaccinationschedule"
		FilterRegistration.Dynamic corsRegistration = context.addFilter("corsFilter", new CORSInterceptor());
		corsRegistration.setAsyncSupported(true);
		corsRegistration.addMappingForUrlPatterns(null, false, "/api/*");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}
}
