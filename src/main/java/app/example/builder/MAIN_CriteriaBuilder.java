package app.example.builder;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.SpringContext;
import app.example.builder.entity.Student;

public class MAIN_CriteriaBuilder
{
	public static void main(String[] args)
	{
		new ClassPathXmlApplicationContext("META-INF/builder/spring.xml");
		EntityManager entityManager = SpringContext.getInstance().getEntityManager();

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Student> cr = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = (Root<Student>) cr.from(Student.class).alias("st");
		ParameterExpression<String> nameParam = criteriaBuilder.parameter(String.class,"nameParamExpression");
		Path<String> studentName = root.get("name");
		Path<Number> studentId = root.get("studentId");
		Predicate like = criteriaBuilder.like(studentName, nameParam);
		Predicate gt = criteriaBuilder.gt(studentId, 2);
		Predicate and = criteriaBuilder.and(like, gt);
		cr.select(root).where(and);


		Query query = entityManager.createQuery(cr).setParameter("nameParamExpression", "%sha");
		List<Student> results = query.getResultList();
		System.out.println("size = " + results.size());
		System.out.println("Student: \nId: " + results.get(0).getStudentId() + " name: " + results.get(0).getName());
	}
}
