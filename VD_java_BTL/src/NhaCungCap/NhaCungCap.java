package NhaCungCap;

import java.util.Objects;

public class NhaCungCap {
	private String MaNCC;
	private String TenNCC;
	private String DiaChiNCC;
	private String SDTNCC;
	private String Email;
	public String getMaNCC() {
		return MaNCC;
	}
	public void setMaNCC(String maNCC) {
		MaNCC = maNCC;
	}
	public String getTenNCC() {
		return TenNCC;
	}
	public void setTenNCC(String tenNCC) {
		TenNCC = tenNCC;
	}
	public String getDiaChiNCC() {
		return DiaChiNCC;
	}
	public void setDiaChiNCC(String diaChiNCC) {
		DiaChiNCC = diaChiNCC;
	}
	public String getSDTNCC() {
		return SDTNCC;
	}
	public void setSDTNCC(String sDTNCC) {
		SDTNCC = sDTNCC;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public NhaCungCap() {
		super();
	}
	public NhaCungCap(String maNCC) {
		super();
		MaNCC = maNCC;
	}
	public NhaCungCap(String maNCC, String tenNCC, String diaChiNCC, String sDTNCC, String email) {
		super();
		MaNCC = maNCC;
		TenNCC = tenNCC;
		DiaChiNCC = diaChiNCC;
		SDTNCC = sDTNCC;
		Email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(MaNCC);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhaCungCap other = (NhaCungCap) obj;
		return Objects.equals(MaNCC, other.MaNCC);
	}
	
	
}
