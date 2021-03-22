package entryPoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import useCase.useCaseCalculadora;


@WebServlet(name = "calcula", urlPatterns = { "/calcula" })
public class Calcula extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public Calcula() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new useCaseCalculadora(request, response).execute();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
