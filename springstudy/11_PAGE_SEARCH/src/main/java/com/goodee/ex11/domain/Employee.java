package com.goodee.ex11.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	private Integer employeeId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate; 
	private String jobId;
	private Integer salary;
	private Double commissionPct;
	private Integer managerId;
	private Integer departmentId;
	private String departmentName;

}
