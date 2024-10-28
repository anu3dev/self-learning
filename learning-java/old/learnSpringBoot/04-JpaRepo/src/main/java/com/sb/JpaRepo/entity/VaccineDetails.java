package com.sb.JpaRepo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="vaccinedetails")
public class VaccineDetails {
	@Id
	private Long id;
	@Column(name="vaccinename")
	private String vaccineName;
	@Column(name="vaccinecompany")
	private String vaccineCompany;
	private Integer price;
}
