package co.edu.udea.ingenieriaweb.xsoftbackend.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.VentaBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Venta;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

/**
 * Clase utilizada para definir los servicios respectivos de la entidad venta
 * @author julianesten
 *
 */
@Path("venta")
@Component
public class VentaResource {

	@Autowired
	private VentaBl ventaBl;
	
	
	/**
	 * Servicio para listar todas las ventas registradas en la base de datos
	 * @return lista en formato Json de las ventas registradas en el sistema
	 * @throws RemoteException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venta> listarVentas() throws RemoteException{
		List<Venta> listaVentas = new ArrayList<Venta>();
		Logger log = Logger.getLogger(this.getClass());
		try{
			listaVentas = ventaBl.obtenerVentas();
		}catch(DataBaseException e){
			log.error(e);	
		}catch(Exception ex){
			log.error(ex);
		}
		return listaVentas;
	}
	
}
