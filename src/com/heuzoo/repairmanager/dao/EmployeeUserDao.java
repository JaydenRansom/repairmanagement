package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.heuzoo.repairmanager.bean.EmployeeInfo;
import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.common.Utils;


/***
 *@author Johnson
 *@date 2016年7月29日 上午10:17:51
 *@version 1.0
 ***/
public class EmployeeUserDao {
	
	public EmployeeInfo login(EmployeeInfo u){
		EmployeeInfo employee = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = Utils.getConnection();
		
		try {
			pst = con.prepareStatement("select count(*) as c from employee where employee_username=? and employee_password=?");
			pst.setString(1,u.getEmployeeUsername());
			pst.setString(2,u.getEmployeePassword());
			rs = pst.executeQuery();
			
			if(rs.next()){
				int i = rs.getInt("c");
				if(i==1){
					employee = new EmployeeInfo();
					pst = con.prepareStatement("select * from employee where employee_username=?");
					pst.setString(1,u.getEmployeeUsername());
					rs = pst.executeQuery();
					rs.next();
					employee.setEmployeeName(rs.getString("employee_name"));
					employee.setEmployeeNo(rs.getInt("employee_no"));
					employee.setEmployeeType(rs.getInt("employee_type"));
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return employee;
	}
	
	public ArrayList<EmployeeInfo> queryUser(EmployeeInfo u,int no){
		ArrayList<EmployeeInfo> result = new ArrayList<EmployeeInfo>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = Utils.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from employee where 1 = '1' ");
			
			sql.append("and employee_no = ?");
			pst = con.prepareStatement(sql.toString());
			
			int index = 1;
			
			pst.setInt(index++, no);
			rs = pst.executeQuery();
			
			if(rs.next()){
				EmployeeInfo employee = new EmployeeInfo();
				employee.setEmployeeName(rs.getString("employee_name"));
				employee.setEmployeeType(rs.getInt("employee_type"));
				employee.setEmployeeNo(rs.getInt("employee_no"));
				result.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Utils.closeResource(rs, pst, con);
		}
		
		return result;
	}
	
	
	public ArrayList<EmployeeInfo> getEngineer(){
		ArrayList<EmployeeInfo> result = new ArrayList<EmployeeInfo>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = Utils.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from employee where employee_type = ? ");
			
			pst = con.prepareStatement(sql.toString());
			
			int index = 1;
			pst.setInt(1, 3);
			rs = pst.executeQuery();
			
			while(rs.next()){
				EmployeeInfo employee = new EmployeeInfo();
				employee.setEmployeeName(rs.getString("employee_name"));
				employee.setEmployeeType(rs.getInt("employee_type"));
				employee.setEmployeeNo(rs.getInt("employee_no"));
				result.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Utils.closeResource(rs, pst, con);
		}
		
		return result;
	}
	
}
