package br.edu.ifsp.cmp.tads.dsw.t1.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.cmp.tads.dsw.t1.CatalogoPalavras;

/**
 * Servlet implementation class CadastroPalavras
 */
@WebServlet(description = "Servlet que realiza o cadastro das palavras", urlPatterns = { "/cadastro-palavras" })
public class CadastroPalavras extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPalavras() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession sessao = request.getSession();
		if(sessao.getAttribute("catalogo") != null){
			if(request.getAttribute("palavra") != null){
				System.out.println(request.getAttribute("palavra"));
			}
		}*/
		request.setAttribute("podeJogar", "disabled");
		request.setAttribute("quantidadeDePalavras", "0");
		request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sessao = request.getSession();
		if(sessao.getAttribute("catalogo") != null){
			if(request.getParameter("palavra") != null){
				CatalogoPalavras catalogo = (CatalogoPalavras) sessao.getAttribute("catalogo");
				catalogo.addPalavra(request.getParameter("palavra"));
			}
		}
		else{
			CatalogoPalavras catalogo = new CatalogoPalavras();
			catalogo.addPalavra(request.getParameter("palavra"));
			sessao.setAttribute("catalogo", catalogo);
		}
		CatalogoPalavras catalogoDaSessao = (CatalogoPalavras) sessao.getAttribute("catalogo");
		if(catalogoDaSessao.quantidadeDePalavras() >= 5)
		{
			request.setAttribute("podeJogar", "");
			request.setAttribute("quantidadeDePalavras", catalogoDaSessao.quantidadeDePalavras());
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		}
		else{
			request.setAttribute("podeJogar", "disabled");
			request.setAttribute("quantidadeDePalavras", catalogoDaSessao.quantidadeDePalavras());
			request.getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
		}
	}
}
