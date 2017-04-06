package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.heuzoo.repairmanager.bean.PartflowInfo;
import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.common.Utils;

/***
 *@author Johnson
 *@date 2016年7月25日 下午4:17:51
 *@version 1.0
 ***/
public class PartflowDao {
	
	public boolean addPartflow(PartflowInfo partflow){
		boolean result = true;
		Connection con = Utils.getConnection();
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement("insert into partflow (partflow_sparepart,"
					+ "partflow_amount,partflow_type,partflow_time) values(?,?,?,?)");
			pst.setInt(1, partflow.getPartflowSparepart());
			pst.setInt(2, partflow.getPartflowAmount());
			pst.setInt(3, partflow.getPartflowType());
			java.sql.Date d = new java.sql.Date(partflow.getPartflowDate().getTime());
			pst.setDate(4, d);
			
			if(pst.executeUpdate() < 1)
				result = false;
		} catch (SQLException e) {
			result = false;
			e.printStackTrace();
		}finally{
			Utils.closeResource(pst, con);
		}
		return result;		
	}
	
	
	//获取总行数
			public int queryUserTotalRows(PartflowInfo u){
				int result = 0;
				
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				
				con = Utils.getConnection();
				
				try {
					StringBuilder sql = new StringBuilder();
					sql.append("select count(*) from partflow where 1 = '1' ");
					
					pst = con.prepareStatement(sql.toString());
					
					int index = 1;
								
					rs = pst.executeQuery();		
					
					if(rs.next()){
						//因为取得是count(*)，只有一列。故能直接取出来
						result = rs.getInt(1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					Utils.closeResource(rs, pst, con);
				}
				
				
				return result;
			}
			
			public ArrayList<PartflowInfo> queryUser(int type,PartflowInfo u,int start,int size){
				ArrayList<PartflowInfo> result = new ArrayList<PartflowInfo>();
				
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				
				con = Utils.getConnection();
				
				try {
					StringBuilder sql = new StringBuilder();
					if(type == 1)
						sql.append("select * from partflow where partflow_type = '1' ");
					else 
						sql.append("select * from partflow where partflow_type = '2' ");
								
//					sql.append(" limit ?,?");			
					
					pst = con.prepareStatement(sql.toString());
					
//					int index = 1;
//					
//					pst.setInt(index++, start);
//					pst.setInt(index++, size);
					
					rs = pst.executeQuery();		
					
					while(rs.next()){
						PartflowInfo partflow = new PartflowInfo();
						partflow.setPartflowNo(rs.getInt("partflow_no"));
						partflow.setPartflowSparepart(rs.getInt("partflow_sparepart"));
						partflow.setPartflowAmount(rs.getInt("partflow_amount"));
						partflow.setPartflowDate(rs.getDate("partflow_time"));
						partflow.setPartflowType(rs.getInt("partflow_type"));
						result.add(partflow);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					Utils.closeResource(rs, pst, con);
				}
				
				return result;
			}

}
