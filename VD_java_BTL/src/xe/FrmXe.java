package xe;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.AbstractButton;
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
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import ConnectDB.connectDB;
import HoaDon.FrmHopDongTraGop;
import KhachHang.FrmKhachHang;
import NhanVien.FrmNhanVien;
import TimKiemNhanVien.FrmTimKiemHD;
import TrangChu.JMenuTrangChu;

public class FrmXe extends JFrame implements ActionListener,MouseListener{
	public JTextField txtMaXe; 
	public JTextField txtTenXe;
	public JTextField txtLoaiXe;
	public JTextField txtSoMay;
	public JTextField txtSoKhung;
	public JTextField txtMauXe;
	public JTextField txtNuocSX;
	public JTextField txtSoLuong;
	public JTextField txtGia;
	public JTextField txtNhaCungCap;
	public JTextField txtTim;
	
	public JLabel lblMaXe;
	public JLabel lblTenXe;
	public JLabel lblLoaiXe;
	public JLabel lblSoMay;
	public JLabel lblSoKhung;
	public JLabel lblMauXe;
	public JLabel lblNuocSX;
	public JLabel lblSoLuong;
	public JLabel lblGia;
	public JLabel lblNhaCungCap;
	public JLabel lblTieuDe;
	
	public JButton btnThem;
	public JButton btnXoa;
	public JButton btnSua;
	public JButton btnXoaTrang;
	public JButton btnLuu;
	public JButton btnTrangChu;
	public JButton btnXeMay;
	public JButton btnHoaDon;
	public JButton btnNhanVien;
	public JButton btnKhachHang;
	public JButton btnBaoHanh;
	public JButton btnGioiThieu;
	public JButton btnThoat;
	public JButton btnTim;
	private DanhSachXe dsXe;
	private JComboBox<String> cbxTim;
	
