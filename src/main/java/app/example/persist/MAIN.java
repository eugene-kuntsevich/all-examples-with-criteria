package app.example.persist;

import java.util.Collections;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.example.persist.dao.SaveStudentDao;
import app.example.persist.dao.SaveTeacherDao;
import app.example.persist.dao.SaveTeachingDepartmentDao;
import app.example.persist.entity.Student;
import app.example.persist.entity.Teacher;
import app.example.persist.entity.TeachingDepartment;

public class MAIN
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("META-INF/persist/spring.xml");
		SaveStudentDao daoSaveStudent = (SaveStudentDao) classPathXmlApplicationContext.getBean("SaveStudentDao");
		SaveTeacherDao daoSaveTeacher = (SaveTeacherDao) classPathXmlApplicationContext.getBean("SaveTeacherDao");
		SaveTeachingDepartmentDao daoSaveTeachingDepartment = (SaveTeachingDepartmentDao) classPathXmlApplicationContext.getBean("SaveTeachingDepartmentDao");

		Student student1 = new Student("Ivan");
		daoSaveStudent.saveStudent(student1);
		TeachingDepartment mathDepartment = new TeachingDepartment("Math");
		daoSaveTeachingDepartment.save(mathDepartment);

		Teacher galina = new Teacher("Galina");
		galina.setTeachingDepartment(mathDepartment);
		daoSaveTeacher.save(galina);
		galina.setStudents(Collections.singletonList(student1));
		daoSaveTeacher.update(galina);
	}
}
