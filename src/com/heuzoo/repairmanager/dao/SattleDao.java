package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.heuzoo.repairmanager.bean.CustomerInfo;
import com.heuzoo.repairmanager.bean.DeviceInfo;
import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.bean.ParterFlowInfo;
import com.heuzoo.repairmanager.bean.ParterSattleInfo;
import com.heuzoo.repairmanager.bean.SattleInfo;
import com.heuzoo.repairmanager.common.ChangeUtils;
import com.heuzoo.repairmanager.common.DBUtils;

public class SattleDao {
	//Select the finished information in the repair table.
	public ArrayList<FaultRepairInfo> repairFinishQuery() {
		ArrayList<FaultRepairInfo> result = new ArrayList<FaultRepairInfo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		String sql = "select repair_no,repair_person,repair_manual_cost,repair_material_cost,repair_state from faultrepair where repair_state=?";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 3);
			rs = stmt.executeQuery();
			while(rs.next()) {
				FaultRepairInfo repairInfo = new FaultRepairInfo();
				repairInfo.setRepairNo(rs.getInt("repair_no"));
				repairInfo.setRepairPerson(rs.getInt("repair_person"));
				repairInfo.setChangedRepairPerson(SattleDao.getEngineerNameById(rs.getInt("repair_person")));
				repairInfo.setRepairManualCost(rs.getDouble("repair_manual_cost"));
				repairInfo.setRepairMaterialCost(rs.getDouble("repair_material_cost"));
				repairInfo.setRepairState(rs.getInt("repair_state"));
				result.add(repairInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, conn);
		}
		
