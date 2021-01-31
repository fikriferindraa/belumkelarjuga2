
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GigawattBillingSystem extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jTextEditBillDate;
	private JTextField jTextEditAccNo;
	private JTextField jTextEditUserName;
	private JTextField jTextEditUserAddress;
	private JTextField jTextArrears;
	private JTextField jTextEditOldMeter;
	private JTextField jTextEditNewMeter;
	private JTextField TotalUnit;
	private JTextField Total_Charge;
	private JTextField TotalBill;
	private JTextField jTextSearch;
	private JTable table;
	
	public ArrayList<GigawattData> Datalist;
	public String header[] = new String[] {"Account Number", "Bill Date", "Name", "Address", "Arrears", "Previous Meter", "Current Meter", "Total Unit", "Current Charge", "Total Bill"};
	public DefaultTableModel dtm;
	public int row, col;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GigawattBillingSystem frame = new GigawattBillingSystem();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GigawattBillingSystem() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1872, 987);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Datalist = new ArrayList<>();
		dtm = new DefaultTableModel(header,0);
		this.setLocationRelativeTo(null);
		
		JLabel lblGigawatt = new JLabel("GIGAWATT");
		lblGigawatt.setBounds(653, 11, 662, 153);
		lblGigawatt.setForeground(Color.YELLOW);
		lblGigawatt.setFont(new Font("Imprint MT Shadow", Font.BOLD | Font.ITALIC, 99));
		contentPane.add(lblGigawatt);
		
		JLabel lblLightIsThe = new JLabel("Light is The Key of Life");
		lblLightIsThe.setBounds(841, 122, 249, 42);
		lblLightIsThe.setFont(new Font("SimSun-ExtB", Font.BOLD, 18));
		lblLightIsThe.setForeground(Color.WHITE);
		contentPane.add(lblLightIsThe);
		
		JLabel jlabel_logo = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
		jlabel_logo.setIcon(new ImageIcon(images));
		jlabel_logo.setBounds(535, 25, 115, 147);
		contentPane.add(jlabel_logo);
		
		JLabel lblTotalBill = new JLabel("Total Bill");
		lblTotalBill.setBounds(23, 900, 170, 21);
		contentPane.add(lblTotalBill);
		lblTotalBill.setBackground(Color.BLACK);
		lblTotalBill.setForeground(SystemColor.text);
		lblTotalBill.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblCurrentCharge = new JLabel("Total Charge");
		lblCurrentCharge.setBounds(23, 805, 170, 21);
		contentPane.add(lblCurrentCharge);
		lblCurrentCharge.setForeground(SystemColor.text);
		lblCurrentCharge.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel lblTotalUnit = new JLabel("Total Unit");
		lblTotalUnit.setBounds(23, 706, 170, 21);
		contentPane.add(lblTotalUnit);
		lblTotalUnit.setForeground(SystemColor.text);
		lblTotalUnit.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel jLabel10 = new JLabel("Current Meter");
		jLabel10.setBounds(23, 611, 170, 21);
		contentPane.add(jLabel10);
		jLabel10.setForeground(SystemColor.text);
		jLabel10.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel jLabel2 = new JLabel("Bill Date (DD/MM/YYYY)");
		jLabel2.setBounds(23, 230, 174, 21);
		contentPane.add(jLabel2);
		jLabel2.setForeground(SystemColor.text);
		jLabel2.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel jLabel3 = new JLabel("Account Number");
		jLabel3.setBounds(23, 292, 141, 21);
		contentPane.add(jLabel3);
		jLabel3.setForeground(SystemColor.text);
		jLabel3.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel jLabel5 = new JLabel("Owner Name");
		jLabel5.setBounds(23, 355, 141, 21);
		contentPane.add(jLabel5);
		jLabel5.setForeground(SystemColor.text);
		jLabel5.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel jLabel6 = new JLabel("Owner Address");
		jLabel6.setBounds(23, 423, 141, 21);
		contentPane.add(jLabel6);
		jLabel6.setForeground(SystemColor.text);
		jLabel6.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel jLabel7 = new JLabel("Arrears");
		jLabel7.setBounds(23, 489, 141, 21);
		contentPane.add(jLabel7);
		jLabel7.setForeground(SystemColor.text);
		jLabel7.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JLabel jLabel9 = new JLabel("Previous Meter");
		jLabel9.setBounds(23, 550, 170, 21);
		contentPane.add(jLabel9);
		jLabel9.setForeground(SystemColor.text);
		jLabel9.setFont(new Font("Arial", Font.PLAIN, 15));
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] {
						jTextEditAccNo.getText(),
						jTextEditBillDate.getText(),
						jTextEditUserName.getText(),
						jTextEditUserAddress.getText(),
						jTextArrears.getText(),
						jTextEditOldMeter.getText(),
						jTextEditNewMeter.getText(),
						TotalUnit.getText(),
						Total_Charge.getText(),
						TotalBill.getText()
				});
				
				if (table.getSelectedRow() == -1) {
					if(table.getRowCount() == 0) {
						JOptionPane.showMessageDialog(null, "Data Added Successfully", "Gigawatt Menu", 
								JOptionPane.OK_OPTION);
					}
				}
			}
		});
		btnAdd.setBounds(523, 390, 126, 45);
		contentPane.add(btnAdd);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnAdd.setBackground(Color.DARK_GRAY);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(523, 467, 126, 45);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jTextEditBillDate.setText("");
				jTextEditAccNo.setText("");
				jTextEditUserName.setText("");
				jTextEditUserAddress.setText("");
				jTextArrears.setText("");
				jTextEditOldMeter.setText("");
				jTextEditNewMeter.setText("");
				TotalUnit.setText("");
				Total_Charge.setText("");
				TotalBill.setText("");
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnReset.setBackground(Color.DARK_GRAY);
		
		JButton btnCalculate_1 = new JButton("Calculate");
		btnCalculate_1.setBounds(270, 748, 148, 34);
		contentPane.add(btnCalculate_1);
		btnCalculate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double num5=0.00,ans;
				try {
					
					ans = Double.parseDouble(TotalUnit.getText());
					
					if (ans > 0 && ans <=200){
						num5 = ans * 0.218;
			            num5 = num5 * 0.016 + num5;
			        }
			        else if (ans > 200 && ans <=300){
			            num5 = 200 * 0.218;
			            num5 = num5 + (ans - 200) * 0.334;
			        }
			        else if (ans > 300 && ans <= 600){
			        	num5 = (200 * 0.218) + (100 * 0.334);
			            num5 = num5 + (ans - 300) * 0.516;
			        }
			        else if (ans > 600 && ans <= 900){
			        	num5 = (200 * 0.218) + (100 * 0.334) + (300 * 0.516);
			        	num5 = num5 + (ans - 600) * 0.546;
			        }
			        else if (ans > 900) {
			        	num5 = (200 * 0.218) + (100 * 0.334) + (300 * 0.516) + (300 * 0.546);
			        	num5 = num5 + (ans - 300) * 0.571;
			        }
					
					Total_Charge.setText(Double.toString(num5));
				}catch(Exception o) {
						
					JOptionPane.showMessageDialog(null, "Please Enter Valid Number");
				}
			}
		});
		btnCalculate_1.setForeground(Color.WHITE);
		btnCalculate_1.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnCalculate_1.setBackground(Color.DARK_GRAY);
		
		JButton btnCalculate_2 = new JButton("Calculate");
		btnCalculate_2.setBounds(270, 845, 148, 34);
		contentPane.add(btnCalculate_2);
		btnCalculate_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double num3,num4,ans1;
				try {
					num3 = Double.parseDouble(jTextArrears.getText());
					num4 = Double.parseDouble(Total_Charge.getText());
					
					ans1 = num3+num4;
					TotalBill.setText(Double.toString(ans1));
				}catch(Exception p) {
					
					JOptionPane.showMessageDialog(null, "Please Enter Valid Number");
				}
			}
		});
		btnCalculate_2.setForeground(Color.WHITE);
		btnCalculate_2.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnCalculate_2.setBackground(Color.DARK_GRAY);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(270, 651, 148, 31);
		contentPane.add(btnCalculate);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int num1,num2,ans = 0;
				try {
					num1 = Integer.parseInt(jTextEditNewMeter.getText());
					num2 = Integer.parseInt(jTextEditOldMeter.getText());
					
					ans = num1-num2;
					TotalUnit.setText(Integer.toString(ans));
				}catch(Exception i) {
					
					JOptionPane.showMessageDialog(null, "Please Enter Valid Number");
				}
			}
		});
		btnCalculate.setForeground(Color.WHITE);
		btnCalculate.setFont(new Font("Arial Black", Font.BOLD, 12));
		btnCalculate.setBackground(Color.DARK_GRAY);
		
		jTextEditBillDate = new JTextField();
		jTextEditBillDate.setColumns(10);
		jTextEditBillDate.setBounds(195, 231, 287, 20);
		contentPane.add(jTextEditBillDate);
		
		jTextEditAccNo = new JTextField();
		jTextEditAccNo.setColumns(10);
		jTextEditAccNo.setBounds(195, 293, 287, 20);
		contentPane.add(jTextEditAccNo);
		
		jTextEditUserName = new JTextField();
		jTextEditUserName.setColumns(10);
		jTextEditUserName.setBounds(195, 356, 287, 20);
		contentPane.add(jTextEditUserName);
		
		jTextEditUserAddress = new JTextField();
		jTextEditUserAddress.setColumns(10);
		jTextEditUserAddress.setBounds(195, 424, 287, 20);
		contentPane.add(jTextEditUserAddress);
		
		jTextArrears = new JTextField();
		jTextArrears.setColumns(10);
		jTextArrears.setBounds(195, 490, 287, 20);
		contentPane.add(jTextArrears);
		
		jTextEditOldMeter = new JTextField();
		jTextEditOldMeter.setColumns(10);
		jTextEditOldMeter.setBounds(195, 551, 287, 20);
		contentPane.add(jTextEditOldMeter);
		
		jTextEditNewMeter = new JTextField();
		jTextEditNewMeter.setColumns(10);
		jTextEditNewMeter.setBounds(195, 612, 287, 20);
		contentPane.add(jTextEditNewMeter);
		
		TotalUnit = new JTextField();
		TotalUnit.setColumns(10);
		TotalUnit.setBounds(195, 707, 287, 20);
		contentPane.add(TotalUnit);
		
		Total_Charge = new JTextField();
		Total_Charge.setColumns(10);
		Total_Charge.setBounds(195, 806, 287, 20);
		contentPane.add(Total_Charge);
		
		TotalBill = new JTextField();
		TotalBill.setColumns(10);
		TotalBill.setBounds(195, 901, 287, 20);
		contentPane.add(TotalBill);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=table.getSelectedRow();
				try {
				table.setValueAt(jTextEditAccNo.getText(), i, 0);
				table.setValueAt(jTextEditBillDate.getText(), i, 1);
				table.setValueAt(jTextEditUserName.getText(), i, 2);
				table.setValueAt(jTextEditUserAddress.getText(), i, 3);
				table.setValueAt(jTextArrears.getText(), i, 4);
				table.setValueAt(jTextEditOldMeter.getText(), i, 5);
				table.setValueAt(jTextEditNewMeter.getText(), i, 6);
				table.setValueAt(TotalUnit.getText(), i, 7);
				table.setValueAt(Total_Charge.getText(), i, 8);
				table.setValueAt(TotalBill.getText(), i, 9); 
				} catch (Exception n) {
					JOptionPane.showMessageDialog(null, "Please Select Data That You Want To Update");
				}
				
			}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnUpdate.setBackground(Color.DARK_GRAY);
		btnUpdate.setBounds(523, 538, 126, 45);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() == -1) {
					if(table.getRowCount() == 0) {
						
						JOptionPane.showMessageDialog(null, "No Data to Delete",
								"Gigawatt Billing System",JOptionPane.OK_OPTION);
					} else {
						JOptionPane.showMessageDialog(null, "Select a row to delete",
								"Gigawatt Billing System",JOptionPane.OK_OPTION);
					}
					
				}else {
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnDelete.setBackground(Color.DARK_GRAY);
		btnDelete.setBounds(523, 606, 126, 45);
		contentPane.add(btnDelete);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					table.print();
				}
				catch(java.awt.print.PrinterException u) {
					System.err.format("No Printer Found", u.getMessage());
				}
			}
		});
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnPrint.setBackground(Color.DARK_GRAY);
		btnPrint.setBounds(523, 678, 126, 45);
		contentPane.add(btnPrint);
		
		jTextSearch = new JTextField();
		jTextSearch.setBounds(1077, 225, 412, 20);
		contentPane.add(jTextSearch);
		jTextSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = jTextEditAccNo.getText();
				for (int i=0; i<Datalist.size();i++) {
					if (Datalist.get(i).AccountNumber.equalsIgnoreCase(input)) {
						JOptionPane.showMessageDialog(btnSearch, "Found", "Search Found", 2);
						jTextEditAccNo.setText(Datalist.get(i).AccountNumber);
						jTextEditBillDate.setText(Datalist.get(i).BillDate);
						jTextEditUserName.setText(Datalist.get(i).Name);
						jTextEditUserAddress.setText(Datalist.get(i).Address);
						jTextArrears.setText(String.valueOf(Datalist.get(i).Arrears));
						jTextEditOldMeter.setText(String.valueOf(Datalist.get(i).OldMeter));
						jTextEditNewMeter.setText(String.valueOf(Datalist.get(i).NewMeter));
						TotalUnit.setText(String.valueOf(Datalist.get(i).Total_Unit));
						Total_Charge.setText(String.valueOf(Datalist.get(i).TotalCharge));
						TotalBill.setText(String.valueOf(Datalist.get(i).Total_Bill));
					}
				}
				return;
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnSearch.setBackground(Color.DARK_GRAY);
		btnSearch.setBounds(1557, 216, 126, 34);
		contentPane.add(btnSearch);
		
		JLabel lblYourAccountNumber = new JLabel("Enter Your Account Number");
		lblYourAccountNumber.setFont(new Font("Arial", Font.PLAIN, 15));
		lblYourAccountNumber.setForeground(SystemColor.text);
		lblYourAccountNumber.setBounds(854, 224, 187, 21);
		contentPane.add(lblYourAccountNumber);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(673, 262, 1159, 659);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int i=table.getSelectedRow();
				try {
				jTextEditAccNo.setText(table.getValueAt(i, 0).toString());
				jTextEditBillDate.setText(table.getValueAt(i, 1).toString());
				jTextEditUserName.setText(table.getValueAt(i, 2).toString());
				jTextEditUserAddress.setText(table.getValueAt(i, 3).toString());
				jTextArrears.setText(table.getValueAt(i, 4).toString());
				jTextEditOldMeter.setText(table.getValueAt(i, 5).toString());
				jTextEditNewMeter.setText(table.getValueAt(i, 6).toString());					
				} catch (Exception c) {
					JOptionPane.showMessageDialog(null, "Please Select Data You Want To Update");
				}
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Account Number", "Bill Date", "Name", "Address", "Arrears", "Previous Meter", "Current Meter", "Total Unit", "Current Charge", "Total Bill"
			}
		));
		table.getColumnModel().getColumn(4).setPreferredWidth(51);
		table.getColumnModel().getColumn(6).setPreferredWidth(65);
		table.getColumnModel().getColumn(7).setPreferredWidth(61);
		table.getColumnModel().getColumn(8).setPreferredWidth(54);
		scrollPane.setViewportView(table);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"Confirm if you want to exit","Gigawatt Menu",
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnExit.setBackground(Color.DARK_GRAY);
		btnExit.setBounds(523, 751, 126, 45);
		contentPane.add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 170, 1836, 5);
		contentPane.add(panel);
	}
}
