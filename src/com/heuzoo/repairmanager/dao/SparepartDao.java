package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.common.Utils;
/***
 *@author Johnson
 *@date 2016年7月25日 上午9:56:26
 *@version 1.0
 ***/
public class SparepartDao {
	
	//获取指定ID的备件的详细信息
	public SparepartInfo getSparepartInfo(int id){
		ResultSet rs = null;
		SparepartInfo sparepart = null;
		Connection con = Utils.getConnection();
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement("select * from sparepart where sparepart_no = ?");
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while(rs.next()){
				sparepart = new SparepartInfo();
				sparepart.setSparepartName(rs.getString("sparepart_name"));
				sparepart.setSparepartNo(rs.getInt("sparepart_no"));
				sparepart.setSparepartPrice(rs.getDouble("sparepart_price"));
				sparepart.setSparepartTotal(rs.getInt("sparepart_total"));
				sparepart.setSparepartType(rs.getString("sparepart_type"));
				sparepart.setSparepartWarn(rs.getInt("sparepart_warn"));
				sparepart.setSparepartState(rs.getInt("sparepart_state"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sparepart;
	}
	
	public boolean addSparepart(SparepartInfo sparepart){
		boolean result = true;
		Connection con = Utils.getConnection();
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement("insert into sparepart (sparepart_name,"
					+ "sparepart_type,sparepart_price,sparepart_total,sparepart_warn,"
					+ "sparepart_state) values(?,?,?,?,?,?)");
			pst.setString(1, sparepart.getSparepartName());
			pst.setString(2, sparepart.getSparepartType());
			pst.setDouble(3, sparepart.getSparepartPrice());
			pst.setInt(4, sparepart.getSparepartTotal());
			pst.setInt(5, sparepart.getSparepartWarn());
			pst.setInt(6, sparepart.getSparepartState());
			
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
	
	public ArrayList<SparepartInfo> queryUser(SparepartInfo u,int start,int size){
		ArrayList<SparepartInfo> result = new ArrayList<SparepartInfo>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = Utils.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select * from sparepart where 1 = '1' ");
						
			sql.append(" limit ?,?");			
			
			pst = con.prepareStatement(sql.toString());
			
			int index = 1;
			
			pst.setInt(index++, start);
			pst.setInt(index++, size);
			
			rs = pst.executeQuery();		
			
			while(rs.next()){
				SparepartInfo sparepart = new SparepartInfo();
				sparepart.setSparepartName(rs.getString("sparepart_name"));
				sparepart.setSparepartNo(rs.getInt("sparepart_no"));
				sparepart.setSparepartPrice(rs.getDouble("sparepart_price"));
				sparepart.setSparepartTotal(rs.getInt("sparepart_total"));
				sparepart.setSparepartType(rs.getString("sparepart_type"));
				sparepart.setSparepartWarn(rs.getInt("sparepart_warn"));
				sparepart.setSparepartState(rs.getInt("sparepart_state"));
				result.add(sparepart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Utils.closeResource(rs, pst, con);
		}
		
		return result;
	}
	
	
	//获取总行数
		public int queryUserTotalRows(SparepartInfo u){
			int result = 0;
			
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
			
			con = Utils.getConnection();
			
			try {
				StringBuilder sql = new StringBuilder();
				sql.append("select count(*) from sparepart where 1 = '1' ");
				
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
		
		
		public boolean deleteSparepart(int no){
			boolean result = false;
			
			Connection con = null;
			PreparedStatement pst = null;
			
			con = Utils.getConnection();
			
			try {
				pst = con.prepareStatement("delete from sparepart where sparepart_no=?");
				pst.setInt(1, no);
				if(pst.executeUpdate() == 1)
					result = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				Utils.closeResource(pst, con);
			}		
			
			return result;
		}
	
		
		//更新表，
		public boolean updateSparepart(SparepartInfo sparepart){
			boolean result = true;
			Connection con = null;
			PreparedStatement pst = null;
			
			con = Utils.getConnection();
			//更改对应备件总量
			try {
				pst = con.prepareStatement("update sparepart set sparepart_total=? where sparepart_no=?");
				pst.setInt(1, sparepart.getSparepartTotal());
				pst.setInt(2, sparepart.getSparepartNo());
				if(pst.executeUpdate() < 1) result = false;
				pst = con.prepareStatement("update sparepart set sparepart_state=? where sparepart_no=?");
				pst.setInt(1, sparepart.getSparepartState());
				pst.setInt(2, sparepart.getSparepartNo());
				if(pst.executeUpdate() < 1) result = false;
				pst = con.prepareStatement("update sparepart set sparepart_warn=? where sparepart_no=?");
				pst.setInt(1, sparepart.getSparepartWarn());
				pst.setInt(2, sparepart.getSparepartNo());
				if(pst.executeUpdate() < 1) result = false;
				pst = con.prepareStatement("update sparepart set sparepart_price=? where sparepart_no=?");
				pst.setDouble(1, sparepart.getSparepartPrice());
				pst.setInt(2, sparepart.getSparepartNo());
				if(pst.executeUpdate() < 1) result = false;
				pst = con.prepareStatement("update sparepart set sparepart_type=? where sparepart_no=?");
				pst.setString(1, sparepart.getSparepartType());
				pst.setInt(2, sparepart.getSparepartNo());
				if(pst.executeUpdate() < 1) result = false;
				pst = con.prepareStatement("update sparepart set sparepart_name=? where sparepart_no=?");
				pst.setString(1, sparepart.getSparepartName());
				pst.setInt(2, sparepart.getSparepartNo());
				if(pst.executeUpdate() < 1) result = false;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				Utils.closeResource(pst, con);
			}
			
			return result;
		}
}
