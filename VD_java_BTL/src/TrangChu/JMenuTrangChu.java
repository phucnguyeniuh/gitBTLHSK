package TrangChu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import BaoHanh.FrmBaoHanh;
import HoaDon.FrmHopDongTraGop;
import HoaDon.FrmHopDongTraGop_1;
import HoaDon.FrmHopDongTraHet;
import KhachHang.FrmKhachHang;
import NhaCungCap.FrmNhaCungCap;
import NhanVien.FrmNhanVien;
import xe.FrmXe;

public class JMenuTrangChu extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JMenuBar mnubar;
	JMenu mnuTapTin, mnuDanhMuc, mnuMuaHang, mnuTim, mnuBH, mnuBaoCao, mnuTroGiup;
	JMenuItem mnuThoat;
	JMenuItem mnuXeMay, mnuKhachHang, mnuNhanVien, mnuHoaDon, mnuBaoHanh, mnuNCC;
	JMenuItem mnuDatHang;
	JMenuItem mnuNVHanhChinh, mnuNVKyThuat;
	JMenuItem mnuHoaDonTraGop, mnuHoaDonTraHet;
	JMenuItem mnuTimXeMay, mnuTimKhachHang, mnuTimNhanVien, MnuTimHoaDon;
	JMenuItem mnuTimHDTG, mnuTimHDTH;
	JMenuItem mnuDoanhThu, mnuHangTon;

	public JMenuTrangChu() {
		mnubar = new JMenuBar();
		setJMenuBar(mnubar);

		mnuTapTin = new JMenu("Tập Tin");
		mnubar.add(mnuTapTin);
		mnuDanhMuc = new JMenu("Danh Mục");
		mnubar.add(mnuDanhMuc);
		mnuMuaHang = new JMenu("Mua Hàng");
		mnubar.add(mnuMuaHang);
		mnuTim = new JMenu("Tìm Kiếm");
		mnubar.add(mnuTim);
		mnuBH = new JMenu("Bảo Hành");
		mnubar.add(mnuBH);
		mnuTroGiup = new JMenu("Trợ Giúp");
		mnubar.add(mnuTroGiup);

		// menu File
		mnuThoat = new JMenuItem("Thoát", 't');
		mnuTapTin.add(mnuThoat);

		mnuXeMay = new JMenuItem("Xe máy");
		mnuDanhMuc.add(mnuXeMay);
		mnuKhachHang = new JMenuItem("Khách hàng");
		mnuDanhMuc.add(mnuKhachHang);
		mnuNhanVien = new JMenuItem("Nhân viên");
		mnuDanhMuc.add(mnuNhanVien);
		mnuHoaDon = new JMenu("Hóa đơn");
		mnuDanhMuc.add(mnuHoaDon);
		mnuHoaDonTraGop = new JMenuItem("Hóa đơn trả góp");
		mnuHoaDon.add(mnuHoaDonTraGop);
		mnuHoaDonTraHet = new JMenuItem("Hóa đơn trả hết");
		mnuHoaDon.add(mnuHoaDonTraHet);
		mnuNCC = new JMenuItem("Nhà cung cấp");
		mnuDanhMuc.add(mnuNCC);

		mnuDatHang = new JMenuItem("Đặt Hàng");
		mnuMuaHang.add(mnuDatHang);
		mnuBaoHanh = new JMenuItem("Bảo hành");
		mnuBH.add(mnuBaoHanh);
		MnuTimHoaDon = new JMenu("Hóa đơn");
		mnuTim.add(MnuTimHoaDon);
		mnuTimHDTG = new JMenuItem("Hóa đơn trả góp");
		MnuTimHoaDon.add(mnuTimHDTG);
		mnuTimHDTH = new JMenuItem("Hóa đơn tra hết");
		MnuTimHoaDon.add(mnuTimHDTH);
		mnuTimXeMay = new JMenuItem("Tìm xe máy");
		mnuTim.add(mnuTimXeMay);
		mnuTimKhachHang = new JMenuItem("Tìm khách hàng");
		mnuTim.add(mnuTimKhachHang);
		mnuTimNhanVien = new JMenuItem("Tìm nhân viên");
		mnuTim.add(mnuTimNhanVien);
		// Font chu
		Font font = new Font("arial", Font.BOLD, 15);
		mnuTapTin.setFont(font);
		mnuThoat.setFont(font);
		mnuDanhMuc.setFont(font);
		mnuKhachHang.setFont(font);
		mnuNhanVien.setFont(font);
		mnuHoaDon.setFont(font);
		mnuXeMay.setFont(font);
		mnuHoaDonTraGop.setFont(font);
		mnuHoaDonTraHet.setFont(font);
		mnuTim.setFont(font);
		mnuTimHDTG.setFont(font);
		mnuTimHDTH.setFont(font);
		mnuBaoHanh.setFont(font);
		mnuTroGiup.setFont(font);
		MnuTimHoaDon.setFont(font);
		mnuDatHang.setFont(font);
		mnuMuaHang.setFont(font);
		mnuBH.setFont(font);
		mnuTimKhachHang.setFont(font);
		mnuTimXeMay.setFont(font);
		mnuTimNhanVien.setFont(font);
		mnuNCC.setFont(font);
		// mau chu
		mnubar.setBackground(Color.gray);
		mnuTapTin.setForeground(Color.white);
		mnuDanhMuc.setForeground(Color.white);
		mnuTim.setForeground(Color.white);
		mnuTroGiup.setForeground(Color.white);
		mnuMuaHang.setForeground(Color.white);
		mnuBH.setForeground(Color.white);
		// ActionListener
		mnuXeMay.addActionListener(this);
		mnuKhachHang.addActionListener(this);
		mnuHoaDonTraGop.addActionListener(this);
		mnuHoaDonTraHet.addActionListener(this);
		mnuBaoHanh.addActionListener(this);
		mnuNhanVien.addActionListener(this);
		mnuThoat.addActionListener(this);
		mnuTimHDTG.addActionListener(this);
		mnuTimHDTH.addActionListener(this);
		mnuTimKhachHang.addActionListener(this);
		mnuTimXeMay.addActionListener(this);
		mnuTimNhanVien.addActionListener(this);
		mnuDatHang.addActionListener(this);
		mnuNCC.addActionListener(this);
		// Xu ly anh
		JPanel pnlcontent = new JPanel();
		JLabel lblBanner = new JLabel();
		pnlcontent.add(lblBanner);
		lblBanner.setSize(1050, 650);
		add(pnlcontent);
		setPicture(lblBanner, "HinhAnh\\anhCuaHang2.jpg");
		// banner
		// ...
		setSize(1055, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o = arg0.getSource();
	
		if (o.equals(mnuXeMay)) {
			new FrmXe();
		}
		if (o.equals(mnuKhachHang)) {
			new FrmKhachHang();
		}
		if(o.equals(mnuNCC)) {
			new FrmNhaCungCap();
		}
		if (o.equals(mnuNhanVien)) {
			new FrmNhanVien();
		}
		if (o.equals(mnuHoaDonTraHet)) {
			new FrmHopDongTraHet();
		}
		if (o.equals(mnuBaoHanh)) {
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					new FrmBaoHanh();
				}
			});
		}
		if (o.equals(mnuThoat)) {
			System.exit(0);
		}
		if (o.equals(mnuDatHang)) {
			EventQueue.invokeLater(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					new FrmHopDongTraGop();
				}
			});
		}
		if (o.equals(mnuTimHDTG)) {
			new FrmHopDongTraGop_1();
		}
		if (o.equals(mnuTimHDTH)) {
			new FrmHopDongTraHet();
		}
		if (o.equals(mnuTimXeMay)) {
			new FrmXe();
		}
		if (o.equals(mnuTimKhachHang)) {
			new FrmKhachHang();
		}
		if (o.equals(mnuTimNhanVien)) {
			new FrmNhanVien();
		}
	}

	public void setPicture(JLabel label, String filename) {
		try {
			BufferedImage image = ImageIO.read(new File(filename));
			int x = label.getSize().width;
			int y = label.getSize().height;

			int dx = x;
			int dy = y;

			ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, BufferedImage.SCALE_SMOOTH));
			label.setIcon(icon);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null, "Loi hinh anh");
		}

	}

	public static void main(String[] args) {
		new JMenuTrangChu();
	}
}