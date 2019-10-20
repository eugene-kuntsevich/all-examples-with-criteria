package app.example.persist.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HEAD_OF_DEPARTMENT")
public class HeadOfDepartment
{
	private Long id;
	private String name;
	private TeachingDepartment teachingDepartment;

	public HeadOfDepartment()
	{
	}

	@Id
	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@OneToOne(targetEntity = TeachingDepartment.class, fetch = FetchType.LAZY)
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
