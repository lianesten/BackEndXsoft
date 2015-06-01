package co.edu.udea.ingenieriaweb.xsoftbackend.bl;


import java.util.List;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Servicio;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * 
 * @author Alejandro Zambrano
 *
 */
public interface ServicioBL {
	/**
	 * Instancia del metodo guardarServicio por medio del cual se implementa la logica para almacenar
	 * un Servicio en la DB
	 * @param nombres
	 * @param descripcion
	 * @param valor
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	public void guardarServicio(String nombres, String descripcion,
			Double valor) throws DataBaseException, LogicException;
	
	/**
	 * Instancia del metodo obtenerServicio por medio del cual se implementa la logica para obtener
	 * un Servicio de la DB 
	 * @param id
	 * @return Servicio
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	public Servicio obtenerServicio(int id) throws DataBaseException,
	LogicException ;
	
	/**
	 * Instancia del metodo actualizarServicio por medio del cual se implementa la logica para actualizar
	 * un Servicio en la DB
	 * @param servicio
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	public void actualizarServicio(Servicio servicio) throws DataBaseException,
	LogicException;
	
	/**
	 * Instancia del metodo obtenerServicios por medio del cual se implementa la logica para obtener
	 * un Lista de todos los Servicios en la DB
	 * @return List
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	public List obenerServicios() throws DataBaseException, LogicException ;
	
	/**
	 * Instancia del metodo eliminarServicio por medio del cual se implementa la logica para eliminar
	 * un Servicio en la DB
	 * @param id
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	public void eliminarServicio(int id) throws DataBaseException,
	LogicException;
}
