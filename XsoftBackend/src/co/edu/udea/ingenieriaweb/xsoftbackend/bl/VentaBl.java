package co.edu.udea.ingenieriaweb.xsoftbackend.bl;

import java.util.Date;
import java.util.List;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Venta;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;


/**
 * Interface que contiene la logica del negocio que se va implementar sobre la tabla venta 
 * @author Julian Montoya, Luis Duque, Joaquin Hernandez
 *
 */
public interface VentaBl {
	/**
	 * Metodo que me permite almacenar una nueva venta en la BD.
	 * @param numeroIdCliente
	 * @param usuarioCreaId
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	public void GuardarVenta(String numeroIdCliente, String usuarioCreaId ) throws DataBaseException, LogicException;
	public Venta obtenerVenta(Integer idVenta) throws DataBaseException, LogicException;
	public void actualizarVenta(int idVenta, String numeroIdCliente, String usuarioCreaId) throws DataBaseException, LogicException;
	public List<Venta> obtenerVentas() throws DataBaseException;
	
}
