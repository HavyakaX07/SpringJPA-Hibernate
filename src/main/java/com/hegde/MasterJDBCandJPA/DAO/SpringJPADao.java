package com.hegde.MasterJDBCandJPA.DAO;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hegde.MasterJDBCandJPA.model.CourseEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SpringJPADao {

	@PersistenceContext
	private EntityManager entityManager;
	
	public void insertCouse(CourseEntity course) {
	     entityManager.merge(course);
	}

	public void deleteCourse(long courseId) {
		CourseEntity course = entityManager.find(CourseEntity.class, courseId);
		entityManager.remove(course);
		
	}

	public CourseEntity findById(long id) {
		return entityManager.find(CourseEntity.class, id);
	}
	
	 public List<CourseEntity> findAll() {
	        TypedQuery<CourseEntity> query = entityManager.createQuery("SELECT c FROM CourseEntity c", CourseEntity.class);
	        return query.getResultList();
	    }
}
