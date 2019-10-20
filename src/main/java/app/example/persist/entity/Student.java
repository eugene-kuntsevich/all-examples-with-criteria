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
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "STUDENTS")
public class Student implements Serializable
{
	private Long studentId;
	private String name;
	private Set<Teacher> teachers = new HashSet<>();

	public Student()
	{
	}

	public Student(String name)
	{
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "student_id", unique = true, nullable = false)
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

	@ManyToMany(fetch = FetchType.EAGER, targetEntity = Teacher.class, cascade = {CascadeType.ALL})
	@JoinTable(name = "STUDENTS_TO_TEACHERS", joinColumns = {@JoinColumn(name = "student_id")}, inverseJoinColumns = {@JoinColumn(
		name = "teacher_id")})
	public Set<Teacher> getTeachers()
	{
		return teachers;
	}

	public void setTeachers(Set<Teacher> teachers)
	{
		this.teachers = teachers;
	}
}
