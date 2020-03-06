package app.example.jpafind;

import java.util.Collections;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.example.jpafind.dao.TeachingDepartmentDao;
import app.example.jpafind.entity.Teacher;
import app.example.jpafind.entity.TeachingDepartment;

public class MAIN_JPA_TeachersWithTeachingDeptCascadeMerge
{

	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("META-INF/jpafind/spring.xml");

		TeachingDepartmentDao deptDao = (TeachingDepartmentDao) classPathXmlApplicationContext.getBean("teachingDepartmentDao");
		TeachingDepartment dept = new TeachingDepartment();
		dept.setId(27L);
		dept.setDepartmentName("Biology333");
		Teacher teacher = new Teacher();
		teacher.setTeacherId(23L);
		teacher.setName("Sveta222");
		teacher.setTeachingDepartment(dept);
		dept.setTeachers(Collections.singletonList(teacher));
		deptDao.updateTeachingDepartment(dept);
	}
}
