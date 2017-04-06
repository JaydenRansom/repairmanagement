package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.common.Utils;

/***
 *@author Johnson
 *@date 2016年7月28日 下午1:49:22
 *@version 1.0
 ***/
public class FaultReportDao {
	public ArrayList<FaultReportInfo> queryUser(FaultReportInfo u,int no){
		ArrayList<FaultReportInfo> result = new ArrayList<FaultReportInfo>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = Utils.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from faultreport where 1 = '1' ");
			
			sql.append("and report_no = ?");
			pst = con.prepareStatement(sql.toString());
			
			int index = 1;
			
			pst.setInt(index++, no);
			rs = pst.executeQuery();
			
			while(rs.next()){
				FaultReportInfo faultreport = new FaultReportInfo();
				faultreport.setReportCustomerId(rs.getString("report_customer_id"));
				faultreport.setReportDevice(rs.getInt("report_device"));
				faultreport.setReportFinish(rs.getDate("report_finish"));
				faultreport.setReportNo(rs.getInt("report_no"));
				faultreport.setReportPrice(rs.getDouble("report_price"));
				faultreport.setReportState(rs.getInt("report_state"));
				faultreport.setReportTime(rs.getDate("report_time"));
				result.add(faultreport);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Utils.closeResource(rs, pst, con);
		}
		
		return result;
	}
	
	public boolean updateFaultReport(FaultReportInfo faultreport){
		boolean result = true;
		Connection con = null;
		PreparedStatement pst = null;
		
		con = Utils.getConnection();
		//更改对应备件总量
		try {
			pst = con.prepareStatement("update faultreport set report_state=? where report_no=?");
			pst.setInt(1, faultreport.getReportState());
			pst.setInt(2, faultreport.getReportNo());
			if(pst.executeUpdate() < 1) result = false;			
			
			pst = con.prepareStatement("update faultreport set report_finish=? where report_no=?");
			java.sql.Date d = new java.sql.Date(faultreport.getReportFinish().getTime());
			pst.setDate(1, d);
			pst.setInt(2, faultreport.getReportNo());
			if(pst.executeUpdate() < 1) result = false;	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Utils.closeResource(pst, con);
		}
		
		return result;
	}
	
}
