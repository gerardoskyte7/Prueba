/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carritocompras.procesos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Init;
import javax.ejb.Stateful;
import org.carritocompras.entidades.Producto;

/**
 *
 * @author Gerardo
 */
@Stateful
public class CarritoSB implements CarritoSBLocal {

	private ArrayList<Producto> carrito;

	// Add business logic below. (Right-click in editor and choose
	// "Insert Code > Add Business Method")
	@Override
	@Init
	public void init() {
		carrito = new ArrayList<Producto>();
	}

	//@PrePassivate //Justo antes de recibir la informacion de la ejecucion
	//@PostActivate //Justo despues de inicializada
	//@Remove //remueve la instancia del pool destruye

	@Override
	public void agregarProducto(Producto producto) {
		carrito.add(producto);
	}

	@Override
	public double calcularTotal(){
		double total=0.00;

		try {
			for(Producto producto:carrito){
				total+=(producto.getCantidad()*producto.getPrecio());
			}
		} catch (Exception e) {
		}

		return total;
	}

	@Override
	public List<Producto> getCarrito() {
		return carrito;
	}

}
