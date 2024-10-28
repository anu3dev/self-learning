package com.sb.dataJDBCH2.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbc {
	private static final String INSERT_QUERY = "insert into course(id, name) values(?, ?)";
	private static final String DELETE_QUERY = "delete from course where id = ?";
	private static final String SELECT_QUERY = "select * from course where id = ?";
	
	@Autowired
	private JdbcTemplate repo;
	
	public void insertById(CourseModel course) {
		repo.update(INSERT_QUERY, course.getId(), course.getName());
	}
	
	public void deleteById(Integer id) {
		repo.update(DELETE_QUERY, id);
	}
	
	public CourseModel selectById(Integer id) {
		return repo.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(CourseModel.class), id);
	}
}
