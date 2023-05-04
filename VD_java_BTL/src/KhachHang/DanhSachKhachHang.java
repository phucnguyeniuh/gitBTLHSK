package KhachHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.connectDB;

public class DanhSachKhachHang {
	ArrayList<KhachHang> dskh;
	KhachHang kh;
	public DanhSachKhachHang() {
		dskh=new ArrayList<KhachHang>();
		kh=new KhachHang();
	}
	public ArrayList<KhachHang> docTuBang(){
		try {
			Connection con =connectDB.getinstance().getConnection();
			String sql="select * from khachhang";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String diachi=rs.getString(3);
				String sdt=rs.getString(4);
				KhachHang s=new KhachHang(ma, ten, diachi, sdt);
				dskh.add(s);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dskh;
	}
	public boolean create(String ma,String ten,String diachi,String sdt) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into khachhang values(?,?,?,?)");
			stmt.setString(1, ma);
			stmt.setString(2, ten);
			stmt.setString(3, diachi);
			stmt.setString(4, sdt);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean them(KhachHang kh) {
		if(dskh.contains(kh))
			return false;
		dskh.add(kh);
		return true;
	}
	public boolean update(String ma,String tenkh,String diachikh,String sdtkh) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update khachhang "+"set tenkh=?,"+"diachi=?,"+"sdt=?"+" where makh=?");
			stmt.setString(1, tenkh);
			stmt.setString(2, diachikh);
			stmt.setString(3, sdtkh);
			stmt.setString(4, ma);
		n=stmt.executeUpdate();
		}
		catch (SQLException e) {  
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean delete(String ma) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("delete from khachhang where makh=?");
			stmt.setString(1, ma);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public void timkiem(KhachHang khachhang) {
	
	}
}
