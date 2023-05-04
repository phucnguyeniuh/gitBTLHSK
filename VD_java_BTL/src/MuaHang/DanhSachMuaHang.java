package MuaHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectDB.connectDB;

public class DanhSachMuaHang {
	ArrayList<MuaHang> dsmh;
	MuaHang mh;
	public DanhSachMuaHang() {
		dsmh=new ArrayList<MuaHang>();
		mh=new MuaHang();
	}
	public boolean create(String mahd,String maxe,String tenxe,int soluong, double dongia,double thanhtien, String ngaylap,String mahd1) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into m_hd values(?,?,?,?) insert into m_ct values(?,?,?,?)");
			stmt.setString(1, mahd);
			stmt.setString(2, maxe);
			stmt.setString(3, tenxe);
			stmt.setInt(4, soluong);
			stmt.setDouble(5, dongia);
			stmt.setDouble(6, thanhtien);
			stmt.setString(7, ngaylap);
			stmt.setString(8, mahd1);
			n=stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean them(MuaHang mh) {
		if(dsmh.contains(mh))
			return false;
			dsmh.add(mh);
			return true;
	}
	public boolean delete(String mahd) {
		connectDB.getinstance();
		Connection con = connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete m_ct  delete m_hd ");
			n=stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
}
