package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.heuzoo.repairmanager.bean.FaultReportInfo;
import com.heuzoo.repairmanager.common.DBUtil;
import com.heuzoo.repairmanager.common.DBUtils;

public class FaultReportInfoDao {
	public boolean addFaultReportInfo(FaultReportInfo Report) {
		boolean result = true;

		Connection con = null;
		PreparedStatement st = null;

		con = DBUtil.getConnection();

		try {
			st = con.prepareStatement(" INSERT INTO"
					+ " faultreport(report_device, report_customer_id, report_time, report_price, report_finish, report_state) "
					+ " VALUES(?, ?, ?, ?, ?, ?) ");

			st.setInt(1, Report.getReportDevice());
			st.setString(2, Report.getReportCustomerId());
			//陆芦java.util.Date脳陋禄禄鲁脡java.sql.Date
			java.sql.Timestamp d = new java.sql.Timestamp(Report.getReportTime().getTime());
			st.setTimestamp(3, d);
			st.setDouble(4, Report.getReportPrice());
			d = new java.sql.Timestamp(Report.getReportFinish().getTime());
			st.setTimestamp(5, d);
			st.setInt(6, Report.getReportState());

			int i = st.executeUpdate();
			if(i < 1) {
				result = false;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			result = false;
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<FaultReportInfo> queryFaultReport(FaultReportInfo u, int start, int size) {
		ArrayList<FaultReportInfo> result = new ArrayList<FaultReportInfo>();

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		con = DBUtil.getConnection();

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" select * from faultreport where 1=1 ");
			sql.append(" limit ?, ? ");

			st = con.prepareStatement(sql.toString());
			int index = 1;

			st.setInt(index++, start);
			st.setInt(index++, size);
			rs = st.executeQuery();

			while (rs.next()) {
				FaultReportInfo Report = new FaultReportInfo();
				Report.setReportNo(rs.getInt("report_no"));
				Report.setReportDevice(rs.getInt("report_device"));
				Report.setReportCustomerId(rs.getString("report_customer_id"));
				Report.setReportTime(rs.getDate("report_time"));
				Report.setReportPrice(rs.getDouble("report_price"));
				Report.setReportFinish(rs.getDate("report_finish"));
				Report.setReportState(rs.getInt("report_state"));
				result.add(Report);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(rs, st, con);
		}

		return result;
	}

	public int queryReporttotalRows(FaultReportInfo u) {
		int result = 0;

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		con = DBUtil.getConnection();

		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" select count(*) from faultreport where 1=1 ");

			st = con.prepareStatement(sql.toString());
			rs = st.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(rs, st, con);
		}

		return result;
	}

	public int queryReportNo() {
		int result = 0;

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		con = DBUtil.getConnection();

		try {
			StringBuilder sql = new StringBuilder();
			sql.append("select MAX(report_no) from faultreport");

			st = con.prepareStatement(sql.toString());
			rs = st.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeResource(rs, st, con);
		}

		return result;
	}

	public static ArrayList<FaultReportInfo> queryFaultReport() {
		ArrayList<FaultReportInfo> result = new ArrayList<FaultReportInfo>();

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from faultreport";
		conn = DBUtils.getConnection();

		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				FaultReportInfo Report = new FaultReportInfo();
				Report.setReportNo(rs.getInt("report_no"));
				Report.setReportDevice(rs.getInt("report_device"));
				Report.setReportCustomerId(rs.getString("report_customer_id"));
				Report.setReportTime(rs.getDate("report_time"));
				Report.setReportPrice(rs.getDouble("report_price"));
				Report.setReportFinish(rs.getDate("report_finish"));
				Report.setReportState(rs.getInt("report_state"));
				result.add(Report);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return result;
	}

}
