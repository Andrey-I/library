package org.teonit.library.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="library_user")
@SequenceGenerator(name="person_id", sequenceName="person_id_seq", allocationSize=1)
public class User extends Person {


	private String password;

	private Boolean active;
	
	@OneToMany(mappedBy="roleId.user")
	private Set<UserRole> roles;
	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the active
	 */
	public Boolean getActive() {
		return active;
	}

	/**
	 * @param active
	 *            the active to set
	 */
	public void setActive(Boolean active) {
		this.active = active;
	}
	
	public Set<UserRole> getRoles() {
		return roles;
	}
	
	public void addRole(UserRole role) {
		roles.add(role);
	}
}
