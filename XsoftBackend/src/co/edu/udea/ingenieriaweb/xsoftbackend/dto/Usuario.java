
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

     public Usuario() {
     }

 	
     public Usuario(String numeroId, String nombres, String apellidos, int privilegio, String username, String password, String email) {
         this.numeroId = numeroId;
         this.nombres = nombres;
         this.apellidos = apellidos;
         this.privilegio = privilegio;
         this.username = username;
         this.password = password;
         this.email = email;
     }
   
    public String getNumeroId() {
        return this.numeroId;
    }
    
    public void setNumeroId(String numeroId) {
        this.numeroId = numeroId;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public int getPrivilegio() {
        return this.privilegio;
    }
    
    public void setPrivilegio(int privilegio) {
        this.privilegio = privilegio;
    }
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}

    

}


