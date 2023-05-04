package HoaDon;

public class HoaDon {
	private String maHD;
	private String maKH;
	private String maNV;
	private String maXe;
	private String ngayLap;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getMaXe() {
		return maXe;
	}
	public void setMaXe(String maXe) {
		this.maXe = maXe;
	}
	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	public HoaDon(String maHD, String maKH, String maNV, String maXe, String ngayLap) {
		super();
		this.maHD = maHD;
		this.maKH = maKH;
		this.maNV = maNV;
		this.maXe = maXe;
		this.ngayLap = ngayLap;
	}
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHD, String maXe, String ngayLap) {
		super();
		this.maHD = maHD;
		this.maXe = maXe;
		this.ngayLap = ngayLap;
	}
	
}
