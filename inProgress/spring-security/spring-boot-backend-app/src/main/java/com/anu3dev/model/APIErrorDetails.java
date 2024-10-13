package com.anu3dev.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIErrorDetails {
	private LocalDateTime time;
	private String msg;
	private String status;
}