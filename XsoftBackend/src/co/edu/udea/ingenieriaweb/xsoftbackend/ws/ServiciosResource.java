package co.edu.udea.ingenieriaweb.xsoftbackend.ws;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;



import co.edu.udea.ingenieriaweb.xsoftbackend.bl.ServicioBL;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Servicio;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * Clase utilizada para definir los servicios respectivos de la entidad servicios
 * 
 * @author luisduque
 *
 */
@Path("servicio")
@Component
public class ServiciosResource {

	@Autowired
	private ServicioBL servicioBl;

	/**
	 * Servicio para listar todas los servicios registradas en la base de datos
	 * 
	 * @return lista en formato Json de los servicios registradas en el sistema
	 * @throws RemoteException
	 */
	/*
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Servicio> listarServicios() throws RemoteException {
		List<Servicio> listaServicios = new ArrayList<Servicio>();
		Logger log = Logger.getLogger(this.getClass());
		try {
			listaServicio = servicioBl.obtenerServicio();
		} catch (DataBaseException e) {
			log.error(e);
		} catch (Exception ex) {
			log.error(ex);
		}
		return listaServicios;
	}
	
	*/
	/**
	 * Servicio que permite obtener dado su id, un servicio ofrecido por la empresa de software 
	 * @autor Luis Angel Duque
	 * @param Idservicio
	 * @return
	 * @throws RemoteException
	 */
	@Path("consultarServicio")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Object consultarServicio(@QueryParam("Idservicio") String Idservicio)
			throws RemoteException {
		Servicio servicio=null;
		Gson gson = new Gson();
		Logger log = Logger.getLogger(this.getClass());
		if (Idservicio == null || "".equals(Idservicio)) {
			return gson.toJson("Ingrese el id del servicio que sea   consultar?");
		}

		try {
			int id = Integer.parseInt(Idservicio);
			servicio = servicioBl.obtenerServicio(id);
			if(servicio==null){
				return gson.toJson("no se ha encontrado un servicio con id: "+Idservicio);
			}
		} catch (DataBaseException e) {
			log.error(e);
			return gson.toJson("Error en el servicio DataBaseException ");
		} catch (LogicException e) {
			log.error(e);
			return gson.toJson("Error en  el servicio LogicException");
		} catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			System.out.println(e.toString());
			return gson.toJson("Error en el  servicio Exception general");
		}
		return gson.toJson(servicio);
	}

}