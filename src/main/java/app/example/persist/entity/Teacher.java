package app.example.persist.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "TEACHERS")
public class Teacher implements Serializable
{
	private Long teacherId;
	private String name;
	private Set<Student> students = new HashSet<>();
	private TeachingDepartment teachingDepartment;

	public Teacher()
	{
	}

	public Teacher(String name, Set<Student> students)
	{
		this.name = name;
		this.students = students;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "teacher_id", unique = true, nullable = false)
	public Long getTeacherId()
	{
		return teacherId;
	}

	public void setTeacherId(Long teacherId)
	{
		this.teacherId = teacherId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Student.class, cascade = CascadeType.ALL)
	@JoinTable(name = "STUDENTS_TO_TEACHERS", joinColumns = {@JoinColumn(name = "teacher_id")}, inverseJoinColumns = {@JoinColumn(
		name = "student_id")})
	//@ManyToMany(mappedBy = "teachers")
	public Set<Student> getStudents()
	{
		return students;
	}

	public void setStudents(Set<Student> students)
	{
		this.students = students;
	}

	@ManyToOne(targetEntity = TeachingDepartment.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "teaching_department_id")
	public TeachingDepartment getTeachingDepartment()
	{
		return teachingDepartment;
	}

	public void setTeachingDepartment(TeachingDepartment teachingDepartment)
	{
		this.teachingDepartment = teachingDepartment;
	}
}