	public JTable table;
	public static DefaultTableModel dataModel;
	DanhSachXe dsxe=new DanhSachXe();
	public FrmXe() throws HeadlessException{
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
		pnlBanner.add(lblTieuDe=new JLabel("QUẢN LÝ THÔNG TIN XE"));
		lblTieuDe.setFont(new Font("arial",Font.BOLD,20));
		lblTieuDe.setForeground(Color.red);
		/**
		 * Panel Content
		 */
		JPanel pnlContent=new JPanel();
		add(pnlContent);
		pnlContent.setBounds(0,80,1055,320);
		pnlContent.setLayout(null);
		
		
		
		pnlContent.add(lblMaXe=new JLabel("Mã xe:"));
		pnlContent.add(txtMaXe=new JTextField());
		pnlContent.add(lblTenXe=new JLabel("Tên xe"));
		pnlContent.add(txtTenXe=new JTextField());
		pnlContent.add(lblLoaiXe=new JLabel("Loại xe"));
		pnlContent.add(txtLoaiXe=new JTextField());
		pnlContent.add(lblSoMay=new JLabel("Số máy"));
		pnlContent.add(txtSoMay=new JTextField());
		pnlContent.add(lblSoKhung=new JLabel("Số khung"));
		pnlContent.add(txtSoKhung=new JTextField());
		pnlContent.add(lblMauXe=new JLabel("Màu xe"));
		pnlContent.add(txtMauXe=new JTextField());
		pnlContent.add(lblNuocSX=new JLabel("Nước SX"));
		pnlContent.add(txtNuocSX=new JTextField());
		pnlContent.add(lblSoLuong=new JLabel("Số lượng"));
		pnlContent.add(txtSoLuong=new JTextField());
		pnlContent.add(lblGia=new JLabel("Giá"));
		pnlContent.add(txtGia=new JTextField());
		pnlContent.add(lblNhaCungCap=new JLabel("Nhà cung cấp"));
		pnlContent.add(txtNhaCungCap=new JTextField());
		
		/**
		 * Mu
		 */

		pnlContent.add(btnThem=new JButton("Thêm"));
		pnlContent.add(btnXoa=new JButton("Xóa"));
		pnlContent.add(btnSua=new JButton("Sửa"));
		pnlContent.add(btnXoaTrang=new JButton("Xóa trắng"));
		pnlContent.add(btnLuu=new JButton("Lưu"));
	
		int w1=100, w2=300, h=25;
		lblMaXe.setBounds(50,100, w1, h);txtMaXe.setBounds(150,100, w2, h);
		lblTenXe.setBounds(550, 100, w1, h);txtTenXe.setBounds(650, 100, w2, h);
		
		lblLoaiXe.setBounds(50, 150, w1, h);txtLoaiXe.setBounds(150, 150, w2, h);
		lblSoMay.setBounds(550, 150, w1, h);txtSoMay.setBounds(650, 150, w2, h);
		
		lblMauXe.setBounds(50, 200, w1, h);txtMauXe.setBounds(150, 200, w2, h);
		lblSoKhung.setBounds(550, 200, w1, h);txtSoKhung.setBounds(650, 200, w2, h);
		
		lblSoLuong.setBounds(50, 250, w1, h);txtSoLuong.setBounds(150, 250, w2, h);
		lblNuocSX.setBounds(550, 250, w1, h);txtNuocSX.setBounds(650, 250, w2, h);
		
		lblGia.setBounds(50, 300, w1, h);txtGia.setBounds(150, 300, w2, h);
		lblNhaCungCap.setBounds(550, 300, w1, h);txtNhaCungCap.setBounds(650, 300, w2, h);
		
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnlContent.add(split);
		split.setBounds(0, 340, 1055, 40);
		JPanel pnlRight,pnlLeft;
		split.add(pnlLeft=new JPanel());
		split.add(pnlRight=new JPanel());
		
		
		
		String[] cbxStr = {"Mã xe","Tên xe"};
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
		String[] header= {"Mã xe","Tên xe","Loại xe","Số máy","Số Khung","Màu","Nước SX","Số lượng kho","Giá","Nhà cung cấp"};
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
		txtMaXe.setText("");
		txtTenXe.setText("");
		txtGia.setText("");
		txtLoaiXe.setText("");
		txtSoKhung.setText("");
		txtSoMay.setText("");
		txtSoLuong.setText("");
		txtMauXe.setText("");
		txtSoLuong.setText("");
		txtNhaCungCap.setText("");
		txtNuocSX.setText("");
		txtMaXe.setEditable(true);
		txtMaXe.requestFocus();
	}
	private void updateTableData() {
		Locale localeEN = new Locale("en", "EN");
	    NumberFormat en = NumberFormat.getInstance(localeEN);
		DanhSachXe dsxe=new DanhSachXe();
			List<Xe> list=dsxe.docTubang();
			
		for(Xe x : list) {
			String[] rowData= {x.getMaXe(),x.getTenXe(),x.getLoaiXe(),x.getSoMay()+"",x.getSoKhung()+"",x.getMauXe(),x.getNuocSX(),x.getSoLuong()+"",en.format(x.getGiaXe())+"",x.getNhaCungCap()};
			dataModel.addRow(rowData);
		}
		table.setModel(dataModel);
	}
	private void fillForm(int row) {
		if(row!=-1) {
			String maxe=(String) table.getValueAt(row, 0);
			Xe x=new Xe(maxe);
			ArrayList<Xe> ds=dsxe.getDsXe();
			if(dsxe.getDsXe().contains(x)) {
				x=ds.get(ds.indexOf(x));
				txtMaXe.setText(x.getMaXe());
				txtTenXe.setText(x.getTenXe());
				txtLoaiXe.setText(x.getLoaiXe());
				txtSoMay.setText(x.getSoMay()+"");
				txtSoKhung.setText(x.getSoKhung()+"");
				txtMauXe.setText(x.getMauXe());
				txtNuocSX.setText(x.getNuocSX());
				txtSoLuong.setText(x.getSoLuong()+"");
				txtGia.setText(x.getGiaXe()+"");
				txtNhaCungCap.setText(x.getNhaCungCap());
				txtMaXe.setEditable(false);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=table.getSelectedRow();
		txtMaXe.setText(table.getValueAt(row, 0).toString());
		txtTenXe.setText(table.getValueAt(row, 1).toString());
		txtLoaiXe.setText(table.getValueAt(row, 2).toString());
		txtSoMay.setText(table.getValueAt(row, 3).toString());
		txtSoKhung.setText(table.getValueAt(row, 4).toString());
		txtMauXe.setText(table.getValueAt(row, 5).toString());
		txtNuocSX.setText(table.getValueAt(row, 6).toString());
		txtSoLuong.setText(table.getValueAt(row, 7).toString());
		txtGia.setText(table.getValueAt(row, 8).toString());
		txtNhaCungCap.setText(table.getValueAt(row, 9).toString());
		txtMaXe.setEditable(false);
		
		
		
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
					String ma=txtMaXe.getText();
					String ten=txtTenXe.getText();
					String loai=txtLoaiXe.getText();
					String somay=txtSoMay.getText();
					String sokhung=txtSoKhung.getText();
					String mau=txtMauXe.getText();
					String nuoc=txtNuocSX.getText();
					int soluong=Integer.parseInt(txtSoLuong.getText());
					Double gia=Double.parseDouble(txtGia.getText());
					String nha=txtNhaCungCap.getText();
					Xe xe=new Xe(ma, ten, loai, somay, sokhung, mau, nuoc, soluong, gia, nha);
				if(dsxe.create(ma, ten, loai, somay, sokhung, mau, nuoc, soluong, gia, nha) && dsxe.them(xe)) {
					Object[] rowData= {ma, ten, loai, somay, sokhung, mau, nuoc, soluong, gia, nha};
					dataModel.addRow(rowData);
				}
				else {
					JOptionPane.showMessageDialog(null, "Trùng mã");
					txtMaXe.selectAll();
					txtMaXe.requestFocus();
				}
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}
		else if(o.equals(btnLuu)) {
			if(dsxe.create(txtMaXe.getText(), txtTenXe.getText(), txtLoaiXe.getText(),txtSoMay.getText(),txtSoKhung.getText(), txtMauXe.getText(), txtNuocSX.getText(), Integer.parseInt(txtSoLuong.getText()), Double.parseDouble(txtGia.getText()), txtNhaCungCap.getText())) {
				Object[] rowData= {txtMaXe.getText(), txtTenXe.getText(), txtLoaiXe.getText(), txtSoMay.getText(), txtSoKhung.getText(), txtMauXe.getText(), txtNuocSX.getText(), txtSoLuong.getText(), txtGia.getText(), txtNhaCungCap.getText()};
				dataModel.addRow(rowData);
			}
		}
		else if(o.equals(btnSua)) {
			if(validData()) {
			int row =table.getSelectedRow();
			if(row>=0) {
				if(dsxe.update(txtMaXe.getText(), txtTenXe.getText(),txtLoaiXe.getText(),txtSoMay.getText().toString(),txtSoKhung.getText().toString(), txtMauXe.getText(), txtNuocSX.getText(),Integer.parseInt(txtSoLuong.getText().toString()),Double.parseDouble(txtGia.getText()) , txtNhaCungCap.getText())) {
					table.setValueAt(txtTenXe.getText(), row, 1);
					table.setValueAt(txtLoaiXe.getText(), row, 2);
					table.setValueAt(txtSoMay.getText(), row, 3);
					table.setValueAt(txtSoKhung.getText(), row, 4);
					table.setValueAt(txtMauXe.getText(), row, 5);
					table.setValueAt(txtNuocSX.getText(), row, 6);
					table.setValueAt(txtSoLuong.getText(), row, 7);
					table.setValueAt(txtGia.getText(), row, 8);
					table.setValueAt(txtNhaCungCap.getText(), row, 9);
					
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
			String maXe = txtMaXe.getText().trim();
			String tenXe = txtTenXe.getText().trim();
			String soMay = txtSoMay.getText().trim();
			String soKhung = txtSoKhung.getText().trim();
			String mauXe = txtMauXe.getText().trim();
			String nuocSX = txtNuocSX.getText().trim();
			String soLuong = txtSoLuong.getText().trim();
			String gia = txtGia.getText().trim();
			String nhaCC = txtNhaCungCap.getText().trim();
			
			if(!(maXe.length()>0)) {
				JOptionPane.showMessageDialog(this, "Mã xe không được để trống");
				return false;
			}
			if(!(tenXe.length()>0)) {

				JOptionPane.showMessageDialog(this, "Tên xe không được để trống");
				return false;
			}
			if(!(mauXe.length()>0)) {
				JOptionPane.showMessageDialog(this, "Màu xe không được để trống");
				return false;
			}
			if(!(nuocSX.length()>0)) {
				JOptionPane.showMessageDialog(this, "Nước sản xuất không được để trống");
				return false;
			}
			if(!(nhaCC.length()>0)) {
				JOptionPane.showMessageDialog(this, "Nhà cung cấp không được để trống");
				return false;
			}
			if(!(gia.length()>0)) {
					JOptionPane.showMessageDialog(this, "Giá tiền không được để trống");
					return false;
			}
			if(!(soMay.length()>0)) {
				JOptionPane.showMessageDialog(this, "Số máy không được để trống");
				return false;
			}
			if(!(soKhung.length()>0)) {
				JOptionPane.showMessageDialog(this, "Số khung không được để trống");
				return false;
			}
			if(!(soLuong.length()>0)) {
				JOptionPane.showMessageDialog(this, "Số luọng phải lớn hơn 0");
				return false;
			}
				

			return true;
		}
	
}
