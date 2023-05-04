package HoaDon;

public class HopDongTraGop extends HoaDon{
	private String nguoiTra;
	private String nguoiNhan;
	private int soLuong;
	private double donGia;
	private double thanhTien;
	private int lanTra;
	private double soTienTra;
	public String getTenKH() {
		return nguoiTra;
	}
	public void setTenKH(String tenKH) {
		this.nguoiTra = tenKH;
	}
	public String getTenXe() {
		return nguoiNhan;
	}
	public void setTenXe(String tenXe) {
		this.nguoiNhan = tenXe;
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
	public int getLanTra() {
		return lanTra;
	}
	public void setLanTra(int lanTra) {
		this.lanTra = lanTra;
	}
	public double getSoTienTra() {
		return soTienTra;
	}
	public void setSoTienTra(double soTienTra) {
		this.soTienTra = soTienTra;
	}

	public HopDongTraGop(String maHD, String maXe, String nguoiTra, String nguoiNhan, int soLuong,
			double donGia, double thanhTien, int lanTra, double soTienTra, String ngayLap) {
		super(maHD, maXe, ngayLap);
		this.nguoiTra = nguoiTra;
		this.nguoiNhan = nguoiNhan;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
		this.lanTra = lanTra;
		this.soTienTra = soTienTra;
	}
	public HopDongTraGop(String maHD) {
		this(maHD,"","","",0,0.0,0.0,0,0.0,"");
	}
	public HopDongTraGop() {
		this("ma hd");
	}
}
