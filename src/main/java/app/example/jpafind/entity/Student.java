package app.example.jpafind.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "STUDENTS")
public class Student implements Serializable
{
	private Long studentId;
	private String name;
	private List<Teacher> teachers = new ArrayList<>();

	public Student()
	{
	}

	public Student(String name)
	{
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getStudentId()
	{
		return studentId;
	}

	public void setStudentId(Long studentId)
	{
		this.studentId = studentId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@ManyToMany
	@JoinTable(name = "STUDENTS_TO_TEACHERS", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {@JoinColumn(
		name = "teacher_id")})
	public List<Teacher> getTeachers()
	{
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers)
	{
		this.teachers = teachers;
	}
}
