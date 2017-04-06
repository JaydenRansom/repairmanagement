package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.heuzoo.repairmanager.bean.CustomerInfo;
import com.heuzoo.repairmanager.common.DBUtil;

public class CustomerInfoDao {

	//≤Â»Î
	public boolean addCustomerInfo(CustomerInfo cus)
	{
		boolean result = true;
		
		Connection con = null;
		
		PreparedStatement st = null;
		
		con=DBUtil.getConnection();
		
		try {
			st=con.prepareStatement("insert into"+" CUSTOMER(CUSTOMER_NAME,CUSTOMER_ID,CUSTOMER_TYPE,CUSTOMER_OFFICE,CUSTOMER_TEL,CUSTOMER_MOBILE,CUSTOMER_ADDRESS,CUSTOMER_MAIL,CUSTOMER_EMAIL)"
			+" values(?,?,?,?,?,?,?,?,?)");
			st.setString(1, cus.getCustomerName());
			st.setString(2, cus.getCustomerId());
			st.setInt(3, cus.getCustomerType());
			st.setString(4, cus.getCustomerOffice());
			st.setString(5, cus.getCustomerTel());
			st.setString(6, cus.getCustomerMobile());
			st.setString(7, cus.getCustomerAddress());
			st.setInt(8, cus.getCustomerMail());
			st.setString(9, cus.getCustomerEmail());
			int i=st.executeUpdate();
			
			if(i<1)
			{
				return false;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=false;
			e.printStackTrace();
		}
		finally
		{
			DBUtil.closeResource(st,con);
		}
		return result;
	}
	//≤È—Ø
	public CustomerInfo queryCus(CustomerInfo u)
	{
		CustomerInfo result = new CustomerInfo();
		Connection con = null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		con=DBUtil.getConnection();
		
		try {
			st=con.prepareStatement("select * from customer where CUSTOMER_ID=?");
			
			st.setString(1, u.getCustomerId());
			rs=st.executeQuery();
			if(rs.next()) {
				CustomerInfo cus = new CustomerInfo();
				cus.setCustomerId(rs.getString("CUSTOMER_ID"));
				cus.setCustomerName(rs.getString("CUSTOMER_NAME"));
				cus.setCustomerType(rs.getInt("CUSTOMER_TYPE"));
				cus.setCustomerOffice(rs.getString("CUSTOMER_OFFICE"));
				cus.setCustomerTel(rs.getString("CUSTOMER_TEL"));
				cus.setCustomerMobile(rs.getString("CUSTOMER_MOBILE"));
				cus.setCustomerAddress(rs.getString("CUSTOMER_ADDRESS"));
				cus.setCustomerMail(rs.getInt("CUSTOMER_MAIL"));
				cus.setCustomerEmail(rs.getString("CUSTOMER_EMAIL"));
				
				result = cus;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtil.closeResource(rs, st, con);
		}
		
		
		
		return result;
	
		
	}
	//…æ≥˝
	public boolean deleteUser(String no)
	{
		
		boolean result = false;
		
		Connection con=null;
		PreparedStatement st=null;
		con=DBUtil.getConnection();
		System.out.println(no);
		try {
			st=con.prepareStatement("delete from customer where CUSTOMER_ID=? ");
			st.setString(1, no);
			System.out.println(no);
			int i=st.executeUpdate();
			System.out.println(i);
			if(i==1)
			{
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			DBUtil.closeResource(st, con);
		}
		return result;
	}
	
/*	public boolean zhenUpdata(CustomerInfo cus)
	{
		boolean result = false;
		
		Connection con=null;
		
		PreparedStatement st=null;
		
		con=DBUtil.getConnection();
		
		
		//System.out.println(no);
		try {
			st=con.prepareStatement("delete from customer where CUSTOMER_ID=? ");
			st.setString(1, cus.getCustomerId());
		//	System.out.println(no);
			int i=st.executeUpdate();
			
			System.out.println(i);
			if(i==1)
			{
				result=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			st=con.prepareStatement("insert into"+" CUSTOMER(CUSTOMER_NAME,CUSTOMER_ID,CUSTOMER_TYPE,CUSTOMER_OFFICE,CUSTOMER_TEL,CUSTOMER_MOBILE,CUSTOMER_ADDRESS,CUSTOMER_MAIL,CUSTOMER_EMAIL)"
			+" values(?,?,?,?,?,?,?,?,?)");
			st.setString(1, cus.getCustomerName());
			st.setString(2, cus.getCustomerId());
			st.setInt(3, cus.getCustomerType());
			st.setString(4, cus.getCustomerOffice());
			st.setString(5, cus.getCustomerTel());
			st.setString(6, cus.getCustomerMobile());
			st.setString(7, cus.getCustomerAddress());
			st.setInt(8, cus.getCustomerMail());
			st.setString(9, cus.getCustomerEmail());
			int i=st.executeUpdate();
			
			if(i<1)
			{
				return false;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=false;
			e.printStackTrace();
		}
		return result;
	}*/
}
