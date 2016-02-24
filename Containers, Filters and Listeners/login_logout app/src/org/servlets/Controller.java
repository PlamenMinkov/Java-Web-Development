package org.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/index")
public class Controller implements Servlet{

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		request.setAttribute("username", httpRequest.getSession().getAttribute("username"));
		request.setAttribute("version", "Version: 1.0");
		request.setAttribute("project", "ContainersFiltersAndSession_HW");
		//httpRequest.getSession().invalidate();
		String thisUsername = (String)request.getAttribute("username");
		
		if(request.getAttribute("username") != null &&
				thisUsername.compareTo("empty") == 0) {
			httpRequest.getSession().invalidate();
			
			RequestDispatcher requestDispacher = request.getRequestDispatcher("/login");
			requestDispacher.forward(request, response);
		}
		else{
			RequestDispatcher requestDispacher = request.getRequestDispatcher("/index.jsp");
			requestDispacher.forward(request, response);
		}
		
		
		

		//httpRequest.getSession().invalidate();
	}

}
