package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


public class SpringContext
{
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private JpaTransactionManager jpaTransactionManager;
	private static SpringContext springContext;

	public static SpringContext getInstance()
	{
		if (springContext == null)
		{
			springContext = new SpringContext();
			return springContext;
		}
		return springContext;
	}

	public EntityManager getEntityManager()
	{
		return entityManagerFactory.createEntityManager();
	}

	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	public EntityManagerFactory getEntityManagerFactory()
	{
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory)
	{
		this.entityManagerFactory = entityManagerFactory;
	}

	public JpaTransactionManager getJpaTransactionManager()
	{
		return jpaTransactionManager;
	}

	public void setJpaTransactionManager(JpaTransactionManager jpaTransactionManager)
	{
		this.jpaTransactionManager = jpaTransactionManager;
	}

	public Session getSession()
	{
		return entityManager.getEntityManagerFactory().createEntityManager().unwrap(Session.class);
	}
}
