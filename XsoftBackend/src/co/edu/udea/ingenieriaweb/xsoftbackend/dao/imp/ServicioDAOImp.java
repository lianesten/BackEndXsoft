package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ServicioDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Servicio;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

/**
 * 
 * @author  Alejandro Zambrano, Joaquin Hernandez
 *
 */
public class ServicioDAOImp extends HibernateDaoSupport implements ServicioDAO{
	private Session session;
	public ServicioDAOImp() {
	}
	/**
	 * Metodo que se utiliza para almacenar un Servicio en la Base de datos
	 * 
	 * @param servicio
	 * @throws DataBaseException
	 */
	@Override
	public void guardarServicio(Servicio servicio) throws DataBaseException {
		Session session = null;
		Logger log = Logger.getLogger(this.getClass());
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(servicio);
			session.flush();
			tx.commit();

			/* catch para caturar algun posible Error */
		} catch (HibernateException e) {
			log.error(e);
			throw new DataBaseException(e,
					"Error almacenando un Servicio en la BD");

		} catch (Exception e) {
			log.error(e);
			throw new DataBaseException(e,
					"Error almacenando un Servicio en la BD");
		}

		
	}
	/**
	 * Metodo para obtener un Servicio por medio de su Identificacion
	 * 
	 * @param identificacion
	 * @throws DataBaseException
	 */

	@Override
	public Servicio obtenerServicio(int identificacion)
			throws DataBaseException {
			Session session = null;
			Logger log = Logger.getLogger(this.getClass());
			try {

				Servicio servicio = null;
				/* Obtenemos la sesion mediante la cual nos vamos a conectar */
				session = getSession();

				/* Le indicamos que vamos a hacer consultas sobre la clase Servicio */
				Criteria criteria = session.createCriteria(Servicio.class);

				/* Obtenemos la lista de Servicios*/
				servicio = (Servicio) session.get(Servicio.class, identificacion);

				return servicio;

				/* catch para caturar algun posible Error */
			} catch (HibernateException e) {
				log.error(e);
				throw new DataBaseException(e);

			} catch (Exception e) {
				log.error(e);
				throw new DataBaseException(e,
						"Error general que se presenta en el ServicioDaoImp, metodo obtener Servicio");
			}
	}

	/**
	 * Metodo mediante el cual se actualiza un servicio existente en la DB
	 * 
	 * @param servicio
	 * @throws DataBaseException
	 */
	@Override
	public void actualizarSerivicio(Servicio servicio) throws DataBaseException {
		Session session = null;
		Logger log;
		log = Logger.getLogger(this.getClass());
		try {
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.merge(servicio);
			// session.flush();
			tx.commit();
		} catch (HibernateException e) {
			log.error(e);
			throw new DataBaseException(e,
					"Error actualizando un Servicio en la BD");
		} catch (Exception e) {
			log.error(e);
			throw new DataBaseException(e,
					"Error actualizando un Servicio en la BD");
		}
		
	}

	/**
	 * Metodo mediante el cual se elimina un Servicio que esta almacenado en la
	 * DB
	 * 
	 * @param idServicio
	 * @throws DataBaseException
	 */
	@Override		
	public void eliminarServicio(int idServicio) throws DataBaseException {
		Session session = null;
		session = getSession();
		Logger log;
		log = Logger.getLogger(this.getClass());
		try {
			Servicio servicio = new Servicio();
			servicio.setId(idServicio);
			Transaction tx = session.beginTransaction();
			session.delete(servicio);
			// session.flush();
			tx.commit();
		} catch (HibernateException e) {
			log.error(e);
			throw new DataBaseException(e,"Error eliminando un servicio en la BD");
		} catch (Exception e) {
			log.error(e);
			throw new DataBaseException(e,"Error eliminando un servicio en la BD");
		}

		
	}

	@Override
	public List obtenerServicio() throws DataBaseException {
		List<Servicio> listaServicio = new ArrayList<Servicio>();
		session = null;
		Logger log = null;
		log = Logger.getLogger(this.getClass());
		try {

			session = getSession();
			
			/*Le indicamos que vamos a hacer consultas sobre la clase Servicio*/
			Criteria criteria = session.createCriteria(Servicio.class);
			
			/*Obtenemos la lista de las Servicio*/
			listaServicio = criteria.list();

		} catch (HibernateException e) {
			log.error(e);
			throw new DataBaseException(e,
					"Error obteniendo la lista de servicios en la DB");
		} catch (Exception e) {
			log.error(e);
			throw new DataBaseException(e,
					"Error obteniendo la lista de servicios en la DB");
		}

		return listaServicio;
	}
	


}
