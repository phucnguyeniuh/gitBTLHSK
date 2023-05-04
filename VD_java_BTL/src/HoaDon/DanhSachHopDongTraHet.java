package HoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.connectDB;


public class DanhSachHopDongTraHet {
	ArrayList<HopDongTraHet> dshdth;
	HopDongTraHet hdth;
	public DanhSachHopDongTraHet() {
		// TODO Auto-generated constructor stub
		dshdth=new ArrayList<HopDongTraHet>();
		hdth=new HopDongTraHet();
	}
	public ArrayList<HopDongTraHet> docTuBang(){
		try {
			Connection con=connectDB.getinstance().getConnection();
			String sql="select * from hopdongtrahet1_view";
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
				Double sotientraHet=rs.getDouble(8);
				String ngaylap=rs.getString(9);
				HopDongTraHet s=new HopDongTraHet(mahd, maxe,tenkh, tenxe, soluong, dongia, thanhtien, sotientraHet,ngaylap);
				dshdth.add(s);
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dshdth;
	}
	public boolean create(String mahd,String tenkh,String tenxe,int soluong,double dongia, double thanhtien,double sotientrahet,String ngaylap) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0; 
		try {
			stmt=con.prepareStatement("");
			stmt.setString(1, mahd);
			stmt.setString(2, tenkh);
			stmt.setString(3, tenxe);
			stmt.setInt(4, soluong);
			stmt.setDouble(5, dongia);
			stmt.setDouble(6, thanhtien);
			stmt.setDouble(7, sotientrahet);
			stmt.setString(8, ngaylap);
			n=stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean them(HopDongTraHet hdth) {
		if(dshdth.contains(hdth))
			return false;
		dshdth.add(hdth);
		return true;
	}
	public boolean update(String mahd,String tenkh,String tenxe,int soluong,double dongia, double thanhtien,double sotientrahet,String ngaylap) {
		
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0; 
		try {
			stmt=con.prepareStatement("");
			stmt.setString(1, mahd);
			stmt.setString(2, tenkh);
			stmt.setString(3, tenxe);
			stmt.setInt(4, soluong);
			stmt.setDouble(5, dongia);
			stmt.setDouble(6, thanhtien);
			stmt.setDouble(7, sotientrahet);
			stmt.setString(8, ngaylap);
			n=stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String mahd) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0; 
		try {
			stmt=con.prepareStatement("");
			stmt.setString(1, mahd);
			n=stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
}
