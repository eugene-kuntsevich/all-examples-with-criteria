package app.example.jpafind.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.Transactional;

import app.SpringContext;
import app.example.jpafind.entity.TeachingDepartment;

public class TeachingDepartmentDao
{
	private EntityManager entityManager = SpringContext.getInstance().getEntityManager();

	@Transactional
	public TeachingDepartment findTeachingDepartment(Long id)
	{
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<TeachingDepartment> criteriaQuery = criteriaBuilder.createQuery(TeachingDepartment.class);
		Root<TeachingDepartment> root = criteriaQuery.from(TeachingDepartment.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("id"), id));

		Query query = entityManager.createQuery(criteriaQuery);
		TeachingDepartment teachingDepartment = (TeachingDepartment) query.getSingleResult();
		return teachingDepartment;
	}

	public void saveTeachingDepartment(TeachingDepartment teachingDepartment)
	{
		entityManager.persist(teachingDepartment);
	}

	public void updateTeachingDepartment(TeachingDepartment teachingDepartment)
	{
		entityManager.merge(teachingDepartment);
	}

	public void deleteTeachingDepartment(Long id)
	{
		TeachingDepartment teachingDepartment = null;
		if (id != null)
		{
			teachingDepartment = findTeachingDepartment(id);
		}
		if (teachingDepartment != null)
		{
			entityManager.remove(teachingDepartment);
		}
	}

	public void deleteTeachersOrphanRemoval(Long teacherId, Long deptId)
	{
		TeachingDepartment teachingDepartment = null;
		if (deptId != null)
		{
			teachingDepartment = entityManager.find(TeachingDepartment.class, deptId);
		}
		if (teachingDepartment != null && teacherId != null)
		{
			teachingDepartment.getTeachers().removeIf(teacher -> teacherId.equals(teacher.getTeacherId()));
		}
	}
}
