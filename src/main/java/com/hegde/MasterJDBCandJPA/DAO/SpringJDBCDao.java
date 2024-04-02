package com.hegde.MasterJDBCandJPA.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hegde.MasterJDBCandJPA.model.Course;

@Repository
public class SpringJDBCDao {

	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	public void insertCouse(Course course) {
		String sqlQuery = "insert into COURSE(id,name,author) values (?,?,?)";
		int affectedRows = springJdbcTemplate.update(sqlQuery, course.getId(),course.getName(),course.getAuthor());
		System.out.println("Affected rows after insert query is "+affectedRows);
	}

	public void deleteCourse(long id) {
		String sqlQuery = "delete from COURSE where id = ?";
		int affectedRowa = springJdbcTemplate.update(sqlQuery,id);
		System.out.println(affectedRowa+" Deleted!");
		
	}

	public Course getCourse(long id) {
		String sqlQuery = "select * from COURSE where id = ?";
		//We use bean propery row mapper to map the Bean and columns value from pojo and schema.
		return springJdbcTemplate.queryForObject(sqlQuery, new BeanPropertyRowMapper<>(Course.class),id);
	}

	public List<Course> getAllCourse() {
		String sqlQuery = "select * from COURSE";
		//We use bean propery row mapper to map the Bean and columns value from pojo and schema.
		return springJdbcTemplate.query(sqlQuery,new CourseRowMapper());
	}
	
	/*
	 * Old way of doing things Rowmapper
	 */
	
	private class CourseRowMapper implements RowMapper<Course>{

		@Override
		public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
			Course c = new Course();
			c.setId(rs.getLong("id"));
			c.setName(rs.getString("name"));
			c.setAuthor(rs.getString("author"));
			return c;
		}
		
	}
}