		return result;
	}
	//按照工程师的编号查询工程师的姓名信息
	public static String getEngineerNameById(int id) {
		String result = null;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select employee_name from employee where employee_no = ?;";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				result = rs.getString("employee_name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//Select the not finished information in the repair table.
	//Having tested done(only two params).
	public ArrayList<FaultRepairInfo> repairNoFinishQuery() {
		ArrayList<FaultRepairInfo> result = new ArrayList<FaultRepairInfo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		//Only test sql.
		String sql = "select repair_no,repair_person,repair_manual_cost,repair_material_cost,repair_state from faultrepair";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
//			stmt.setInt(1, 3);
			rs = stmt.executeQuery();
			while(rs.next()) {
				FaultRepairInfo repairInfo = new FaultRepairInfo();
				repairInfo.setRepairNo(rs.getInt("repair_no"));
				repairInfo.setRepairPerson(rs.getInt("repair_person"));
				repairInfo.setChangedRepairPerson(SattleDao.getEngineerNameById(rs.getInt("repair_person")));
				repairInfo.setRepairManualCost(rs.getDouble("repair_manual_cost"));
				repairInfo.setRepairMaterialCost(rs.getDouble("repair_material_cost"));
				repairInfo.setRepairState(rs.getInt("repair_state"));
				result.add(repairInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, conn);
		}
		
		return result;
	}
	//查询一个报修表中的手工费和
	public ArrayList<ParterFlowInfo> parterPriceQuery(int repairNo) {
		ArrayList<ParterFlowInfo> result = new ArrayList<ParterFlowInfo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select repair_partflow_sparepart,repair_partflow_count from repair_partflow where repair_partflow_repair=?";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, repairNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ParterFlowInfo parterFlowInfo = new ParterFlowInfo();
				parterFlowInfo.setRepairPartFlowSparepart(rs.getInt("repair_partflow_sparepart"));
				parterFlowInfo.setRepairPartFlowCount(rs.getInt("repair_partflow_count"));
				result.add(parterFlowInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, conn);
		}
		
		return result;
	}
	//按维修表编号查询信息,获得的信息要存入结算表中，给财务人员看
	public static FaultRepairInfo getInfoByRepairNo(int repairNo) {
		FaultRepairInfo result = new FaultRepairInfo();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select repair_no,repair_person,repair_manual_cost,repair_material_cost,repair_arrange_time,repair_repair_time from faultrepair where repair_no=?";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, repairNo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				result.setRepairNo(rs.getInt("repair_no"));
				result.setRepairPerson(rs.getInt("repair_person"));
				result.setRepairManualCost(rs.getDouble("repair_manual_cost"));
				result.setRepairMaterialCost(rs.getDouble("repair_material_cost"));
				result.setRepairArrangeTime(rs.getDate("repair_arrange_time"));
				result.setRepairRepairTime(rs.getDate("repair_repair_time"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, conn);
		}
		
		return result;
	}
	//从零件表中获取单价
	public static double getPrice(int parterNo) {
		double result = 0.0;
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select sparepart_price from sparepart where sparepart_no=?";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, parterNo);
			rs = stmt.executeQuery();
			if (rs.next()) {
				result = rs.getDouble("sparepart_price");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(rs, stmt, conn);
		}
		return result;
	}
	//获得所有的价格集合，用于展示
	public static ArrayList<Double> getAllPrice(ArrayList<ParterFlowInfo> parterInfo) {
		ArrayList<Double> result = new ArrayList<Double>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select sparepart_price from sparepart where sparepart_no = ?";
		conn = DBUtils.getConnection();
		for(ParterFlowInfo x : parterInfo) {
			int number = x.getRepairPartFlowSparepart();
			try {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, number);
				rs = stmt.executeQuery();
				if(rs.next()) {
					Double price = rs.getDouble("sparepart_price");
					result.add(price);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		return result;
	}
	//向结算表中插入信息
	public static boolean insertSattle(SattleInfo sattleInfo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement stmt = null;
		String sql = "insert into sattle(sattle_no,sattle_repair_no,sattle_manual_charge,sattle_mater_charge,sattle_parter_charge,sattle_all_charge) values(?,?,?,?,?,?)";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 0);
			stmt.setInt(2, sattleInfo.getRepairNo());
			stmt.setDouble(3, sattleInfo.getManualCharge());
			stmt.setDouble(4, sattleInfo.getMaterCharge());
			stmt.setDouble(5, sattleInfo.getParterCharge());
			stmt.setDouble(6, sattleInfo.getAllCharge());
			int innerLine = stmt.executeUpdate();
			if(innerLine != 0)
				result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.closeAll(stmt, conn);
		}
		return result;
	}
	//从维修表中获取所有信息
	public static ArrayList<SattleInfo> getSattleInfo() {
		ArrayList<SattleInfo> result = new ArrayList<SattleInfo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select sattle_repair_no,sattle_manual_charge,sattle_mater_charge,sattle_parter_charge,sattle_all_charge from sattle";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				SattleInfo temp = new SattleInfo();
				temp.setRepairNo(rs.getInt("sattle_repair_no"));
				temp.setManualCharge(rs.getDouble("sattle_manual_charge"));
				temp.setMaterCharge(rs.getDouble("sattle_mater_charge"));
				temp.setParterCharge(rs.getDouble("sattle_parter_charge"));
				temp.setAllCharge(rs.getDouble("sattle_all_charge"));
				System.out.println(temp.getRepairNo());
				System.out.println(temp.getManualCharge());
				System.out.println(temp.getMaterCharge());
				System.out.println(temp.getParterCharge());
				System.out.println(temp.getAllCharge());
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//根据维修表查询到的信息继续查询设备表
	public static ArrayList<SattleInfo> getFinalSattleInfo(ArrayList<SattleInfo> inParam) {
		ArrayList<SattleInfo> result = new ArrayList<SattleInfo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select device_type,device_brand,device_model from device where device_no = (select report_device from faultreport where report_no = (select repair_report_no from faultrepair where repair_no = ?));";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			for(SattleInfo x : inParam) {
				SattleInfo temp = new SattleInfo();
				stmt.setInt(1, x.getRepairNo());
				temp.setRepairNo(x.getRepairNo());
				temp.setManualCharge(x.getManualCharge());
				temp.setMaterCharge(x.getMaterCharge());
				temp.setParterCharge(x.getParterCharge());
				temp.setAllCharge(x.getAllCharge());
				
				rs = stmt.executeQuery();
				if (rs.next()) {
					temp.setProductType(ChangeUtils.deviceToString(rs.getInt("device_type")));
					temp.setProductBrand(rs.getString("device_brand"));
					temp.setProductModel(rs.getString("device_model"));
				}
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	//查询报修人信息
	public static CustomerInfo getCustomerInfo(int repairNo) { 
		CustomerInfo customer = new CustomerInfo();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select customer_name,customer_id,customer_office from customer where customer_id=(select report_customer_id from faultreport where report_no= (select report_no from faultrepair where repair_no=?));";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, repairNo);
			rs = stmt.executeQuery();
			if(rs.next()) {
				customer.setCustomerId(rs.getString("customer_id"));
				customer.setCustomerName(rs.getString("customer_name"));
				customer.setCustomerOffice(rs.getString("customer_office"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}
	//查询报修设备信息
	public static DeviceInfo getDeviceInfo(int repairNo) {
		DeviceInfo device = new DeviceInfo();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select device_type,device_brand,device_model,device_series,device_fault_appearance from device where device_no = (select report_device from faultreport where report_no = (select repair_report_no from faultrepair where repair_no=?));";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, repairNo);
			rs = stmt.executeQuery();
			if(rs.next()) {
				device.setDeviceType(rs.getInt("device_type"));
				device.setDeviceBrand(rs.getString("device_brand"));
				device.setDeviceModel(rs.getString("device_model"));
				device.setDeviceSeries(rs.getString("device_series"));
				device.setDeviceFaultAppearance(rs.getString("device_fault_appearance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return device;
	}
	//这个是我要返回第一次集合（只有配件id和配件数量的方法）
	public static ArrayList<ParterSattleInfo> getFirstCollection(int repairNo) {
		ArrayList<ParterSattleInfo> result = new ArrayList<ParterSattleInfo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select repair_partflow_sparepart,repair_partflow_count from repair_partflow where repair_partflow_repair = ?;";
		conn = DBUtils.getConnection();
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, repairNo);
			rs = stmt.executeQuery();
			while(rs.next()) {
				ParterSattleInfo temp = new ParterSattleInfo();
				temp.setParterId(rs.getInt("repair_partflow_sparepart"));
				temp.setParterCount(rs.getInt("repair_partflow_count"));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return result;
	}
	//根据第一次返回的集合去 继续查询，获得第二个集合
	public static ArrayList<ParterSattleInfo> getSecondCollection(ArrayList<ParterSattleInfo> inParam) {
		ArrayList<ParterSattleInfo> result = new ArrayList<ParterSattleInfo>();
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		conn = DBUtils.getConnection();
		String sql = "select sparepart_name,sparepart_price,sparepart_type from sparepart where sparepart_no=?;";
		try {
			stmt = conn.prepareStatement(sql);
			for(ParterSattleInfo x : inParam) {
				ParterSattleInfo temp = new ParterSattleInfo();
				temp.setParterId(x.getParterId());
				temp.setParterCount(x.getParterCount());
				stmt.setInt(1, x.getParterId());
				rs = stmt.executeQuery();
				if(rs.next()) {
					temp.setParterName(rs.getString("sparepart_name"));
					temp.setParterType(rs.getString("sparepart_type"));
					temp.setParterPrice(rs.getDouble("sparepart_price"));
				}
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
