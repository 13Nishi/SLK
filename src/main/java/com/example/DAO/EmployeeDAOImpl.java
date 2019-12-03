package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dbutil.DBUtil;
import com.example.model.Employee;


@Repository
public class EmployeeDAOImpl  implements EmployeeDAO{
Connection connection=null;
	
	


	
	
		private static List<Employee> admins;
		
		
		 {
			connection = DBUtil.getConnection();
			System.out.println(connection);
			String query = "Select * from employee where emp_role = 'admin' ";
			//Employee emp;
			admins = new ArrayList<>();
			PreparedStatement st;
			try {
				
				st = connection.prepareStatement(query);
				
				ResultSet rs = st.executeQuery();
				
				while(rs.next()) {
					Employee emp = new Employee();
					int empId = rs.getInt(1);
					String empName = rs.getString(2);
					String empDob = rs.getString(3);
					String empContact = rs.getString(4);
					String uname = rs.getString(5);
					String pwd = rs.getString(6);
					String erole = rs.getString(7);
					System.out.println(empId + " " + empName + " " + empDob + " " + empContact);
					emp.setEmpid(empId);
					emp.setName(empName);
					emp.setDob(empDob);
					emp.setPhno(empContact);
					emp.setUsername(uname);
					emp.setPassword(pwd);
					emp.setEmprole(erole);
					//admins.add(new Employee(empId,empName,empDob,empContact));
					admins.add(emp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}


		@Override
		public List<Employee> getAllEmployee() {
			// TODO Auto-generated method stub
			return admins;
		}
		
		@Override
		public Long deleteAdmin(Long empId) {
			// TODO Auto-generated method stub
			try{
				
				String sql="DELETE FROM Employee WHERE empId = ? ";			
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setLong(1, empId);
				
				int res  = pst.executeUpdate();
				
				if(res > 0)
				{
					System.out.println("Admin Deleted");
				}
				
				return empId;
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return null;
		}

		@Override
		public Employee get(Long id) {
			// TODO Auto-generated method stub
			Employee cust=new Employee();
			try {
				String sql="select*from customer where id=?";
				PreparedStatement st=connection.prepareStatement(sql);
				st.setEmpid(1, id);
				ResultSet result=st.executeQuery();
				while(result.next()) {
					
					
					cust.setEmpid(result.getInt(1));
					cust.setName(result.getString(2));
					cust.setAddress(result.getString(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			}
			return cust;
		}

		
	

}
