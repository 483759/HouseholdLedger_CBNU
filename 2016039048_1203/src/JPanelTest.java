//패널전환
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField; 
 
 
 class JPanel01 extends JPanel{ 
	
	 private JButton jButton1;
	 private JButton jButton2;
	 private JButton jButton3;
	 private JButton jButton4;
	 
	 private JButton writeBtn;
	 private JButton changeBtn;
	 private JButton eraseBtn;

	 private JScrollPane jScrollPane1;
	 private JTable jTable1;
	 private JPanelTest win;	

	 public JPanel01(JPanelTest win) {
		 this.win=win;
		 setLayout(null);
	
	jButton1 = new JButton("월별로 보기");
	jButton1.setSize(100,20);
	jButton1.setLocation(10,90);
	add(jButton1);
	
	jButton2 = new JButton("지출 분석");
	jButton2.setSize(100,20);
	jButton2.setLocation(10,130);
	add(jButton2);
	
	jButton3 = new JButton("차트로 보기");
	jButton3.setSize(100,20);
	jButton3.setLocation(10,170);
	add(jButton3);
	
	jButton4 = new JButton("오늘 할 일");
	jButton4.setSize(100,20);
	jButton4.setLocation(10,210);
	add(jButton4);
	
	writeBtn = new JButton("작성");
	writeBtn.setSize(70,20);
	writeBtn.setLocation(700,90);
	add(writeBtn);
	
	changeBtn = new JButton("수정");
	changeBtn.setSize(70,20);
	changeBtn.setLocation(700,130);
	add(changeBtn);
	
	eraseBtn = new JButton("삭제");
	eraseBtn.setSize(70,20);
	eraseBtn.setLocation(700,170);
	add(eraseBtn);
	//
	
	String [] [] data;
	String [] title = {"날짜","항목","금액","수입/지출","비고"};
	
	data = new String[3][5];
	
	data[0][0]="2017.12.18";
	data[0][1]="수입";
	data[0][2]="100,000";
	data[0][3]="용돈";
	data[0][4]=" ";
	
	data[1][0]="2017.12.18";
	data[1][1]="지출";
	data[1][2]="10,000";
	data[1][3]="식비";
	data[1][4]=" ";
	
	data[2][0]="2017.12.18";
	data[2][1]="지출";
	data[2][2]="5,000";
	data[2][3]="생활비";
	data[2][4]=" ";
	
	jTable1=new JTable(data,title);
	
	jScrollPane1 = new JScrollPane(jTable1);
	jScrollPane1.setSize(550,450);
	jScrollPane1.setLocation(140,90); //가로,세로
	add(jScrollPane1);
	
	jButton1.addActionListener(new MyActionListener1());
	jButton2.addActionListener(new MyActionListener2());
	jButton3.addActionListener(new MyActionListener3());
	jButton4.addActionListener(new MyActionListener4());
	 
	 } 
	 
class MyActionListener1 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		win.change("panel01");
	}
	
}
class MyActionListener2 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		win.change("panel02");
	}
}
class MyActionListener3 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		win.change("panel03");
	}
}
class MyActionListener4 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		win.change("panel04");
	}
}
 }
 
class JPanel04 extends JPanel{
	private JTextField textField;
	private JPasswordField listField;
	private JPanelTest win;
	
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	
	public JPanel04(JPanelTest win) {
		setLayout(null);
		this.win=win;
		
		
		JLabel lblLbl = new JLabel("4번패널:");
		lblLbl.setBounds(150,90,100,21); // x,y,width,height
		add(lblLbl);
		
		textField = new JTextField();
		textField.setBounds(200,90,116,21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblLbl_1 = new JLabel("항목:");
		lblLbl_1.setBounds(150, 130, 100, 21);
		add(lblLbl_1);
		
		listField = new JPasswordField();
		listField.setBounds(200,130,116,21);
		add(listField);
		
		
		jButton1 = new JButton("월별로 보기");
		jButton1.setSize(100,20);
		jButton1.setLocation(10,90);
		add(jButton1);
		
		jButton2 = new JButton("지출 분석");
		jButton2.setSize(100,20);
		jButton2.setLocation(10,130);
		add(jButton2);
		
		jButton3 = new JButton("차트로 보기");
		jButton3.setSize(100,20);
		jButton3.setLocation(10,170);
		add(jButton3);
		
		jButton4 = new JButton("오늘 할 일");
		jButton4.setSize(100,20);
		jButton4.setLocation(10,210);
		add(jButton4);
		
		
		
		jButton1.addActionListener(new MyActionListener1());
		jButton2.addActionListener(new MyActionListener2());
		jButton3.addActionListener(new MyActionListener3());
		jButton4.addActionListener(new MyActionListener4());
	}
	class MyActionListener1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel01");
		}
	}
	class MyActionListener2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel02");
		}
	}
	class MyActionListener3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel03");
		}
	}
	class MyActionListener4 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel04");
		}
	}
}

