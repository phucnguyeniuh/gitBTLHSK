package MuaHang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;
import javax.swing.table.DefaultTableModel;

import ConnectDB.connectDB;
import HoaDon.DanhSachHopDongTraGop;
import HoaDon.FrmHopDongTraHet;
import HoaDon.HopDongTraGop;
import KhachHang.FrmKhachHang;
import NhanVien.FrmNhanVien;
import TimKiemNhanVien.FrmTimKiemHD;
import xe.DanhSachXe;
import xe.FrmXe;
import xe.Xe;

public class FrmMuaHang extends JFrame implements ActionListener,MouseListener{
	private JTextField txtMaHD; 
	private JTextField txtTenKH;
	private JTextField txtNgayLap;
	private JTextField txtSoTienTra;
	private JTextField txtlanTra;
	private JTextField txtTenXe;
	private JTextField txtDonGia;
	private JTextField txtSoLuong;
	private JTextField txtThanhTien;
	private JTextField txtTim,txtMaKH,txtDiaChi,txtSDT,txtMaNV,txtTenNV,txtMaXe;
	
	
	private JLabel lblMaHD;
	private JLabel lblTenKH;
	private JLabel lblNgayLap;
	private JLabel lblSoTienTra;
	private JLabel lblLanTra;
	private JLabel lblTenXe;
	private JLabel lblDonGia;
	private JLabel lblSoLuuong;
	private JLabel lblThanhTien,lblMaKH,lblDiaChi,lblSDT,lblMaNV,lblTenNV;
	private JLabel lblTieuDe;
	
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXoaTrang;
	private JButton btnLuu;
	private JButton btnTrangChu;
	private JButton btnXeMay;
	private JButton btnHoaDon;
	private JButton btnNhanVien;
	private JButton btnKhachHang;
	private JButton btnBaoHanh;
	private JButton btnGioiThieu;
	private JButton btnThoat;
	private JButton btnTim;
	private JButton btnXemHDTH;
	
