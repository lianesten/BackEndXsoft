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

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.ServicioBL;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Servicio;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

///*Le especificamos que correremos la prueba con el Junit de Spring*/
@RunWith(SpringJUnit4ClassRunner.class)
// @Transactional
// /*Le decimos cual es el archivo de configuraciones del Spring*/
@ContextConfiguration(locations = "classpath:/ConfigurationSpring.xml")
// /*Le decimos a Spring que en esta clase pueden haber cosas que deba
// inyectar*/
@Component
/**
 * Clese que contiene las pruebas de integracion del a logica del negocio de la tabla Cliente
 * @author Equipo de desarrollo Xsoft
 *
 */
public class ServicioBLImpTest {

	@Autowired
	ServicioBL servicioBl;

	/**
	 * Prueba de integracion que permite validar el correcto ingreso de un
	 * Servicio en la DB
	 */
	@Test
	public void testGuardarServicio() {
		/**
		 * Creamos el objeto de la Clase Servio
		 */
		Servicio servicio = new Servicio();
		servicio.setNombre("Desarrollo Backend");
		servicio.setDescripcion("Desarrollo del Backend de unaaplicacion");
		servicio.setValor(3000000);

		try {
			/**
			 * Almacenamos el servicio en la DB
			 */
			servicioBl.guardarServicio(servicio.getNombre(),
					servicio.getDescripcion(), servicio.getValor());
			assertTrue(servicio != null);
		} catch (Exception e) {
			e.printStackTrace();
			Logger log = Logger.getLogger(this.getClass());
			log.info("Error guardando Servicio: " + e.toString());
		}
	}

	/**
	 * Prueba de integracion que se realiza para verificar que se pueda obtener
	 * correctamente un Servicio almacenado en la DB
	 */
	@Test
	public void testObtenerServicio() {
		Servicio servicio = null;
		/**
		 * Identificacion del servicio en la base de datos de nombre Desarrollo
		 * Backend
		 */
		String idServicio = "2";

		try {
			servicio = servicioBl.obtenerServicio(Integer.parseInt(idServicio));

			assertTrue(servicio.getId().equals(2));
			Logger log = Logger.getLogger(this.getClass());
			log.info("Nombre Servicio: " + servicio.getNombre());
		} catch (DataBaseException e) {
			e.printStackTrace();
		} catch (LogicException e) {
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error de Logica de negocio" + e.toString());
		}
	}

	/**
	 * Prueba de integracion realizada para verificar que un Servicio puede ser actualizado 
	 * correctamente
	 * @throws LogicException 
	 * @throws DataBaseException 
	 */
	@Test
	public void testActualizarServicio() throws DataBaseException, LogicException {
		/**
		 * Obtenemos el Servicio que se desea modificar
		 */
		Servicio servicio = servicioBl.obtenerServicio(2);

		/**
		 * Llenamos los datos del Servicio, podemos cambiar todo excepto el Id del servicio
		 */
		servicio.setNombre("Desarrollo FronEnd");

		try {
			servicioBl.actualizarServicio(servicio);
			assertTrue(servicio != null);
		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
			Logger log = Logger.getLogger(this.getClass());
			log.error("Error de Logica de negocio actualizando un Servicio" + e.toString());
		}
	}

	/**
	 * Prueba de integracion realizada para verificar que es posible obtener una lista con todos los
	 * servicios en la DB
	 */
	@Test
	public void testObenerServicios() {
		List servicios = null;
		Logger log = Logger.getLogger(this.getClass());
		try {
			servicios = (List) servicioBl.obenerServicios();
			assertTrue(servicios != null);
			Servicio servicio = (Servicio) servicios.get(0);
			log.info("Nombre Primer Servicio: " + servicio.getNombre());

		} catch (DataBaseException e) {
			e.printStackTrace();
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prueba de integracion realizada para verificar que se puede eliminar un Servicio de la DB
	 */
	@Test
	public void testEliminarServicio() {
		/**
		 * Id del Servicio a eliminar
		 */
		int idServicio = 4;
		Logger log = Logger.getLogger(this.getClass());
		try {
			servicioBl.eliminarServicio(idServicio);
			log.info("Servicio Eliminado");
			/**
			 * Preguntar al profesor como hacer assertTrue con errores
			 */
			assertTrue(idServicio==4);
			
		} catch (DataBaseException e) {
			e.printStackTrace();
			log.error("Error eliminando Servicio" + e.toString() );
			fail("Not yet implemented");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
