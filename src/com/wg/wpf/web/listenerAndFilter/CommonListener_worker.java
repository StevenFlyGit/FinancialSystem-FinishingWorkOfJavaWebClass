package com.wg.wpf.web.listenerAndFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
//import sun.print.resources.serviceui_sv;
/**
 * Application Lifecycle Listener implementation class CommonListener_worker
 *
 */
@WebListener
public class CommonListener_worker implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CommonListener_worker() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent lis)  { 
         // TODO Auto-generated method stub
    	
    	ServletContext servletContext = lis.getServletContext();
    	//ctx为变量名，将前台页面的路径传递给“ctx”
    	String ctxsale = servletContext.getContextPath();
    	//resource为本地文件夹路径
    	servletContext.setAttribute("ctx",ctxsale);
    	servletContext.setAttribute("inf",ctxsale+"/WEB-INF");
    	servletContext.setAttribute("res",ctxsale+"/resource");
    	servletContext.setAttribute("com",ctxsale+"/resource/common");
    	servletContext.setAttribute("js",ctxsale+"/resource/js");
    	servletContext.setAttribute("xhe",ctxsale+"/resource/xheditor");
    	servletContext.setAttribute("upl",ctxsale+"/resource/uploadify");
    	servletContext.setAttribute("thm",ctxsale+"/resource/themes");
    	servletContext.setAttribute("css",ctxsale+"/resource/themes/css");
    	
    }
	
}
