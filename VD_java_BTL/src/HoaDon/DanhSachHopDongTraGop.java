package HoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.connectDB;

public class DanhSachHopDongTraGop {
	ArrayList<HopDongTraGop> dshdtg;
	HopDongTraGop hdtg;
	public DanhSachHopDongTraGop() {
		dshdtg=new ArrayList<HopDongTraGop>();
		hdtg=new HopDongTraGop();
	}
	public ArrayList<HopDongTraGop> docTuBang(){
		try {
			Connection con=connectDB.getinstance().getConnection();
			String sql="select * from view_tragop";  
			Statement statement=con.createStatement();	
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String mahd=rs.getString(1);
				String maxe=rs.getString(2);
				String tenkh=rs.getString(3);	
				String tenxe=rs.getString(4);
				int soluong=rs.getInt(5);
				Double dongia=rs.getDouble(6);
				Double thanhtien=rs.getDouble(7);
				int lantra=rs.getInt(8);
				Double sotientragop=rs.getDouble(9);
				String ngaylap=rs.getString(10);
				HopDongTraGop s=new HopDongTraGop(mahd, maxe, tenkh, tenxe, soluong, dongia, thanhtien, lantra, sotientragop, ngaylap);
				dshdtg.add(s);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dshdtg;
	}
	public boolean create(String mahd,String maxe,String tenkh,String tenxe,int soluong,double dongia, double thanhtien,int lantra,double sotientra,String ngaylap) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0; 
		try {
			stmt=con.prepareStatement("insert view_tragop values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, mahd);
			stmt.setString(2, maxe);
			stmt.setString(3, tenkh);
			stmt.setString(4, tenxe);
			stmt.setInt(5, soluong);
			stmt.setDouble(6, dongia);
			stmt.setDouble(7, thanhtien);
			stmt.setInt(8, lantra);
			stmt.setDouble(9, sotientra);
			stmt.setString(10, ngaylap);
			n=stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean them(HopDongTraGop hdtg) {
		if(dshdtg.contains(hdtg))
			return false;
		dshdtg.add(hdtg);
		return true;
	}
	public boolean delete(String maxe) {
		connectDB.getinstance();
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0; 
		try {
			stmt=con.prepareStatement("delete tg_hd delete tg_xe");
			n=stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}

}
