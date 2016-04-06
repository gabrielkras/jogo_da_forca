package br.edu.ifsp.cmp.tads.dsw.t1.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.cmp.tads.dsw.t1.CatalogoPalavras;
import br.edu.ifsp.cmp.tads.dsw.t1.Jogo;

@WebServlet("/jogar")
public class JogoForca extends ForcaServlet {
	private static final long serialVersionUID = 1L;

    public JogoForca() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String palavra = getCatalogoPalavras(request).getPalavra();
		
		if (palavra == null) {
			redirect(request, response, "cadastro-palavras");
		} else {
			iniciaJogo(request, palavra);
			render(request, response, "jogo");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Jogo jogo = getJogo(request);
		
		if (jogo == null) {
			doGet(request, response);
		} else {
			String letra = request.getParameter("letra").toString();
			
			if (!letra.isEmpty()) {
				jogo.chutar(letra.charAt(0));
			}
			
			request.setAttribute("jogo", jogo);
			render(request, response, "jogo");
		}
	}
}
