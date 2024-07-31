package com.sb.springMVCCRMProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="learn")
@Data
@NoArgsConstructor
public class CustomerModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	private String name;
	private Integer age;
	private String city;
}
