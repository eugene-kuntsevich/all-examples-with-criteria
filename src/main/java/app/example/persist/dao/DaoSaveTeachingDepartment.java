package app.example.persist.dao;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import app.SpringContext;
import app.example.persist.entity.TeachingDepartment;

public class DaoSaveTeachingDepartment
{
	Session session = SpringContext.getInstance().getSession();

	@Transactional
	public TeachingDepartment save(TeachingDepartment teachingDepartment)
	{
		session.save(teachingDepartment);
		return teachingDepartment;
	}
}
