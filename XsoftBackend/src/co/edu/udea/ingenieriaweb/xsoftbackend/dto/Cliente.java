package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;



/**
 * 
 * @author Joaquin Hernandez, Luis Zambrano
 * DTO de la tabla Cliente en la Base de datos
 */
@XmlRootElement
public class Cliente  implements java.io.Serializable {


    private String numeroId;
    private Usuario usuarioCrea;
    private String nombres;
    private String apellidos;
    private String telefonoFijo;
    private String telefonoMovil;
    private String email;
    private String direccion;
    private Date fechaCreacion;
     

     /**
      * Constructor vacio de la Clase
      */
    public Cliente() {
    }

    /**
     * Contructor que permite ingresar un 
     * @param id
     * @param tipodocumento
     * @param nombres
     * @param apellidos
     * @param telefonoFijo
     * @param telefonoMovil
     * @param email
     * @param direccion
     */
    public Cliente(String id, String nombres, String apellidos, String telefonoFijo, String telefonoMovil, String email, String direccion) {
       this.numeroId = id;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.telefonoFijo = telefonoFijo;
       this.telefonoMovil = telefonoMovil;
       this.email = email;
       this.direccion = direccion;
    }
    
    /**
     * Metodo que permite obtener el id de un cliente
     * @return id
     */
    public String getNumeroId() {
        return this.numeroId;
    }
    /**
     * Metodo que permite ingresar el id de un Cliente
     * @param id
     */
    public void setNumeroId(String id) {
        this.numeroId = id;
    }
    
    /**
     * Permite obtener los nombres de un cliente
     * @return nombres
     */
    public String getNombres() {
        return this.nombres;
    }
    /**
     * Permite almacer los nombres de los clientes en el objeto Cliente
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    /**
     * Permite obtener los apellidos de un Cliente
     * @return apellidos
     */
    public String getApellidos() {
        return this.apellidos;
    }
    /**
     * Permite almacenar los apellidos de un cliente
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    /**
     * Metodo que permite obtener el n�mero telefonico de un Cliente
     * @return telefonoFijo
     */
    public String getTelefonoFijo() {
        return this.telefonoFijo;
    }
    /**
     * Metodo que permite almacenar el n�mero telefonico de un Cliente
     * @param telefonoFijo
     */
    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }
    /**
     * Metodo que devuelve un String que contiene el n�mero del telefono movil de un cliente
     * @return telefonoMovil
     */
    public String getTelefonoMovil() {
        return this.telefonoMovil;
    }
    /**
     * Metodo para ingresar el telefono movil de un Cliente
     * @param telefonoMovil
     */
    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }
    /**
     * Metodo que permite obtener un String con el Email del Cliente
     * @return email
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * Metodo que permite almacenar el email de un Cliente
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Metodo que permite obtener un String con la direcci�n de un Cliente
     * @return direccion
     */
    public String getDireccion() {
        return this.direccion;
    }
    /**
     * Metodo para almacenar la direcci�n de un Cliente
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
/**
 * Metodo que permite obtener un String con el usuario de un Cliente
 * @return usuarioCrea
 */
	public Usuario getUsuarioCrea() {
		return usuarioCrea;
	}
/**
 * Metodo para almacenar la direcci�n de un Cliente
 * @param usuarioCrea
 */
	public void setUsuarioCrea(Usuario usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
/**
 * Metodo que permite obtener un String con la fecha de creacion de un Cliente
 * @return fechaCreacion
 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
/**
 * Metodo para almacenar la fecha de creacion  de un Cliente
 * @param fechaCreacion
 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
}


