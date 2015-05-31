package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

import java.util.Date;

/**
 *  Clase DTO que contiene los atributos de la tabla ServiciosVenta
 * @author Equipo de desarrollo Xsoft
 *
 */
public class Serviciosventa  implements java.io.Serializable {


    private ServicioVentaId id;
    private Servicio servicio;
    private Venta venta;
    private double totalventa;
    private Date fechaCaducidad;
    private int cantidad;
    private Date fechaVenta;

   public Serviciosventa() {
   }

   public Serviciosventa(ServicioVentaId id, Servicio servicio, Venta venta, double totalventa, Date fechaCaducidad, int cantidad, Date fechaVenta) {
      this.id = id;
      this.servicio = servicio;
      this.venta = venta;
      this.totalventa = totalventa;
      this.fechaCaducidad = fechaCaducidad;
      this.cantidad = cantidad;
      this.fechaVenta = fechaVenta;
   }

public ServicioVentaId getId() {
	return id;
}

public void setId(ServicioVentaId id) {
	this.id = id;
}

public Servicio getServicio() {
	return servicio;
}

public void setServicio(Servicio servicio) {
	this.servicio = servicio;
}

public Venta getVenta() {
	return venta;
}

public void setVenta(Venta venta) {
	this.venta = venta;
}

public double getTotalventa() {
	return totalventa;
}

public void setTotalventa(double totalventa) {
	this.totalventa = totalventa;
}

public Date getFechaCaducidad() {
	return fechaCaducidad;
}

public void setFechaCaducidad(Date fechaCaducidad) {
	this.fechaCaducidad = fechaCaducidad;
}

public int getCantidad() {
	return cantidad;
}

public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public Date getFechaVenta() {
	return fechaVenta;
}

public void setFechaVenta(Date fechaVenta) {
	this.fechaVenta = fechaVenta;
}
  



}