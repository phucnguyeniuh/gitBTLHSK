package NhanVien;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ConnectDB.connectDB;



public class DanhSachNhanVien {
	private ArrayList<NhanVien> dsnv;
	NhanVien nv;
	public DanhSachNhanVien() {
		dsnv = new ArrayList<NhanVien>();
		nv=new NhanVien();
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean them(NhanVien v) {
		if(dsnv.contains(v))
			return false;
			dsnv.add(v);
		return true;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<NhanVien> docTubangNV(){
		try {
			connectDB.getinstance();
			Connection con = connectDB.getinstance().getConnection();
			String sql="select * from m_nhanvien";
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			int soNamKN;
			
			/////////////////////////////////////////////////////////////////////////////////////////////
		
			while(rs.next()) {
				String maNV=rs.getString(1);
				String ten=rs.getString(2);
				String diaChi=rs.getString(3);
				String dienThoai=rs.getString(4);
				String chucVu=rs.getString(5);
				String phongBan=rs.getString(6);
				String trinhDo=rs.getString(7);
				String namKN=rs.getString(8);
				String bacTho=rs.getString(9);
				/*if(chucVu.equalsIgnoreCase("Nhân viên kĩ thuật"))
					soNamKN = Integer.parseInt(namKN);
				else {
					
				}*/
				NhanVien n=new NhanVien(maNV,ten,diaChi,dienThoai,chucVu, phongBan,trinhDo,bacTho, namKN);
				dsnv.add(n);
			}
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return dsnv;
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean createNV(String maNV, String tenNV, String diaChi, String dienThoai, String chucVu, String phongBan, String trinhDo, String bacTho, String namKN) {
		
		Connection con=connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
			
			stmt = con.prepareStatement("insert into m_nhanvien values(?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, maNV);
			stmt.setString(2, tenNV);
			stmt.setString(3, diaChi);
			stmt.setString(4, dienThoai);
			stmt.setString(5, chucVu);
			stmt.setString(6, phongBan);
			stmt.setString(7, trinhDo);
			stmt.setString(8, bacTho);
			stmt.setString(9, namKN);
			
			n=stmt.executeUpdate();
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		return n>0;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean delete(String ma) {
		connectDB.getinstance();
		Connection con = connectDB.getinstance().getConnection();
		PreparedStatement stmt=null;
		int n=0;
		try {
		stmt=con.prepareStatement("delete from m_nhanvien where manv=?");
			stmt.setString(1, ma);
			n=stmt.executeUpdate();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n>0;
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////


	
	public ArrayList<NhanVien> getList()
	{
		ArrayList<NhanVien> arr = new ArrayList<NhanVien>();
		
		for (NhanVien nhanVien : dsnv) {
			arr.add(nhanVien);
		}
		return arr;
	}
	public boolean xoa(String ma)
	{
		
		for (NhanVien nhanVien : dsnv) {
			if(nhanVien.getMaNV().equalsIgnoreCase(ma))
			{
				dsnv.remove(nhanVien);
				return true;
			}
		}
		return false;
	}
	
	public boolean Tim(String ma)
	{
		for (NhanVien nhanVien : dsnv) {
			if(ma.equalsIgnoreCase(nhanVien.getMaNV()))
			{
				return true;
			}
		}
		return false;
	}
	
}
