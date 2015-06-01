package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.ingenieriaweb.xsoftbackend.dao.VentaDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Venta;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

/**
 * 
 * @author Equipo de Desarrollo Xsoft
 *
 */

// /*Le especificamos que correremos la prueba con el Junit de Spring*/
@RunWith(SpringJUnit4ClassRunner.class)
// @Transactional
// /*Le decimos cual es el archivo de configuraciones del Spring*/
@ContextConfiguration(locations = "classpath:/ConfigurationSpring.xml")
// /*Le decimos a Spring que en esta clase pueden haber cosas que deba
// inyectar*/
@Component
public class VentaDAOImpTest {

	/**
	 * Inyectamos el bean de ventaDAO
	 */
	@Autowired
	VentaDAO ventaDAO;

	/**
	 * Prueba realizada para verificar que se pueda ingresar una Venta
	 */
	@Test
	public void testGuardarVenta() {

		/**
		 * Creamos un objeto de la venta
		 */
		Venta venta = new Venta();

		/**
		 * Es necesario crear un objeto de Cliente
		 *
		 */
		Cliente cliente = new Cliente();
		cliente.setNumeroId("120365485");

		/**
		 * Es necesario crear un objeto de la clase Usuario
		 */
		Usuario usuario = new Usuario();
		usuario.setNumeroId("1038481420");

		/**
		 * Ingresamos los parametros de la venta
		 *
		 */
		venta.setCliente(cliente);
		venta.setUsuario(usuario);

		/**
		 * Guardamos la Venta
		 */
		try {
			ventaDAO.guardarVenta(venta);
			assertTrue(venta != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	/**
	 * Prueba realizada para verificar que se pueda obtener correctamente una
	 * Venta desde la DB
	 */
	@Test
	public void testObtenerVenta() {
		int idVenta = 1;
		Venta venta = null;
		try {
			venta = ventaDAO.obtenerVenta(idVenta);
			assertTrue(venta != null);
			Logger log = Logger.getLogger(this.getClass());
			log.info("Nombre Usuario que hizo la venta: "
					+ venta.getUsuario().getNombres());
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	/**
	 * Prueba realizada para verificar que una venta se pueda actualizar
	 * 
	 * @throws DataBaseException
	 */
	@Test
	public void testActualizarVenta() throws DataBaseException {
		/**
		 * Obtenemos la venta que se desea modificar
		 */
		Venta venta = ventaDAO.obtenerVenta(1);

		/**
		 * Modificamos los datos que queremos cambiar, en este caso vamos a
		 * cambiar el usuario que realizo la venta, para eso vamos a crear un
		 * objeto de la clase Usuario
		 */
		Usuario usuario = new Usuario();
		usuario.setNumeroId("1152690699");

		venta.setUsuario(usuario);

		try {
			ventaDAO.actualizarVenta(venta);
			assertTrue(venta != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			System.out.println("Problema" + e.toString());
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba realizada para verificar que se pueda obtener la informacion de
	 * todas las ventas
	 */
	@Test
	public void testObtenerVentas() {
		List ventas = null;
		Logger log = Logger.getLogger(this.getClass());
		try {
			ventas = ventaDAO.obtenerVentas();
			assertTrue(ventas != null);
			Venta venta = (Venta) ventas.get(0);
			log.info("Nombre Cliente de la primera Venta: "
					+ venta.getCliente().getNombres());

		} catch (DataBaseException e) {
			e.printStackTrace();
			System.out.println("Problema" + e.toString());
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
