package com.goodee.ex11.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
	private Integer departmentId;
	private String departmentName;
	private Integer managerId;
	private Integer locationId;
}
