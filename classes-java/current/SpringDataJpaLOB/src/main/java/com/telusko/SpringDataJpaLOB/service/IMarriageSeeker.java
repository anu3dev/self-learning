package com.telusko.SpringDataJpaLOB.service;

import java.util.Optional;

import com.telusko.SpringDataJpaLOB.entity.MarriageSeeker;

public interface IMarriageSeeker 
{

	
	public String registerMarriageSeeker(MarriageSeeker seeker);
	public Optional<MarriageSeeker> searchById(Long id);
}
