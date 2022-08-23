package com.rest.api.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name="employee")
public class Employee {
	  @Id
	  
	    @Column
	    private int id;
	   

	    @Column
	    
	     private String name;
	  
	    @Column
	   
	    private int age;
	   
	    @Column
	   
	    private String joiningdate;
	    @Column
	   
	    private String email;

	    @ManyToOne
	    @JoinColumn(name = "d_id")
	    private Department department;
        
	   

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getJoiningdate() {
			return joiningdate;
		}

		public void setJoiningdate(String joiningdate) {
			this.joiningdate = joiningdate;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Department getDepartment() {
	        return department;
	    }

	    public void setDepartment(Department department) {
	        this.department = department;
	    }

		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", joiningdate=" + joiningdate
					+ ", email=" + email + ", department=" + department + "]";
		}

	

		

		

	   

	}

