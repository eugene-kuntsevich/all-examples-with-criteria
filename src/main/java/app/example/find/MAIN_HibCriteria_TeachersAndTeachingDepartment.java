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
public class MAIN_HibCriteria_TeachersAndTeachingDepartment
{
	public static void main(String[] args)
	{
		new ClassPathXmlApplicationContext("META-INF/find/spring.xml");
		Session session = SpringContext.getInstance().getSession();

		Criteria criteria = session.createCriteria(Teacher.class);
		criteria.createCriteria("teachingDepartment");
		List<Teacher> teachers = criteria.list();
		System.out.println("Teacher: \nId: " + teachers.get(0).getTeacherId() + " name: " + teachers.get(0).getName() + " teachingDepartment: " + teachers.get(0).getTeachingDepartment().getDepartmentName());
		System.out.println("Teacher: \nId: " + teachers.get(1).getTeacherId() + " name: " + teachers.get(1).getName() + " teachingDepartment: " + teachers.get(1).getTeachingDepartment().getDepartmentName());
	}
}
