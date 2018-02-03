/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
import org.carritocompras.entidades.Producto;

/**
 *
 * @author Gerardo
 */
public class UtilidadesHTML {
	public String generarTablaHtml(List<Producto> listaProductos) {
        String html = "<table border='1'>";
        html += "<tr>"
                + "<th>ID</th>"
                + "<th>Marca</th>"
                + "<th>Procesador</th>"
                + "<th>Memoria</th>"
                + "<th>Disco</th>"
                + "<th>Memoria de Video</th>"
                + "<th>Descripci&oacute;n</th>"
            + "</tr>";
        for (Object objWeb : listaProductos) {
            Producto p = (Producto) objWeb;
            html += "<tr>";
            html += "<td>" + p.getNombre()+ "</td>";
            html += "<td>" + p.getDescripcion()+ "</td>";
            html += "<td>" + p.getPrecio()+ "</td>";
            html += "<td>" + p.getCantidad()+ " GB</td>";
            html += "</tr>";
        }
        html += "</table>";
        return html;
    }
}
