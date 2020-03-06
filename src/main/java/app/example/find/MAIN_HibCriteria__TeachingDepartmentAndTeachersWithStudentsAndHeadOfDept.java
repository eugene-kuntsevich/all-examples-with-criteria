package app.example.find;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import app.SpringContext;
import app.example.find.entity.Teacher;
import app.example.find.entity.TeachingDepartment;

import static org.hibernate.criterion.Restrictions.eq;
import static org.hibernate.criterion.Restrictions.isNull;
import static org.hibernate.sql.JoinType.LEFT_OUTER_JOIN;

/**
 * getting TeachingDepartment with Teachers with students and with HeadOfDepartment
 */
public class MAIN_HibCriteria__TeachingDepartmentAndTeachersWithStudentsAndHeadOfDept
{
	public static void main(String[] args)
	{
		new ClassPathXmlApplicationContext("META-INF/find/spring.xml");
		Session session = SpringContext.getInstance().getSession();

		Criteria criteria = session.createCriteria(TeachingDepartment.class);
		Criteria crTeacher =  criteria.createCriteria("teachers", "t", LEFT_OUTER_JOIN).add(Restrictions.or(eq("name", "Galina"), isNull("name")));
		crTeacher.createCriteria("students", LEFT_OUTER_JOIN).add(Restrictions.or(eq("name", "Ivan")));

		criteria.createCriteria("headOfDepartment", "h", LEFT_OUTER_JOIN);
		List<TeachingDepartment> teachingDepartments = criteria.list();
		System.out.println(teachingDepartments.size());
	}
}
