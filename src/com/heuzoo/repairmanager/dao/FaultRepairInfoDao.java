package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.heuzoo.repairmanager.bean.FaultRepairInfo;
import com.heuzoo.repairmanager.common.DBUtil;

public class FaultRepairInfoDao {
	public boolean addFaultRepairInfo(FaultRepairInfo Repair) {
		boolean result = true;

		Connection con = null;
		PreparedStatement st = null;

		con = DBUtil.getConnection();

		try {
			st = con.prepareStatement(" INSERT INTO "
					+ " faultrepair(repair_report_no, repair_state) "
					+ " VALUES(?, ?) ");
			st.setInt(1, Repair.getRepairReportNo());
			st.setInt(2, Repair.getRepairState());
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
}
