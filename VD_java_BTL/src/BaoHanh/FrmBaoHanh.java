package BaoHanh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
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
import KhachHang.FrmKhachHang;

public class FrmBaoHanh extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lblTitle, lblMaPhieu, lblTenLinhKien, lblLyDo, lblLoi, lblGia, lblMaNV, lblTenNV, lblMaKH, lblTenKH,
			lblTimKiem;
	JTextField txtMaPhieu, txtTenLinhKien, txtLyDo, txtGia, txtMaNV, txtTenNV, txtMaKH, txtTenKH, txtTimKiem;
	JButton btnThem, btnLuu, btnSua, btnXoa, btnThanhToan, btnThoat, btnTimKiem, btnXemDSBH;
	JTable tableBH;
	DefaultTableModel tableModelBH;
	JScrollPane scroll;
	JComboBox<String> cbxLoi;
	private JButton btnXoaTrang;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxTim;
	private JTextField txtTim;
	private JButton btnTim;

	DanhSachBaoHanh dsbh = new DanhSachBaoHanh();

	public FrmBaoHanh() {
		setTitle("Quản Lý Bảo Hành");
		setSize(1055, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		// setResizable(false);
		setDefaultLookAndFeelDecorated(EXIT_ON_CLOSE);

		JPanel pnlBanner = new JPanel();
		add(pnlBanner);

		pnlBanner.setBounds(0, 0, 1055, 30);

		JLabel lblTieuDe;
		pnlBanner.add(lblTieuDe = new JLabel("QUẢN LÝ THÔNG TIN BẢO HÀNH"));
		lblTieuDe.setFont(new Font("arial", Font.BOLD, 20));
		lblTieuDe.setForeground(Color.blue);
		/**
		 * Panel Content
		 */
		JPanel pnlContent = new JPanel();
		add(pnlContent);
		pnlContent.setBounds(0, 30, 1055, 320);
		pnlContent.setLayout(null);

		pnlContent.add(lblMaPhieu = new JLabel("Mã phiếu: "));
		pnlContent.add(txtMaPhieu = new JTextField());
		pnlContent.add(lblTenLinhKien = new JLabel("Tên linh kiện:"));
		pnlContent.add(txtTenLinhKien = new JTextField());
		pnlContent.add(lblLyDo = new JLabel("Lỗi:"));
		pnlContent.add(txtLyDo = new JTextField());
		pnlContent.add(lblLoi = new JLabel("Lỗi: "));
		pnlContent.add(cbxLoi = new JComboBox<String>());
		cbxLoi.addItem("Thiết bị");
		cbxLoi.addItem("Khách hàng");
		pnlContent.add(lblGia = new JLabel("Giá tiền: "));
		pnlContent.add(txtGia = new JTextField());

		pnlContent.add(lblMaNV = new JLabel("Mã nhân viên:"));
		pnlContent.add(txtMaNV = new JTextField("NV002"));
		pnlContent.add(lblTenNV = new JLabel("Tên nhân viên:"));
		pnlContent.add(txtTenNV = new JTextField("Lương Viết Đại"));
		pnlContent.add(lblMaKH = new JLabel("Mã khách hàng:"));
		pnlContent.add(txtMaKH = new JTextField());
		pnlContent.add(lblTenKH = new JLabel("Tên khách hàng:"));
		pnlContent.add(txtTenKH = new JTextField());

		int w1 = 100, w2 = 300, h = 25;
		lblMaPhieu.setBounds(50, 50, w1, h);
		txtMaPhieu.setBounds(150, 50, w2, h);
		lblTenLinhKien.setBounds(550, 50, w1, h);
		txtTenLinhKien.setBounds(650, 50, w2, h);

		lblLyDo.setBounds(50, 100, w1, h);
		txtLyDo.setBounds(150, 100, w2, h);
		// lblLoi.setBounds(550, 100, w1, h);cbxLoi.setBounds(650, 100, w2, h);

		lblGia.setBounds(50, 150, w1, h);
		txtGia.setBounds(150, 150, w2, h);

		lblMaNV.setBounds(50, 200, w1, h);
		txtMaNV.setBounds(150, 200, w2, h);
		lblTenNV.setBounds(550, 200, w1, h);
		txtTenNV.setBounds(650, 200, w2, h);

		lblMaKH.setBounds(50, 250, w1, h);
		txtMaKH.setBounds(150, 250, w2, h);
		lblTenKH.setBounds(550, 250, w1, h);
		txtTenKH.setBounds(650, 250, w2, h);

		pnlContent.add(btnThem = new JButton("Thêm"));
		pnlContent.add(btnXoa = new JButton("Xóa"));
		pnlContent.add(btnSua = new JButton("Sửa"));
		pnlContent.add(btnXoaTrang = new JButton("Xóa trắng"));
		pnlContent.add(btnLuu = new JButton("Lưu"));

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnlContent.add(split);
		split.setBounds(0, 340, 1055, 40);
		JPanel pnlRight, pnlLeft;
		split.add(pnlLeft = new JPanel());
		split.add(pnlRight = new JPanel());

		String[] cbxStr = { "Mã phiếu", "Tên phiếu" };
		cbxTim = new JComboBox<String>(cbxStr);
		pnlLeft.add(txtTim = new JTextField(20));
		txtTim.setEnabled(true);
		txtTim.setDisabledTextColor(Color.GRAY);
		pnlLeft.add(cbxTim);
		pnlLeft.add(btnTim = new JButton("Tìm"));
		pnlRight.add(btnThem);
		pnlRight.add(btnXoa);
		pnlRight.add(btnXoaTrang);
		pnlRight.add(btnLuu);

		txtTenNV.setEditable(false);
		txtMaKH.setEditable(false);
		txtTenKH.setEditable(false);

		JScrollPane scroll;
		String[] header = "Mã phiếu;Tên linh kiện;Lỗi;Giá tiền;Mã nhân viên; Mã khách hàng".split(";");
		tableModelBH = new DefaultTableModel(header, 0);
		add(scroll = new JScrollPane(tableBH = new JTable(tableModelBH), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách Phiếu"));
		tableBH.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0, 250));

		FrmKhachHang frm = new FrmKhachHang();
		frm.getbtnBaoHanh().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtMaKH.setText(frm.getMaKH());
				txtTenKH.setText(frm.getTenKH());
			}
		});

		// btnSua.addActionListener(this);

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTim.addActionListener(this);
		// btnXemDSNV.addActionListener(this);

		tableBH.addMouseListener(this);
		connectDB.instance.connect();
		updateTableData();

	}

	private void setDefaultLookAndFeelDecorated(int exitOnClose) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unused")
	private void clearTextfield() {
		txtMaPhieu.setText("");
		txtTenLinhKien.setText("");
		txtLyDo.setText("");
		cbxLoi.setSelectedItem("");
		txtGia.setText("");
		txtMaPhieu.requestFocus();
	}

	private void updateTableData() {
		DanhSachBaoHanh dsbh = new DanhSachBaoHanh();
		List<BaoHanh> list = dsbh.docTuBang();
		for (BaoHanh bh : list) {
			String[] rowData = { bh.getMaPhieu(), bh.getTenLinhKien(), bh.getLoi(), bh.getGia() + "", bh.getMaKH(),
					bh.getMaNV() };
			tableModelBH.addRow(rowData);
		}
		tableBH.setModel(tableModelBH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThoat)) {
			System.exit(0);
		}
		/*
		 * else if(o.equals(btnSua)) { int row =tableBH.getSelectedRow(); if(row>=0) {
		 * DanhSachBaoHanh dsbh = new DanhSachBaoHanh();
		 * if(dsbh.update(txtMaPhieu.getText(),
		 * txtTenLinhKien.getText(),txtLyDo.getText(),
		 * Double.parseDouble(txtGia.getText().toString()),txtMaKH.getText(),
		 * txtMaNV.getText())) { tableBH.setValueAt(txtTenLinhKien.getText(), row, 1);
		 * tableBH.setValueAt(txtLyDo.getText(), row, 2);
		 * tableBH.setValueAt(txtGia.getText(), row, 3);
		 * tableBH.setValueAt(txtMaKH.getText(), row,4);
		 * tableBH.setValueAt(txtMaNV.getText(), row, 5); } }
		 * 
		 * }
		 */
		else if (o.equals(btnThem)) {
			try {
				String maphieu = txtMaPhieu.getText();
				String tenlk = txtTenLinhKien.getText();
				String loi = txtLyDo.getText();
				Double gia = Double.parseDouble(txtGia.getText());
				String makh = txtMaKH.getText();
				String manv = txtMaNV.getText();
				BaoHanh bh = new BaoHanh(maphieu, tenlk, loi, gia, makh, manv);
				if (dsbh.create(maphieu, tenlk, loi, gia, makh, manv) && dsbh.them(bh)) {
					Object[] rowData = { maphieu, tenlk, loi, gia, makh, manv };
					tableModelBH.addRow(rowData);
				} else {
					JOptionPane.showMessageDialog(null, "Trùng mã");
					txtMaPhieu.selectAll();
					txtMaPhieu.requestFocus();
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		} else if (o.equals(btnTim)) {
			String maXe = txtTim.getText();
			tableBH.clearSelection();

			String ktma = "";
			for (int i = 0; i < tableBH.getRowCount(); i++) {
				ktma = tableBH.getValueAt(i, 0).toString();
				if (ktma.equals(maXe)) {
					tableBH.addRowSelectionInterval(i, i);
					break;
				}
			}

		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableBH.getSelectedRow();
		txtMaPhieu.setText(tableBH.getValueAt(row, 0).toString());
		txtTenLinhKien.setText(tableBH.getValueAt(row, 1).toString());
		txtLyDo.setText(tableBH.getValueAt(row, 2).toString());
		// cbxLoi.setSelectedItem(tableBH.getValueAt(row, 2).toString());
		txtGia.setText(tableBH.getValueAt(row, 3).toString());
		txtMaKH.setText(tableBH.getValueAt(row, 5).toString());
		txtMaPhieu.setEditable(false);
		txtMaKH.setEditable(false);
		txtMaNV.setEditable(false);
		txtTenKH.setEditable(false);
		txtTenNV.setEditable(false);
		txtTenLinhKien.setEditable(false);
		txtLyDo.setEditable(false);
		txtGia.setEditable(false);
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

}
