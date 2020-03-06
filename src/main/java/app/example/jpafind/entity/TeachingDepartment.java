package app.example.jpafind.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHING_DEPARTMENTS")
public class TeachingDepartment
{
	private Long id;
	private String departmentName;
	private List<Teacher> teachers;
	private HeadOfDepartment headOfDepartment;

	public TeachingDepartment()
	{
	}

	public TeachingDepartment(String departmentName)
	{
		this.departmentName = departmentName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	@Column(name = "department_name")
	public String getDepartmentName()
	{
		return departmentName;
	}

	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true, mappedBy = "teachingDepartment")
	public List<Teacher> getTeachers()
	{
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers)
	{
		this.teachers = teachers;
	}

	@OneToOne
	@JoinColumn(name = "id")
	public HeadOfDepartment getHeadOfDepartment()
	{
		return headOfDepartment;
	}

	public void setHeadOfDepartment(HeadOfDepartment headOfDepartment)
	{
		this.headOfDepartment = headOfDepartment;
	}
}
