package com.telusko.SpringDataJpaLOB.entity;



import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class MarriageSeeker implements Serializable 
{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
     private Long id;
	 
	
	 private String name;
	 
	 private String city;
	 
	 @Lob
	 @Column(length = 1000)
	 private byte[] photo;
	 
	 @Lob
	 private char[] bioData;
	 
	 public MarriageSeeker(String name, String city, byte[]photo, char[]bioData)
	 {
		 this.name=name;
		 this.city=city;
		 this.photo=photo;
		 this.bioData=bioData;
	 }
}
