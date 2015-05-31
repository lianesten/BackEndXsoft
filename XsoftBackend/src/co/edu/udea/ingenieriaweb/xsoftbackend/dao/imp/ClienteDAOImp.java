package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ClienteDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 *Clase en la cual se codifican los metodo que permiten hacer operaciones sobre la tabla 
 *Cliente en la Base de Datos
 * @author Equipo de desarrollo Xsoft
 *
 */
public class ClienteDAOImp extends HibernateDaoSupport  implements ClienteDAO {
	
	public ClienteDAOImp() {
	}

	/**
	 * Metodo que se utiliza para almacenar un Cliente en la Base de datos
	 * @param cliente
	 * @throws DataBaseException
	 */
	@Override
	public void guardarCliente(Cliente cliente) throws DataBaseException {
		Session session = null;
		Logger  log = Logger.getLogger(this.getClass());
		try{
			session = getSession(); 
			Transaction tx = session.beginTransaction();
            session.save(cliente);
            session.flush();
            tx.commit();
			
			
		/*catch para caturar algun posible Error*/	
		}catch(HibernateException e){
			log.error("Error guardando Cliente"+ e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error almacenando un Cliente en la BD");
			
		}catch(Exception e){
			log.error("Error guardando Cliente"+ e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error almacenando un Cliente en la BD");
		}	
		
	}
	

	/**
	 * Metodo para obtener un Cliente por medio de su Identificación
	 * @throws DataBaseException 
	 */
	@Override
	public Cliente obtenerCliente(String identificacion) throws DataBaseException {
		System.out.println("LLega al metodo obtenerCliente");
		Session session = null;
		Logger  log = Logger.getLogger(this.getClass());
		try{
			
			Cliente cliente = null;
			/*Obtenemos la sesion mediante la cual nos vamos a conectar*/
			session = getSession();
			
			/*Le indicamos que vamos a hacer consultas sobre la clase Cliente*/
			Criteria criteria = session.createCriteria(Cliente.class);
			
			/*Obtenemos la lista de las Ciudades*/
			cliente =(Cliente)session.get(Cliente.class, identificacion);
			
			return cliente;
			
		/*catch para caturar algun posible Error*/	
		}catch(HibernateException e){
			e.printStackTrace();
			log.error("Error en HibernateException: " + e.getMessage() );
			throw new DataBaseException(e);
			
		}catch(Exception e){
			System.out.println("Entra por el Exception general");
			log.error("Entra por el Exception general ClienteDAOImp: " + e.getMessage());
			e.printStackTrace();
			throw new DataBaseException(e,"Error general que se presenta en el ClienteDaoImp, metodo obtener Cliente");
		}	 
	}

	
}
