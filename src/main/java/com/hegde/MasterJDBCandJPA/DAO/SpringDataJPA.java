package com.hegde.MasterJDBCandJPA.DAO;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.hegde.MasterJDBCandJPA.model.CourseEntity;

@Repository
public interface SpringDataJPA extends JpaRepositoryImplementation<CourseEntity, Long> {

}
