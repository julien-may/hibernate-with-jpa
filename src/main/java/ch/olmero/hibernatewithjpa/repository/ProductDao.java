package ch.olmero.hibernatewithjpa.repository;

import ch.olmero.hibernatewithjpa.domain.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;

@Repository
public class ProductDao {
	private final HibernateTemplate hibernateTemplate;

	@Autowired
	public ProductDao(EntityManagerFactory entityManagerFactory) {
		SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	public Product getByName(final String name) {
		return this.hibernateTemplate.execute(
			session -> (Product)session.createQuery("from Product p where p.name = ?0")
				.setParameter(0, name)
				.uniqueResult()
		);
	}
}
