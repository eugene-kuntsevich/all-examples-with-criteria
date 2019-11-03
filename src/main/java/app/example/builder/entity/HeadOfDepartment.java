package app.example.builder.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

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
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
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

	@OneToOne(targetEntity = TeachingDepartment.class)
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
