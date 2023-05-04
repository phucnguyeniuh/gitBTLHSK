package TimKiemNhanVien;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import javax.swing.table.DefaultTableModel;

import HoaDon.FrmHopDongTraGop;
import KhachHang.FrmKhachHang;
import NhanVien.FrmNhanVien;
import xe.FrmXe;

public class FrmTimKiemHD extends JFrame implements ActionListener,MouseListener{
	JLabel lblMaHD, lblMaKH, lblThang, lblNam, lblTongTien, lblMaNV;
	JTextField txtMaHD, txtMaKH, txtThang, txtNam, txtTongTien, txtMaNV;
	JTable tableHD;
	DefaultTableModel tableModelHD;
	JScrollPane scroll;
	JButton btnTimKiem, btnDong;
	private JButton btnTrangChu;
	private JButton btnXeMay;
	private JButton btnHoaDon;
	private JButton btnNhanVien;
	private JButton btnKhachHang;
	private JButton btnBaoHanh;
	private JButton btnGioiThieu;
	private JButton btnThoat;
	public FrmTimKiemHD() {
		setTitle("Tìm Kiếm Hóa Đơn");
		setSize(1055,700);
		setLocationRelativeTo(null);
		this.setVisible(true);
		setResizable(false);
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

		
		pnlMenu.add(btnBaoHanh=new JButton("BẢO HÀNH"));
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
		btnGioiThieu.setBounds(900, 0, 150, 50);
		btnThoat.setBounds(1050, 0, 150, 50);
		/**
		 * Panel Banner
		*/
		JPanel pnlBanner=new JPanel();
		add(pnlBanner);
		
		pnlBanner.setBounds(0, 50, 1055, 30);
		
		JLabel lblTieuDe;
		pnlBanner.add(lblTieuDe=new JLabel("TÌM KIẾM HÓA ĐƠN"));
		lblTieuDe.setFont(new Font("arial",Font.BOLD,20));
		/**
		 * Panel Content
		 */
		JPanel pnlContent=new JPanel();
		add(pnlContent);
		pnlContent.setBounds(0,80,1055,320);
		pnlContent.setLayout(null);
		
		pnlContent.add(lblMaHD=new JLabel("Mã hóa đơn:"));
		pnlContent.add(txtMaHD=new JTextField());
		pnlContent.add(lblMaKH=new JLabel("Mã khách hàng:"));
		pnlContent.add(txtMaKH=new JTextField());
		pnlContent.add(lblThang=new JLabel("Tháng"));
		pnlContent.add(txtThang=new JTextField());
		pnlContent.add(lblNam=new JLabel("Năm"));
		pnlContent.add(txtNam=new JTextField());
		pnlContent.add(lblTongTien=new JLabel("Tổng tiền: "));
		pnlContent.add(txtTongTien=new JTextField());
		pnlContent.add(lblMaNV=new JLabel("Mã nhân viên"));
		pnlContent.add(txtMaNV=new JTextField());
		pnlContent.add(btnTimKiem=new JButton("Tìm Kiếm"));
		pnlContent.add(btnDong=new JButton("Đóng"));
		pnlContent.add(btnTimKiem = new JButton("Tìm kiếm"));
		pnlContent.add(btnDong = new JButton("Đóng"));
		
		/*pnlContent.add(lblSoLuong=new JLabel("Số lượng"));
		pnlContent.add(txtSoLuong=new JTextField());
		pnlContent.add(lblGia=new JLabel("Giá"));
		pnlContent.add(txtGia=new JTextField());	
	 	
	 
		pnlContent.add(btnXoa=new JButton("Xóa"));
		pnlContent.add(btnSua=new JButton("Sửa"));
		pnlContent.add(btnXoaTrang=new JButton("Xóa trắng"));
		pnlContent.add(btnLuu=new JButton("Lưu"));
	*/
		int w1=100, w2=300, h=25;
		lblMaHD.setBounds(50,100, w1, h);txtMaHD.setBounds(150,100, w2, h);
		lblMaKH.setBounds(550, 100, w1, h);txtMaKH.setBounds(650, 100, w2, h);
		
		lblThang.setBounds(50, 150, w1, h);txtThang.setBounds(150, 150, 100, h);
		lblNam.setBounds(300, 150, w1, h);txtNam.setBounds(350, 150, 100, h);
		
		lblTongTien.setBounds(550, 150, w1, h);txtTongTien.setBounds(650, 150, w2, h);
		lblMaNV.setBounds(50, 200, w1, h);txtMaNV.setBounds(150, 200, w2, h);
		
		btnTimKiem.setBounds(400,250,w1,h);
		btnDong.setBounds(550,250,w1,h);
		/*
		lblSoLuong.setBounds(50, 250, w1, h);txtSoLuong.setBounds(150, 250, w2, h);
		lblGia.setBounds(550, 250, w1, h);txtGia.setBounds(650, 250, w2, h);
		
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnlContent.add(split);
		split.setBounds(0, 300, 1055, 40);
		JPanel pnlRight,pnlLeft;
		split.add(pnlLeft=new JPanel());
		split.add(pnlRight=new JPanel());
		
		/*
		String[] cbxStr = {"Mã xe","Tên xe"};
		JComboBox cbxTim=new JComboBox(cbxStr);
		pnlLeft.add(txtTimKiem=new JTextField("Tìm kiếm: "));
		txtTimKiem.setEnabled(true);
		txtTim.setDisabledTextColor(Color.GRAY);
		pnlLeft.add(cbxTim);
		pnlLeft.add(btnTim=new JButton("Tìm"));
		pnlRight.add(btnThem);
		pnlRight.add(btnXoa);
		pnlRight.add(btnXoaTrang);
		pnlRight.add(btnSua);
		pnlRight.add(btnLuu);
		*/
		JScrollPane scroll;
		String[] header="MaXe;TenXe;Gia;HangXe;SoKhung;SoMay;DungTich;SoLuong".split(";");
		tableModelHD=new DefaultTableModel(header,40);
		add(scroll=new JScrollPane(tableHD=new JTable(tableModelHD),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách Xe"));
		tableHD.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0,330));
		
		btnHoaDon.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnBaoHanh.addActionListener(this);
		btnXeMay.addActionListener(this);
		btnThoat.addActionListener(this);
		
	}

	private void setDefaultLookAndFeelDecorated(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
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
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		 if(o.equals(btnThoat)) {
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
				new FrmHopDongTraGop();
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
	}
}
