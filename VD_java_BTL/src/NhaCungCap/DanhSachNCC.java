package NhaCungCap;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import ConnectDB.connectDB;
import NhaCungCap.NhaCungCap;

public class DanhSachNCC {
	ArrayList<NhaCungCap> dsncc;
	NhaCungCap ncc;
	public ArrayList<NhaCungCap> getDsncc() {
		return dsncc;
	}
	public void setDsncc(ArrayList<NhaCungCap> dsncc) {
		this.dsncc = dsncc;
	}
	public NhaCungCap getNcc() {
		return ncc;
	}
	public void setNcc(NhaCungCap ncc) {
		this.ncc = ncc;
	}
	public DanhSachNCC() {
		dsncc=new ArrayList<NhaCungCap>();
		ncc=new NhaCungCap();
	}
	public ArrayList<NhaCungCap> docTuBang(){
		try {
			Connection con =connectDB.getinstance().getConnection();
			String sql="select * from NhaCungCap";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String ma=rs.getString(1);
				String ten=rs.getString(2);
				String diachi=rs.getString(3);
				String sdt=rs.getString(4);
				String email = rs.getString(0);
				NhaCungCap s=new NhaCungCap(ma, ten, diachi, sdt, email);
				dsncc.add(s);
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsncc;
	}
	public boolean create(String ma,String ten,String diachi,String sdt, String email) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("insert into khachhang values(?,?,?,?)");
			stmt.setString(1, ma);
			stmt.setString(2, ten);
			stmt.setString(3, diachi);
			stmt.setString(4, sdt);
			stmt.setString(5, email);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public boolean them(NhaCungCap ncc) {
		if(dsncc.contains(ncc))
			return false;
		dsncc.add(ncc);
		return true;
	}
	public boolean update(String maNCC,String tenNCC,String diachiNCC,String sdtNCC, String emailNCC) {
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			stmt=con.prepareStatement("update khachhang "+"set tenkh=?,"+"diachi=?,"+"sdt=?"+" where makh=?");
			stmt.setString(1, tenNCC);
			stmt.setString(2, diachiNCC);
			stmt.setString(3, sdtNCC);
			stmt.setString(4, maNCC);
			stmt.setString(5, emailNCC);
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
			stmt=con.prepareStatement("delete from NhaCungCap where maNCC=?");
			stmt.setString(1, ma);
			n=stmt.executeUpdate();
		}
		catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	public int timkiem(String maNCC) {
		int i=0;
		i++;
		if(dsncc.equals(maNCC))
			return i;
		return -1;
	}
}
