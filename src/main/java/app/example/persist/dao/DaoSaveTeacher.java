package app.example.persist.dao;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import app.SpringContext;
import app.example.persist.entity.Teacher;

public class DaoSaveTeacher
{
	Session session = SpringContext.getInstance().getSession();

	@Transactional
	public Teacher save(Teacher teacher)
	{
		session.save(teacher);
		return teacher;
	}
}
