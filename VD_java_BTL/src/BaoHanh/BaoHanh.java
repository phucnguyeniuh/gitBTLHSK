package BaoHanh;

public class BaoHanh {
	private String maPhieu;
	private String tenLinhKien;
	private String loi;
	private Double gia;
	private String maNV;
	private String maKH;
	private String tenNV;
	private String tenKH;
	
	public BaoHanh(String maPhieu, String tenLinhKien, String lyDo, String loi, Double gia, String maNV, String maKH) {
		this.maPhieu = maPhieu;
		this.tenLinhKien = tenLinhKien;
		this.loi = loi;
		this.gia = gia;
		this.maNV = maNV;
		this.maKH = maKH;
	}
	public BaoHanh(String maPhieu, String tenLinhKien, String loi, double gia, String maNV, String maKH) {
		super();
		this.maPhieu = maPhieu;
		this.tenLinhKien = tenLinhKien;
		this.loi= loi;
		this.gia = gia;
		this.maKH = maKH;
		this.maNV = maNV;
	}
	
	public BaoHanh(String maPhieu) {
		this(maPhieu,"Tên linh kiện","Lý do","Lỗi",0.0,"Mã nhân viên","Mã khách hàng");
	}
	
	public BaoHanh() {
		this("Mã phiếu","Tên linh kiện","Lý do","Lỗi",0.0,"Mã nhân viên","Mã khách hàng");
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public String getTenLinhKien() {
		return tenLinhKien;
	}

	public void setTenLinhKien(String tenLinhKien) {
		this.tenLinhKien = tenLinhKien;
	}
	public String getLoi() {
		return loi;
	}

	public void setLoi(String loi) {
		this.loi = loi;
	}

	public Double getGia() {
		return gia;
	}

	public void setGia(Double gia) {
		this.gia = gia;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	
	
	
}
