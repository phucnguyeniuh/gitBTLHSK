package NhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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




public class FrmNhanVien extends JFrame implements ActionListener, MouseListener{

	JLabel lblTitle,lblChucVu1 , lblLoaiNV, lblMaNV, lblTenNV, lblDiaChi, lblDienThoai, lblChucVu, lblTimKiem, lblBacTho, lblNamKN, lblPhongBan, lblTrinhDo;
	JTextField txtLoaiNV, txtMaNV, txtTenNV, txtDiaChi, txtDienThoai, txtChucVu, txtTimKiem, txtBacTho, txtNamKN, txtPhongBan, txtTrinhDo;
	JButton btnThem, btnLuu, btnSua, btnXoa, btnXoaTrang, btnThoat,btnTimKiem, btnXemDSNV;
	JTable tableNV;
	DefaultTableModel tableModelNV;
	JScrollPane scroll;
	ButtonGroup group;
	JComboBox cbxChucVu;
	DanhSachNhanVien dsnv= new DanhSachNhanVien();
	
	private JCheckBox cbNVKyThuat;
	private JCheckBox cbNVHanhChinh;
	private DanhSachNhanVien ds;
	public FrmNhanVien(){
		setTitle("Quản Lý Nhân Viên");
		setSize(1055,700);
		setLocationRelativeTo(null);
		//setResizable(false);
		setDefaultLookAndFeelDecorated(EXIT_ON_CLOSE);
		/**
		 * Panel Menu
		 */		
		JPanel pnlBanner=new JPanel();
		add(pnlBanner);
		
		pnlBanner.setBounds(0, 0, 1055, 30);
		
		JLabel lblTieuDe;
		pnlBanner.add(lblTieuDe=new JLabel("QUẢN LÝ THÔNG TIN NHÂN VIÊN"));
		lblTieuDe.setFont(new Font("arial",Font.BOLD,20));
		/**
		 * Panel Content
		 */
		JPanel pnlContent=new JPanel();
		add(pnlContent);
		pnlContent.setBounds(0,80,1055,450);
		pnlContent.setLayout(null);
		
		pnlContent.add(lblMaNV=new JLabel("Mã nhân viên:"));
		pnlContent.add(txtMaNV=new JTextField());
		pnlContent.add(lblDiaChi=new JLabel("Địa chỉ: "));
		pnlContent.add(txtDiaChi=new JTextField());
		pnlContent.add(lblTenNV=new JLabel("Tên nhân viên"));
		pnlContent.add(txtTenNV=new JTextField());
		pnlContent.add(lblDienThoai=new JLabel("Số điện thoại"));
		pnlContent.add(txtDienThoai=new JTextField());
		pnlContent.add(lblChucVu=new JLabel("Chức vụ"));
		pnlContent.add(cbxChucVu = new JComboBox());
		cbxChucVu.addItem("Nhân viên hành chính");
		cbxChucVu.addItem("Nhân viên kĩ thuật");
		pnlContent.add(lblLoaiNV = new JLabel("Chuc vu: "));
		pnlContent.add(txtLoaiNV = new JTextField());
		txtLoaiNV.setEditable(false);
		pnlContent.add(lblPhongBan = new JLabel("Phòng ban: "));
		pnlContent.add(txtPhongBan = new JTextField());
		txtPhongBan.setEditable(false);
		pnlContent.add(lblTrinhDo = new JLabel("Trình độ: "));
		pnlContent.add(txtTrinhDo = new JTextField());
		txtTrinhDo.setEditable(false);
		pnlContent.add(lblBacTho = new JLabel("Bậc thợ: "));
		pnlContent.add(txtBacTho = new JTextField());
		txtBacTho.setEditable(false);
		pnlContent.add(lblNamKN = new JLabel("Năm kinh nghiệm: "));
		pnlContent.add(txtNamKN = new JTextField());
		txtNamKN.setEditable(false);
		
		

		pnlContent.add(btnThem=new JButton("Thêm"));
		pnlContent.add(btnXoa=new JButton("Xóa"));
		pnlContent.add(btnSua=new JButton("Sửa"));
		pnlContent.add(btnXoaTrang=new JButton("Xóa trắng"));
		pnlContent.add(btnLuu=new JButton("Lưu"));
		pnlContent.add(Box.createHorizontalStrut(50));
		//cbNVKyThuat = new JCheckBox("Nhn vien");
		
	
		int w1=100, w2=300, h=25;
		lblMaNV.setBounds(50,50, w1, h);txtMaNV.setBounds(150,50, w2, h);
		lblDiaChi.setBounds(550, 50, w1, h);txtDiaChi.setBounds(650, 50, w2, h);
		
		lblTenNV.setBounds(50, 100, w1, h);txtTenNV.setBounds(150, 100, w2, h);
		lblDienThoai.setBounds(550, 100, w1, h);txtDienThoai.setBounds(650, 100, w2, h);
		
		lblChucVu.setBounds(50, 150, w1, h);cbxChucVu.setBounds(150, 150, w2, h);
		
		lblTrinhDo.setBounds(50, 200, w1, h);txtTrinhDo.setBounds(150, 200, w2, h);
		lblBacTho.setBounds(550, 200, w1, h);txtBacTho.setBounds(650, 200, w2, h);
		
		
		lblPhongBan.setBounds(50, 250, w1, h);txtPhongBan.setBounds(150, 250, w2, h);
		lblNamKN.setBounds(550, 250, w1, h);txtNamKN.setBounds(650, 250, w2, h);
		
	
		JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		pnlContent.add(split);
		split.setBounds(0, 300, 1055, 40);
		JPanel pnlRight,pnlLeft;
		split.add(pnlLeft=new JPanel());
		split.add(pnlRight=new JPanel());
		
		String[] cbxStr = {"Tên nhân viên"};
		JComboBox cbxTim=new JComboBox(cbxStr);
		pnlLeft.add(txtTimKiem=new JTextField(15));
		txtTimKiem.setEnabled(true);
		txtTimKiem.setDisabledTextColor(Color.GRAY);
		pnlLeft.add(cbxTim);
		pnlLeft.add(btnTimKiem=new JButton("Tìm"));
		pnlRight.add(btnThem);
		pnlRight.add(btnXoa);
		pnlRight.add(btnXoaTrang);
		pnlRight.add(btnSua);
		pnlRight.add(btnLuu);
		
		JScrollPane scroll;
		String[] header="Mã nhân viên;Tên nhân viên;Địa chỉ;Số điện thoại;Chức vụ;Phòng ban;Trình độ;Bậc thợ; Năm kinh nghiệm".split(";");
		tableModelNV=new DefaultTableModel(header,0);
		add(scroll=new JScrollPane(tableNV=new JTable(tableModelNV),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED),BorderLayout.SOUTH);
		scroll.setBorder(BorderFactory.createTitledBorder("Danh Sách Nhân Viên"));
		tableNV.setRowHeight(20);
		scroll.setPreferredSize(new Dimension(0,300));
		
		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTimKiem.addActionListener(this);
		//btnXemDSNV.addActionListener(this);
		//btnThoat.addActionListener(this);
		tableNV.addMouseListener( this);
		setVisible(true);
		cbxChucVu.addActionListener(this);
		
	
		connectDB.instance.connect();
		updateTableData();
		
		
	}


	
private void setDefaultLookAndFeelDecorated(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}



public static void main(String[] args) {
	new FrmNhanVien();
	

}

private void updateTableData() {
	
	
	
	ds=new DanhSachNhanVien();
		List<NhanVien> list=ds.docTubangNV();
		
	for(NhanVien nv : list) {
		String[] rowData= {nv.getMaNV(),nv.getTenNV(),nv.getDiaChi(),nv.getDienThoai(), nv.getChucVu(),nv.getPhongBan(), nv.getTrinhDo(), nv.getBacTho(), nv.getNamKN()};
		
		
		tableModelNV.addRow(rowData);
	}
	tableNV.setModel(tableModelNV);
}

@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	int row=tableNV.getSelectedRow();
	txtMaNV.setText(tableNV.getValueAt(row, 0).toString());
	txtTenNV.setText(tableNV.getValueAt(row, 1).toString());
	txtDiaChi.setText(tableNV.getValueAt(row, 2).toString());
	txtDienThoai.setText(tableNV.getValueAt(row, 3).toString());

