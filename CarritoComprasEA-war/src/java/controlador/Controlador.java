/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.UtilidadesHTML;
import org.carritocompras.entidades.Producto;
import org.carritocompras.procesos.CarritoSBLocal;

/**
 *
 * @author Gerardo
 */
public class Controlador extends HttpServlet {

	CarritoSBLocal carritoSB = lookupCarritoSBLocal();

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		String accion=request.getParameter("accion");
		Double total=0.00;
		List<Producto> carrito;
		String operacion="";

		System.out.println("Llego: "+accion);

		try {
			if (accion.equals("agregar")) {
				String nombre = request.getParameter("nombre");
				String descripcion = request.getParameter("descripcion");
				int cantidad = Integer.parseInt(request.getParameter("cantidad"));
				double precio = Double.parseDouble(request.getParameter("precio"));
				Producto p = new Producto(nombre, descripcion, precio, cantidad);
				carritoSB.agregarProducto(p);
				operacion = "agregar";
			} else if (accion.equals("calcular")) {
				total = carritoSB.calcularTotal();
				request.setAttribute("total", total.toString());
				RequestDispatcher rq = request.getRequestDispatcher("verTtotal.jsp");
				rq.forward(request, response);
				operacion = "calcular";
			} else if (accion.equals("ver")) {
				System.out.println("Entra Aqui");

				carrito = carritoSB.getCarrito();
				UtilidadesHTML utilHtml = new UtilidadesHTML();
				String carritoHTML = utilHtml.generarTablaHtml(carrito);
				request.setAttribute("carrito", carritoHTML);
				RequestDispatcher rq = request.getRequestDispatcher("verCarrito.jsp");
				rq.forward(request, response);
				operacion = "ver";
			}

		} catch (Exception e) {

		}


//		response.setContentType("text/html;charset=UTF-8");
//		try (PrintWriter out = response.getWriter()) {
//			/* TODO output your page here. You may use following sample code. */
//			out.println("<!DOCTYPE html>");
//			out.println("<html>");
//			out.println("<head>");
//			out.println("<title>Servlet Controlador</title>");
//			out.println("</head>");
//			out.println("<body>");
//			out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
//			out.println("</body>");
//			out.println("</html>");
//		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

	private CarritoSBLocal lookupCarritoSBLocal() {
		try {
			Context c = new InitialContext();
			return (CarritoSBLocal) c.lookup("java:global/CarritoComprasEA/CarritoComprasEA-ejb/CarritoSB!org.carritocompras.procesos.CarritoSBLocal");
		} catch (NamingException ne) {
			Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
			throw new RuntimeException(ne);
		}
	}

}
