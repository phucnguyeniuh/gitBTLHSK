package HoaDon;

public class HopDongTraHet extends HoaDon{
	private String tenKH;
	private String tenxe;
	private int soLuong;
	private double donGia;
	private double thanhTien;
	private double soTienTraHet;
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getTenxe() {
		return tenxe;
	}
	public void setTenxe(String tenxe) {
		this.tenxe = tenxe;
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
	public double getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}
	public double getSoTienTraHet() {
		return soTienTraHet;
	}
	public void setSoTienTraHet(double soTienTraHet) {
		this.soTienTraHet = soTienTraHet;
	}

	public HopDongTraHet(String maHD, String maXe,  String tenKH, String tenxe, int soLuong,
			double donGia, double thanhTien, double soTienTraHet,String ngayLap) {
		super(maHD, maXe, ngayLap);
		this.tenKH = tenKH;
		this.tenxe = tenxe;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
		this.soTienTraHet = soTienTraHet;
	}
	public HopDongTraHet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
