package br.edu.ifsp.cmp.tads.dsw.t1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.cmp.tads.dsw.t1.CatalogoPalavras;
import br.edu.ifsp.cmp.tads.dsw.t1.Jogo;

@WebServlet("/jogar")
public class JogoForca extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JogoForca() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palavra = getCatalogoPalavras(request).getPalavra();
		
		if (palavra == null) {
			response.sendRedirect("/cadastro-palavras");
		} else {
			iniciaJogo(request, palavra);
			request.getRequestDispatcher("WEB-INF/jogo.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Jogo jogo = getJogo(request);
		
		if (jogo == null) {
			response.sendRedirect("/cadastro-palavras");
		} else {
			request.setAttribute("jogo", jogo);
		}
		
		doGet(request, response);
	}

	private CatalogoPalavras getCatalogoPalavras(HttpServletRequest request) {
		CatalogoPalavras catalogo = (CatalogoPalavras) request.getSession().getAttribute("catalogo");
		
		if (catalogo == null) { return new CatalogoPalavras(); }
		else { return catalogo; }
	}
	
	private void iniciaJogo(HttpServletRequest request, String palavra) {
		HttpSession session = request.getSession();
		session.setAttribute("forca", new Jogo(palavra));
	}
	
	private Jogo getJogo(HttpServletRequest request) {
		return (Jogo) request.getSession().getAttribute("forca");
		
	}
}