class JPanel03 extends JPanel{
	
	private JTextField textField;
	private JPasswordField listField;
	private JPanelTest win;
	
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	
	public JPanel03(JPanelTest win) {
		setLayout(null);
		this.win=win;
		
		
		JLabel lblLbl = new JLabel("3번패널:");
		lblLbl.setBounds(150,90,100,21); // x,y,width,height
		add(lblLbl);
		
		textField = new JTextField();
		textField.setBounds(200,90,116,21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblLbl_1 = new JLabel("항목:");
		lblLbl_1.setBounds(150, 130, 100, 21);
		add(lblLbl_1);
		
		listField = new JPasswordField();
		listField.setBounds(200,130,116,21);
		add(listField);
		
		
		jButton1 = new JButton("월별로 보기");
		jButton1.setSize(100,20);
		jButton1.setLocation(10,90);
		add(jButton1);
		
		jButton2 = new JButton("지출 분석");
		jButton2.setSize(100,20);
		jButton2.setLocation(10,130);
		add(jButton2);
		
		jButton3 = new JButton("차트로 보기");
		jButton3.setSize(100,20);
		jButton3.setLocation(10,170);
		add(jButton3);
		
		jButton4 = new JButton("오늘 할 일");
		jButton4.setSize(100,20);
		jButton4.setLocation(10,210);
		add(jButton4);
		
		
		
		jButton1.addActionListener(new MyActionListener1());
		jButton2.addActionListener(new MyActionListener2());
		jButton3.addActionListener(new MyActionListener3());
		jButton4.addActionListener(new MyActionListener4());
	}
	class MyActionListener1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel01");
		}
	}
	class MyActionListener2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel02");
		}
	}
	class MyActionListener3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel03");
		}
	}
	class MyActionListener4 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel04");
		}
	}
	
}


class JPanel02 extends JPanel{
	private JTextField textField;
	private JPasswordField listField;
	private JPanelTest win;
	
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	
	public JPanel02(JPanelTest win) {
		setLayout(null);
		this.win=win;
		
		
		JLabel lblLbl = new JLabel("2번패널:");
		lblLbl.setBounds(150,90,100,21); // x,y,width,height
		add(lblLbl);
		
		textField = new JTextField();
		textField.setBounds(200,90,116,21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblLbl_1 = new JLabel("항목:");
		lblLbl_1.setBounds(150, 130, 100, 21);
		add(lblLbl_1);
		
		
		listField = new JPasswordField();
		listField.setBounds(200,130,116,21);
		add(listField);
		
		jButton1 = new JButton("월별로 보기");
		jButton1.setSize(100,20);
		jButton1.setLocation(10,90);
		add(jButton1);
		
		jButton2 = new JButton("지출 분석");
		jButton2.setSize(100,20);
		jButton2.setLocation(10,130);
		add(jButton2);
		
		jButton3 = new JButton("차트로 보기");
		jButton3.setSize(100,20);
		jButton3.setLocation(10,170);
		add(jButton3);
		
		jButton4 = new JButton("오늘 할 일");
		jButton4.setSize(100,20);
		jButton4.setLocation(10,210);
		add(jButton4);
		
		
		
		jButton1.addActionListener(new MyActionListener1());
		jButton2.addActionListener(new MyActionListener2());
		jButton3.addActionListener(new MyActionListener3());
		jButton4.addActionListener(new MyActionListener4());
	}
	
	class MyActionListener2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel02");
		}
	}
	class MyActionListener1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel01");
		}
	}
	class MyActionListener3 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel03");
		}
	}
	class MyActionListener4 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel04");
		}
	}
}
		

class JPanelTest extends JFrame {

	public JPanel01 jpanel01 =null;
	public JPanel02 jpanel02 = null;
	private JPanel03 jpanel03 =null;
	public JPanel04 jpanel04 = null;
	
	
	public void change(String panelName) {
		
		if(panelName.equals("panel01")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel01);
			revalidate();
			repaint();
		}else if(panelName.equals("panel02")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel02);
			revalidate();
			repaint();
		}else if(panelName.equals("panel03")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel03);
			revalidate();
			repaint();
		}
		else if(panelName.equals("panel04")) {
			getContentPane().removeAll();
			getContentPane().add(jpanel04);
			revalidate();
			repaint();
		}
		
	}
	
	public static void main(String[] args) {
		
		JPanelTest win = new JPanelTest();
		
		win.setTitle("frame test");
		win.jpanel01 = new JPanel01(win);
		win.jpanel02 = new JPanel02(win);
		win.jpanel03  = new JPanel03(win);
		win.jpanel04 = new JPanel04(win);
		
		win.add(win.jpanel01);
		win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		win.setSize(800,600);
		win.setVisible(true);
	}

}

