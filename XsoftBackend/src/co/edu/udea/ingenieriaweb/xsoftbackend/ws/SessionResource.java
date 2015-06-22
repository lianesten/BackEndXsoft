package co.edu.udea.ingenieriaweb.xsoftbackend.ws;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.SessionBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

import com.google.gson.Gson;

/**
 * Servicio para realizar la autenticacion de los usuarios
 * 
 * @author Joaquin David Hernandez <jdavihc94@gmail.com>
 *
 */
@Path("Sesion")
@Component
public class SessionResource {

	/**
	 * Inyectamos el bean de la Clase SessionBL
	 */
	@Autowired
	SessionBl sessionBL;

	/**
	 * Servicio mediante el cual se autentica un usuario en el sistema recibe
	 * como parametros el username y el pasword, en caso de que los datos esten
	 * correctos, el servicio retorna un token que contiene la identificacion
	 * del usuario el tipo de usuario y los permisos que tiene.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@GET
	@Path("login")
	@Produces(MediaType.APPLICATION_JSON)
	public Object autenticar(@QueryParam("username") String username,
			@QueryParam("password") String password) {

		Logger log = Logger.getLogger(this.getClass());
		Gson gson = new Gson();
		/**
		 * variable donde se va a almacenar el token del usuario
		 */
		String token = null;

		/**
		 * Verificamos que todos los datos de ingresos esten completos
		 */
		if (username == null || "".equals(username) || password == null
				|| "".equals(password)) {
			return gson.toJson("Debe ingresar todos los parametros");
		}

		try {
			token = sessionBL.autenticar(username, password);
		} catch (LogicException e) {
			return gson.toJson(e.getMessage());
		} catch (DataBaseException e) {

			return gson.toJson("Por favor intenta mas tarde");
		}

		return token;
	}
	
	 @GET
	    @Path("logout")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Object cerrarSesion(@QueryParam("token") String token){
		 
		 return null;
	 }
	
	
}