	private JTable table1,table2;
	private MuaHang muahang;
	public static DefaultTableModel dataModel1,dataModel2;
	DanhSachHopDongTraGop dshdtg= new DanhSachHopDongTraGop();
	FrmKhachHang frmkh;
	private JLabel lblMaXe;
	private JButton btnChon;
	private JButton btnDatHang;
	private JButton btnThanhToan1;
	private JButton btnThanhToan2;
	DanhSachMuaHang dsmh=new DanhSachMuaHang();
	private JLabel lblMauXe;
	private JTextField txtMauXe;
	private JLabel lblLoaiXe;
	private JTextField txtLoaiXe;
	private JLabel lblNCC;
	private JTextField txtNCC;
	private JLabel lblTongTien;
	private JTextField txtTongTien;
	double togTien = 0;
	public FrmMuaHang() throws HeadlessException{
		setSize(1055,800);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(true);
		setDefaultLookAndFeelDecorated(EXIT_ON_CLOSE);
		
		/**
		 * Panel Menu
		 */
		JPanel pnlMenu= new JPanel();
		add(pnlMenu);
		pnlMenu.setBounds(0, 0, 1055, 50);
		pnlMenu.setBackground(Color.gray);
		pnlMenu.setLayout(null);

		pnlMenu.add(btnTrangChu=new JButton("TRANG CHỦ"));
		btnTrangChu.setFont(new Font("arial", Font.BOLD, 17));
		btnTrangChu.setForeground(Color.white);
		btnTrangChu.setBackground(Color.gray);
		
		
		pnlMenu.add(btnXeMay=new JButton("XE MÁY"));
		btnXeMay.setFont(new Font("arial", Font.BOLD, 17));
		btnXeMay.setForeground(Color.white);
		btnXeMay.setBackground(Color.gray);
		
		
		pnlMenu.add(btnHoaDon=new JButton("HÓA ĐƠN"));
		btnHoaDon.setFont(new Font("arial", Font.BOLD, 17));
		btnHoaDon.setForeground(Color.white);
		btnHoaDon.setBackground(Color.gray);
		
		pnlMenu.add(btnNhanVien=new JButton("NHÂN VIÊN"));
		btnNhanVien.setFont(new Font("arial", Font.BOLD, 17));
		btnNhanVien.setForeground(Color.white);
		btnNhanVien.setBackground(Color.gray);
		
		pnlMenu.add(btnKhachHang=new JButton("KHÁCH HÀNG"));
		btnKhachHang.setFont(new Font("arial", Font.BOLD, 17));
		btnKhachHang.setForeground(Color.white);
		btnKhachHang.setBackground(Color.gray);

		
		pnlMenu.add(btnBaoHanh=new JButton("TÌM KIẾM"));
		btnBaoHanh.setFont(new Font("arial", Font.BOLD, 17));
		btnBaoHanh.setForeground(Color.white);
		btnBaoHanh.setBackground(Color.gray);

		
		pnlMenu.add(btnGioiThieu=new JButton("GIỚI THIỆU"));
		btnGioiThieu.setFont(new Font("arial", Font.BOLD, 17));
		btnGioiThieu.setForeground(Color.white);
		btnGioiThieu.setBackground(Color.gray);
		
		
		pnlMenu.add(btnThoat=new JButton("THOÁT"));
		btnThoat.setFont(new Font("arial", Font.BOLD,17));
		btnThoat.setForeground(Color.white);
		btnThoat.setBackground(Color.gray);
		
		btnTrangChu.setBounds(0, 0, 150, 50);
		btnXeMay.setBounds(150,0, 150, 50);
		btnNhanVien.setBounds(300,0, 150, 50);
		btnHoaDon.setBounds(450, 0, 150, 50);
		btnKhachHang.setBounds(600, 0, 150, 50);
		btnBaoHanh.setBounds(750, 0, 150, 50);
		btnThoat.setBounds(900, 0, 150, 50);
		/**
		 * Panel Banner
		 */
		JPanel pnlBanner=new JPanel();
		add(pnlBanner);
		pnlBanner.setBounds(0, 50, 1055, 30);
		JLabel lblTieuDe;
		pnlBanner.add(lblTieuDe=new JLabel("ĐẶT HÀNG"));
		lblTieuDe.setFont(new Font("arial",Font.BOLD,20));
		/**
		 * Panel Content
		 */
		JPanel pnlContent=new JPanel();
		add(pnlContent);
		pnlContent.setBounds(0,80,1055,400);
		pnlContent.setLayout(null);
		
		JPanel pnlL=new JPanel();
		pnlContent.add(pnlL);
		pnlL.setLayout(null);
		pnlL.setBounds(0,80,1035,190);
		
		pnlL.setBorder( new TitledBorder(BorderFactory.createLoweredBevelBorder(),"Thông tin chung"));
		
		pnlL.add(lblMaNV=new JLabel("Mã NV"));
		pnlL.add(txtMaNV=new JTextField("NV001"));
		pnlL.add(lblMaKH=new JLabel("Mã KH"));
		pnlL.add(txtMaKH=new JTextField());
		pnlL.add(lblTenNV=new JLabel("Tên NV"));
		pnlL.add(txtTenNV=new JTextField("Lê Danh Huy"));
		pnlL.add(lblTenKH=new JLabel("Tên KH"));
		pnlL.add(txtTenKH=new JTextField());
		pnlL.add(lblNgayLap=new JLabel("Ngày trả"));
		pnlL.add(txtNgayLap=new JTextField());
		pnlL.add(lblDiaChi=new JLabel("Địa chỉ"));
		pnlL.add(txtDiaChi=new JTextField());
		pnlL.add(lblSDT=new JLabel("Số điện thoại"));
		pnlL.add(txtSDT=new JTextField());
		pnlL.add(lblMaHD=new JLabel("Mã Hợp đồng"));
		pnlL.add(txtMaHD=new JTextField());
		long millis=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(millis);
		txtNgayLap.setText(date+"");
		
		
		
		pnlContent.add(btnXemHDTH=new JButton("Xem hợp đồng trả hết"));
		pnlContent.add(btnThem=new JButton("Thêm"));
		pnlContent.add(btnXoa=new JButton("Xóa"));
		pnlContent.add(btnSua=new JButton("Sửa"));
		pnlContent.add(btnXoaTrang=new JButton("Xóa trắng"));
		pnlContent.add(btnChon=new JButton("Chọn"));
		pnlContent.add(btnThanhToan1=new JButton("Thanh toán trả góp"));
		pnlContent.add(btnThanhToan2=new JButton("Thanh toán trả hết"));
		btnThem.setBackground(Color.gray);
		btnThem.setForeground(Color.white);
		btnXoa.setBackground(Color.gray);
		btnXoa.setForeground(Color.white);
		btnSua.setBackground(Color.gray);
		btnSua.setForeground(Color.white);
		btnXoaTrang.setBackground(Color.gray);
		btnXoaTrang.setForeground(Color.white);
		btnChon.setBackground(Color.gray);
		btnChon.setForeground(Color.white);
		btnThanhToan1.setBackground(Color.gray);
		btnThanhToan1.setForeground(Color.white);
		btnThanhToan2.setBackground(Color.gray);
		btnThanhToan2.setForeground(Color.white);
		
		int w1=100, w2=300, h=25;
		lblMaNV.setBounds(50,20, w1, h);txtMaNV.setBounds(150,20, w2, h);
		lblMaKH.setBounds(550, 20, w1, h);txtMaKH.setBounds(650, 20, w2, h);
		
		lblTenNV.setBounds(50, 65, w1, h);txtTenNV.setBounds(150, 65, w2, h);
		lblTenKH.setBounds(550, 65, w1, h);txtTenKH.setBounds(650, 65, w2, h);
		
		lblNgayLap.setBounds(50, 110, w1, h);txtNgayLap.setBounds(150, 110, w2, h);
		lblDiaChi.setBounds(550, 110, w1, h);txtDiaChi.setBounds(650, 110, w2, h);
		
		lblMaHD.setBounds(50, 155, w1, h);txtMaHD.setBounds(150, 155, w2, h);
		lblSDT.setBounds(550, 155, w1, h);txtSDT.setBounds(650, 155, w2, h);
		
		//lblNgayLap.setBounds(50, 200, w1, h);txtNgayLap.setBounds(150, 200, w2, h);
		
		JPanel pnlXe=new JPanel();
		pnlContent.add(pnlXe);
		pnlXe.setLayout(null);
		pnlXe.setBounds(0,270,1035,200);
		pnlXe.setBorder( new TitledBorder(BorderFactory.createLoweredBevelBorder(),"Thông tin xe"));
		
		pnlXe.add(lblMaXe= new JLabel("Mã xe"));
		pnlXe.add(txtMaXe= new JTextField());
		pnlXe.add(lblTenXe= new JLabel("Tên xe"));
		pnlXe.add(txtTenXe= new JTextField());
		pnlXe.add(lblSoLuuong= new JLabel("Số lượng"));
		pnlXe.add(txtSoLuong=new JTextField());
		pnlXe.add(lblDonGia= new JLabel("Đơn giá"));
		pnlXe.add(txtDonGia= new JTextField());
		pnlXe.add(lblThanhTien= new JLabel("Thành tiền"));
		pnlXe.add(txtThanhTien= new JTextField());
		pnlXe.add(lblMauXe= new JLabel("Màu xe"));
		pnlXe.add(txtMauXe= new JTextField());
		pnlXe.add(lblLoaiXe= new JLabel("Loai xe"));
		pnlXe.add(txtLoaiXe= new JTextField());
		pnlXe.add(lblNCC= new JLabel("Nhà cung cấp"));
		pnlXe.add(txtNCC= new JTextField());
		
		txtMaXe.setEditable(false);
		txtTenXe.setEditable(false);
		txtDonGia.setEditable(false);
		txtThanhTien.setEditable(false);
		txtTenNV.setEditable(false);
		txtMauXe.setEditable(false);
		txtNCC.setEditable(false);
		txtLoaiXe.setEditable(false);
		
		
		lblMaXe.setBounds(50,20, w1, h);txtMaXe.setBounds(150,20, w2, h);
		lblTenXe.setBounds(550, 20, w1, h);txtTenXe.setBounds(650, 20, w2, h);
		
		lblSoLuuong.setBounds(50, 65, w1, h);txtSoLuong.setBounds(150, 65, w2, h);
		lblDonGia.setBounds(550, 65, w1, h);txtDonGia.setBounds(650, 65, w2, h);
		
		lblMauXe.setBounds(50, 110, w1, h);txtMauXe.setBounds(150, 110, w2, h);
		lblLoaiXe.setBounds(550, 110, w1, h);txtLoaiXe.setBounds(650, 110, w2, h);
		
		lblNCC.setBounds(50, 155, w1, h);txtNCC.setBounds(150, 155, w2, h);
		lblThanhTien.setBounds(550, 155, w1, h);txtThanhTien.setBounds(650, 155, w2, h);
		
		
	
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnlContent.add(split);
		split.setBounds(0, 470, 1055, 40);
		JPanel pnlRight,pnlLeft;
		split.add(pnlLeft=new JPanel());
		split.add(pnlRight=new JPanel());
		pnlLeft.add(btnChon);
		pnlLeft.add(btnThanhToan1);
		pnlLeft.add(btnThanhToan2);
		pnlRight.add(btnXoa);
		lblTongTien=new JLabel("Tổng tiền");
		txtTongTien=new JTextField(15);
		pnlRight.add(lblTongTien);
		pnlRight.add(txtTongTien);
		
		
		JScrollPane scroll1;
		String[] header={"Mã xe","Tên xe","Màu xe","Loại xe","Nhà cung cấp","Đơn giá","Số lượng"};
		dataModel1=new DefaultTableModel(header,0);
		scroll1=new JScrollPane(table1=new JTable(dataModel1),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll1.setBorder(BorderFactory.createTitledBorder("Danh Sách xe"));
		table1.setRowHeight(20);
		scroll1.setPreferredSize(new Dimension(500,230));
		
		JScrollPane scroll2;
		String[] headers= {"Mã xe","Tên xe","Số lượng","Đơn giá","Thành tiền","Ngày Trả"};
		dataModel2=new DefaultTableModel(headers,0);
		scroll2=new JScrollPane(table2=new JTable(dataModel2),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll2.setBorder(BorderFactory.createTitledBorder("Danh Sách đặt hàng"));
		table2.setRowHeight(20);
		scroll2.setPreferredSize(new Dimension(500,230));
		
		Box b=Box.createHorizontalBox();
		Box b1,b2;
		
		b.add(b1=Box.createHorizontalBox());
		b1.add(scroll1);
		
		
		b.add(b2=Box.createHorizontalBox());
		b2.add(scroll2);
		
		add(b,BorderLayout.SOUTH);
		
		frmkh=new FrmKhachHang();
		frmkh.getbtnDatHang().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtTenKH.setText(frmkh.getTenKH());
				txtTenKH.setEditable(false);
				txtDiaChi.setText(frmkh.getDiaChi());
				txtDiaChi.setEditable(false);
				txtMaKH.setText(frmkh.getMaKH());
				txtMaKH.setEditable(false);
				txtSDT.setText(frmkh.getSDT());
				txtSDT.setEditable(false);
			}
		});
		
