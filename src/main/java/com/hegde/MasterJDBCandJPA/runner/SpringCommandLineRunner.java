package com.hegde.MasterJDBCandJPA.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.hegde.MasterJDBCandJPA.DAO.SpringDataJPA;
import com.hegde.MasterJDBCandJPA.DAO.SpringJPADao;
import com.hegde.MasterJDBCandJPA.model.CourseEntity;

@Component
public class SpringCommandLineRunner implements CommandLineRunner {

	//@Autowired
	//private SpringJDBCDao springJPADao;
	
	@Autowired
	private SpringJPADao springJpaDao;
	
	@Autowired
	private SpringDataJPA springDataJPA;
	//This method will be called when application context is loaded.
	@Override
	public void run(String... args) throws Exception {
		springJpaDao.insertCouse(new CourseEntity(1,"Learn AWS","Hegde"));
		springJpaDao.insertCouse(new CourseEntity(2,"Learn DSA","Hegde"));
		springJpaDao.insertCouse(new CourseEntity(3,"Learn Data science","GB"));
		
		springJpaDao.deleteCourse(1);
		
		System.out.println(springJpaDao.findById(2));
		//System.out.println(springJpaDao.findAll());
		springDataJPA.save(new CourseEntity(4,"Learn Algo","Hegde"));
		System.out.println(springDataJPA.findAll());
		springDataJPA.deleteById(2L);
		System.out.println(springDataJPA.findAll());
	}

}
