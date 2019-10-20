package app.example.find;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.SpringContext;
import app.example.find.entity.Student;
import app.example.find.entity.Teacher;

/**
 * Using without keyword mappedBy https://www.sql.ru/forum/915534/mappedby-hibernate
 *
 * but this is only one-way communication between objects (Teacher->TeachingDepartment)
 * can't get TeachingDepartment with Teachers
 *
 * FROM TeachingDepartment class:
 * @OneToMany()
 *public List<Teacher> getTeachers()
 *{
 *return teachers;
 *}
 * FROM Teacher class:
 * @ManyToOne
 *@JoinColumn(name = "teaching_department_id")
 *public TeachingDepartment getTeachingDepartment()
 *{
 *return teachingDepartment;
 *}
 */
public class MAIN_TeachersAndTeachingDepartment
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
