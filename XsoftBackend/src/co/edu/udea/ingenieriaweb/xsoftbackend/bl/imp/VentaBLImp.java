package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.VentaBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ClienteDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.UsuarioDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.VentaDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Venta;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/** clase que implementa todos los metodos definos en la interface venta */
public class VentaBLImp implements VentaBl {
	private Venta venta;
	private UsuarioDAO usuarioDAO = null;
	private ClienteDAO clienteDAO = null;
	private Usuario usuario;
	private Cliente cliente;

	VentaDAO ventaDAO;

	public VentaDAO getVentaDAO() {
		return ventaDAO;
	}

	public void setVentaDAO(VentaDAO ventaDAO) {
		this.ventaDAO = ventaDAO;
	}

	/**
	 * metodo para almacenar una nueva venta en la base de datos
	 */

	@Override
	public void GuardarVenta(String numeroIdCliente, String usuarioCreaId)
			throws DataBaseException, LogicException {
		try {
			usuario = usuarioDAO.obtenerUsuario(usuarioCreaId);
			cliente = clienteDAO.obtenerCliente(numeroIdCliente);

			venta = new Venta();
			venta.setUsuario(usuario);
			venta.setCliente(cliente);
			ventaDAO.guardarVenta(venta);

		} catch (DataBaseException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error en el almacenamiento de Venta: " + e);

		}

	}

	@Override
	public void obtenerVenta(Integer idVenta) throws DataBaseException,
			LogicException {
		try {

			venta = ventaDAO.obtenerVenta(idVenta);

		} catch (DataBaseException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error en el almacenamiento de Venta: " + e);

		}

	}

	@Override
	public void actualizarVenta(String numeroIdCliente, String usuarioCreaId)
			throws DataBaseException, LogicException {

		usuario = usuarioDAO.obtenerUsuario(usuarioCreaId);
		cliente = clienteDAO.obtenerCliente(numeroIdCliente);
		venta = new Venta();
		venta.setCliente(cliente);
		venta.setUsuario(usuario);
		try {
			ventaDAO.actualizarVenta(venta);
		} catch (DataBaseException e) {
			e.printStackTrace();
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando Venta: " + e);

		}

	}

	@Override
	public List<Venta> obtenerVentas() throws DataBaseException {
		List<Venta> listadoVentas = new ArrayList<Venta>();
		try{
		listadoVentas = ventaDAO.obtenerVentas();
		}catch(Exception e){
			e.printStackTrace();
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error actualizando Venta: " + e);

		}
		return listadoVentas;
	}

}
