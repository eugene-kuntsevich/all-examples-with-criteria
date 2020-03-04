package app.example.persist.dao;

import javax.persistence.EntityManager;

import app.SpringContext;
import app.example.persist.entity.TeachingDepartment;

public class SaveTeachingDepartmentDao
{
	private EntityManager entityManager = SpringContext.getInstance().getEntityManager();

	public TeachingDepartment save(TeachingDepartment teachingDepartment)
	{
		entityManager.persist(teachingDepartment);
		return teachingDepartment;
	}
}
