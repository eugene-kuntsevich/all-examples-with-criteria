package app.example.persist;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import app.example.persist.dao.SaveStudentDao;
import app.example.persist.dao.DaoSaveTeacher;
import app.example.persist.dao.DaoSaveTeachingDepartment;
import app.example.persist.entity.Student;

@EnableTransactionManagement
public class MAIN
{
	public static void main(String[] args)
	{
		new ClassPathXmlApplicationContext("META-INF/persist/spring.xml");
		SaveStudentDao daoSaveStudent = new SaveStudentDao();
		DaoSaveTeacher daoSaveTeacher = new DaoSaveTeacher();
		DaoSaveTeachingDepartment daoSaveTeachingDepartment = new DaoSaveTeachingDepartment();

		Student student1 = new Student("Ivan22222222222");
		daoSaveStudent.saveStudent(student1);
		//TeachingDepartment mathDepartment = new TeachingDepartment("Math");
		//daoSaveTeachingDepartment.save(mathDepartment);
		//daoSaveTeacher.save(new Teacher("Galina", Collections.singleton(student1)));
	}
}
