package com.telusko.SpringDataJpaLOB.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.SpringDataJpaLOB.entity.MarriageRepo;
import com.telusko.SpringDataJpaLOB.entity.MarriageSeeker;

@Service
public class MarriageSeekeriImp implements IMarriageSeeker
{
	@Autowired
	private MarriageRepo repo;

	@Override
	public String registerMarriageSeeker(MarriageSeeker seeker)
	{
//		 MarriageSeeker s = repo.save(null);
//		 return "Data inserted successfully!" + s.getId();
		return "Data u=inserted Successfully for id ==> "+ repo.save(seeker).getId();
	}

	@Override
	public Optional<MarriageSeeker> searchById(Long id) {
		return repo.findById(id);
		
	}

}
