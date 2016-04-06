package br.edu.ifsp.cmp.tads.dsw.t1.servlets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.cmp.tads.dsw.t1.CatalogoPalavras;
import br.edu.ifsp.cmp.tads.dsw.t1.Jogo;

public abstract class ForcaServlet extends ApplicationServlet {
	private static final long serialVersionUID = 1L;
	protected static final String CATALOGO_PALAVRAS_SESSION_KEY = "catalogo";
	protected static final String JOGO_ATTRIBUTE_KEY = "forca";

	protected CatalogoPalavras getCatalogoPalavras(HttpServletRequest request) {
		HttpSession session = request.getSession();
		CatalogoPalavras catalogo =
				(CatalogoPalavras) session.getAttribute(CATALOGO_PALAVRAS_SESSION_KEY);
		
		if (catalogo == null) { catalogo = new CatalogoPalavras(); }
		session.setAttribute(CATALOGO_PALAVRAS_SESSION_KEY, catalogo);
		
		return catalogo;
	}
	
	protected void setCatalogoPalavras(HttpServletRequest request, CatalogoPalavras catalogo) {
		request.getSession().setAttribute(CATALOGO_PALAVRAS_SESSION_KEY, catalogo);
	}
	
	protected Jogo getJogo(HttpServletRequest request) {
		return (Jogo) request.getAttribute(JOGO_ATTRIBUTE_KEY);
	}
	
	protected void iniciaJogo(HttpServletRequest request, String palavra) {
		Jogo jogo = new Jogo(palavra);
		
		request.setAttribute(JOGO_ATTRIBUTE_KEY, jogo);
	}
}
