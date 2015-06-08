package co.edu.udea.ingenieriaweb.xsoftbackend.ws;


import java.rmi.RemoteException;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.ClienteBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * 
 * @author Joaquin Hernandez
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
	 * Obtiene La información de un cliente
	 * 
	 * @param idCliente
	 *            Número de identificación del cliente que se va a consultar
	 * @return cliente Objeto de la clase cliente con la información del cliente
	 */
	
	//@Path("{idCliente}")
	//@Produces(MediaType.TEXT_HTML)
	@Produces(MediaType.APPLICATION_JSON)
	@GET
	public Object obtenerClienteResource(
			@QueryParam("idCliente") String idCliente) throws RemoteException {
		System.out.println("Identificacion: " + idCliente );
		Cliente cliente = new Cliente();
		
		Logger log = Logger.getLogger(this.getClass());
		Gson gson = new Gson();
		if(idCliente==null || "".equals(idCliente)){
			return gson.toJson("Ingrese todos los parametros");
		}
		try {
			/**
			 * Obtenemos el cliente desde la DB
			 */
			cliente = clienteBl.obtenerCliente(idCliente);
		}catch (DataBaseException e) {
				log.error(e);
				return gson.toJson("Error en el servicio DataBaseException ");
		}catch (LogicException e) {
			log.error(e);
			return gson.toJson("Error en  el servicio LogicException");
		}catch(Exception e){
			log.error(e);
			e.printStackTrace();
			System.out.println(e.toString());
			return gson.toJson("Error en el  servicio Exception general");
		}
		
		/**
		 * Devolvemos un objeto json con la informacion del cliente
		 */
		return gson.toJson(cliente);
	}
	
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public Object obtenerClientesResource() {
//		List clientes = new ArrayList<E>();
//		Logger log = Logger.getLogger(this.getClass());
//		Gson gson = new Gson();
//		try {
//			/**
//			 * Obtenemos el cliente desde la DB
//			 */
//			clientes = clienteBl.obenerClientes();
//		} catch (DataBaseException e) {
//				log.error(e);
//				return gson.toJson("Error en el servicio DataBaseException ");
//		}catch (LogicException e) {
//			log.error(e);
//			return gson.toJson("Error en  el servicio LogicException");
//		}catch(Exception e){
//			log.error(e);
//			e.printStackTrace();
//			System.out.println(e.toString());
//			return gson.toJson("Error en el  servicio Exception general");
//		}
//		
//		/**
//		 * Devolvemos un objeto json con la informacion del cliente
//		 */
//		return gson.toJson(clientes);
//	}
}
