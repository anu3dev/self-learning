package com.sb.SpringBootApp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="learn")
public class Employee {
	@Id
	private Integer id;
	private String name;
	private Integer age;
	@Column(name="city")
	private String place;
}