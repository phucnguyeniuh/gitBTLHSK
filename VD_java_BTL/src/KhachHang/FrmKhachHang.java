package KhachHang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

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

public class FrmKhachHang extends JFrame implements ActionListener, MouseListener {
	JLabel lblTitle, lblMaKH, lblTenKH, lblDiaChi, lblDienThoai, lblTimKiem;
	JTextField txtMaKH, txtTenKH, txtDiaChi, txtDienThoai, txtTimKiem;
	JButton btnThem, btnLuu, btnSua, btnXoa, btnXoaTrang, btnThoat, btnTimKiem, btnXemDSKH;
	public static JTable tableKH;
	DefaultTableModel tableModelKH;
	JScrollPane scroll;
	private JButton btnTrangChu;
	private JButton btnXeMay;
	private JButton btnHoaDon;
	private JButton btnNhanVien;
	private JButton btnKhachHang;
	private JButton btnBaoHanh;
	private JButton btnGioiThieu;
	private JButton btnDatHang;

	DanhSachKhachHang dskh = new DanhSachKhachHang();
	private JTextField txtMess;

	public FrmKhachHang() throws HeadlessException {

		setTitle("Quản lý Khách hàng");
		setSize(1055, 700);
		setLocationRelativeTo(null);
		this.setVisible(true);
		setResizable(false);
		setDefaultLookAndFeelDecorated(EXIT_ON_CLOSE);
		/**
		 * Panel Menu
		 */

		/**
		 * Panel Banner
		 */
		JPanel pnlBanner = new JPanel();
		add(pnlBanner);

		pnlBanner.setBounds(0, 50, 1055, 30);

		JLabel lblTieuDe;
		pnlBanner.add(lblTieuDe = new JLabel("QUẢN LÝ THÔNG TIN KHÁCH HÀNG"));
		lblTieuDe.setFont(new Font("arial", Font.BOLD, 20));
		/**
		 * Panel Content
		 */
		JPanel pnlContent = new JPanel();
		add(pnlContent);
		pnlContent.setBounds(0, 80, 1055, 320);
		pnlContent.setLayout(null);

		pnlContent.add(lblMaKH = new JLabel("Mã khách hàng:"));
		pnlContent.add(txtMaKH = new JTextField());
		pnlContent.add(lblTenKH = new JLabel("Tên khách hàng"));
		pnlContent.add(txtTenKH = new JTextField());
		pnlContent.add(lblDiaChi = new JLabel("Địa chỉ"));
		pnlContent.add(txtDiaChi = new JTextField());
		pnlContent.add(lblDienThoai = new JLabel("Số điện thoại"));
		pnlContent.add(txtDienThoai = new JTextField());

		pnlContent.add(btnBaoHanh = new JButton("Bảo hành"));
		pnlContent.add(btnDatHang = new JButton("Đặt hàng"));
		pnlContent.add(btnThem = new JButton("Thêm"));
		pnlContent.add(btnXoa = new JButton("Xóa"));
		pnlContent.add(btnSua = new JButton("Sửa"));
		pnlContent.add(btnXoaTrang = new JButton("Xóa trắng"));
		pnlContent.add(btnLuu = new JButton("Lưu"));
		btnThem.setBackground(Color.gray);
		btnThem.setForeground(Color.white);
		btnXoa.setBackground(Color.gray);
		btnXoa.setForeground(Color.white);
		btnSua.setBackground(Color.gray);
		btnSua.setForeground(Color.white);
		btnXoaTrang.setBackground(Color.gray);
		btnXoaTrang.setForeground(Color.white);
		btnLuu.setBackground(Color.gray);
		btnLuu.setForeground(Color.white);
		int w1 = 100, w2 = 300, h = 25;
		lblMaKH.setBounds(50, 100, w1, h);
		txtMaKH.setBounds(150, 100, w2, h);
		lblTenKH.setBounds(550, 100, w1, h);
		txtTenKH.setBounds(650, 100, w2, h);

		lblDiaChi.setBounds(50, 150, w1, h);
		txtDiaChi.setBounds(150, 150, w2, h);
		lblDienThoai.setBounds(550, 150, w1, h);
		txtDienThoai.setBounds(650, 150, w2, h);

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnlContent.add(split);
		split.setBounds(0, 300, 1055, 40);
		JPanel pnlRight, pnlLeft;
		split.add(pnlLeft = new JPanel());
		split.add(pnlRight = new JPanel());

		String[] cbxStr = { "Mã khách hàng", "Tên khách hàng" };
		JComboBox cbxTim = new JComboBox(cbxStr);
		pnlLeft.add(txtTimKiem = new JTextField(15));
		txtTimKiem.setEnabled(true);
		txtTimKiem.setDisabledTextColor(Color.GRAY);
		pnlLeft.add(cbxTim);
		pnlLeft.add(btnTimKiem = new JButton("Tìm"));
		pnlRight.add(btnBaoHanh);
		pnlRight.add(btnDatHang);
		pnlRight.add(btnThem);
		pnlRight.add(btnXoa);
		pnlRight.add(btnXoaTrang);
		pnlRight.add(btnSua);
		pnlRight.add(btnLuu);

		JScrollPane scroll;
		String[] header = { "Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại" };
		tableModelKH = new DefaultTableModel(header, 0);
		add(scroll = new JScrollPane(tableKH = new JTable(tableModelKH), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách Khách Hàng"));
		tableKH.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 320));

		btnTimKiem.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		tableKH.addMouseListener(this);
		btnBaoHanh.addActionListener(this);
		btnDatHang.addActionListener(this);
		connectDB.instance.connect();
		updateTableData();
	}

