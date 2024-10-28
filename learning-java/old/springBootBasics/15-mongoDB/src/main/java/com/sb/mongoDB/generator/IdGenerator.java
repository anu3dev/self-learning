package com.sb.mongoDB.generator;

import java.util.UUID;

public class IdGenerator {
	public static String generateId() {
		System.out.println("generateId() is invocked");
		return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
	}
}
