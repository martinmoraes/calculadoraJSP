package useCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Calculadora;

public class useCaseCalculadora {

	private HttpServletRequest request;
	private HttpServletResponse response;

	public useCaseCalculadora(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public void execute() throws IOException, ServletException {
		RequestDispatcher rd = request.getRequestDispatcher("calculadora.jsp");
		
		try {
			Calculadora calculadora = this.createCalculadora();
			String resposta = this.respostaCalculo(calculadora);
//			response.getWriter().append(resposta);
			request.setAttribute("resposta", resposta);
			this.guardaNaSessao(resposta);
			
		} catch (NullPointerException e) {
			request.setAttribute("resposta", "Um dos valores não foi informado."); 
		} catch (NumberFormatException e) {
			request.setAttribute("resposta", "Um ou mais caractere(s) não são válidos."); 
		}

		rd.forward(request, response);
	}

	
	private void guardaNaSessao(String resposta) {
		HttpSession sessao = request.getSession(false);
		if(sessao != null) {
			List<String> listaRespostas = (List<String>) sessao.getAttribute("listaRespostas");
			if(listaRespostas == null) {
				listaRespostas = new ArrayList<String>();
			}
			
			listaRespostas.add(resposta);
			sessao.setAttribute("listaRespostas", listaRespostas);
		}
	}
	
	
	private String respostaCalculo(Calculadora calculadora) {
		return String.format("A %s de %s e %s resulta em %s", 
				calculadora.getOperacao(),
				calculadora.getValorUm(),
				calculadora.getValorDois(),
				calculadora.resultado());
	}
	
	private Calculadora createCalculadora() {
		Calculadora calculadora = new Calculadora();
		String valorUm = this.request.getParameter("valor_um");
		String valorDois = this.request.getParameter("valor_dois");
		calculadora.setValorUm(convertToFloat(valorUm));
		calculadora.setValorDois(convertToFloat(valorDois));
		calculadora.setOperacao(request.getParameter("operacao"));
		return calculadora;
	}

	private float convertToFloat(String valor) throws NullPointerException, NumberFormatException {
		return Float.parseFloat(valor);
	}

}
