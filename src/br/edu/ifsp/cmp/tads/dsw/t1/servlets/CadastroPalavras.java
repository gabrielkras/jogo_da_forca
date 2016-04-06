package br.edu.ifsp.cmp.tads.dsw.t1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.cmp.tads.dsw.t1.CatalogoPalavras;

@WebServlet("/cadastro-palavras" )
public class CadastroPalavras extends ForcaServlet {
	private static final long serialVersionUID = 1L;
       
    public CadastroPalavras() { super(); }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("podeJogar", "disabled");
		request.setAttribute("quantidadeDePalavras", "0");
		
		render(request, response, "home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatalogoPalavras catalogo = getCatalogoPalavras(request);
		String palavra = request.getParameter("palavra");
		
		catalogo.addPalavra(palavra);
		
		request.setAttribute("podeJogar", podeJogar(catalogo) ? "" : "disabled");
		request.setAttribute("quantidadeDePalavras", catalogo.quantidadeDePalavras());
		
		render(request, response, "home");
	}
	
	private boolean podeJogar(CatalogoPalavras catalogo) {
		return catalogo.quantidadeDePalavras() >= 5;
	}
}
