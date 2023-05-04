package HoaDon;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ConnectDB.connectDB;
import KhachHang.FrmKhachHang;
import MuaHang.FrmMuaHang;
import NhanVien.FrmNhanVien;
import TimKiemNhanVien.FrmTimKiemHD;
import xe.FrmXe;

public class FrmHopDongTraHet extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaHD;
	private JTextField txtTenKH;
	private JTextField txtNgayLap;
	private JTextField txtSoTienTra;
	private JTextField txtTenXe;
	private JTextField txtDonGia;
	private JTextField txtSoLuong;
	private JTextField txtThanhTien;
	private JTextField txtTim;

	private JLabel lblMaHD;
	private JLabel lblTenKH;
	private JLabel lblNgayLap;
	private JLabel lblSoTienTra;
	@SuppressWarnings("unused")
	private JLabel lblLanTra;
	private JLabel lblTenXe;
	private JLabel lblDonGia;
	private JLabel lblSoLuuong;
	private JLabel lblThanhTien;
	@SuppressWarnings("unused")
	private JLabel lblTieuDe;

	private JButton btnThem;
	private JButton btnXoa;
	@SuppressWarnings("unused")
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
	private JButton btnXemHDTG;

	@SuppressWarnings("unused")
	private FrmMuaHang frmmuahang;

	private JTable table;
	public static DefaultTableModel dataModel;
	DanhSachHopDongTraHet dshdth = new DanhSachHopDongTraHet();

	public FrmHopDongTraHet() throws HeadlessException {
		setSize(1055, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setResizable(true);
		setDefaultLookAndFeelDecorated(EXIT_ON_CLOSE);

		/**
		 * Panel Menu
		 */
		JPanel pnlMenu = new JPanel();
		add(pnlMenu);
		pnlMenu.setBounds(0, 0, 1055, 50);
		pnlMenu.setBackground(Color.gray);
		pnlMenu.setLayout(null);

		pnlMenu.add(btnTrangChu = new JButton("TRANG CHỦ"));
		btnTrangChu.setFont(new Font("arial", Font.BOLD, 17));
		btnTrangChu.setForeground(Color.white);
		btnTrangChu.setBackground(Color.gray);

		pnlMenu.add(btnXeMay = new JButton("XE MÁY"));
		btnXeMay.setFont(new Font("arial", Font.BOLD, 17));
		btnXeMay.setForeground(Color.white);
		btnXeMay.setBackground(Color.gray);

		pnlMenu.add(btnHoaDon = new JButton("HÓA ĐƠN"));
		btnHoaDon.setFont(new Font("arial", Font.BOLD, 17));
		btnHoaDon.setForeground(Color.white);
		btnHoaDon.setBackground(Color.gray);

		pnlMenu.add(btnNhanVien = new JButton("NHÂN VIÊN"));
		btnNhanVien.setFont(new Font("arial", Font.BOLD, 17));
		btnNhanVien.setForeground(Color.white);
		btnNhanVien.setBackground(Color.gray);

		pnlMenu.add(btnKhachHang = new JButton("KHÁCH HÀNG"));
		btnKhachHang.setFont(new Font("arial", Font.BOLD, 17));
		btnKhachHang.setForeground(Color.white);
		btnKhachHang.setBackground(Color.gray);

		pnlMenu.add(btnBaoHanh = new JButton("TÌM KIẾM"));
		btnBaoHanh.setFont(new Font("arial", Font.BOLD, 17));
		btnBaoHanh.setForeground(Color.white);
		btnBaoHanh.setBackground(Color.gray);

		pnlMenu.add(btnGioiThieu = new JButton("GIỚI THIỆU"));
		btnGioiThieu.setFont(new Font("arial", Font.BOLD, 17));
		btnGioiThieu.setForeground(Color.white);
		btnGioiThieu.setBackground(Color.gray);

		pnlMenu.add(btnThoat = new JButton("THOÁT"));
		btnThoat.setFont(new Font("arial", Font.BOLD, 17));
		btnThoat.setForeground(Color.white);
		btnThoat.setBackground(Color.gray);

		btnTrangChu.setBounds(0, 0, 150, 50);
		btnXeMay.setBounds(150, 0, 150, 50);
		btnNhanVien.setBounds(300, 0, 150, 50);
		btnHoaDon.setBounds(450, 0, 150, 50);
		btnKhachHang.setBounds(600, 0, 150, 50);
		btnBaoHanh.setBounds(750, 0, 150, 50);
		btnThoat.setBounds(900, 0, 150, 50);
		/**
		 * Panel Banner
		 */
		JPanel pnlBanner = new JPanel();
		add(pnlBanner);
		pnlBanner.setBounds(0, 50, 1055, 30);
		JLabel lblTieuDe;
		pnlBanner.add(lblTieuDe = new JLabel("QUẢN LÝ HÓA ĐƠN TRẢ HẾT"));
		lblTieuDe.setFont(new Font("arial", Font.BOLD, 20));
		/**
		 * Panel Content
		 */
		JPanel pnlContent = new JPanel();
		add(pnlContent);
		pnlContent.setBounds(0, 80, 1055, 290);
		pnlContent.setLayout(null);

		JPanel pnlL = new JPanel();
		pnlContent.add(pnlL);
		pnlL.setLayout(null);
		pnlL.setBounds(0, 80, 1035, 285);

		pnlL.setBorder(new TitledBorder(BorderFactory.createLoweredBevelBorder(), "Thông tin chung"));

		pnlL.add(lblMaHD = new JLabel("Mã HD:"));
		pnlL.add(txtMaHD = new JTextField());
		pnlL.add(lblTenKH = new JLabel("Tên KH"));
		pnlL.add(txtTenKH = new JTextField());
		pnlL.add(lblTenXe = new JLabel("Tên xe "));
		pnlL.add(txtTenXe = new JTextField());
		pnlL.add(lblSoLuuong = new JLabel("Số lượng"));
		pnlL.add(txtSoLuong = new JTextField());
		pnlL.add(lblDonGia = new JLabel("Đơn giá"));
		pnlL.add(txtDonGia = new JTextField());
		pnlL.add(lblThanhTien = new JLabel("Thành tiền"));
		pnlL.add(txtThanhTien = new JTextField());
		pnlL.add(lblSoTienTra = new JLabel("Số tiền trả"));
		pnlL.add(txtSoTienTra = new JTextField());
		pnlL.add(lblNgayLap = new JLabel("Ngày lập"));
		pnlL.add(txtNgayLap = new JTextField());

		pnlContent.add(btnXemHDTG = new JButton("Xem hợp đồng trả góp"));
		pnlContent.add(btnThem = new JButton("Thêm"));
		pnlContent.add(btnXoa = new JButton("Xóa"));
		pnlContent.add(btnXoaTrang = new JButton("Xóa trắng"));
		pnlContent.add(btnLuu = new JButton("Lưu"));
		btnThem.setBackground(Color.gray);
		btnThem.setForeground(Color.white);
		btnXoa.setBackground(Color.gray);
		btnXoa.setForeground(Color.white);
		btnXoaTrang.setBackground(Color.gray);
		btnXoaTrang.setForeground(Color.white);
		btnLuu.setBackground(Color.gray);
		btnLuu.setForeground(Color.white);

		int w1 = 100, w2 = 300, h = 25;
		lblMaHD.setBounds(50, 40, w1, h);
		txtMaHD.setBounds(150, 40, w2, h);
		lblTenKH.setBounds(550, 40, w1, h);
		txtTenKH.setBounds(650, 40, w2, h);

		lblTenXe.setBounds(50, 90, w1, h);
		txtTenXe.setBounds(150, 90, w2, h);
		lblSoLuuong.setBounds(550, 90, w1, h);
		txtSoLuong.setBounds(650, 90, w2, h);

		lblDonGia.setBounds(50, 140, w1, h);
		txtDonGia.setBounds(150, 140, w2, h);
		lblThanhTien.setBounds(550, 140, w1, h);
		txtThanhTien.setBounds(650, 140, w2, h);

		lblSoTienTra.setBounds(50, 190, w1, h);
		txtSoTienTra.setBounds(150, 190, w2, h);
		lblNgayLap.setBounds(550, 190, w1, h);
		txtNgayLap.setBounds(650, 190, w2, h);

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnlContent.add(split);
		split.setBounds(0, 370, 1055, 40);
		JPanel pnlRight, pnlLeft;
		split.add(pnlLeft = new JPanel());
		split.add(pnlRight = new JPanel());

		String[] cbxStr = { "Mã hóa đơn" };
		JComboBox<?> cbxTim = new JComboBox<Object>(cbxStr);
		pnlLeft.add(txtTim = new JTextField(15));
		txtTim.setEnabled(true);
		txtTim.setDisabledTextColor(Color.GRAY);
		pnlLeft.add(cbxTim);
		pnlLeft.add(btnTim = new JButton("Tìm"));
		pnlRight.add(btnXemHDTG);
		pnlRight.add(btnThem);
		pnlRight.add(btnXoa);
		pnlRight.add(btnXoaTrang);
		pnlRight.add(btnLuu);

		JScrollPane scroll;
		String[] header = { "MaHD", "TenKH", "ten xe", "SoLuong", "DonGia", "ThanhTien", "So tien tra", "ngay lap" };
		dataModel = new DefaultTableModel(header, 0);
		add(scroll = new JScrollPane(table = new JTable(dataModel), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách Hợp Đồng Trả Hết"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 240));

		/*
		 * frmmuahang =new FrmMuaHang(); frmmuahang.getButton2().addActionListener(new
		 * ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
		 * method stub
		 * 
		 * txtTenKH.setText(frmmuahang.getTenKH());
		 * txtTenXe.setText(frmmuahang.getTenXe());
		 * txtSoLuong.setText(frmmuahang.getSoLuong());
		 * txtDonGia.setText(frmmuahang.getDonGia());
		 * txtThanhTien.setText(frmmuahang.getThanhTien());
		 * txtNgayLap.setText(frmmuahang.getNgayLap()); } });
		 */
		btnTim.addActionListener(this);
		btnXemHDTG.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnLuu.addActionListener(this);
		table.addMouseListener(this);
		btnHoaDon.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnBaoHanh.addActionListener(this);
		btnXeMay.addActionListener(this);
		btnThoat.addActionListener(this);
		connectDB.instance.connect();
		updateTableData();
	}

	private void setDefaultLookAndFeelDecorated(int exitOnClose) {
		// TODO Auto-generated method stub

	}

	private void clearTextfields() {
		txtMaHD.setText("");
		txtTenXe.setText("");
		txtTenKH.setText("");
		txtSoLuong.setText("");
		txtDonGia.setText("");
		txtThanhTien.setText("");
		txtSoTienTra.setText("");
		txtNgayLap.setText("");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		txtMaHD.setText(table.getValueAt(row, 0).toString());
		txtTenKH.setText(table.getValueAt(row, 1).toString());
		txtTenXe.setText(table.getValueAt(row, 2).toString());
		txtSoLuong.setText(table.getValueAt(row, 3).toString());
		txtDonGia.setText(table.getValueAt(row, 4).toString());
		txtThanhTien.setText(table.getValueAt(row, 5).toString());
		txtSoTienTra.setText(table.getValueAt(row, 6).toString());
		txtNgayLap.setText(table.getValueAt(row, 7).toString());
		txtMaHD.setEditable(false);
		txtTenKH.setEditable(false);
		txtTenXe.setEditable(false);
		txtSoLuong.setEditable(false);
		txtDonGia.setEditable(false);
		txtThanhTien.setEditable(false);
		txtSoTienTra.setEditable(false);
		txtNgayLap.setEditable(false);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		/*
		 * if(e.equals(btnThem)){ clearTextfields(); } else if(o.equals(btnLuu)) {
		 * if(dshdtg.create(txtMaHD.getText(), txtTenKH.getText(), txtTenXe.getText(),
		 * Integer.parseInt(txtSoLuong.getText()),
		 * Double.parseDouble(txtDonGia.getText()),Integer.parseInt(txtlanTra.getText())
		 * , Double.parseDouble(txtSoTienTra.getText()),txtNgayTra.getText())) {
		 * Object[] rowData= {txtMaXe.getText(), txtTenXe.getText(),
		 * txtLoaiXe.getText(), txtSoMay.getText(), txtSoKhung.getText(),
		 * txtMauXe.getText(), txtNuocSX.getText(), txtSoLuong.getText(),
		 * txtGia.getText(), txtNhaCungCap.getText()}; dataModel.addRow(rowData); } }
		 */
		/*
		 * if(o.equals(btnSua)) { int row =table.getSelectedRow(); if(row>=0) {
		 * if(dshdth.update(txtMaHD.getText(),
		 * txtTenKH.getText(),txtTenXe.getText(),Integer.parseInt(txtSoLuong.getText()),
		 * Double.parseDouble(txtDonGia.getText()),
		 * Double.parseDouble(txtThanhTien.getText()),Double.parseDouble(txtSoTienTra.
		 * getText()), txtNgayLap.getText())) { table.setValueAt(txtMaHD.getText(), row,
		 * 1); table.setValueAt(txtTenKH.getText(), row, 2);
		 * table.setValueAt(txtTenXe.getText(), row, 3);
		 * table.setValueAt(txtSoLuong.getText(), row, 4);
		 * table.setValueAt(txtDonGia.getText(), row, 5);
		 * table.setValueAt(txtThanhTien.getText(), row, 6);
		 * table.setValueAt(txtSoTienTra.getText(), row, 7);
		 * table.setValueAt(txtNgayLap.getText(), row, 8); } } }
		 */
		if (o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row >= 0) {
				String mahd = (String) table.getValueAt(row, 0);
				if (dshdth.delete(mahd)) {
					dataModel.removeRow(row);
					clearTextfields();
				}
			}
		} else if (o.equals(btnTim)) {
			String mahd = txtTim.getText();
			table.clearSelection();

			String ktma = "";
			for (int i = 0; i < table.getRowCount(); i++) {
				ktma = table.getValueAt(i, 0).toString();
				if (ktma.equals(mahd)) {
					table.addRowSelectionInterval(i, i);
					break;
				}
			}

		} else if (o.equals(btnThoat)) {
			System.exit(0);
		} else if (o.equals(btnXeMay)) {
			new FrmXe();
			this.dispose();
		}
		if (o.equals(btnNhanVien)) {
			new FrmNhanVien();
			this.dispose();
		}
		if (o.equals(btnHoaDon)) {
			new FrmHopDongTraHet();
			this.dispose();
		}
		if (o.equals(btnKhachHang)) {
			new FrmKhachHang();
			this.dispose();
		}
		if (o.equals(btnBaoHanh)) {
			new FrmTimKiemHD();
			this.dispose();
		}
		if (o.equals(btnXemHDTG)) {
			new FrmHopDongTraGop();
			this.dispose();
		}
	}

	private void updateTableData() {
		Locale localeEN = new Locale("en", "EN");
		NumberFormat en = NumberFormat.getInstance(localeEN);
		DanhSachHopDongTraHet dshdth = new DanhSachHopDongTraHet();
		List<HopDongTraHet> list = dshdth.docTuBang();
		for (HopDongTraHet hd : list) {
			String[] rowData = { hd.getMaHD(), hd.getTenKH(), hd.getTenxe(), hd.getSoLuong() + "",
					en.format(hd.getDonGia()) + "", en.format(hd.getThanhTien()) + "",
					en.format(hd.getSoTienTraHet()) + "", hd.getNgayLap() };
			dataModel.addRow(rowData);
		}
		table.setModel(dataModel);
	}

}
