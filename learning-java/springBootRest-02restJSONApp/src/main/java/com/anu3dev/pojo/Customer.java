package com.anu3dev.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private Integer no;
	private String name;
	private Float billAmount;
	private String[] teamNames;
	private List<String> studies;
	private Company company;
}
