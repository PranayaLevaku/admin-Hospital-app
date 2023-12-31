package org.jsp.admin_Hospital.Controller;

import java.util.Scanner;


import org.jsp.admin_Hospital.dao.AdminDao;
import org.jsp.admin_Hospital.dao.HospitalDao;
import org.jsp.admin_Hospital.dto.Admin;
import org.jsp.admin_Hospital.dto.Hospital;
import java.util.List;




public class AdminHospitalapp {
	 private static Scanner s=new Scanner(System.in);
	 
	private static AdminDao adminDao=new AdminDao();

	private static HospitalDao hospitalDao= new HospitalDao();
	public static void main(String[] args) {
System.out.println("1.save Admin");
System.out.println("2.Update Admin");
System.out.println("3.Find Admin By Id");
System.out.println("4.Verify Admin By Phone");
System.out.println("5.Verify Admin By Email and Password");
System.out.println("6.Save Hospital");
System.out.println("7.update Hospital");
System.out.println("8.Find Hospital By Admin Id");
System.out.println("9.Find Hospitals By Admin phone and Password");
System.out.println("10.Find Hospitals By  Admin Email and password");
System.out.println("==============================");
System.out.println("Enter your choice");
  switch(s.nextInt()) 
  {
      case 1:{
    	  System.out.println("Register Admin details");
    	      saveAdmin();
    	      break;
	  
            }
      case 2:{
    	  System.out.println("Update Admin Details");
    	   updateAdmin();
    	   break;
      }
      case 3:{
    	   System.out.println("Find Admin By Id");
    	   findAdminById();
    	   break;
      }
      case 4:{
    	  System.out.println("Verify Admin By phone and password");
    	    verifyByPhone();
    	    break;
      }
     case 5:{
    	 System.out.println("verify Admin buy eamil and password");
    	     verifyByEmail();
    	      break;    	 
    	    }
      
      case 6:{
    	  System.out.println("Save the Hospital details");
    	  saveHospital();
    	  break;
      }
      case 7:{
    	  System.out.println("Update the hospital details");
    	  updateHospital();
    	  break;
      }
      case 8:{
    	   System.out.println("Find Hospital By Admin id");
    	   findHospitalsByAdminId();
    	   break;
      }
      case 9:{
    	    System.out.println("Find Hospitals by phone and password");
    	    findHospitalsByAdminPhone$Pasword();
    	    break;
      }
      case 10:{
    	   System.out.println("Find Hospitals by Email and Password");
    	   findHospitalsByAdminEmail$Pasword();
    	   break;
    	   
      }
    }
  
  }
	public static void saveAdmin() {
		System.out.println("Enter Email ,name,Phone,password to register the admin");
		Admin a=new Admin();
		a.setEmail(s.next());
		a.setName(s.next());
		a.setPhone(s.nextLong());
		a.setPassword(s.next());
		a=adminDao.saveAdmin(a);
		System.out.println("Admin saved with id :"+a.getId());
	}
	public static void updateAdmin() {
		System.out.println("Enter the Admin id to update");
		int id=s.nextInt();
		System.out.println("Enter the email,name,phone and password to update");
		Admin a=new Admin();
		a.setId(id);
		a.setEmail(s.next());
		a.setName(s.next());
		a.setPhone(s.nextLong());
		a.setPassword(s.next());
		a=adminDao.updateAdmin(a);
		if(a!=null) {
			System.out.println("Admin with id"+a.getId()+" updated id");
		}
		else {
			System.err.println("Cannot updated admin with invalid id");
		}
	
	}
	public  static void findAdminById() {
		System.out.println("Enter the Admin id to display details");
		int id=s.nextInt();
		Admin a=adminDao.findAdminById(id);
		if(a!=null) {
			System.out.println("Admin Id:"+a.getId());
			System.out.println("Name :"+a.getName());
			System.out.println("Email:"+a.getEmail());
			System.out.println("Password :"+a.getPassword());
			
		}
		else {
			System.out.println("you have entered invalid id");
		}
	}
	public static void verifyByPhone() {
		System.out.println("Enter the Phone Number and password to verify Admin");
		long phone = s.nextLong();
		String password = s.next();
		Admin a = adminDao.verifyAdmin(phone, password);
		if (a != null) {
			System.out.println("Verification Succesfull");
			System.out.println("Admin Id:" + a.getId());
			System.out.println("Name:" + a.getName());
			System.out.println("Phone Number:" + a.getPhone());
			System.out.println("Email Id:" + a.getEmail());
		} else
			System.err.println("Invalid Phone Number or Password");
	}

