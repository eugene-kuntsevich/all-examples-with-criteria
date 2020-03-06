package app.example.jpafind.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

import app.SpringContext;
import app.example.jpafind.entity.Teacher;

public class TeachersDao
{
	private EntityManager entityManager = SpringContext.getInstance().getEntityManager();

	@Transactional
	public Teacher findTeacher()
	{
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Teacher> criteriaQuery = criteriaBuilder.createQuery(Teacher.class);
		Root<Teacher> root = criteriaQuery.from(Teacher.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("teacherId"), 13L));

		Query query = entityManager.createQuery(criteriaQuery);
		Teacher singleResult = (Teacher) query.getSingleResult();
		Hibernate.initialize(singleResult.getTeachingDepartment());
		return singleResult;
	}

	public void saveTeacher(Teacher teacher)
	{
		entityManager.persist(teacher);
	}

}
