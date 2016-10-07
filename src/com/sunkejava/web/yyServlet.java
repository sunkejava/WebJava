package com.sunkejava.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class yyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5626721625469230197L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, resonse);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException {
		String searchContext = request.getParameter("searchContext");
		System.out.println("searchContext¡·¡·¡·¡·¡·¡·"+searchContext);
		
	}
	
	
}
