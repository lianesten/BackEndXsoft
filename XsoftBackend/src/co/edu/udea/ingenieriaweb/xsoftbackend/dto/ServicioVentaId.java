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
    /**
     * Constructor vacio de la Clase
     */
   public ServicioVentaId() {
   }
/**
 * Contructor que permite ingresar un 
 * @param idservicioVenta
 * @param idservicio
 * @param idventa
 */
   public ServicioVentaId(int idservicioVenta, int idservicio, int idventa) {
      this.idservicioVenta = idservicioVenta;
      this.idservicio = idservicio;
      this.idventa = idventa;
   }
  /**
   * 
   * @return
   */
   public int getIdservicioVenta() {
       return this.idservicioVenta;
   }
   /**
    * 
    * @param idservicioVenta
    */
   public void setIdservicioVenta(int idservicioVenta) {
       this.idservicioVenta = idservicioVenta;
   }
   /**
    * 
    * @return
    */
   public int getIdservicio() {
       return this.idservicio;
   }
   /**
    * 
    * @param idservicio
    */
   public void setIdservicio(int idservicio) {
       this.idservicio = idservicio;
   }
   /**
    * 
    * @return
    */
   public int getIdventa() {
       return this.idventa;
   }
   
   public void setIdventa(int idventa) {
       this.idventa = idventa;
   }
 
}
