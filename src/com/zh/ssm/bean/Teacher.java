package com.zh.ssm.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of teacher.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class Teacher implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id. */
	private Long id;

	/** name. */
	private String name;

	/** phone. */
	private String phone;

	/** sex. */
	private String sex;

	/** The set of course. */
	private Set<Course> courseSet;

	/**
	 * Constructor.
	 */
	public Teacher() {
		this.courseSet = new HashSet<Course>();
	}

	/**
	 * Set the id.
	 * 
	 * @param id
	 *            id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the id.
	 * 
	 * @return id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Set the name.
	 * 
	 * @param name
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the name.
	 * 
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the phone.
	 * 
	 * @param phone
	 *            phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Get the phone.
	 * 
	 * @return phone
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * Set the sex.
	 * 
	 * @param sex
	 *            sex
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * Get the sex.
	 * 
	 * @return sex
	 */
	public String getSex() {
		return this.sex;
	}

	/**
	 * Set the set of the course.
	 * 
	 * @param courseSet
	 *            The set of course
	 */
	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}

	/**
	 * Add the course.
	 * 
	 * @param course
	 *            course
	 */
	public void addCourse(Course course) {
		this.courseSet.add(course);
	}

	/**
	 * Get the set of the course.
	 * 
	 * @return The set of course
	 */
	public Set<Course> getCourseSet() {
		return this.courseSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Teacher other = (Teacher) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
