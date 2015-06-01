package co.edu.udea.ingenieriaweb.xsoftbackend.dao;


import java.util.List;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Venta;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

/**
 * 
 * @author Julian Montoya, Luis Duque
 *
 */
public interface VentaDAO {
	/**
	 * Instancia del metodo encargado de guardar una venta en la DB
	 * @param venta
	 * @throws DataBaseException
	 */
	public void guardarVenta(Venta venta) throws DataBaseException;
	
	/**
	 *  Instancia del metodo encargado de obtener una venta en la DB
	 * @param idVenta
	 * @return Venta
	 * @throws DataBaseException
	 */
	public Venta obtenerVenta(Integer idVenta) throws DataBaseException;
	/**
	 *  Instancia del metodo encargado de actualizar una venta en la DB
	 * @param venta
	 * @throws DataBaseException
	 */
	public void actualizarVenta(Venta venta) throws DataBaseException;
	/**
	 *  Instancia del metodo encargado de obtener todas las ventas de la DB
	 * @return List
	 * @throws DataBaseException
	 */
	public List<Venta> obtenerVentas() throws DataBaseException;
}
