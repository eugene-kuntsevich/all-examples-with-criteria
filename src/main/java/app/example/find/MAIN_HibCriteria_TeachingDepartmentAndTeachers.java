package app.example.find;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.SpringContext;
import app.example.find.entity.Teacher;
import app.example.find.entity.TeachingDepartment;

/**
 *
 */
public class MAIN_HibCriteria_TeachingDepartmentAndTeachers
{
	public static void main(String[] args)
	{
		new ClassPathXmlApplicationContext("META-INF/find/spring.xml");
		Session session = SpringContext.getInstance().getSession();

		Criteria criteria = session.createCriteria(TeachingDepartment.class);
		criteria.createCriteria("teachers");
		List<TeachingDepartment> teachingDepartments = criteria.list();
		System.out.println(teachingDepartments.size());
	}
}
