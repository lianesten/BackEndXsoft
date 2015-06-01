package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.SessionBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.UsuarioDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.seguridad.Autenticator;

/**
 * Clase que permite controlar las sesiones de los usuarios en el sistema
 * @author Equipo de desarrollo Xsoft
 *
 */
public class SessionBLImp implements SessionBl {

	/**
	 * Necesitamos un objeto de la clase Autenticator para generar el token
	 */
	private Autenticator autenticator = new Autenticator();
	
	UsuarioDAO usuarioDAO;
	
    Usuario usuario;
	
	public UsuarioDAO getUsuarioDAO(){
		return usuarioDAO;
	}
	
	public void setUsuarioDAO(UsuarioDAO usuarioDAO){
		this.usuarioDAO = usuarioDAO;
	}
	
	/**
	 * Metodo encargado de logear los usuarios en el sistema
	 * Retorna un token de 512 caracteres que contiene la informacion basica de 
	 * un usuario, IdUsuari, username y privilegios
	 * @param username
	 * @param password
	 * @return Token   
	 */
	@Override
	public String autenticar(String username, String password) {
		
		 Usuario usuario = new Usuario();
	        
	        try {
	            usuario = usuarioDAO.obtenerUsuarioUsername(username);
	            Logger log = Logger.getLogger(this.getClass());
	            log.info("Nombre de usuario: " + usuario.getNombres());
	        } catch (Exception e) {
	        	Logger log = Logger.getLogger(this.getClass());
	        	e.printStackTrace();
				log.error("Error obteniendo el usuario por medio de su Username"+ e.toString());
				new DataBaseException(e, "Error obteniendo usuario por Usernaname");
	        }
	        /**
	         * Le pasamos los parametros que queremos setear en el TOKEN
	         */
	        autenticator.addParam( Autenticator.USER_ID, usuario.getNumeroId().toString() );
	        autenticator.addParam(Autenticator.USERNAME, username);
	        autenticator.addParam(Autenticator.ROL, Integer.toString(usuario.getPrivilegio()));
			 
				 
	        /**
	         * String para almacenar el token
	         */
	        String token = null;	
	        
	        try {
	            /**
	             * Se debe enviar la Key con la que se va a cifrar el token
	             */
	            token = autenticator.generarToken("xsoft");
	            Logger log = Logger.getLogger(this.getClass());
	            log.info("Token: " + token);
	            
	        } catch (UnsupportedEncodingException ex) {
	        	Logger log = Logger.getLogger(this.getClass());
	        	ex.printStackTrace();
				log.error("Error obteniendo el usuario por medio de su Username, "+ ex.toString());
				new DataBaseException(ex, "Error obteniendo usuario por Usernaname");
	        }catch (IllegalArgumentException ex){
	        	Logger log = Logger.getLogger(this.getClass());
	        	ex.printStackTrace();
				log.error("Error obteniendo el usuario por medio de su Username"+ ex.toString());
				new DataBaseException(ex, "Error obteniendo usuario por Usernaname");
	        } catch (NoSuchAlgorithmException ex){
	        	Logger log = Logger.getLogger(this.getClass());
	        	ex.printStackTrace();
				log.error("Error obteniendo el usuario por medio de su Username"+ ex.toString());
				new DataBaseException(ex, "Error obteniendo usuario por Usernaname");
	        } catch (InvalidKeyException ex){
	        	Logger log = Logger.getLogger(this.getClass());
	        	ex.printStackTrace();
				log.error("Error obteniendo el usuario por medio de su Username"+ ex.toString());
				new DataBaseException(ex, "Error obteniendo usuario por Usernaname");
	        }
	        
	        usuario.setToken(token);
	        try {
				usuarioDAO.actualizarUsuario(usuario);
			} catch (DataBaseException e) {
				Logger log = Logger.getLogger(this.getClass());
	        	e.printStackTrace();
				log.error("Error obteniendo el usuario por medio de su Username"+ e.toString());
				new DataBaseException(e, "Error obteniendo usuario por Usernaname");
			}
		return token;
	}
	
	 
    /**
     * Cierra una sesión de usuario de usuario a partir de un token.
     * @param  token Token que contiene los datos de la sesión del usuario       
     */
	@Override
	public void cerrarSesion(String idUsuario) {
		 try {
			 Usuario usuario  = usuarioDAO.obtenerUsuario(idUsuario);
	            usuario.setToken(null);
	            usuarioDAO.actualizarUsuario(usuario);                
	        } catch (DataBaseException ex) {
	        	Logger log = Logger.getLogger(this.getClass());
	        	ex.printStackTrace();
				log.error("Error cerrando la sesion"+ ex.toString());
				new DataBaseException(ex, "La sesion no pudo ser cerrada, intente luego");
	            
	           
	        }
	}

}
