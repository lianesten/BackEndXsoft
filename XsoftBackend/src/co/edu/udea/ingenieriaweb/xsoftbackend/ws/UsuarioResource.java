package co.edu.udea.ingenieriaweb.xsoftbackend.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.UsuarioBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp.SessionBLImp;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;
/**
 * Clase donde se implementan los servicios RestFul para la entidad usuario
 * @author julianesten
 *
 */
@Component
@Path("usuario")
public class UsuarioResource {
	/**
	 * Inyectamos el bean desde Spring FW
	 */
	@Autowired
	private UsuarioBl usuarioBl;
	private SessionBLImp session;
	
	/**
	 * Servicio que almacena un nuevo usuario en la BD
	 * @param numeroId
	 * @param nombres
	 * @param apellidos
	 * @param privilegio
	 * @param username
	 * @param password
	 * @param email
	 * @return un mensaje en caso de que se presente excepcion alguna o un string vacio en caso de exito
	 * @throws LogicException
	 * @throws DataBaseException
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String guardarUsuario(@QueryParam("numeroId") String numeroId,
			@QueryParam("nombres") String nombres, @QueryParam("apellidos") String apellidos,
			@QueryParam("privilegio") int privilegio, @QueryParam("username") String username,
			@QueryParam("password") String password, @QueryParam("email") String email) throws RemoteException{
		Logger log = Logger.getLogger(this.getClass());
		try{
			usuarioBl.guardarUsuario(numeroId, nombres, apellidos, privilegio, username, password, email);
		}catch(LogicException e){
			log.error(e);
			return e.getMessage();
		}catch(DataBaseException e){
			log.error(e);
			return e.getMessage();
		}
		return "";
		
	}
	/**
	 * Servicio para actualizar un usuario en la base de datos
	 * @param numeroId
	 * @param nombres
	 * @param apellidos
	 * @param privilegio
	 * @param username
	 * @param password
	 * @param email
	 * @return retorna un mensaje en caso de excepcion alguna, de lo contrario retorna un string vacio en caso de exito
	 * @throws LogicException
	 * @throws DataBaseException
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarUsuario(@QueryParam("numeroId") String numeroId,
			@QueryParam("nombres") String nombres, @QueryParam("apellidos") String apellidos,
			@QueryParam("privilegio") int privilegio, @QueryParam("username") String username,
			@QueryParam("password") String password, @QueryParam("email") String email) throws RemoteException{
		Logger log = Logger.getLogger(this.getClass());
		try{
			usuarioBl.actualizarUsuario(numeroId, nombres, apellidos, privilegio, username, password, email);
		}catch(LogicException e){
			log.error(e);
			return e.getMessage();
		}catch(DataBaseException e){
			log.error(e);
			return e.getMessage();
		}
		return "";
	}
	
	/**
	 * Servicio para retornar al front end en formato Json una lista de todos los 
	 * usuario registrados en el sistema
	 * @return
	 * @throws RemoteException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listarUsuarios() throws RemoteException{
		List<Usuario> listaClientes = new ArrayList<Usuario>();
		Logger log = Logger.getLogger(this.getClass());
		try{
		listaClientes = usuarioBl.obtenerUsuarios();
		}catch(DataBaseException e){
			log.error(e);
		}catch(LogicException e){
			log.error(e);
		}catch(Exception e){
			log.error(e);
		}
		
		return listaClientes;
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String validarUsuario(@QueryParam("username")  String username, 
			@QueryParam("password") String password) throws RemoteException{
		Logger log = Logger.getLogger(this.getClass());
		try{
			session.autenticar(username, password);
			
		}catch(DataBaseException e){
			log.error(e.getMessage());
			return e.getMessage();
		}catch(LogicException e){
			log.error(e.getMessage());
			return e.getMessage();
		}
		return "";
	}
}
