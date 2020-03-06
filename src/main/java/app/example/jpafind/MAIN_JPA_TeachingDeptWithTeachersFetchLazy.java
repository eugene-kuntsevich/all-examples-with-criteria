package app.example.jpafind;

import javax.transaction.Transactional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.example.jpafind.dao.TeachingDepartmentDao;
import app.example.jpafind.entity.TeachingDepartment;

@Transactional
public class MAIN_JPA_TeachingDeptWithTeachersFetchLazy
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("META-INF/jpafind/spring.xml");
		TeachingDepartmentDao departmentDao = (TeachingDepartmentDao) classPathXmlApplicationContext.getBean("teachingDepartmentDao");

		TeachingDepartment result = departmentDao.findTeachingDepartment(1L);
		//System.out.println("Size = " + results.size());
		System.out.println("Teacher's name = " + result.getTeachers().get(0).getName());
	}
}
