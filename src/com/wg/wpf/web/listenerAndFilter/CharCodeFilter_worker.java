package com.wg.wpf.web.listenerAndFilter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharCodeFilter_worker
 */
@WebFilter("/CharCodeFilter_worker")
public class CharCodeFilter_worker implements Filter {

    /**
     * Default constructor. 
     */
    public CharCodeFilter_worker() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
//		过滤器的作用是将数据库中的中午字符转码(将IS8859-1装换成utf-8)
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if (req.getMethod().equalsIgnoreCase("post")){
//			post方式提交，直接设置编码格式
			req.setCharacterEncoding("utf-8");
		}
		else {
//			get方式提交，需要逐个字节进行转换
			request = new HttpServletRequestWrapper(req) {
				@Override
				public String getParameter(String name) {
					String value = null;
					if(super.getParameter(name) != null) {
						try {
							value = new String(super.getParameter(name).getBytes("iso8859-1"));
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}	
					}
					return value;
				}
			};
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
