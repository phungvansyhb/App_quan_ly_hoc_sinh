package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.graduate;
public class graduateDao {
	public List<graduate> getlistgrade (Connection conn) throws SQLException{
		List<graduate> list = new ArrayList<graduate>();
		PreparedStatement pst = null;
		String sql = "Select * From apptimhocsinh.graduate";
		pst = conn.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			graduate grade = new graduate();
			grade.setGraduateId(rs.getInt("idGraduate"));
			grade.setGraduateName(rs.getString("graduateName"));
			list.add(grade);
		}
		
		
		return list;
	}
}
