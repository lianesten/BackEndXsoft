
package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

/**
 *  Clase DTO que contiene los atributos de la tabla Usuario
 * @author Equipo de Desarrollo Xsoft
 *
 */
public class Usuario  implements java.io.Serializable {


     private String numeroId;
     private String nombres;
     private String apellidos;
     private int privilegio;
     private String username;
     private String password;
     private String email;
     private String token;
     /**
      * Constructor vacio de la Clase
      */
     public Usuario() {
     }

 	/**
 	 * Contructor que permite ingresar un 
 	 * @param numeroId
 	 * @param nombres
 	 * @param apellidos
 	 * @param privilegio
 	 * @param username
 	 * @param password
 	 * @param email
 	 */
     public Usuario(String numeroId, String nombres, String apellidos, int privilegio, String username, String password, String email) {
         this.numeroId = numeroId;
         this.nombres = nombres;
         this.apellidos = apellidos;
         this.privilegio = privilegio;
         this.username = username;
         this.password = password;
         this.email = email;
     }
   /**
    * Metodo que permite obtener el numero de identificacion de un usuario
    * @return
    */
    public String getNumeroId() {
        return this.numeroId;
    }
    /**
     * Metodo que permite ingresar el id del usuario
     * @param numeroId
     */
    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }
    /**
     * Metodo que permite obtener el nombre de un usuario
     * @return
     */
    public String getNombres() {
        return this.nombres;
    }
    /**
     *  Metodo que permite ingresar el nombre del usuario
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    /**
     * Metodo que permite obtener el apellido de un usuario
     * @return
     */
    public String getApellidos() {
        return this.apellidos;
    }
    /**
     * Metodo que permite ingresar el apellido del usuario
     * @param apellidos
     */
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    /**
     * 
     * Metodo que permite obtener el privilegio de un usuario
     * @return
     */
    public int getPrivilegio() {
        return this.privilegio;
    }
    /**
     * Metodo que permite ingresar el privilegio del usuario
     * 
     * @param privilegio
     */
    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }
    /**
     * Metodo que permite obtener el username de un usuario
     * @return
     */
    public String getUsername() {
        return this.username;
    }
    /**
     * Metodo que permite ingresar el username del usuario
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * Metodo que permite obtener el password de un usuario
     * @return
     */
    
    public String getPassword() {
        return this.password;
    }
    /**
     * Metodo que permite ingresar el password del usuario
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * Metodo que permite obtener el email de un usuario
     * @return
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * Metodo que permite ingresar el email del usuario
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Metodo que permite obtener el token de un usuario
     * @return
     */
	public String getToken() {
		return token;
	}
	/**
	 * Metodo que permite ingresar el token del usuario
	 * @param token
	 */
	public void setToken(String token) {
		this.token = token;
	}
}


