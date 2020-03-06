package app.example.jpafind;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.example.jpafind.dao.TeachersDao;
import app.example.jpafind.entity.Teacher;

public class MAIN_JPA_TeachersWithTeachingDeptFetchLazy
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("META-INF/jpafind/spring.xml");

		TeachersDao teachersDao = (TeachersDao) classPathXmlApplicationContext.getBean("teachersDao");
		Teacher teacher = teachersDao.findTeacher();
		System.out.println("TeachingDepartment's name = " + teacher.getTeachingDepartment().getDepartmentName());
	}
}
