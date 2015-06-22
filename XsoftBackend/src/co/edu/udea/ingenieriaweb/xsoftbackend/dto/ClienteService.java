package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Clase utilizada para enviar la información del cliente mediante el Servicio Web
 * @author Joaquin Hernandez <jdavidhc94@gmail.com>
 *
 */

@XmlRootElement
public class ClienteService {
	    private String numeroId;
	    private String nombres;
	    private String apellidos;
	    private String telefonoFijo;
	    private String telefonoMovil;
	    private String email;
	    private String direccion;
	    
	    /**
	     * Constructor de la Clase
	     */
	    public ClienteService(){
	    	
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
	     * Metodo que permite obtener el nï¿½mero telefonico de un Cliente
	     * @return telefonoFijo
	     */
	    public String getTelefonoFijo() {
	        return this.telefonoFijo;
	    }
	    /**
	     * Metodo que permite almacenar el nï¿½mero telefonico de un Cliente
	     * @param telefonoFijo
	     */
	    public void setTelefonoFijo(String telefonoFijo) {
	        this.telefonoFijo = telefonoFijo;
	    }
	    /**
	     * Metodo que devuelve un String que contiene el nï¿½mero del telefono movil de un cliente
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
	     * Metodo que permite obtener un String con la direcciï¿½n de un Cliente
	     * @return direccion
	     */
	    public String getDireccion() {
	        return this.direccion;
	    }
	    /**
	     * Metodo para almacenar la direcciï¿½n de un Cliente
	     * @param direccion
	     */
	    public void setDireccion(String direccion) {
	        this.direccion = direccion;
	    }
}
