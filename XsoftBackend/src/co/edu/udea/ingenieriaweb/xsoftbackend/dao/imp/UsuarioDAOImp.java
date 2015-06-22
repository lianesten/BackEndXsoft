package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import java.util.ArrayList;
import java.util.List;





import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.ingenieriaweb.xsoftbackend.dao.UsuarioDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * * Clase en la cual se codifican los metodo que permiten hacer operaciones sobre
 * la tabla Usuario en la Base de Datos
 * @author Julian Montoya, Luis Duque, Joaquin Hernandez
 */
public class UsuarioDAOImp extends HibernateDaoSupport implements UsuarioDAO{
	private Session session = null;
	private Logger log;
	
	/**
	 * Metodo que se utiliza para almacenar un Usuario en la Base de datos
	 * 
	 * @param usuario
	 * @throws DataBaseException
	 */
	@Override
	public void guardarUsuario(Usuario usuario) throws DataBaseException {
		
		log = Logger.getLogger(this.getClass());
		try{
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(usuario);
			session.flush();
			tx.commit();
		}catch(HibernateException e){
			log.error(e);
			throw new DataBaseException(e, "Error almacenando un Usuario en la BD");
		}catch(Exception e){
			log.error(e);
			throw new DataBaseException(e, "Error almacenando un Usuario en la BD");
		}
	}
	
	/**
	 * Metodo para obtener un Usuario por medio de su Identificacion
	 * 
	 * @param numeroId
	 * @throws DataBaseException
	 */
	@Override
	public Usuario obtenerUsuario(String numeroId) throws DataBaseException {
		log = Logger.getLogger(this.getClass());
		Usuario usuario=null;
		try{
			//user = (Usuario) session.createQuery("SELECT usuario FROM Usuario WHERE numeroId="+numeroId).uniqueResult();
			/*Obtenemos la sesion mediante la cual nos vamos a conectar*/
			session = getSession();
			
			/*Le indicamos que vamos a hacer consultas sobre la clase Usuario*/
			Criteria criteria = session.createCriteria(Usuario.class);
			
			/*Obtenemos el usuario*/
			usuario =(Usuario)session.get(Usuario.class, numeroId);
			
			
			
			
		}catch(HibernateException e){
			log.error(e);
			throw new DataBaseException(e, "Error obtendiendo un Usuario en la BD");
		}catch(Exception e){
			log.error(e);
			throw new DataBaseException(e, "Error obteniendo un Usuario en la BD");
		}
		
		return usuario;
		
	}
	
	
	/**
	 * Metodo para obtener un Usuario por medio de su token
	 * 
	 * @param token
	 * @throws DataBaseException
	 */
	@Override
	public Usuario obtenerUsuarioToken(String token) throws DataBaseException, LogicException {
		log = Logger.getLogger(this.getClass());
		Usuario usuario=null;
		try{
			//user = (Usuario) session.createQuery("SELECT usuario FROM Usuario WHERE numeroId="+numeroId).uniqueResult();
			/*Obtenemos la sesion mediante la cual nos vamos a conectar*/
			session = getSession();
			
			/*Le indicamos que vamos a hacer consultas sobre la clase Usuario*/
			Criteria criteria = session.createCriteria(Usuario.class)
					.add(Restrictions.eq("token", token));
			
			/*Obtenemos el usuario*/
			usuario =(Usuario) criteria.list().get(0);
				
			
		}catch(HibernateException e){
			log.error(e);
			throw new DataBaseException(e, "Error obtendiendo un Usuario en la BD");
		}catch(IndexOutOfBoundsException e){
			log.error(e);
			throw new LogicException("El token es invalido");
		}
		catch(Exception e){
			log.error(e);
			throw new DataBaseException(e, "Error obteniendo un Usuario en la BD");
		}
		
		return usuario;
		
	}
	
	
	/**
	 * Implementacion del metodo definido en la interface UsuarioDAO, en este metodo 
	 * se hace uso de hibernate para hacer la respectiva transacciond de actualizacion en 
	 * la BD
	 * 	/**
	 * 
	 * @param usuario
	 * @throws DataBaseException
	 */
	@Override
	public void actualizarUsuario(Usuario usuario) throws DataBaseException {
		log = Logger.getLogger(this.getClass());
		try{
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.merge(usuario);
			//session.flush();
			tx.commit();
		}catch(HibernateException e){
			log.error(e);
			throw new DataBaseException(e, "Error actualizando un Usuario en la BD");
		}catch(Exception e){
			log.error(e);
			throw new DataBaseException(e, "Error almacenando un Usuario en la BD");
		}
	}
	
	/**
	 * Implementaciond el metodo obtenerUsuarios definido en la interface UsuarioDAO.
	 * retorna una lista con todos los usuarios almacenados en la bd
	 */
	@Override
	public List<Usuario> obtenerUsuarios() throws DataBaseException {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		session = null;
		Logger log = null;
		log = Logger.getLogger(this.getClass());
		try{
			
			session = getSession();
			
			/*Le indicamos que vamos a hacer consultas sobre la clase Cliente*/
			Criteria criteria = session.createCriteria(Usuario.class);
			
			/*Obtenemos la lista de las Ciudades*/
			listaUsuarios = criteria.list();
			
		}catch(HibernateException e){
			log.error(e);
			throw new DataBaseException(e, "Error obteniendo la lista de usuarios en la DB");
		}catch(Exception e){
			log.error(e);
			throw new DataBaseException(e, "Error obteniendo la lista de usuarios en la DB");
		}
		
		return listaUsuarios;
	}
	
	/**
	 * Implementacion del metodo definido en UsuarioDAO. Permite eliminar un usuario en la bd dado su numeroid
	 * DB
	 * 
	 * @param numeroId
	 * @throws DataBaseException
	 */
	@Override
	public void eliminarUsuario(String numeroId) throws DataBaseException {
		log = Logger.getLogger(this.getClass());
		try{
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.delete(this.obtenerUsuario(numeroId));
			//session.flush();
			tx.commit();
		}catch(HibernateException e){
			log.error(e);
			throw new DataBaseException(e, "Error eliminando usuario");
		}catch(Exception e){
			log.error(e);
			throw new DataBaseException(e, "Error eliminando usuario");
		}
		
	}

	/**
	 * Metodo Mediante el cual se obtiene un usuario por medio de su username
	 * @param username
	 * @throws DataBaseException
	 */
	@Override
	public Usuario obtenerUsuarioUsername(String username)throws DataBaseException {
		session = null;
		Logger log = null;
		log = Logger.getLogger(this.getClass());
		Usuario usuario=null;
		try{
			//user = (Usuario) session.createQuery("SELECT usuario FROM Usuario WHERE numeroId="+numeroId).uniqueResult();
			/*Obtenemos la sesion mediante la cual nos vamos a conectar*/
			session = getSession();
			
			/*Le indicamos que vamos a hacer consultas sobre la clase Usuario*/
//			Criteria criteria = session.createCriteria(Usuario.class).add( Restrictions.eq("username", username)).uniqueResult();;
			
			  usuario = (Usuario) session
                     .createCriteria(Usuario.class)
                     .add( Restrictions.eq("username", username) )
                     .uniqueResult();
			/*Obtenemos el usuario*/
		//	usuario =(Usuario)session.get(Usuario.class,);
			
			
		}catch(HibernateException e){
			log.error(e);
			throw new DataBaseException(e, "Error obtendiendo un Usuario en la BD");
		}catch(Exception e){
			log.error(e);
			throw new DataBaseException(e, "Error almacenando un Usuario en la BD");
		}
		
		return usuario;
	}

}
