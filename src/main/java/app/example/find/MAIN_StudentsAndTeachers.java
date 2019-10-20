package app.example.find;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.SpringContext;
import app.example.find.entity.Student;

public class MAIN_StudentsAndTeachers
{
	public static void main(String[] args)
	{
		new ClassPathXmlApplicationContext("META-INF/find/spring.xml");
		Session session = SpringContext.getInstance().getSession();

		Criteria criteria = session.createCriteria(Student.class);
		criteria.createCriteria("teachers");
		List<Student> students = criteria.list();
		System.out.println("Student: \nId: " + students.get(0).getStudentId() + " name: " + students.get(0).getName() + " teacher: " + students.get(0).getTeachers().iterator().next().getName());
		System.out.println("Student: \nId: " + students.get(1).getStudentId() + " name: " + students.get(1).getName() + " teacher: " + students.get(1).getTeachers().iterator().next().getName());
	}
}