	private static void setDefaultLookAndFeelDecorated(int exitOnClose) {
		// TODO Auto-generated method stub

	}

	private void clearTextfield() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtDiaChi.setText("");
		txtDienThoai.setText("");
		txtMaKH.setEditable(true);
		txtMaKH.requestFocus();
	}

	private void updateTableData() {
		DanhSachKhachHang dskh = new DanhSachKhachHang();
		List<KhachHang> list = dskh.docTuBang();
		for (KhachHang kh : list) {
			String[] rowData = { kh.getMaKH(), kh.getTenKH(), kh.getDiaChi(), kh.getSDT() + "" };
			tableModelKH.addRow(rowData);
		}
		tableKH.setModel(tableModelKH);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		int row = tableKH.getSelectedRow();
		txtMaKH.setText(tableKH.getValueAt(row, 0).toString());
		txtMaKH.setEditable(false);
		txtTenKH.setText(tableKH.getValueAt(row, 1).toString());
		txtDiaChi.setText(tableKH.getValueAt(row, 2).toString());
		txtDienThoai.setText(tableKH.getValueAt(row, 3).toString());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		Object o = arg0.getSource();
		if (o.equals(btnThem)) {
			if (validData()) {
				try {
					String ma = txtMaKH.getText();
					String ten = txtTenKH.getText();
					String diachi = txtDiaChi.getText();
					String sdt = txtDienThoai.getText();
					KhachHang kh = new KhachHang(ma, ten, diachi, sdt);
					if (dskh.create(ma, ten, diachi, sdt) && dskh.them(kh)) {
						Object[] rowData = { ma, ten, diachi, sdt };
						tableModelKH.addRow(rowData);
					} else {
						JOptionPane.showMessageDialog(null, "Trùng mã");
						txtMaKH.selectAll();
						txtMaKH.requestFocus();
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		} else if (o.equals(btnXoa)) {
			int row = tableKH.getSelectedRow();
			if (row >= 0) {
				String makh = (String) tableKH.getValueAt(row, 0);
				if (dskh.delete(makh)) {
					tableModelKH.removeRow(row);
					clearTextfield();
				}
			}
		} else if (o.equals(btnXoaTrang)) {
			clearTextfield();
		} else if (o.equals(btnThoat)) {
			System.exit(0);
		} else if (o.equals(btnSua)) {
			int row = tableKH.getSelectedRow();
			if (row >= 0) {
				if (dskh.update(txtMaKH.getText(), txtTenKH.getText(), txtDiaChi.getText(), txtDienThoai.getText())) {
					tableKH.setValueAt(txtTenKH.getText(), row, 1);
					tableKH.setValueAt(txtDiaChi.getText(), row, 2);
					tableKH.setValueAt(txtDienThoai.getText(), row, 3);
				}

			}
		} else if (o.equals(btnTimKiem)) {
			String makh = txtTimKiem.getText();
			tableKH.clearSelection();

			String ktma = "";
			for (int i = 0; i < tableKH.getRowCount(); i++) {
				ktma = tableKH.getValueAt(i, 0).toString();

				if (ktma.equals(makh)) {
					tableKH.addRowSelectionInterval(i, i);
					break;
				}

			}
			for (int i = 0; i < tableKH.getRowCount(); i++) {
				ktma = tableKH.getValueAt(i, 1).toString();

				if (ktma.equals(makh)) {
					tableKH.addRowSelectionInterval(i, i);
					break;
				}

			}

		} else if (o.equals(btnDatHang)) {
			this.dispose();
		} else if (o.equals(btnBaoHanh)) {
			this.dispose();
		}

	}

	private boolean validData() {
		String maKH = txtMaKH.getText().trim();
		String tenKH = txtTenKH.getText().trim();
		String diaChi = txtDiaChi.getText().trim();
		String dienThoai = txtDienThoai.getText().trim();

		if (!(maKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Mã khách hàng không được để trống");
			return false;
		}
		if (!(tenKH.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Tên khách hàng không được để trống");
			return false;
		}
		if (!(diaChi.length() > 0 && diaChi.matches("^\\w+$"))) {
			JOptionPane.showMessageDialog(this, "Địa chỉ khách hàng không được để trống");
			return false;
		}
		if (!(dienThoai.length() > 0)) {
			JOptionPane.showMessageDialog(this, "Điện thoại khách hàng bắt đầu bằng 0 và có 9 chữ số theo sau");
			return false;
		}
		return true;
	}

	public JButton getbtnBaoHanh() {
		return btnBaoHanh;
	}

	public JButton getbtnDatHang() {
		return btnDatHang;
	}

	public String getTenKH() {
		return txtTenKH.getText();
	}

	public String getMaKH() {
		return txtMaKH.getText();
	}

	public String getDiaChi() {
		return txtDiaChi.getText();
	}

	public String getSDT() {
		return txtDienThoai.getText();
	}
}
