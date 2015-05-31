package co.edu.udea.ingenieriaweb.xsoftbackend.dto;



import java.util.HashSet;
import java.util.Set;

/**
 * clase DTO que contiene los atributos de la tabla Venta
 * @author JoaquinD
 *
 */
public class Venta  implements java.io.Serializable {



    private Integer idVenta;
    private Cliente cliente;
    private Usuario usuario;
    //private Set serviciosventas = new HashSet(0);

   public Venta() {
   }

	
   public Venta(Cliente cliente, Usuario usuario) {
       this.cliente = cliente;
       this.usuario = usuario;
   }
  
   public Integer getIdVenta() {
       return this.idVenta;
   }
   
   public void setIdVenta(Integer idVenta) {
       this.idVenta = idVenta;
   }
   public Cliente getCliente() {
       return this.cliente;
   }
   
   public void setCliente(Cliente cliente) {
       this.cliente = cliente;
   }
   public Usuario getUsuario() {
       return this.usuario;
   }
   
   public void setUsuario(Usuario usuario) {
       this.usuario = usuario;
   }
  




}


