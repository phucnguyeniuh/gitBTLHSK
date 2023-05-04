package MuaHang;

public class MuaHang {
	private String maXe;
	private String tenXe;
	private int soLuong;
	private double donGia;
	private String mauXe;
	private String loaiXe;
	private String nhaCungCap;
	private double thanhTien;
	public MuaHang(String maXe, String tenXe, int soLuong, double donGia, String mauXe, String loaiXe,
			String nhaCungCap, double thanhTien, String ngayLap) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.mauXe = mauXe;
		this.loaiXe = loaiXe;
		this.nhaCungCap = nhaCungCap;
		this.thanhTien = thanhTien;
		this.ngayLap = ngayLap;
	}


	public MuaHang(String maXe, String tenXe, int soLuong, double donGia, double thanhTien, String ngayLap) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
		this.ngayLap = ngayLap;
		this.tien();
	}


	public MuaHang(String maXe, String tenXe, int soLuong, double donGia, String ngayLap) {
		super();
		this.maXe = maXe;
		this.tenXe = tenXe;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.ngayLap = ngayLap;
	}


	private String ngayLap;
	
	
	public double tien() {
		thanhTien= soLuong*donGia;
		return thanhTien;
	}
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
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	
	
	public MuaHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
