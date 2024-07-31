package com.sb.springRestJSONApp.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	private String name;
	private String type;
	private String address;
	private Integer size;
}
