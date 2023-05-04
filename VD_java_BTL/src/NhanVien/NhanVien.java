package NhanVien;

public class NhanVien {

	private String maNV;
	private String tenNV;
	private String diaChi;
	private String dienThoai;
	private String chucVu;
	private String phongBan;
	private String trinhDo;
	private String bacTho;
	private String namKN;

	public NhanVien(String maNV, String tenNV, String diaChi, String dienThoai, String chucVu, String phongBan,
			String trinhDo, String bacTho, String soNamKN) {
		setMaNV(maNV);
		setTenNV(tenNV);
		setDiaChi(diaChi);
		setDienThoai(dienThoai);
		setChucVu(chucVu);
		setPhongBan(phongBan);
		setTrinhDo(trinhDo);
		setBacTho(bacTho);
		setNamKN(soNamKN);
	}
	public NhanVien() {
	
	}
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getDienThoai() {
		return dienThoai;
	}
	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	public String getPhongBan() {
		return phongBan;
	}
	public void setPhongBan(String phongBan) {
		this.phongBan = phongBan;
	}
	public String getTrinhDo() {
		return trinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}
	public String getBacTho() {
		return bacTho;
	}
	public void setBacTho(String bacTho) {
		this.bacTho = bacTho;
	}
	public String getNamKN() {
		return namKN;
	}
	public void setNamKN(String namKN) {
		this.namKN = namKN;
	}

	
	
}
