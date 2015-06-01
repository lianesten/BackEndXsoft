package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

import java.util.Date;

/**
 *  Clase DTO que contiene los atributos de la tabla ServiciosVenta
 * @author Joaquin Hernandez, Luis Zambrano
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
    /**
     * Constructor vacio de la Clase
     */
   public Serviciosventa() {
   }

   /**
    * * Contructor que permite ingresar un 
    * @param id
    * @param servicio
    * @param venta
    * @param totalventa
    * @param fechaCaducidad
    * @param cantidad
    * @param fechaVenta
    */
   public Serviciosventa(ServicioVentaId id, Servicio servicio, Venta venta, double totalventa, Date fechaCaducidad, int cantidad, Date fechaVenta) {
      this.id = id;
      this.servicio = servicio;
      this.venta = venta;
      this.totalventa = totalventa;
      this.fechaCaducidad = fechaCaducidad;
      this.cantidad = cantidad;
      this.fechaVenta = fechaVenta;
   }
   /**
    * Metodo que permite obtener el id de un servicio por venta
    * @return id
    */
public ServicioVentaId getId() {
	return id;
}
/**
 * Metodo que permite ingresar el id del servicio por venta
 * @param id
 */
public void setId(ServicioVentaId id) {
	this.id = id;
}
/**
 * Metodo que permite obtener el servicio de un servicio por venta
 * @return servicio
 */
public Servicio getServicio() {
	return servicio;
}
/**
 * Metodo que permite ingresar el servicio del servicio por venta
 * @param servicio
 */
public void setServicio(Servicio servicio) {
	this.servicio = servicio;
}
/**
 * Metodo que permite obtener la venta de un servicio por venta
 * @return venta
 */
public Venta getVenta() {
	return venta;
}
/**
 * Metodo que permite ingresar la venta del servicio por venta
 * @param venta
 */
public void setVenta(Venta venta) {
	this.venta = venta;
}
/**
 * Metodo que permite obtener el total de la venta de un servicio por venta
 * @return totalventa
 */
public double getTotalventa() {
	return totalventa;
}

/**
 * Metodo que permite ingresar el total de la venta del servicio por venta
 * @param totalventa
 */
public void setTotalventa(double totalventa) {
	this.totalventa = totalventa;
}
/**
 * Metodo que permite obtener la fecha de caducidad de un servicio por venta
 * @return fechaCaducidad
 */
public Date getFechaCaducidad() {
	return fechaCaducidad;
}
/**
 * Metodo que permite ingresar la fecha de caducidad del servicio por venta
 * @param fechaCaducidad
 */
public void setFechaCaducidad(Date fechaCaducidad) {
	this.fechaCaducidad = fechaCaducidad;
}
/**
 * Metodo que permite obtener la cantidad de un servicio por venta
 * @return cantidad 
 */
public int getCantidad() {
	return cantidad;
}
/**
 * Metodo que permite ingresar la cantidad del servicio por venta
 * @param cantidad
 */
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}
/**
 * Metodo que permite obtener la fecha de venta de un servicio por venta
 * @return fechaVenta
 */
public Date getFechaVenta() {
	return fechaVenta;
}
/**
 * Metodo que permite ingresar la fecha de venta del servicio por venta
 * @param fechaVenta
 */
public void setFechaVenta(Date fechaVenta) {
	this.fechaVenta = fechaVenta;
}
 
}