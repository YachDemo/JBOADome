package cn.jboa.utils;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class EncodingFilter implements Filter {

	 private String charset = "UTF-8";
	 
	    public void destroy() {
	    	
	    }


	    public void doFilter(ServletRequest request, ServletResponse response,
	            FilterChain chain) throws IOException, ServletException {
	    	
	        HttpServletRequest req = (HttpServletRequest) request;
	        if(req.getMethod().equalsIgnoreCase("GET")) {
	        
	            if(!(req instanceof GetRequest)) {
	            
	                req = new GetRequest(req, charset);//����get�������
	            }
	        } else {
	      
	            req.setCharacterEncoding(charset);//����post�������
	        }
	        chain.doFilter(req, response);
	    }

	  
	    public void init(FilterConfig fConfig) throws ServletException {
	    	
	        String charset = fConfig.getInitParameter("charset");
	        if(charset != null && !charset.isEmpty()) {
	            this.charset = charset;
	        }
	    }
	}