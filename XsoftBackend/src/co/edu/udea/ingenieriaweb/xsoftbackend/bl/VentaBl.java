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
 * @author USUARIO
 *
 */
public interface VentaBl {
	/**
	 * Metodo que me permite almacenar una nueva venta en la BD.
	 * @param cliente es aquel quien realizo la compra
	 * @param usuario es aquel quien realizo la venta
	 * @throws DataBaseException
	 * @throws LogicException
	 */
	public void GuardarVenta(String numeroIdCliente, String usuarioCreaId ) throws DataBaseException, LogicException;
	public void obtenerVenta(Integer idVenta) throws DataBaseException, LogicException;
	public void actualizarVenta(String numeroIdCliente, String usuarioCreaId) throws DataBaseException, LogicException;
	public List<Venta> obtenerVentas() throws DataBaseException;
	
}
