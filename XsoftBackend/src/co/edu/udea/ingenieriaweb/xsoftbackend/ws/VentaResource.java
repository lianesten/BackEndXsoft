package co.edu.udea.ingenieriaweb.xsoftbackend.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.ClienteBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.bl.UsuarioBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.bl.VentaBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Venta;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.VentaService;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * Clase utilizada para definir los servicios respectivos de la entidad venta
 * 
 * @author julianesten
 *
 */

@Path("venta")
@Component
public class VentaResource {

	@Autowired
	private VentaBl ventaBl;
	private UsuarioBl usuarioBl;
	private ClienteBl clienteBl;
	
	/**
	 *@autor Julian Esteban Montoya Cc: 11522686066
	 *Servicio que permite obtener todas las ventas registradas previamente en el sistema,
	 * retorna la respectiva informacion de las ventas en formato Json
	 * @param idVenta
	 * @return
	 * @throws RemoteException
	 */
	@Path("listarVentas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarVentas() throws RemoteException{
		List aux=new ArrayList(), listaVentas= new ArrayList();
		Venta ventaPojo = null; 
		VentaService ventaAux = null;
		Logger log = Logger.getLogger(this.getClass());
		Gson gson = new Gson();
		try{
			aux = ventaBl.obtenerVentas();
			if(aux==null){
				return Response.ok(gson.toJson("No hay ventas registradas en el sistema")).build();
			}
			for(int i=0;i<aux.size();i++){
				ventaPojo = (Venta) aux.get(i);
				ventaAux = new VentaService(ventaPojo.getUsuario().getNombres(), ventaPojo.getCliente().getNombres(),
						ventaPojo.getUsuario().getUsername(),
						ventaPojo.getUsuario().getNumeroId(),
						ventaPojo.getCliente().getNumeroId(),
						ventaPojo.getIdVenta(),
						ventaPojo.getCliente().getApellidos(),
						ventaPojo.getCliente().getDireccion(),
						ventaPojo.getCliente().getEmail(),
						ventaPojo.getCliente().getTelefonoMovil(),
						ventaPojo.getCliente().getTelefonoFijo());
						listaVentas.add(i, ventaAux);
				
			}
		}catch(DataBaseException e){
			log.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}catch(Exception e){
			log.error(e);
		}
		
		return Response.ok(gson.toJson(listaVentas)).build();

	}

	
	/**
	 * 
	 *@autor Julian Esteban Montoya Cc: 11522686066
	 *Servicio que permite obtener una venta dada su numeroId, retorna la respectiva informacion
	 *de la venta en formato Json
	 * @param idVenta
	 * @return
	 * @throws RemoteException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("obtenerVenta")
	public Object obtenerVenta(@QueryParam("idVenta") String idVenta)
			throws RemoteException {
		VentaService ventaService =null;
		Venta venta = new Venta();
		Logger log = Logger.getLogger(this.getClass());
		Gson gson = new Gson(); 
		if(idVenta==null){
			//Response.status(Response.Status.BAD_REQUEST).build();
			return Response.ok(gson.toJson("Se requiere el id de la venta a buscar")).build();
		}
		
		try{
			int id = Integer.parseInt(idVenta);
			venta = ventaBl.obtenerVenta(id);
			
			if(venta==null){
				return Response.ok(gson.toJson("La venta con el id: "+idVenta+"No se encuentra en la base de datos")).build();
			}
			
			ventaService = new VentaService(venta.getUsuario().getNombres(),
					venta.getCliente().getNombres(), 
					venta.getUsuario().getUsername(),
					venta.getUsuario().getNumeroId(), 
					venta.getCliente().getNumeroId(),
					venta.getIdVenta(), 
					venta.getCliente().getApellidos(),
					venta.getCliente().getDireccion(), 
					venta.getCliente().getEmail(),
					venta.getCliente().getTelefonoMovil(), 
					venta.getCliente().getTelefonoFijo());
		}catch(DataBaseException e){
			log.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}catch(LogicException e){
			log.error(e);
			return Response.status(Response.Status.BAD_REQUEST).build();
		}
	//	if(venta == null){
		//	return Response.ok(gson.toJson("La venta con id: "+venta+" no se enceuntra en la base de datos")).build();
		//}
		return Response.ok(gson.toJson(ventaService)).build();
		
	}
	
	
	@Path("almacenarVenta")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response guardarUsuario(String ventaJson) throws RemoteException{
		Logger log = Logger.getLogger(this.getClass());
		Gson gson = new Gson();
		Venta newVenta = null;
		Cliente newCliente = null;
		try{
			newVenta = gson.fromJson(ventaJson, Venta.class);
			String idUsuario = newVenta.getUsuario().getNumeroId();
			String idCliente = newVenta.getCliente().getNumeroId();
			if(usuarioBl.obtenerUsuario(idUsuario)==null){
				return Response.ok(gson.toJson("El usuario  con id: "+idUsuario+" no se encuetra registrado en el sistema, digite un usuario valido!")).build();
			}
			if(clienteBl.obtenerCliente(idCliente)==null){
				return Response.ok(gson.toJson("Se debe de registrar primero el nuevo cliente para proceder a ejecutar la venta")).build();
			}
			/*
			if(clienteBl.obtenerCliente(idCliente)==null){
				newCliente = new Cliente(idCliente,
						newVenta.getCliente().getNombres(),
						newVenta.getCliente().getApellidos(),
						newVenta.getCliente().getTelefonoFijo(),
						newVenta.getCliente().getTelefonoMovil(),
						newVenta.getCliente().getEmail(),
						newVenta.getCliente().getDireccion());
			}*/
			
			
			
			ventaBl.GuardarVenta(idCliente, idUsuario);;
			
		}catch(LogicException e){
			log.error(e);
			return Response.status(Response.Status.BAD_REQUEST).build();
		}catch(DataBaseException e){
			log.error(e);
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}catch(Exception e){
			log.error(e);
		}
		
		return Response.ok(gson.toJson("La venta  ha sido alamacenada exitosamente en el sistema")).build();
		
	}
	

}
