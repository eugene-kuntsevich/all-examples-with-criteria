package app.example.jpafind;

import java.util.Collections;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.example.jpafind.dao.TeachingDepartmentDao;
import app.example.jpafind.entity.Teacher;
import app.example.jpafind.entity.TeachingDepartment;

public class MAIN_JPA_TeachersWithTeachingDeptCascadePersist
{

	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("META-INF/jpafind/spring.xml");

		TeachingDepartmentDao deptDao = (TeachingDepartmentDao) classPathXmlApplicationContext.getBean("teachingDepartmentDao");
		TeachingDepartment dept = new TeachingDepartment();
		dept.setDepartmentName("Biology");
		Teacher teacher = new Teacher();
		teacher.setName("Masha2");
		teacher.setTeachingDepartment(dept);
		dept.setTeachers(Collections.singletonList(teacher));
		deptDao.saveTeachingDepartment(dept);
	}
}
