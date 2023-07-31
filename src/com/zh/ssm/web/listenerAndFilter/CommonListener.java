package com.zh.ssm.web.listenerAndFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.websocket.Session;

import javafx.scene.Scene;
//import sun.print.resources.serviceui_sv;

/**
 * Application Lifecycle Listener implementation class CommonListener
 *
 */
@WebListener
public class CommonListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public CommonListener() {
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
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    	ServletContext servletContext = sce.getServletContext();
    	//ctx为变量名，将前台页面的路径传递给“ctx”
    	String ctx = servletContext.getContextPath();
    	//resource为本地文件夹路径
    	servletContext.setAttribute("ctx",ctx);
    	servletContext.setAttribute("inf",ctx+"/WEB-INF");
    	servletContext.setAttribute("res",ctx+"/resource");
    	servletContext.setAttribute("com",ctx+"/resource/common");
    	servletContext.setAttribute("js",ctx+"/resource/js");
    	servletContext.setAttribute("xhe",ctx+"/resource/xheditor");
    	servletContext.setAttribute("upl",ctx+"/resource/uploadify");
    	servletContext.setAttribute("thm",ctx+"/resource/themes");
    	servletContext.setAttribute("css",ctx+"/resource/themes/css");
    }
	
}