	public static void verifyByEmail() {
		System.out.println("Enter the Email Id and password to verify Admin");
		String email = s.next();
		String password = s.next();
		Admin a = adminDao.verifyAdmin(email, password);
		if (a != null) {
			System.out.println("Verification Succesfull");
			System.out.println("Admin Id:" + a.getId());
			System.out.println("Name:" + a.getName());
			System.out.println("Phone Number:" + a.getPhone());
			System.out.println("Email Id:" + a.getEmail());
		} else
			System.err.println("Invalid Email Id or Password");
	}
	

		
	
	public static  void saveHospital() {
		System.out.println("Enter admin_id to save the hospital");
		int admin_id=s.nextInt();
		System.out.println("Enter the name,founder, year od establishment ,gst_numberof the hospital ");
		Hospital h=new Hospital();
		h.setName(s.next());
		h.setFounder(s.next());
		h.setYear_of_estb(s.nextInt());
		h.setGst_number(s.next());
	
		h=hospitalDao.saveHospital(h, admin_id);
		if(h!=null) {
			System.out.println("hosipital added with id :"+h.getId());
		}
		else {
			System.out.println("hospital cannot be added with the id:"+admin_id);
		}
	}

		

		
		
	public static void updateHospital() {
		System.out.println("Enter hospital id to update the hospital details");
	
		System.out.println("Enter the hospital name,founder,year_od_estb,gst_number to update the hospital");
		Hospital h=new Hospital();
		h.setId(s.nextInt());
		h.setName(s.next());
		h.setFounder(s.next());
		h.setYear_of_estb(s.nextInt());
		h.setGst_number(s.next());
		h=hospitalDao.updateHospital(h);
		if(h!=null) {
			System.out.println("Hospital is updated with the hospital id ");
		}
		else {
			System.err.println("cannot update the hospital with invalid id");
		}
	}
		public static void findHospitalsByAdminId() {
			System.out.println("Enter the Admin Id to display hospital details");
			int admin_id = s.nextInt();
			List<Hospital> hospitals = hospitalDao.findHospitalByAdminId(admin_id);
			if (hospitals.size() > 0) {
				for (Hospital h : hospitals) {
					System.out.println("Hospital Id:" + h.getId());
					System.out.println("Hospital name:" + h.getName());
					System.out.println("Hospital Founder:" + h.getFounder());
					System.out.println("GST Number:" + h.getGst_number());
					System.out.println("Year of Establishment:" + h.getYear_of_estb());
					System.out.println("---------------------------------");
				}
			} else {
				System.err.println("Invalid Admin Id");
			}
		}

		public static void findHospitalsByAdminPhone$Pasword() {
			System.out.println("Enter the Admin phone and password to display hospital details");
			long phone = s.nextLong();
			String password = s.next();
			List<Hospital> hospitals = hospitalDao.findHospitals(phone, password);
			if (hospitals.size() > 0) {
				for (Hospital h : hospitals) {
					System.out.println("Hospital Id:" + h.getId());
					System.out.println("Hospital name:" + h.getName());
					System.out.println("Hospital Founder:" + h.getFounder());
					System.out.println("GST Number:" + h.getGst_number());
					System.out.println("Year of Establishment:" + h.getYear_of_estb());
					System.out.println("---------------------------------");
				}
			} else {
				System.err.println("Invalid Phone Number or Password");
			}
		}

		public static void findHospitalsByAdminEmail$Pasword() {
			System.out.println("Enter the Admin email and password to display hospital details");
			String email = s.next();
			String password = s.next();
			List<Hospital> hospitals = hospitalDao.findHospitals(email, password);
			if (hospitals.size() > 0) {
				for (Hospital h : hospitals) {
					System.out.println("Hospital Id:" + h.getId());
					System.out.println("Hospital name:" + h.getName());
					System.out.println("Hospital Founder:" + h.getFounder());
					System.out.println("GST Number:" + h.getGst_number());
					System.out.println("Year of Establishment:" + h.getYear_of_estb());
					System.out.println("---------------------------------");
				}
			} else {
				System.err.println("Invalid Email Id or Password");
			}
		}
		
		
		
	}
	
    
	

	


