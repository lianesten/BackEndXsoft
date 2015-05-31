package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.ClienteBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

//*Le especificamos que correremos la prueba con el Junit de Spring*/
@RunWith (SpringJUnit4ClassRunner.class)

//@Transactional
//*Le decimos cual es el archivo de configuraciones del Spring*/
@ContextConfiguration (locations ="classpath*:/ConfigurationSpring.xml")

//*Le decimos a Spring que en esta clase pueden haber cosas que deba inyectar*/
@Component
public class ClienteBLImpTest {

	/**
	 * Inyectamos el bean clienteBL
	 */
	@Autowired
	ClienteBl clienteBL;
	
	@Test
	public void testGuardarCliente() {
		/**
		 * Creamos el objeto de la clase Cliente
		 */
		Cliente cliente = new Cliente();
		
		/**
		 * Es necesario definir un objeto de la Clase Usuario para indicar quien lo creo
		 */
		Usuario usuarioCrea = new Usuario(); 
		usuarioCrea.setNumeroId("1038481420");
		
		/**
		 * Llenamos los datos del Cliente
		 */
		cliente.setNombres("Juan ");
		cliente.setApellidos("Restrepo");
		cliente.setDireccion("Sur de Medellin");
		cliente.setEmail("pandres@gmail.com");
		cliente.setFechaCreacion(new Date());
		cliente.setNumeroId("47885");
		cliente.setTelefonoFijo("42566");
		cliente.setTelefonoMovil("3142563214");
		cliente.setUsuarioCrea(usuarioCrea);
		
		try{
			clienteBL.GuardarCliente("410", "mario", "Rojas", "123521459", 
					"47856954", "Mario@gmail.com", "calle94 /45", usuarioCrea);
			assertTrue(cliente!=null);
		}catch(DataBaseException e){
			e.printStackTrace();
			System.out.println("Problema"+ e.toString());
			fail("Not yet implemented");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
