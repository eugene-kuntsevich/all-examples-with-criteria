package app.example.find;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.SpringContext;
import app.example.find.entity.Teacher;

/**
 *
 */
public class MAIN_FetchTypeTeachingDepartmentAndTeachers
{
	public static void main(String[] args)
	{
		new ClassPathXmlApplicationContext("META-INF/find/spring.xml");
		Session session = SpringContext.getInstance().getSession();

		Criteria criteria = session.createCriteria(Teacher.class);
		criteria.createCriteria("teachingDepartment");
		List<Teacher> teachingDepartments = criteria.list();
		System.out.println(teachingDepartments.size());
	}
}
