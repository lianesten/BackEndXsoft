package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

/**
 * Clase creada para registrar las claves primarias de la tabla ServicioVenta en la 
 * Basede datos
 * @author Joaquin Hernandez, Luis Zambrano
 *
 */
public class ServicioVentaId  implements java.io.Serializable {


    private int idservicioVenta;
    private int idservicio;
    private int idventa;

   public ServicioVentaId() {
   }

   public ServicioVentaId(int idservicioVenta, int idservicio, int idventa) {
      this.idservicioVenta = idservicioVenta;
      this.idservicio = idservicio;
      this.idventa = idventa;
   }
  
   public int getIdservicioVenta() {
       return this.idservicioVenta;
   }
   
   public void setIdservicioVenta(int idservicioVenta) {
       this.idservicioVenta = idservicioVenta;
   }
   public int getIdservicio() {
       return this.idservicio;
   }
   
   public void setIdservicio(int idservicio) {
       this.idservicio = idservicio;
   }
   public int getIdventa() {
       return this.idventa;
   }
   
   public void setIdventa(int idventa) {
       this.idventa = idventa;
   }
 
}
