package br.edu.ifsp.cmp.tads.dsw.t1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class ApplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VIEW_ROOT= "/WEB-INF";
	
	protected String viewPath(String view) {
		return new StringBuilder(VIEW_ROOT).append(viewDir()).append(view).append(".jsp").toString();
	}
	
	protected String viewDir() {
		return "/";
	}
	
	protected void render(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException {
		request.getRequestDispatcher(viewPath(view)).forward(request, response);
	}
	
	protected void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		String fullPath = new StringBuilder(request.getContextPath())
				.append("/").append(path).toString();
		
		response.sendRedirect(fullPath);
	}
}
