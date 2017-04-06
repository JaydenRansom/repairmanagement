package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.heuzoo.repairmanager.bean.DeviceInfo;
import com.heuzoo.repairmanager.common.DBUtil;
import com.heuzoo.repairmanager.common.DBUtils;

public class DeviceInfoDao {
//	public boolean addDeviceInfo(DeviceInfo Dev) {
//		boolean result = true;
//
//		Connection con = null;
//		PreparedStatement st = null;
//
//		con = DBUtil.getConnection();
//
//		try {
//			st = con.prepareStatement(" INSERT INTO"
//					+ " device(device_type, device_brand, device_model, device_series, device_lack, device_fault_appearance, device_fault_type, device_surface, device_password, device_imp_file, device_hdd, device_memory, device_pc, device_ac, device_battery, device_dvd, device_other) "
//					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
//
//			st.setInt(1, Dev.getDeviceType());
//			st.setString(2, Dev.getDeviceBrand());
//			st.setString(3, Dev.getDeviceModel());
//			st.setString(4, Dev.getDeviceSeries());
//			st.setString(5, Dev.getDeviceLack());
//			st.setString(6, Dev.getDeviceFaultAppearance());
//			st.setInt(7, Dev.getDeviceFaultType());
//			st.setString(8, Dev.getDeviceSurface());
//			st.setString(9, Dev.getDevicePassword());
//			st.setString(10, Dev.getDeviceImpFile());
//			st.setString(11, Dev.getDeviceHDD());
//			st.setString(12, Dev.getDeviceMemory());
//			st.setString(13, Dev.getDevicePC());
//			st.setString(14, Dev.getDeviceAC());
//			st.setString(15, Dev.getDeviceBattery());
//			st.setString(16, Dev.getDeviceDVD());
//			st.setString(17, Dev.getDeviceOther());
//
//			int i = st.executeUpdate();
//			if(i < 1) {
//				result = false;
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			result = false;
//			e.printStackTrace();
//		}
//
//		return result;
//	}

//		public boolean queryDeviceInfo(String deviceSeries) {
//		Connection con = null;
//		PreparedStatement st = null;
//		ResultSet rs = null;
//		boolean result = false;
//
//		con = DBUtil.getConnection();
//
//		try {
//			st = con.prepareStatement(" SELECT device_series from device where device_series = ? ");
//			st.setString(1, deviceSeries);
//			rs = st.executeQuery();
//			if (rs.next()) {
//				result = true;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return result;
//	}
		public int queryDeviceNo() {
			int result = 0;
	    	Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			con = DBUtil.getConnection();
			try {
				StringBuilder sql = new StringBuilder();
				sql.append(" select device_no from device ");

				st = con.prepareStatement(sql.toString());
				rs = st.executeQuery();
				while(rs.next()) {
					result = rs.getInt("device_no");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBUtil.closeResource(rs, st, con);
			}
	    	return result;
	    }
		public boolean addDeviceInfo(DeviceInfo Dev) {
			boolean result = true;

			Connection con = null;
			PreparedStatement st = null;

			con = DBUtils.getConnection();

			try {
				st = con.prepareStatement(" INSERT INTO"
						+ " device(device_type, device_brand, device_model, device_series, device_lack, device_fault_appearance, device_fault_type, device_surface, device_password, device_imp_file, device_hdd, device_memory, device_pc, device_ac, device_battery, device_dvd, device_other) "
						+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

				st.setInt(1, Dev.getDeviceType());
				st.setString(2, Dev.getDeviceBrand());
				st.setString(3, Dev.getDeviceModel());
				st.setString(4, Dev.getDeviceSeries());
				st.setString(5, Dev.getDeviceLack());
				st.setString(6, Dev.getDeviceFaultAppearance());
				st.setInt(7, Dev.getDeviceFaultType());
				st.setString(8, Dev.getDeviceSurface());
				st.setString(9, Dev.getDevicePassword());
				st.setString(10, Dev.getDeviceImpFile());
				st.setString(11, Dev.getDeviceHDD());
				st.setString(12, Dev.getDeviceMemory());
				st.setString(13, Dev.getDevicePC());
				st.setString(14, Dev.getDeviceAC());
				st.setString(15, Dev.getDeviceBattery());
				st.setString(16, Dev.getDeviceDVD());
				st.setString(17, Dev.getDeviceOther());

				int i = st.executeUpdate();
				if(i < 1) {
					result = false;
				}

			} catch (SQLException e) {
				result = false;
				e.printStackTrace();
			}

			return result;
		}

			public boolean queryDeviceInfo(String deviceSeries) {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			boolean result = false;

			con = DBUtils.getConnection();

			try {
				st = con.prepareStatement(" SELECT device_series from device where device_series = ? ");
				st.setString(1, deviceSeries);
				rs = st.executeQuery();
				if (rs.next()) {
					result = true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
//		public DeviceInfo queryDeviceInfo(String deviceSeries) {
//			Connection con = null;
//			PreparedStatement st = null;
//			ResultSet rs = null;
//			DeviceInfo dev = new DeviceInfo();
//			con = DBUtil.getConnection();
//			try {
//				st = con.prepareStatement(" SELECT device_no, device_type, device_brand, device_model, device_series, device_lack, device_fault_appearance, device_fault_type, device_surface, device_password, device_imp_file, device_hdd, device_memory, device_pc, device_ac, device_battery, device_dvd, device_other "
//										+ " from device "
//										+ " where device_series = ? ");
//				st.setString(1, deviceSeries);
//				rs = st.executeQuery();
//				dev.setDeviceNo(rs.getInt("device_no"));
//				dev.setDeviceType(rs.getInt("device_type"));
//				dev.setDeviceBrand(rs.getString("device_brand"));
//				dev.setDeviceModel(rs.getString("device_model"));
//				dev.setDeviceSeries(rs.getString("device_series"));
//				dev.setDeviceLack(rs.getString("device_lack"));
//				dev.setDeviceFaultAppearance(rs.getString("device_fault_appearance"));
//				dev.setDeviceFaultType(rs.getInt("device_fault_type"));
//				dev.setDeviceSurface(rs.getString("device_surface"));
//				dev.setDevicePassword(rs.getString("device_password"));
//				dev.setDeviceImpFile(rs.getString("device_imp_file"));
//				dev.setDeviceHDD(rs.getString("device_hdd"));
//				dev.setDeviceMemory(rs.getString("device_memory"));
//				dev.setDevicePC(rs.getString("device_pc"));
//				dev.setDeviceAC(rs.getString("device_ac"));
//				dev.setDeviceBattery(rs.getString("device_battery"));
//				dev.setDeviceDVD(rs.getString("device_dvd"));
//				dev.setDeviceOther(rs.getString("device_other"));
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return dev;
//		}
		public static ArrayList<DeviceInfo> getAllDevice() {
			ArrayList<DeviceInfo> result = new ArrayList<DeviceInfo>();
			Connection conn = null;
			String sql = " select device_no, device_type, device_brand, device_model, device_series, device_lack, device_fault_appearance, device_fault_type, device_surface, device_password, device_imp_file, device_hdd, device_memory, device_pc, device_ac, device_battery, device_dvd, device_other "
					                             + " from device";
			conn = DBUtils.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery();
				while(rs.next()) {
					DeviceInfo dev = new DeviceInfo();
					dev.setDeviceNo(rs.getInt("device_no"));
					dev.setDeviceType(rs.getInt("device_type"));
					dev.setDeviceBrand(rs.getString("device_brand"));
					dev.setDeviceModel(rs.getString("device_model"));
					dev.setDeviceSeries(rs.getString("device_series"));
					dev.setDeviceLack(rs.getString("device_lack"));
					dev.setDeviceFaultAppearance(rs.getString("device_fault_appearance"));
					dev.setDeviceFaultType(rs.getInt("device_fault_type"));
					dev.setDeviceSurface(rs.getString("device_surface"));
					dev.setDevicePassword(rs.getString("device_password"));
					dev.setDeviceImpFile(rs.getString("device_imp_file"));
					dev.setDeviceHDD(rs.getString("device_hdd"));
					dev.setDeviceMemory(rs.getString("device_memory"));
					dev.setDevicePC(rs.getString("device_pc"));
					dev.setDeviceAC(rs.getString("device_ac"));
					dev.setDeviceBattery(rs.getString("device_battery"));
					dev.setDeviceDVD(rs.getString("device_dvd"));
					dev.setDeviceOther(rs.getString("device_other"));
					result.add(dev);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return result;
		}
}
