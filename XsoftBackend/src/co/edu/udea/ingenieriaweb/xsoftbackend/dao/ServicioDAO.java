package co.edu.udea.ingenieriaweb.xsoftbackend.dao;

import java.util.List;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Servicio;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

/**
 * 
 * @author  Alejandro Zambrano, Joaquin Hernandez
 * Interfaces que contiene los metodo que permiten hacer operaciones de el DTO Servicios en la DB
 *
 */
public interface ServicioDAO {
	/**
	 * Metodo para alamcenar un Servicio en la DB
	 * @param servicio
	 * @throws DataBaseException
	 */
	public void guardarServicio(Servicio servicio) throws DataBaseException;
	/**
	 * Metodo para obtener un servicio con el Id
	 * @param identificacion
	 * @throws DataBaseException
	 */
	public Servicio obtenerServicio(int identificacion)  throws DataBaseException;
	
	/**
	 * Instancia del metodo que permite actualizar un servicio
	 * @param servicio
	 * @throws DataBaseException
	 */
	public void actualizarSerivicio(Servicio servicio) throws DataBaseException;
	
	/**
	 * Instancia del metodo que permite eliminar un servicio de la DB
	 * @param idServicio
	 * @throws DataBaseException
	 */
	public void eliminarServicio(int idServicio) throws DataBaseException;
	
	/**
	 * Instancia del metodo que permite obtener los Servicios en la DB
	 * @return List con los Servicios almacenados en la DB
	 * @throws DataBaseException
	 */
	public List obtenerServicio() throws DataBaseException;
	
}
