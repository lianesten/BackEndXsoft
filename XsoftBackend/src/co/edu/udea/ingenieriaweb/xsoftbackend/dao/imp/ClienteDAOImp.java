package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ClienteDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * Clase en la cual se codifican los metodo que permiten hacer operaciones sobre
 * la tabla Cliente en la Base de Datos
 * 
 * @author Equipo de desarrollo Xsoft
 *
 */
public class ClienteDAOImp extends HibernateDaoSupport implements ClienteDAO {

	private Session session;

	public ClienteDAOImp() {
	}

	/**
	 * Metodo que se utiliza para almacenar un Cliente en la Base de datos
	 * 
	 * @param cliente
	 * @throws DataBaseException
	 */
	@Override
	public void guardarCliente(Cliente cliente) throws DataBaseException {
		Session session = null;
		Logger log = Logger.getLogger(this.getClass());
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(cliente);
			session.flush();
			tx.commit();

			/* catch para caturar algun posible Error */
		} catch (HibernateException e) {
			log.error("Error guardando Cliente" + e.toString());
			e.printStackTrace();
			throw new DataBaseException(e,
					"Error almacenando un Cliente en la BD");

		} catch (Exception e) {
			log.error("Error guardando Cliente" + e.toString());
			e.printStackTrace();
			throw new DataBaseException(e,
					"Error almacenando un Cliente en la BD");
		}

	}

	/**
	 * Metodo para obtener un Cliente por medio de su Identificaci�n
	 * 
	 * @param identificacion
	 * @throws DataBaseException
	 */
	@Override
	public Cliente obtenerCliente(String identificacion)
			throws DataBaseException {
		Session session = null;
		Logger log = Logger.getLogger(this.getClass());
		try {

			Cliente cliente = null;
			/* Obtenemos la sesion mediante la cual nos vamos a conectar */
			session = getSession();

			/* Le indicamos que vamos a hacer consultas sobre la clase Cliente */
			Criteria criteria = session.createCriteria(Cliente.class);

			/* Obtenemos la lista de las Ciudades */
			cliente = (Cliente) session.get(Cliente.class, identificacion);

			return cliente;

			/* catch para caturar algun posible Error */
		} catch (HibernateException e) {
			e.printStackTrace();
			log.error("Error en HibernateException: " + e.getMessage());
			throw new DataBaseException(e);

		} catch (Exception e) {
			log.error("Entra por el Exception general ClienteDAOImp: "
					+ e.getMessage());
			e.printStackTrace();
			throw new DataBaseException(e,
					"Error general que se presenta en el ClienteDaoImp, metodo obtener Cliente");
		}
	}

	/**
	 * Metodo mediante el cual se actualiza un cliente existente en la DB
	 * 
	 * @param cliente
	 * @throws DataBaseException
	 */
	@Override
	public void actualizarCliente(Cliente cliente) throws DataBaseException {
		Session session = null;
		Logger log;
		log = Logger.getLogger(this.getClass());
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.merge(cliente);
			// session.flush();
			tx.commit();
		} catch (HibernateException e) {
			log.error("Error actualizando Cliente " + e);
			e.printStackTrace();
			throw new DataBaseException(e,
					"Error actualizando un Cliente en la BD");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error actualizando Usuario" + e);
			throw new DataBaseException(e,
					"Error actualizando un Cliente en la BD");
		}

	}

	/**
	 * Metodo mediante el cual se elimina un Cliente que esta almacenado en la
	 * DB
	 * 
	 * @param idCliente
	 * @throws DataBaseException
	 */
	@Override
	public void eliminarCliente(String idCliente) throws DataBaseException {

		Session session = null;
		session = getSession();
		Logger log;
		log = Logger.getLogger(this.getClass());
		try {
			Cliente cliente = new Cliente();
			cliente.setNumeroId(idCliente);;
			Transaction tx = session.beginTransaction();
			session.delete(cliente);
			// session.flush();
			tx.commit();
		} catch (HibernateException e) {
			log.error("Error eliminando Cliente " + e);
			e.printStackTrace();
			throw new DataBaseException(e,
					"Error eliminando un Cliente en la BD");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error actualizando Usuario" + e);
			throw new DataBaseException(e,
					"Error eliminando un Cliente en la BD");
		}

	}

	/**
	 * Metodo que permite obtener una lista con todos los Clientes en la DB
	 * 
	 * @throws DataBaseException
	 */
	@Override
	public List<Cliente> obtenerClientes() throws DataBaseException {
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		session = null;
		Logger log = null;
		log = Logger.getLogger(this.getClass());
		try {

			session = getSession();
			
			/*Le indicamos que vamos a hacer consultas sobre la clase Cliente*/
			Criteria criteria = session.createCriteria(Cliente.class);
			
			/*Obtenemos la lista de las Ciudades*/
			listaClientes = criteria.list();

		} catch (HibernateException e) {
			log.error("Error obteniendo una lista de  Cliente " + e);
			e.printStackTrace();
			throw new DataBaseException(e,
					"Error obteniendo la lista de clientes en la DB");
		} catch (Exception e) {
			System.out.println("Error en el ClienteDAOImp");
			e.printStackTrace();
			log.error("Error obteniendo lista de clientes " + e.toString());
			throw new DataBaseException(e,
					"Error obteniendo la lista de clientes en la DB");
		}

		return listaClientes;
	}

}
