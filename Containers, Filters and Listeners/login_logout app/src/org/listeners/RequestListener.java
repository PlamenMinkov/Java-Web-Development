package org.listeners;

import java.util.*;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("Request Session ID: " + ((HttpServletRequest) event.getServletRequest()).getSession().getId());
		System.out.println("IP address: " + event.getServletRequest().getLocalAddr());
		System.out.println("Content type: " + event.getServletRequest().getContentType());
		System.out.println("Data time: " + new java.util.Date());
	}

}
