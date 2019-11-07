package Dao;

import java.sql.*;

import bean.*;
public class insertDao {
	public static boolean insertstudent(Connection conn ,student st) throws SQLException {
		
		PreparedStatement pst = null;
		String sql = "Insert into apptimhocsinh.student(studentName,idClass,point) values(?,?,?)";
		pst = conn.prepareStatement(sql);
		pst.setString(1, st.getStudentName());
		pst.setInt(2, st.getClassID());
		
		pst.setDouble(3,st.getPoint());
		
		if(pst.executeUpdate() != 0) return true;
		else return false;
	}
}

