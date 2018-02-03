/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carritocompras.procesos;

import java.util.List;
import javax.ejb.Local;
import org.carritocompras.entidades.Producto;

/**
 *
 * @author Gerardo
 */
@Local
public interface CarritoSBLocal {

	void agregarProducto(Producto producto);

	double calcularTotal();

	List<Producto> getCarrito();

	void init();

}
