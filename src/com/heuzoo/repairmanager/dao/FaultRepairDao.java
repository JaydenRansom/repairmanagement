package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.bean.PartflowInfo;
import com.heuzoo.repairmanager.bean.SparepartInfo;
import com.heuzoo.repairmanager.common.Utils;

/***
 *@author Johnson
 *@date 2016年7月27日 下午3:49:08
 *@version 1.0
 ***/
public class FaultRepairDao {

	
	//获取总行数
	public int queryUserTotalRows(FaultRepairInfo u){
		int result = 0;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = Utils.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select count(*) from faultrepair where 1 = '1' ");
			
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
	
	
	public ArrayList<FaultRepairInfo> queryUser(int type,FaultRepairInfo u,int emp_no,int temp){
		ArrayList<FaultRepairInfo> result = new ArrayList<FaultRepairInfo>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = Utils.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from faultrepair where 1 = '1' ");
			
				if(type == FaultRepairInfo.STATE_BLOCK)
					sql.append("and repair_state = '1' ");
				if(type == FaultRepairInfo.STATE_ARRANGED)
					sql.append("and repair_person = '"+emp_no+"'");
			
				if(temp == 1){
					//temp传参为1，说明要查询只是所有还没维修的单子
					sql.append("and repair_state = '2' ");
				}
			pst = con.prepareStatement(sql.toString());
			
			rs = pst.executeQuery();		
			
			while(rs.next()){
				FaultRepairInfo faultrapair = new FaultRepairInfo();
				faultrapair.setRepairWorkload(rs.getString("repair_workload"));
				faultrapair.setRepairState(rs.getInt("repair_state"));
				faultrapair.setRepairReportNo(rs.getInt("repair_report_no"));
				faultrapair.setRepairRepairTime(rs.getDate("repair_repair_time"));
				faultrapair.setRepairRepairRecord(rs.getString("repair_repair_record"));
				faultrapair.setRepairPerson(rs.getInt("repair_person"));
				faultrapair.setRepairNoticePoints(rs.getString("repair_notice_points"));
				faultrapair.setRepairNo(rs.getInt("repair_no"));
				faultrapair.setRepairMaterialCost(rs.getDouble("repair_material_cost"));
				faultrapair.setRepairManualCost(rs.getDouble("repair_manual_cost"));
				faultrapair.setRepairExaminationRecord(rs.getString("repair_examination_record"));
				faultrapair.setRepairDelayDegree(rs.getInt("repair_delay_degree"));
				faultrapair.setRepairCommitment(rs.getString("repair_commitment"));
				faultrapair.setRepairArrangeTime(rs.getDate("repair_arrange_time"));
				result.add(faultrapair);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Utils.closeResource(rs, pst, con);
		}
		
		return result;
	}
	
	
	public ArrayList<FaultRepairInfo> queryUser(FaultRepairInfo u,int no){
		ArrayList<FaultRepairInfo> result = new ArrayList<FaultRepairInfo>();
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		con = Utils.getConnection();
		
		try {
			StringBuilder sql = new StringBuilder();
			
			sql.append("select * from faultrepair where 1 = '1' ");
			
			sql.append("and repair_no = ?");
			pst = con.prepareStatement(sql.toString());
			
			int index = 1;
			
//			pst.setInt(index++, start);
//			pst.setInt(index++, size);
			
			pst.setInt(index++, no);
			
			rs = pst.executeQuery();		
			
			while(rs.next()){
				FaultRepairInfo faultrapair = new FaultRepairInfo();
				faultrapair.setRepairWorkload(rs.getString("repair_workload"));
				faultrapair.setRepairState(rs.getInt("repair_state"));
				faultrapair.setRepairReportNo(rs.getInt("repair_report_no"));
				faultrapair.setRepairRepairTime(rs.getDate("repair_repair_time"));
				faultrapair.setRepairRepairRecord(rs.getString("repair_repair_record"));
				faultrapair.setRepairPerson(rs.getInt("repair_person"));
				faultrapair.setRepairNoticePoints(rs.getString("repair_notice_points"));
				faultrapair.setRepairNo(rs.getInt("repair_no"));
				faultrapair.setRepairMaterialCost(rs.getDouble("repair_material_cost"));
				faultrapair.setRepairManualCost(rs.getDouble("repair_manual_cost"));
				faultrapair.setRepairExaminationRecord(rs.getString("repair_examination_record"));
				faultrapair.setRepairDelayDegree(rs.getInt("repair_delay_degree"));
				faultrapair.setRepairCommitment(rs.getString("repair_commitment"));
				faultrapair.setRepairArrangeTime(rs.getDate("repair_arrange_time"));
				result.add(faultrapair);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			Utils.closeResource(rs, pst, con);
		}
		
		return result;
	}
	
	
	//更新表，
			public boolean updateFaultRepair(FaultRepairInfo faultrepair){
				boolean result = true;
				Connection con = null;
				PreparedStatement pst = null;
				
				con = Utils.getConnection();
				//更改对应备件总量
				try {
					
					if(faultrepair.getRepairPerson() > 0){
					pst = con.prepareStatement("update faultrepair set repair_person=? where repair_no=?");
					pst.setInt(1, faultrepair.getRepairPerson());
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairReportNo() > 0){
					pst = con.prepareStatement("update faultrepair set repair_report_no=? where repair_no=?");
					pst.setInt(1, faultrepair.getRepairReportNo());
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairArrangeTime()!=null){
					pst = con.prepareStatement("update faultrepair set repair_arrange_time=? where repair_no=?");
					java.sql.Date date = new java.sql.Date(faultrepair.getRepairArrangeTime().getTime());
					pst.setDate(1, date);
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairExaminationRecord()!=null){
					pst = con.prepareStatement("update faultrepair set repair_examination_record=? where repair_no=?");
					pst.setString(1, faultrepair.getRepairExaminationRecord());
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairRepairRecord()!=null){
					pst = con.prepareStatement("update faultrepair set repair_repair_record=? where repair_no=?");
					pst.setString(1, faultrepair.getRepairRepairRecord());
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairRepairTime()!=null){
					pst = con.prepareStatement("update faultrepair set repair_repair_time=? where repair_no=?");
					java.sql.Date date = new java.sql.Date(faultrepair.getRepairRepairTime().getTime());
					pst.setDate(1, date);
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairWorkload()!=null){
					pst = con.prepareStatement("update faultrepair set repair_workload=? where repair_no=?");
					pst.setString(1, faultrepair.getRepairWorkload());
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairManualCost() >= 0){
					pst = con.prepareStatement("update faultrepair set repair_manual_cost=? where repair_no=?");
					pst.setDouble(1, faultrepair.getRepairManualCost());
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairMaterialCost() >= 0){
					pst = con.prepareStatement("update faultrepair set repair_material_cost=? where repair_no=?");
					pst.setDouble(1, faultrepair.getRepairMaterialCost());
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairNoticePoints() != null){
					pst = con.prepareStatement("update faultrepair set repair_notice_points=? where repair_no=?");
					pst.setString(1, faultrepair.getRepairNoticePoints());
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairState() >= 0){
					pst = con.prepareStatement("update faultrepair set repair_state=? where repair_no=?");
					pst.setInt(1, faultrepair.getRepairState());
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
					if(faultrepair.getRepairDelayDegree() >= 0){
					pst = con.prepareStatement("update faultrepair set repair_delay_degree=? where repair_no=?");
					pst.setInt(1, faultrepair.getRepairDelayDegree());
					pst.setInt(2, faultrepair.getRepairNo());
					if(pst.executeUpdate() < 1) result = false;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					Utils.closeResource(pst, con);
				}
				
				return result;
			}
			
			
			
			
			
}
