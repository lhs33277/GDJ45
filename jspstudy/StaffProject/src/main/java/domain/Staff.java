package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Staff {
	private String sNo;
	private String name;
	private String dept;
	private int salary;

}
