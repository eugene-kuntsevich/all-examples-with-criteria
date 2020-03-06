package app.example.jpafind;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.example.jpafind.dao.TeachingDepartmentDao;

public class MAIN_JPA_TeachersWithTeachingDeptCascadeRemove
{

	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("META-INF/jpafind/spring.xml");

		TeachingDepartmentDao deptDao = (TeachingDepartmentDao) classPathXmlApplicationContext.getBean("teachingDepartmentDao");
		deptDao.deleteTeachingDepartment(26L);
	}
}
