package app.example.persist.dao;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import app.SpringContext;
import app.example.persist.entity.Teacher;

public class SaveTeacherDao
{
	private EntityManager entityManager = SpringContext.getInstance().getEntityManager();

	public Teacher save(Teacher teacher)
	{
		entityManager.persist(teacher);
		return teacher;
	}

	public Teacher update(Teacher teacher)
	{
		entityManager.merge(teacher);
		return teacher;
	}
}
