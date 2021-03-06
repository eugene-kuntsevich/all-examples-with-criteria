package app.example.jpafind;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.SpringContext;
import app.example.jpafind.entity.Student;

public class MAIN_CriteriaBuilder
{
	public static void main(String[] args)
	{
		new ClassPathXmlApplicationContext("META-INF/jpafind/spring.xml");
		EntityManager entityManager = SpringContext.getInstance().getEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		criteriaQuery.select(root);

		Query query = entityManager.createQuery(criteriaQuery);
		List<Student> results = query.getResultList();
		System.out.println("Student: \nId: " + results.get(0).getStudentId() + " name: " + results.get(0).getName() + " teacher: " + results.get(18).getTeachers().iterator().next());
		System.out.println("Size = " + results.size());
	}
}