	txtPhongBan.setText(tableNV.getValueAt(row, 5).toString());
	txtTrinhDo.setText(tableNV.getValueAt(row, 6).toString());
	txtBacTho.setText(tableNV.getValueAt(row, 7).toString());
	txtNamKN.setText(tableNV.getValueAt(row, 8).toString());
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

public void xoaTrang()
{
	txtMaNV.setText("");
	txtTenNV.setText("");
	txtDiaChi.setText("");
	txtDienThoai.setText("");
	txtMaNV.setText("");
	txtNamKN.setText("");
	txtPhongBan.setText("");
	txtTrinhDo.setText("");
	txtTimKiem.setText("");
}

public int sua()
{
	txtMaNV.setEditable(false);
	int row = tableNV.getSelectedRow();
	txtMaNV.setText(tableNV.getValueAt(row, 0).toString());
	txtTenNV.setText(tableNV.getValueAt(row, 1).toString());
	txtDiaChi.setText(tableNV.getValueAt(row, 2).toString());
	txtDienThoai.setText(tableNV.getValueAt(row, 3).toString());
	
	
	txtPhongBan.setText(tableNV.getValueAt(row, 5).toString());
	txtTrinhDo.setText(tableNV.getValueAt(row, 6).toString());
	txtBacTho.setText(tableNV.getValueAt(row, 7).toString());
	txtNamKN.setText(tableNV.getValueAt(row, 8).toString());
	
	
	return row;
}
//////////////////////////////////////////////////////////
public void luu()
{
	int row = sua();
	
	tableNV.setValueAt(txtTenNV.getText(),row, 1);
	tableNV.setValueAt(txtDiaChi.getText().toString(),row, 2);
	tableNV.setValueAt(txtDienThoai.getText().toString(),row, 3);
	tableNV.setValueAt(cbxChucVu.getSelectedItem().toString(),row, 4);
	tableNV.setValueAt(txtPhongBan.getText().toString(),row, 5);
	tableNV.setValueAt(txtTrinhDo.getText().toString(),row, 6);
	tableNV.setValueAt(txtBacTho.getText().toString(),row, 7);
	tableNV.setValueAt(txtNamKN.getText().toString(),row, 8);
	txtMaNV.setEditable(false);
	
	ds.xoa(txtMaNV.getText());
	//ds.them(new NhanVien(txtMaNV.getText(), txtTenNV.getText(), txtDiaChi.getText(), txtDienThoai.getText(), txtChucVu.getText(), txtPhongBan.getText(), txtTrinhDo.getText(), txtBacTho.getText(), txtNamKN.getText()));
	ds.createNV(txtMaNV.getText(), txtTenNV.getText(), txtDiaChi.getText(), txtDienThoai.getText(), cbxChucVu.getSelectedItem().toString(), txtPhongBan.getText(), txtTrinhDo.getText(), txtBacTho.getText(), txtNamKN.getText());
	xoaTrang();
	updateTableData();
}


///////////////////////////////////////////////////////////
@Override
public void actionPerformed(ActionEvent e) {
	Object o = e.getSource();
	
	if(o.equals(btnXoa))
	{
		int row=tableNV.getSelectedRow();
		
		if(row>=0) {
			String manv=(String) tableNV.getValueAt(row, 0);
			if(dsnv.delete(manv)) {
				tableModelNV.removeRow(row);
			}
		}
	}
	///////////////////////////////////////////////////////
	if(o.equals(btnSua))
	{
		sua();
	}
	////////////////////////////////////////////////////////////////
	if(o.equals(btnTimKiem))
	{
		

		String maNV = txtTimKiem.getText();
		tableNV.clearSelection();
		
		String ktma = "";
		for (int i = 0; i < tableNV.getRowCount(); i++) {
			ktma = tableNV.getValueAt(i, 1).toString();
			if(ktma.equals(maNV))
			{
				tableNV.addRowSelectionInterval(i, i);
				break;
			}
		}
		for (int i = 0; i < tableNV.getRowCount(); i++) {
			ktma = tableNV.getValueAt(i, 1).toString();
		
		if(ktma.equals(maNV)){
				tableNV.addRowSelectionInterval(i, i);
				break;
			}
		
		}
	
	}
	
	////////////////////////////////////////////////////////////////////////////////
	if(o==cbxChucVu && cbxChucVu.getSelectedItem()=="Nhân viên hành chính")
	{
		txtBacTho.setEditable(false);
		txtNamKN.setEditable(false);
		txtTrinhDo.setEditable(true);
		txtPhongBan.setEditable(true);
	}
	else if(o==cbxChucVu && cbxChucVu.getSelectedItem()=="Nhân viên kĩ thuật")
	{
		txtTrinhDo.setEditable(false);
		txtPhongBan.setEditable(false);
		txtBacTho.setEditable(true);
		txtNamKN.setEditable(true);
	}
	////////////////////////////////////////////////////////////////////////////
	if(o.equals(btnThem))
	{
		
		try {
			
				String phongBan = "";
				String trinhDo = "";
				String bacTho = "";
				String namKN = "";
				
				
			
				String manv = txtMaNV.getText();
				
				
			
				
				String Ten = txtTenNV.getText();
				String diaChi = txtDiaChi.getText();
				String dienThoai = txtDienThoai.getText();
				String chucVu = cbxChucVu.getSelectedItem().toString();
				if(cbxChucVu.getSelectedItem()=="Nhân viên hành chính")
				{
					
					phongBan = txtPhongBan.getText();
					trinhDo = txtTrinhDo.getText();
					
				}
				else if(cbxChucVu.getSelectedItem()=="Nhân viên kĩ thuật")
				{
					
					bacTho= txtBacTho.getText();
					namKN = txtNamKN.getText();
				}
				
				/////////////////////////////////
				if(!txtMaNV.getText().equals(""))
				{
					if(ds.Tim(manv)==false)
					{
						boolean flag=false;
						for (int i = 0; i < tableNV.getRowCount(); i++) {
							if(manv.equalsIgnoreCase(tableNV.getValueAt(i, 0).toString()))
							{
								flag=true;
								break;
							}
						}
						if(flag = true)
						{
							ds.createNV(manv, Ten, diaChi, dienThoai, chucVu, phongBan, trinhDo, bacTho, namKN);
							
							String[] rowData= {manv, Ten, diaChi, dienThoai, chucVu, phongBan, trinhDo, bacTho, namKN};
							tableModelNV.addRow(rowData);
							xoaTrang();
						}
						else {
							JOptionPane.showMessageDialog(this, "Trùng mã nhân viên");
						}
					
					
				}
					else if(ds.Tim(manv)==true)
					{
						JOptionPane.showMessageDialog(this, "Trùng mã không thêm được");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(this, "Mã NV không được bỏ trống");
				}
				
		} catch (Exception e2) {
			
		}
	////////////////////////////////////////////////////////////////////////////
		if(o.equals(btnXoaTrang))
		{
			xoaTrang();
		}
		
		
	}
	
}
}

