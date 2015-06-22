package co.edu.udea.ingenieriaweb.xsoftbackend.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.ClienteBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.bl.UsuarioBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.ClienteService;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * Clase que contiene los servicios de la tabla Clientes
 * @author Joaquin David Hernandez <jdavihc94@gmail.com>
 * @param <E>
 *
 */
@Path("Cliente")
@Component
public class ClienteResource<E> {
	/**
	 * Inyectamos el bean de la Clase clienteBl
	 */
	@Autowired
	private ClienteBl clienteBl;

	
	/**
	 *Inyectamos el bean de la Clase UsuarioBl 
	 */
	@Autowired
	UsuarioBl usuarioBL;
	
	/**
	 * Metodo que permite obtener la lista de todos los clientes en la DB
	 * @return Lista con todos los cliente en la DB
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object obtenerTodosLosClientes() {
		
		List clientes = new ArrayList();
		List clienteService = new ArrayList();
		Logger log = Logger.getLogger(this.getClass());
		Gson gson = new Gson();
		try {
			/**
			 * Obtenemos la lista de clientes de la DB
			 */
			clientes = clienteBl.obenerClientes();
			System.out.println("Clientes: " + clientes);
		} catch (DataBaseException e) {
			log.error(e);
			return gson.toJson("Por favor intente mas tarde");
		} catch (LogicException e) {
			log.error(e);
			return gson.toJson("Por favor intente mas tarde");
		} catch (Exception e) {
			log.error(e);
			return gson.toJson("Por favor intente mas tarde");
		}
		
		/**
		 * Mapeamos los objetos a la clase clienteService
		 */
		for (int i = 0; i < clientes.size(); i++) {
			Cliente cliente =(Cliente) clientes.get(i);
			ClienteService clienteS = new ClienteService();
			
			clienteS.setNumeroId(cliente.getNumeroId());
			clienteS.setNombres(cliente.getNombres());
			clienteS.setApellidos(cliente.getApellidos());
			clienteS.setDireccion(cliente.getDireccion());
			clienteS.setEmail(cliente.getEmail());
			clienteS.setTelefonoFijo(cliente.getTelefonoFijo());
			clienteS.setTelefonoMovil(cliente.getTelefonoMovil());
			
			clienteService.add(clienteS);
		}
		
		/**
		 * Devolvemos un objeto json con la lista de los clientes
		 */
		return gson.toJson(clienteService);
	}
	
	

	/**
	 * Servicio que obtiene La información de un cliente mediante su
	 * identificación
	 * 
	 * @param idCliente
	 *            Número de identificación del cliente que se va a consultar
	 * @return Objeto de la clase cliente con la información del cliente
	 */

	@Produces(MediaType.APPLICATION_JSON)
	@Path("obtenerCliente")
	@GET
	public Object obtenerClienteResource(
			@QueryParam("idCliente") String idCliente) throws RemoteException {
		Cliente cliente = new Cliente();

		Logger log = Logger.getLogger(this.getClass());
		Gson gson = new Gson();
		if (idCliente == null || "".equals(idCliente)) {
			return gson.toJson("Debe ingresar la identificacion del cliente");
		}
		try {
			/**
			 * Obtenemos el cliente desde la DB
			 */
			cliente = clienteBl.obtenerCliente(idCliente);
		} catch (DataBaseException e) {
			log.error(e);
			return gson.toJson("Por favor intente mas tarde");
		} catch (LogicException e) {
			log.error(e);
			return gson.toJson("Por favor intente mas tarde");
		} catch (Exception e) {
			log.error(e);
			return gson.toJson("Por favor intente mas tarde");
		}

		if (cliente == null) {
			return gson
					.toJson("No existe un cliente con la identificacion ingresada");
		}

		ClienteService clienteS = new ClienteService();

		clienteS.setNumeroId(cliente.getNumeroId());
		clienteS.setNombres(cliente.getNombres());
		clienteS.setApellidos(cliente.getApellidos());
		clienteS.setDireccion(cliente.getDireccion());
		clienteS.setEmail(cliente.getEmail());
		clienteS.setTelefonoFijo(cliente.getTelefonoFijo());
		clienteS.setTelefonoMovil(cliente.getTelefonoMovil());
		/**
		 * Devolvemos un objeto json con la informacion del cliente
		 */
		return gson.toJson(clienteS);

	}
	
	/**
	 * Servicio que permite guardar un Cliente en la DB
	 * @param identificacion
	 * @param nombres
	 * @param apellidos
	 * @param direccion
	 * @param email
	 * @param telFijo
	 * @param telMovil
	 * @return String con un mensaje de confirmacion
	 */
	
	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("guardarCliente")
	@POST
	public Object IngresarCliente(
			@HeaderParam("identificacion") String identificacion,
			@HeaderParam("nombres") String nombres, 
			@HeaderParam("apellidos") String apellidos,
			@HeaderParam("direccion") String direccion, 
			@HeaderParam("email") String email,
			@HeaderParam("telFijo") String telFijo,
			@HeaderParam("telMovil") String telMovil,
			@HeaderParam("usuarioCrea") String usuarioCrea) {
		
		Logger log = Logger.getLogger(this.getClass());
		Gson gson = new Gson();
		
		if(usuarioCrea==null){
			gson.toJson("Ingrese la identificacion del usuario que crea el cliente");
		}
		
		/**
		 * Obtenemos el usuario de la DB
		 */
		Usuario usuario = null;
		try {
			usuario = usuarioBL.obtenerUsuario(usuarioCrea);
		} catch (DataBaseException e1) {
			return gson.toJson("Por favor intente mas tarde");
		} catch (LogicException e1) {
			return gson.toJson("Ingrese la identificacion del usuario que crea el cliente");
		}
		
		
		if(usuario == null){
			return gson.toJson("No existe un usuario con la identificacion ingresada");
		}
		try{
			clienteBl.GuardarCliente(identificacion, nombres, apellidos, telFijo, 
					telMovil, email, direccion, usuario);	
		} catch (DataBaseException e) {
			log.error(e);
			return gson.toJson("Por favor intente mas tarde");
		} catch (LogicException e) {
			log.error(e);
			return gson.toJson(e.getMessage());
		} catch (Exception e) {
			log.error(e);
			return gson.toJson("Por favor intente mas tarde");
		}
		
		return gson.toJson("Cliente guardad exitosamente");
	}

}
