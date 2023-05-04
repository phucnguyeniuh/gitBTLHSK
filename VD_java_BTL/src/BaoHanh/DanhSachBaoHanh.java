package BaoHanh;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.connectDB;

public class DanhSachBaoHanh {
	ArrayList<BaoHanh> dsbh;
	BaoHanh bh;
	public DanhSachBaoHanh() {
		dsbh=new ArrayList<BaoHanh>();
		bh=new BaoHanh();
	}
		
	public ArrayList<BaoHanh> docTuBang(){
		try {
			Connection con =connectDB.getinstance().getConnection();
			String sql="select maPhieu,tenLinhKien,loi,giaTien,maKH,maNV from baohanh";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String maPhieu=rs.getString(1);
				String tenLinhKien=rs.getString(2);
				String loi=rs.getString(3);
				Double gia=rs.getDouble(4);
				String maKH=rs.getString(5);
				String maNV=rs.getString(6);
				BaoHanh s = new BaoHanh(maPhieu, tenLinhKien, loi, (double)gia, maNV, maKH);
				dsbh.add(s);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsbh;
	}
	
	public boolean create(String maPhieu,String tenLinhKien,String loi, Double gia, String maKH, String maNV) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into baohanh values(?,?,?,?,?,?)");
			stmt.setString(1, maPhieu);
			stmt.setString(2, tenLinhKien);
			stmt.setString(3, loi);
			stmt.setString(4, gia.toString());
			stmt.setString(5, maKH);
			stmt.setString(6, maNV);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	
	public boolean them(BaoHanh bh) {
		if(dsbh.contains(bh))
			return false;
		dsbh.add(bh);
		return true;
	}
	
	public boolean update(String maPhieu,String tenLinhKien, String loi, Double gia, String maKH, String maNV) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update baohanh "+"set tenLinhKien=?,"+"loi=?"+"gia=?,"+"maKH=?,"+"maNV=?"+" where maPhieu=?");
			stmt.setString(1, tenLinhKien);
			//stmt.setString(2, lyDo);
			stmt.setString(2, loi);
			stmt.setDouble(3, gia);
			stmt.setString(4, maKH);
			stmt.setString(5, maNV);
			stmt.setString(6, maPhieu);
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
			stmt=con.prepareStatement("delete from baohanh where maPhieu=?");
			stmt.setString(1, ma);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
}
