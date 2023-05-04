package NhaCungCap;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
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
import javax.swing.table.DefaultTableModel;

import ConnectDB.connectDB;
import HoaDon.FrmHopDongTraGop;
import KhachHang.FrmKhachHang;
import NhanVien.FrmNhanVien;
import TimKiemNhanVien.FrmTimKiemHD;
import TrangChu.JMenuTrangChu;
import xe.FrmXe;


public class FrmNhaCungCap extends JFrame implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable table;
	public static DefaultTableModel dataModel;
	DanhSachNCC dsxe=new DanhSachNCC();
	private JButton btnTrangChu;
	private JButton btnXeMay;
	private JButton btnHoaDon;
	private JButton btnNhanVien;
	private JButton btnKhachHang;
	private JButton btnBaoHanh;
	private JButton btnGioiThieu;
	private JButton btnThoat;
	private JLabel lblMaNCC;
	private JTextField txtMaNCC;
	private JLabel lblTenNCC;
	private JTextField txtTenNCC;
	private JLabel lblDiaChi;
	private JTextField txtDiaChi;
	private JTextField txtSDT;
	private JLabel lblSDT;
	private JTextField txtEmail;
	private JLabel lblEmail;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnXoaTrang;
	private JButton btnLuu;
	private JComboBox cbxTim;
	private JTextField txtTim;
	private JButton btnTim;
	
	DanhSachNCC dsncc = new DanhSachNCC();
	
	public FrmNhaCungCap() throws HeadlessException{
		setSize(1055,700);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultLookAndFeelDecorated(EXIT_ON_CLOSE);
		setResizable(false);
		
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
		pnlBanner.add(lblTieuDe=new JLabel("QUẢN LÝ THÔNG NHÀ CUNG CẤP"));
		lblTieuDe.setFont(new Font("arial",Font.BOLD,20));
		lblTieuDe.setForeground(Color.red);
		/**
		 * Panel Content
		 */
		JPanel pnlContent=new JPanel();
		add(pnlContent);
		pnlContent.setBounds(0,80,1055,320);
		pnlContent.setLayout(null);
		
		
		
		pnlContent.add(lblMaNCC=new JLabel("Mã nhà cung cấp"));
		pnlContent.add(txtMaNCC=new JTextField());
		pnlContent.add(lblTenNCC=new JLabel("Tên nhà cung cấp"));
		pnlContent.add(txtTenNCC=new JTextField());
		pnlContent.add(lblDiaChi=new JLabel("Địa chỉ"));
		pnlContent.add(txtDiaChi=new JTextField());
		pnlContent.add(lblSDT=new JLabel("Số điện thoại"));
		pnlContent.add(txtSDT=new JTextField());
		pnlContent.add(lblEmail=new JLabel("Email"));
		pnlContent.add(txtEmail=new JTextField());
		
		
		pnlContent.add(btnThem=new JButton("Thêm"));
		pnlContent.add(btnXoa=new JButton("Xóa"));
		pnlContent.add(btnSua=new JButton("Sửa"));
		pnlContent.add(btnXoaTrang=new JButton("Xóa trắng"));
		pnlContent.add(btnLuu=new JButton("Lưu"));
	
		int w1=100, w2=300, h=25;
		lblMaNCC.setBounds(50,100, w1, h);txtMaNCC.setBounds(150,100, w2, h);
		lblTenNCC.setBounds(550, 100, w1, h);txtTenNCC.setBounds(650, 100, w2, h);
		
		lblDiaChi.setBounds(50, 150, w1, h);txtDiaChi.setBounds(150, 150, w2, h);
		lblSDT.setBounds(550, 150, w1, h);txtSDT.setBounds(650, 150, w2, h);
		
		lblEmail.setBounds(50, 200, w1, h);txtEmail.setBounds(150, 200, w2, h);
		
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnlContent.add(split);
		split.setBounds(0, 340, 1055, 40);
		JPanel pnlRight,pnlLeft;
		split.add(pnlLeft=new JPanel());
		split.add(pnlRight=new JPanel());
		
		
		
		String[] cbxStr = {"Mã nhà cung cấp","Tên nhà cung cấp"};
		cbxTim=new JComboBox(cbxStr);
		pnlLeft.add(txtTim=new JTextField(20));
		txtTim.setEnabled(true);
		txtTim.setDisabledTextColor(Color.GRAY);
		pnlLeft.add(cbxTim);
		pnlLeft.add(btnTim=new JButton("Tìm"));
		pnlRight.add(btnThem);
		pnlRight.add(btnXoa);
		pnlRight.add(btnXoaTrang);
		pnlRight.add(btnSua);
		pnlRight.add(btnLuu);

		JScrollPane scroll;
		String[] header= {"Mã NCC","Tên NCC","Địa chỉ","Số điện thoại","Email"};
		dataModel=new DefaultTableModel(header,0);
		add(scroll=new JScrollPane(table=new JTable(dataModel),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách Xe"));
		table.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0,285));
		
		btnThem.addActionListener(this);
		
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnThoat.addActionListener(this);
		btnTrangChu.addActionListener(this);
		table.addMouseListener(this);
		btnHoaDon.addActionListener(this);
		btnKhachHang.addActionListener(this);
		btnNhanVien.addActionListener(this);
		btnBaoHanh.addActionListener(this);
		btnXeMay.addActionListener(this);
		btnThoat.addActionListener(this);
		btnTim.addActionListener(this);
		cbxTim.addActionListener(this);
		connectDB.instance.connect();
		updateTableData();
	}
	
	private void setDefaultLookAndFeelDecorated(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	private void clearTextfields() {
		txtMaNCC.setText("");
		txtTenNCC.setText("");
		txtDiaChi.setText("");
		txtEmail.setText("");
		txtSDT.setText("");
		txtMaNCC.setEditable(true);
		txtMaNCC.requestFocus();
	}
	private void updateTableData() {
		Locale localeEN = new Locale("en", "EN");
	    NumberFormat en = NumberFormat.getInstance(localeEN);
			List<NhaCungCap> list=dsncc.docTuBang();
			
		for(NhaCungCap ncc : list) {
			String[] rowData= {ncc.getMaNCC(),ncc.getTenNCC(),ncc.getDiaChiNCC(),ncc.getSDTNCC(), ncc.getEmail()};
			dataModel.addRow(rowData);
		}
		table.setModel(dataModel);
	}
	private void fillForm(int row) {
		if(row!=-1) {
			String mancc=(String) table.getValueAt(row, 0);
			NhaCungCap ncc = new NhaCungCap(mancc);
			ArrayList<NhaCungCap> ds= dsncc.getDsncc() ;
			if(dsncc.getDsncc().contains(ds))
			{
				ncc = ds.get(ds.indexOf(ds));
				txtMaNCC.setText(ncc.getMaNCC());
				txtTenNCC.setText(ncc.getTenNCC());
				txtDiaChi.setText(ncc.getDiaChiNCC());
				txtSDT.setText(ncc.getSDTNCC());
				txtEmail.setText(ncc.getEmail());
				txtMaNCC.setEditable(false);
			}
			
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		txtMaNCC.setText(table.getValueAt(row, 0).toString());
		txtTenNCC.setText(table.getValueAt(row, 1).toString());
		txtDiaChi.setText(table.getValueAt(row, 2).toString());
		txtSDT.setText(table.getValueAt(row, 3).toString());
		txtEmail.setText(table.getValueAt(row, 4).toString());
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
		
		Object o=e.getSource();
		if(o.equals(btnThem)){
			if(validData()) {
				try {
					String ma=txtMaNCC.getText();
					String ten=txtTenNCC.getText();
					String diachi=txtDiaChi.getText();
					String sdt=txtSDT.getText();
					String email=txtEmail.getText();
					NhaCungCap ncc=new NhaCungCap(ma, ten, diachi,sdt, email);
				if(dsxe.create(ma, ten, diachi, sdt, email) && dsncc.them(ncc)) {
					Object[] rowData= {ma, ten, diachi, sdt, email};
					dataModel.addRow(rowData);
				}
				else {
					JOptionPane.showMessageDialog(null, "Trùng mã");
					txtMaNCC.selectAll();
					txtMaNCC.requestFocus();
				}
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		else if(o.equals(btnLuu)) {
			if(dsxe.create(txtMaNCC.getText(), txtTenNCC.getText(), txtDiaChi.getText(), txtSDT.getText(), txtEmail.getText())){
				Object[] rowData= {txtMaNCC.getText(), txtTenNCC.getText(), txtDiaChi.getText(), txtSDT.getText(), txtEmail.getText()};
				dataModel.addRow(rowData);
			}
		}
		else if(o.equals(btnSua)) {
			if(validData()) {
			int row =table.getSelectedRow();
			if(row>=0) {
				if(dsxe.update(txtMaNCC.getText(), txtTenNCC.getText(), txtDiaChi.getText(), txtSDT.getText(), txtEmail.getText())) {
					table.setValueAt(txtTenNCC.getText(), row, 1);
					table.setValueAt(txtDiaChi.getText(), row, 2);
					table.setValueAt(txtSDT.getText(), row, 3);
					table.setValueAt(txtEmail.getText(), row, 4);
				}
			}
			}
		}
		else if(o.equals(btnXoa)) {
			int row=table.getSelectedRow();
			if(row>=0) {
				String maXe=(String) table.getValueAt(row, 0);
				if(dsxe.delete(maXe)) {
					dataModel.removeRow(row);
					clearTextfields();
				}
			}
		}
		else if(o.equals(btnTim)) {
			String maXe = txtTim.getText();
			table.clearSelection();

			String ktma = "";
			for (int i = 0; i < table.getRowCount(); i++) {
				ktma = table.getValueAt(i, 0).toString();
			if(ktma.equals(maXe)){
					table.addRowSelectionInterval(i, i);
					break;
				}
			}

		}
		else if(o.equals(btnXoaTrang)) {
			clearTextfields();
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
		if(o.equals(btnTrangChu)) {
			new JMenuTrangChu();
			this.dispose();
		}
	}
	    private boolean validData() {
			String maNCC = txtMaNCC.getText().trim();
			String tenNCC = txtTenNCC.getText().trim();
			String sdt = txtSDT.getText().trim();
			String diachi = txtDiaChi.getText().trim();
			String email = txtEmail.getText().trim();
			if(!(maNCC.length()>0)) {
				JOptionPane.showMessageDialog(this, "Mã nhà cung cấp không được để trống");
				return false;
			}
			if(!(tenNCC.length()>0)) {

				JOptionPane.showMessageDialog(this, "Tên nhà cung cấp không được để trống");
				return false;
			}
			if(!(diachi.length()>0)) {
				JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống");
				return false;
			}
			if(!(sdt.length()>0)) {
				JOptionPane.showMessageDialog(this, "Email không được để trống");
				return false;
			}

			return true;
		}
	}
