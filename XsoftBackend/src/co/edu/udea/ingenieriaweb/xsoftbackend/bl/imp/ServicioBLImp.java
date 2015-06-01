package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.ServicioBL;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ServicioDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Servicio;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * Clase que contiene la logica del negocio para realizar operaciones con la
 * tabla Servicios en la Base de datos
 * 
 * @author Equipo Desarrollo Xsoft
 *
 */
public class ServicioBLImp implements ServicioBL{
	
	/**
	 * Objeto que permite realizar las operaciones sobre la tabla Servicio
	 */
	ServicioDAO servicioDAO;
	public ServicioDAO getServicioDAO() {
		return servicioDAO;
	}

	public void setServicioDAO(ServicioDAO servicioDAO) {
		this.servicioDAO = servicioDAO;
	}


	/**
	 * Metodo de la Logica del negocio mediante el cual se ingresa un servicio a la DB
	 * @param id
	 * @param descripcion
	 * @param nombres
	 * @param valor
	 * @throws DataBaseException
	 */
	
	@Override
	public void guardarServicio(String nombres, String descripcion,
			Double valor) throws DataBaseException, LogicException {

		if (nombres == null || "".equals(nombres)) {
			throw new LogicException("Los nombres no pueden ser vacio ni Nulo");
		}
		if (descripcion == null || "".equals(descripcion)) {
			throw new LogicException("Los apellidos no pueden ser vacio ni Nulo");
		}
	
		Servicio servicio = new Servicio();
		servicio.setNombre(nombres);
		servicio.setDescripcion(descripcion);
		servicio.setValor(valor);
		

		try {
			servicioDAO.guardarServicio(servicio);
		} catch (Exception e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error en el almacenamiento de Cliente: " + e);
			new DataBaseException(e, "Error almacenando el Cliente");

		}
		
	}

	/**
	 * Implementación del metodo obtenerServicio por medio del cual se implementa la logica para obtener
	 * un Servicio de la DB 
	 * @param id
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	@Override
	public Servicio obtenerServicio(int id) throws DataBaseException,
			LogicException {
		
		Servicio servicio = null;
		try {
			servicio = servicioDAO.obtenerServicio(id);
		} catch (DataBaseException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error en el obteniendo un  Servicio: " + e);
			throw new DataBaseException(e,
					"Error obteniendo un  Servicio en la DB");

		} catch (Exception e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error obteniendo un Servicio: " + e);
			throw new DataBaseException(e,
					"Error general obteniendo un Servicio en la DB");
		}
		return servicio;
	}
	
	/**
	 * Implementacion del metodo actualizarServicio por medio del cual se implementa la logica para actualizar
	 * un Servicio en la DB
	 * @param servicio
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	@Override
	public void actualizarServicio(Servicio servicio) throws DataBaseException,
			LogicException {
		
		try {
			servicioDAO.actualizarSerivicio(servicio);
		} catch (DataBaseException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando servicio: " + e);
			throw new DataBaseException(e,
					"Error actualizando un servicio en la BD");

		} catch (Exception e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando servicio: " + e);
			throw new DataBaseException(e,
					"Error actualizando un servicio en la BD");
		}
		
	}

	/**
	 * Implemementación del metodo obtenerServicios por medio del cual se implementa la logica para obtener
	 * un Lista de todos los Servicios en la DB
	 * @return
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	@Override
	public List obenerServicios() throws DataBaseException, LogicException {
		List listaservicio = (List) new ArrayList<Servicio>();
		try {
			listaservicio = (List) servicioDAO.obtenerServicio();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DataBaseException(e,
					"Error obteniendo una Lista de todos los  servicios  en la BD");
		}
		return listaservicio;
	}
	

	/**
	 * Implementacón del metodo eliminarServicio por medio del cual se implementa la logica para eliminar
	 * un Servicio en la DB
	 * @param id
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	@Override
	public void eliminarServicio(int id) throws DataBaseException,
			LogicException {
	
		try {
			servicioDAO.eliminarServicio(id);
		} catch (DataBaseException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error eliminando servicio: " + e);
			throw new DataBaseException(e,
					"Error eliminando un servicio en la BD");

		}
		
	}
	
	
}
