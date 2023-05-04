package xe;

import java.io.Serializable;

public class Xe implements Serializable{
	public String maXe;
	public String tenXe;
	public String loaiXe;
	public String soMay;
	public String soKhung;
	public String mauXe;
	public String nuocSX;
	public int soLuong;
	public double giaXe;
	public String nhaCungCap;
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	public String getTenXe() {
		return tenXe;
	}
	public void setTenXe(String tenXe) {
		this.tenXe = tenXe;
	}
	public String getLoaiXe() {
		return loaiXe;
	}
	public void setLoaiXe(String loaiXe) {
		this.loaiXe = loaiXe;
	}
	public String getSoMay() {
		return soMay;
	}
	public void setSoMay(String soMay) {
		this.soMay = soMay;
	}
	public String getSoKhung() {
		return soKhung;
	}
	public void setSoKhung(String soKhung) {
		this.soKhung = soKhung;
	}
	public String getMauXe() {
		return mauXe;
	}
	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}
	public String getNuocSX() {
		return nuocSX;
	}
	public void setNuocSX(String nuocSX) {
		this.nuocSX = nuocSX;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getGiaXe() {
		return giaXe;
	}
	public void setGiaXe(double giaXe) {
		this.giaXe = giaXe;
	}
	public String getNhaCungCap() {
		return nhaCungCap;
	}
	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mauXe == null) ? 0 : mauXe.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Xe other = (Xe) obj;
		if (mauXe == null) {
			if (other.mauXe != null)
				return false;
		} else if (!mauXe.equals(other.mauXe))
			return false;
		return true;
	}
	public Xe(String maXe, String tenXe, String loaiXe, String soMay, String soKhung, String mauXe, String nuocSX,
			int soLuong, double giaXe, String nhaCungCap) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.loaiXe = loaiXe;
		this.soMay = soMay;
		this.soKhung = soKhung;
		this.mauXe = mauXe;
		this.nuocSX = nuocSX;
		this.soLuong = soLuong;
		this.giaXe = giaXe;
		this.nhaCungCap = nhaCungCap;
	}
	public Xe(String maXe) {
		this(maXe,"","","","","","",0,0,"");
	}
	public Xe() {
		this("ma xe");
	}
	
}
