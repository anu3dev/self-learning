package com.anu3dev.service;

import com.anu3dev.model.Email;

public interface IEmailService {
	public String sendContactEmail(Email email) throws Exception;
}
