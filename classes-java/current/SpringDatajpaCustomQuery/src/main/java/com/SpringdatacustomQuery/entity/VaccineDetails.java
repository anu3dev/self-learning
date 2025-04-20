package com.SpringdatacustomQuery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name="vaccinedetails")
public class VaccineDetails 
{
	 @Id
     private Long id;
     
	 @Column(name="vaccinename")
     private String vaccineName;
	 
	 @Column(name="vaccinecompany")
     private String vaccineCompany;
	 
     private Integer price;
}
