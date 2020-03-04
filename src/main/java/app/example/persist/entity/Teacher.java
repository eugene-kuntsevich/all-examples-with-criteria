package app.example.persist.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private List<Student> students = new ArrayList<>();
	private TeachingDepartment teachingDepartment;

	public Teacher()
	{
	}

	public Teacher(String name)
	{
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
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

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Student.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(name = "STUDENTS_TO_TEACHERS", joinColumns = {@JoinColumn(name = "teacher_id")}, inverseJoinColumns = {@JoinColumn(
		name = "student_id")})
	public List<Student> getStudents()
	{
		return students;
	}

	public void setStudents(List<Student> students)
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
