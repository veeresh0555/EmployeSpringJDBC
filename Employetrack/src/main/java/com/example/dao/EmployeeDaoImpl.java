package com.example.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO {

	
	@Autowired
	SessionFactory sessionFoctory;
	
	
	
	
	
	@Override
	public List<Employee> getempAll() {
		
		Session session=sessionFoctory.getCurrentSession();//creeate session
		
		CriteriaBuilder cbuilder=session.getCriteriaBuilder();//create critera builder
		
		CriteriaQuery<Employee> cquery=cbuilder.createQuery(Employee.class);//create criteria query
		
		Root<Employee> root=cquery.from(Employee.class); //create root from object
		cquery.select(root);  //select that root 
		
		Query<Employee> query=session.createQuery(cquery);//query in session
		
		return query.getResultList();//get result
	}





	@Override
	public long empsave(Employee emp) {
		sessionFoctory.getCurrentSession().save(emp);
		return emp.getId();
	}

	
	
	
	
	
	
}
