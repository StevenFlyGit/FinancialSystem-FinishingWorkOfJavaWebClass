package com.zh.ssm.bean;

import java.io.Serializable;

/**
 * Model class of users_course.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class UsersCourse implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** users. */
	private Users userUsers;

	/** course. */
	private Course course;

	/**
	 * Constructor.
	 */
	public UsersCourse() {
	}

	/**
	 * Set the users.
	 * 
	 * @param userUsers
	 *            users
	 */
	public void setUserUsers(Users userUsers) {
		this.userUsers = userUsers;
	}

	/**
	 * Get the users.
	 * 
	 * @return users
	 */
	public Users getUserUsers() {
		return this.userUsers;
	}

	/**
	 * Set the course.
	 * 
	 * @param course
	 *            course
	 */
	public void setCourse(Course course) {
		this.course = course;
	}

	/**
	 * Get the course.
	 * 
	 * @return course
	 */
	public Course getCourse() {
		return this.course;
	}


}
