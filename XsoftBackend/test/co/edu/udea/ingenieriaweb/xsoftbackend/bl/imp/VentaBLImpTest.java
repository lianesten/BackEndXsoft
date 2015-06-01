package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.VentaBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Venta;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;


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
public class VentaBLImpTest {
	
	/**
	 * Inyectamos el bean de ventaBl
	 */
	@Autowired
	VentaBl ventaBl;


	/**
	 * Prueba de integracion realizada para verificar que se pueda guardar una venta en la DB
	 * @throws LogicException 
	 */
	@Test
	public void testGuardarVenta() throws LogicException {
	
		/**
		 * Necesitamos el Id del cliente la que se le hace la venta
		 */

		String idCliente = "120365485";
		
		/**
		 * Necesitamos el ID del usuario que realizo la venta
		 */

		String idUsuario = "1038481420";

		/**
		 * Guardamos la Venta
		 */
		try {
			ventaBl.GuardarVenta(idCliente, idUsuario);
			assertTrue(idCliente != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

	/**
	 * Prueba de integracion realizada para validar que se pueda obtener correctamente la informacion
	 * de una venta que esta en la DB
	 * @throws LogicException 
	 */
	@Test
	public void testObtenerVenta() throws LogicException {
		int idVenta = 1;
		Venta venta = null;
		try {
			venta = ventaBl.obtenerVenta(idVenta);
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
	 * Prueba de integracion realizada para verificar que una venta se pueda actualizar correctamente
	 * @throws LogicException 
	 * @throws DataBaseException 
	 */
	@Test
	public void testActualizarVenta() throws DataBaseException, LogicException {
		/**
		 * Obtenemos la venta que se desea modificar
		 */
		Venta venta = ventaBl.obtenerVenta(1);

		/**
		 * Modificamos los datos que queremos cambiar, en este caso vamos a
		 * cambiar el usuario que realizo la venta, para eso vamos a crear un
		 * objeto de la clase Usuario
		 */
		Usuario usuario = new Usuario();
		usuario.setNumeroId("1038481420");
		venta.setUsuario(usuario);

		try {
			ventaBl.actualizarVenta(venta.getIdVenta(),venta.getCliente().getNumeroId(), usuario.getNumeroId());
			assertTrue(venta != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba de integracion realizada para verificar que se puedan obtener todas las Ventas en la
	 * Db
	 */
	@Test
	public void testObtenerVentas() {
		List ventas = null;
		Logger log = Logger.getLogger(this.getClass());
		try {
			ventas = ventaBl.obtenerVentas();
			assertTrue(ventas != null);
			Venta venta = (Venta) ventas.get(0);
			log.info("Nombre Cliente de la primera Venta: "
					+ venta.getCliente().getNombres());

		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