		btnChon.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		table1.addMouseListener(this);
		btnHoaDon.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnBaoHanh.addActionListener(this);
		btnXeMay.addActionListener(this);
		btnThoat.addActionListener(this);
		btnThanhToan1.addActionListener(this);
		btnThanhToan2.addActionListener(this);
		
		connectDB.instance.connect();
		updateTableData();
	}
	private void setDefaultLookAndFeelDecorated(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
	private void clearTextfields() {
		txtTenXe.setText("");
		txtSoLuong.setText("");
		txtDonGia.setText("");
		txtThanhTien.setText("");
		txtNgayLap.setText("");	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=table1.getSelectedRow();
		txtMaXe.setText(table1.getValueAt(row, 0).toString());
		txtTenXe.setText(table1.getValueAt(row, 1).toString());
		txtMauXe.setText(table1.getValueAt(row, 2).toString());
		txtLoaiXe.setText(table1.getValueAt(row, 3).toString());
		txtNCC.setText(table1.getValueAt(row, 4).toString());
		txtDonGia.setText(table1.getValueAt(row, 5).toString());
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public void tien()
	{
		double tinhTien = Integer.parseInt(txtSoLuong.getText())*Double.parseDouble((txtDonGia.getText()));
		txtThanhTien.setText(String.valueOf(tinhTien));
	}
	public void tinhTongTien(double tt2)
	{
	double togTien = 0;
	togTien = togTien + tt2;
	txtTongTien.setText(Double.toString(togTien));
	}
	private boolean validData() {
		String mahd=txtMaHD.getText().trim();
		String soluong=txtSoLuong.getText().trim();
		
		if(!(mahd.length()>0)) {
			JOptionPane.showMessageDialog(this, "Mã hợp đồng không được để trống");
			return false;
		}
		if(!(soluong.length()>0)) {
			JOptionPane.showMessageDialog(this, "Số luọng phải lớn hơn 0 và nhỏ hơn số lượng trong kho");
			return false;
		}
		return true;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnChon)){
			if(validData()) {
				tien();
				if(dsmh.create(txtMaHD.getText(),txtMaXe.getText(),txtTenXe.getText(),Integer.parseInt(txtSoLuong.getText()),Double.parseDouble(txtDonGia.getText()),Double.parseDouble(txtThanhTien.getText()),txtNgayLap.getText(),txtMaHD.getText())){
					Object[] rowData= {txtMaXe.getText(),txtTenXe.getText(),Integer.parseInt(txtSoLuong.getText()),Double.parseDouble(txtDonGia.getText()),Double.parseDouble(txtThanhTien.getText()),txtNgayLap.getText()};
					dataModel2.addRow(rowData);
					tinhTongTien(Double.parseDouble(txtThanhTien.getText().toString()));
				//	txtThanhTien.setText();
				}
			}
		}
		else if(o.equals(btnXoa)) {
			int row=table2.getSelectedRow();
			if(row>=0) {
				String mahd=(String) table2.getValueAt(row, 0);
				if(dsmh.delete(mahd)) {
					dataModel2.removeRow(row);
					clearTextfields();
				}
			}
		}
		else if(o.equals(btnThoat)) {
			System.exit(0);
		}
		else if(o.equals(btnXeMay)) {
			new FrmXe();
			this.dispose();
		}
		if(o.equals(btnNhanVien)) {
			new FrmNhanVien();
			this.dispose();
		}
		if(o.equals(btnHoaDon)) {
			new FrmMuaHang();
			this.dispose();
		}
		if(o.equals(btnKhachHang)) {
			new FrmKhachHang();
			this.dispose();
		}
		if(o.equals(btnBaoHanh)) {
			new FrmTimKiemHD();
			this.dispose();
		}
		if(o.equals(btnThanhToan1)) {
			this.dispose();
		}
		if(o.equals(btnThanhToan2)) {
			new FrmHopDongTraHet();
		}
	}
	private void updateTableData() {
		DanhSachXe dsx=new DanhSachXe();
		List<Xe> list=dsx.docTubang();
		for(Xe x : list) {
			String[] rowData= {x.getMaXe(),x.getTenXe(),x.mauXe,x.loaiXe,x.nhaCungCap,x.getGiaXe()+"",x.getSoLuong()+""};
			dataModel1.addRow(rowData);
		}
		table1.setModel(dataModel1);
	}
	public JButton getButton1() {
		return btnThanhToan1;
	}
	public JButton getButton2() {
		return btnThanhToan2;
	}
	public String getMaXe() {
		return txtMaXe.getText();
	}
	public String getTenXe() {
		return txtTenXe.getText();
	}
	public String getSoLuong() {
		return txtSoLuong.getText();
	}
	public String getDonGia() {
		return txtDonGia.getText();
	}
	public String getNgayLap() {
		return txtNgayLap.getText();
	}
	public String getTenKH() {
		return txtTenKH.getText();
	}
	public String getThanhTien() {
		return txtThanhTien.getText();
	}
	public String getMaHopDong() {
		return txtMaHD.getText();
	}
}

