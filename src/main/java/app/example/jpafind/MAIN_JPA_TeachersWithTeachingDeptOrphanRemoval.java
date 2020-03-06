package app.example.jpafind;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.example.jpafind.dao.TeachingDepartmentDao;

public class MAIN_JPA_TeachersWithTeachingDeptOrphanRemoval
{

	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("META-INF/jpafind/spring.xml");

		TeachingDepartmentDao deptDao = (TeachingDepartmentDao) classPathXmlApplicationContext.getBean("teachingDepartmentDao");
		deptDao.deleteTeachersOrphanRemoval(2L, 33L);
	}
}
