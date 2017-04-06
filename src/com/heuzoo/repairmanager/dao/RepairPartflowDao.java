package com.heuzoo.repairmanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.heuzoo.repairmanager.bean.RepairPartflowInfo;
import com.heuzoo.repairmanager.common.Utils;

/***
 *@author Johnson
 *@date 2016年7月31日 上午11:32:50
 *@version 1.0
 ***/
public class RepairPartflowDao {
	
	public boolean addPartflow(RepairPartflowInfo repairpartflow){
		boolean result = true;
		Connection con = Utils.getConnection();
		PreparedStatement pst = null;
		
		try {
			pst = con.prepareStatement("insert into repair_partflow (repair_partflow_sparepart,"
					+ "repair_partflow_repair,repair_partflow_count) values(?,?,?)");
			pst.setInt(1, repairpartflow.getRepairPartflowSparepart());
			pst.setInt(2, repairpartflow.getRepairPartflowRepair());
			pst.setInt(3, repairpartflow.getRepairPartflowCount());
			
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
	
}
