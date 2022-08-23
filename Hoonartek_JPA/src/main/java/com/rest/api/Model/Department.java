package com.rest.api.Model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="department")
public class Department {
	@Id

    @Column

    
    private int d_id;
    @Column

    private String dName;

  
    public int getD_id() {
        return d_id;
    }

    public void setD_id(int d_id) {
        this.d_id = d_id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

  

  @Override
	public String toString() {
		return "Department [d_id=" + d_id + ", dName=" + dName + "]";
	}




	
	
	

}
