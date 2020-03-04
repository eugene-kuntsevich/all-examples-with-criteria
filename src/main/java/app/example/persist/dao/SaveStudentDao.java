package app.example.persist.dao;

import javax.persistence.EntityManager;

import app.SpringContext;
import app.example.persist.entity.Student;

public class SaveStudentDao
{
	private EntityManager entityManager = SpringContext.getInstance().getEntityManager();

	public SaveStudentDao()
	{
	}

	public Student saveStudent(Student student)
	{
		entityManager.persist(student);
		return student;
	}

	public Student findStudent(Long id)
	{
		return entityManager.find(Student.class, id);
	}
}
