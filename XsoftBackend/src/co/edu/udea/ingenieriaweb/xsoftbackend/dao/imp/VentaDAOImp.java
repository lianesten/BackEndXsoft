package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.ingenieriaweb.xsoftbackend.dao.VentaDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Venta;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

public class VentaDAOImp extends HibernateDaoSupport implements VentaDAO {
	private Session session = null;
	private Logger log;
	@Override
	public void guardarVenta(Venta venta) throws DataBaseException {
		Session session = null;
		Logger  log = Logger.getLogger(this.getClass());
		try{
			session = getSession(); 
			Transaction tx = session.beginTransaction();
            session.save(venta);
            session.flush();
            tx.commit();
		/*catch para caturar algun posible Error*/	
		}catch(HibernateException e){
			log.error("Error guardando Venta"+ e);
			System.out.println("Error Guardando Venta"+ e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error almacenando un venta en la BD");
			
		}catch(Exception e){
			System.out.println("Error en el VentaDAOImp");
			e.printStackTrace();
			log.error("Error guardando Venta"+ e);
			throw new DataBaseException(e, "Error almacenando un venta en la BD");
		}finally{
			/*Cerramos la sesion creada*/
			 if (session!=null) {
					session.close(); 	
			}
		
		}
		
	}

	@Override
	public Venta obtenerVenta(Integer idVenta) throws DataBaseException {
		log = Logger.getLogger(this.getClass());
		Venta venta=null;
		try{
			//user = (Usuario) session.createQuery("SELECT usuario FROM Usuario WHERE numeroId="+numeroId).uniqueResult();
			/*Obtenemos la sesion mediante la cual nos vamos a conectar*/
			session = getSession();
			
			/*Le indicamos que vamos a hacer consultas sobre la claseventa*/
			Criteria criteria = session.createCriteria(Venta.class);
			
			/*Obtenemos la venta*/
			venta =(Venta)session.get(Venta.class, idVenta);
			
			
			
			
		}catch(HibernateException e){
			log.error("Error guardando Cliente "+e);
			System.out.println("Error obteniendo Venta"+e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error almacenando un Venta en la BD");
		}catch(Exception e){
			System.out.println("Error en el VentaDAOImp");
			e.printStackTrace();
			log.error("Error obteniendo Venta"+e);
			throw new DataBaseException(e, "Error almacenando un venta en la BD");
		}finally{
			/*Cerramos la sesion creada*/
			 if (session!=null) {
					session.close(); 	
			}
		}
		return venta;
	}

	@Override
	public void actualizarVenta(Venta venta) throws DataBaseException {
		log = Logger.getLogger(this.getClass());
		try{
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.merge(venta);
			//session.flush();
			tx.commit();
		}catch(HibernateException e){
			log.error("Error actualizando venta"+e);
			System.out.println("Error actualizando venta "+e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error actualizando una venta en la BD");
		}catch(Exception e){
			System.out.println("Error en el VentaDAOImp");
			e.printStackTrace();
			log.error("Error actualizando venta"+e);
			throw new DataBaseException(e, "Error almacenando un venta en la BD");
		}finally{
			/*Cerramos la sesion creada*/
			 if (session!=null) {
					session.close(); 	
			}
		}
		
	}

	@Override
	public List<Venta> obtenerVentas() throws DataBaseException {
		List<Venta> listadoVentas = null;
		try{
			
			Transaction tx = session.beginTransaction();
			listadoVentas = (List<Venta>) session.createQuery("from ventas").list();
			tx.commit();
			
		}catch(HibernateException e){
			log.error("Error obteniendo listado de ventas "+e);
			System.out.println("Error obteniendo listado de ventas "+e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error obteniendo listado de ventas en la BD");
		}catch(Exception e){
			System.out.println("Error en el VentasDAOImp");
			e.printStackTrace();
			log.error("Error obteniendo listado de ventas"+e);
			throw new DataBaseException(e, "Error almacenando un venta en la BD");
		}
		return listadoVentas;
	}


	
}
