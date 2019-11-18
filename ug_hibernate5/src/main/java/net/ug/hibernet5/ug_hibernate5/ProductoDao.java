package net.ug.hibernet5.ug_hibernate5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class ProductoDao {

	
protected SessionFactory sessionFactory;
	
	protected void setup() {
		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure()  //lee los settings del archivo hibernate.cfg.xml
				.build();
		try {
			sessionFactory = new MetadataSources(registry)
					.buildMetadata().buildSessionFactory();			
		} catch (Exception e) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
		
	}
	
	
	protected void crear(Producto producto) {
		Session s =  sessionFactory.openSession();
		s.beginTransaction();
		s.save(producto);
		s.getTransaction().commit();
		s.close();
	}
	protected Producto read(long productoId) {
		Session s =  sessionFactory.openSession();
		Producto producto = s.get(Producto.class, productoId);
		s.close();
		return producto;
	}
	
	protected void update(Producto producto) {
		Session s =  sessionFactory.openSession();
		s.beginTransaction();
		s.update(producto);
		s.getTransaction().commit();
		s.close();
	}
	
	
	protected void delete(int productoId) {
		Session s =  sessionFactory.openSession();
		s.beginTransaction();
		Producto producto = new Producto();
		producto.setId(productoId);
		s.delete(producto);
		s.getTransaction().commit();
		s.close();
	}
	
}
