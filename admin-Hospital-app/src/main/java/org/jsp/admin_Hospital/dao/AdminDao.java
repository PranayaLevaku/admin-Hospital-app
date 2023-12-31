package org.jsp.admin_Hospital.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jsp.admin_Hospital.dto.Admin;



public class AdminDao {
	private EntityManager manager=Persistence.createEntityManagerFactory("dev").createEntityManager();
	
  public Admin saveAdmin(Admin admin) {
	EntityTransaction transaction=manager.getTransaction();
	manager.persist(admin);
	transaction.begin();
	transaction.commit();
	  return admin;
  }
  public Admin updateAdmin(Admin admin) {
	  Admin dbadmin=findAdminById(admin.getId());
	  if(dbadmin!=null) {
		  dbadmin.setEmail(admin.getEmail());
		  dbadmin.setName(admin.getName());
		  dbadmin.setPhone(admin.getPhone());
		  dbadmin.setPassword(admin.getPassword());
		  EntityTransaction transaction=manager.getTransaction();
		  transaction.begin();
		  transaction.commit();
		  return dbadmin;
		  
	  }
	  return null;
  }
  public Admin findAdminById(int id) {
	  return manager.find(Admin.class, id);
	  
  }
  public Admin verifyAdmin(long phone,String password) {
	  Query q=manager.createQuery(" select a from Admin where a.phone=?1 and a.password=?2");
	  q.setParameter(1, phone);
	  q.setParameter(2, password);
	  try {
		  return (Admin) q.getSingleResult();
	  }catch(NoResultException e){
		return null;  
	  }

  }
  public Admin verifyAdmin(String email,String password) {
	  Query q=manager.createQuery(" select a from Admin where a.email=?1 and a.password=?2");
	  q.setParameter(1, email);
	  q.setParameter(2, password);
	  try {
		  return (Admin) q.getSingleResult();
	  }catch(NoResultException e){
		return null;  
	  }

	  
  }





}
