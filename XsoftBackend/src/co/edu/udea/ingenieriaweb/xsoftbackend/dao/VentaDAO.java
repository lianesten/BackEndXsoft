package co.edu.udea.ingenieriaweb.xsoftbackend.dao;


import java.util.List;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Venta;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;


public interface VentaDAO {
	public void guardarVenta(Venta venta) throws DataBaseException;
	public Venta obtenerVenta(Integer idVenta) throws DataBaseException;
	public void actualizarVenta(Venta venta) throws DataBaseException;
	public List<Venta> obtenerVentas() throws DataBaseException;
}
