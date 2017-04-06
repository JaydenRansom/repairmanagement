package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.heuzoo.repairmanager.bean.OrderInfo;
import com.heuzoo.repairmanager.common.DBUtil;

public class OrderInfoDao {
	public OrderInfo queryOrderInfo(int reportNo) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		OrderInfo od = new OrderInfo();

		con = DBUtil.getConnection();

		try {
			st = con.prepareStatement(" SELECT report_time, report_no, device_type, device_brand, device_model, device_series, customer_name, customer_office, device_fault_appearance, device_lack "
									+ " from device, faultreport, customer "
									+ " where report_no = ? ");
			st.setInt(1, reportNo);
			rs = st.executeQuery();
			od.setReportTime(rs.getDate("report_time"));
			od.setReportNo(rs.getInt("report_no"));
			od.setDeviceType(rs.getString("device_type"));
			od.setDeviceBrand(rs.getString("device_brand"));
			od.setDeviceModel(rs.getString("device_model"));
			od.setDeviceSeries(rs.getString("device_series"));
			od.setCustomerName(rs.getString("customer_name"));
			od.setCustomerOffice(rs.getString("customer_office"));
			od.setDeviceFaultAppearance(rs.getString("device_fault_appearance"));
			od.setDeviceLack(rs.getString("device_lack"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return od;
	}
}
