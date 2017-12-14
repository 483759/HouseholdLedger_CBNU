package ijinzzang;

//패널전환

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

//import ijinzzang.DrawChart.ChartPanel;

//import plus.InputForm;

class JPanel01 extends JPanel{ 

	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;

	private JButton writeBtn;
	private JButton changeBtn;
	private JButton eraseBtn;

	private JScrollPane jScrollPane1;
	// private JScrollPane jscroll1;
	private JTable jTable1;
	//private JTextField jtext;
	private JFrame frame1;

	private JPanelTest win;
	//InputForm form;

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

		DBConnection db = new DBConnection();

		String [] colName = {"날짜","항목","금액","수입/지출","비고"};

		String [][] data;


		data = new String[20][5];

		for(int i=0;i<20;i++)
			for(int j=0;j<5;j++)
				data[i][j] = db.arr[i][j+1];

		int i=0;

		DefaultTableModel model = new DefaultTableModel(colName, 0);
		JTable table = new JTable(model);

		while(data[i][0]!=null) {
			//String arr[] = new String[3];
			model.addRow(data[i]);
			i++;
		}

		jScrollPane1 = new JScrollPane(table);
		jScrollPane1.setSize(550, 450);
		jScrollPane1.setLocation(140, 90);
		add(jScrollPane1);


		jButton1.addActionListener(new MyActionListener1());
		jButton2.addActionListener(new MyActionListener2());
		jButton3.addActionListener(new MyActionListener3());
		jButton4.addActionListener(new MyActionListener4());
		writeBtn.addActionListener(new MyActionListener5());
		changeBtn.addActionListener(new MyActionListener6());
		eraseBtn.addActionListener(new RemoveActionListener(table));

	} 

	/*private void JTableTest() {
    // TODO Auto-generated method stub

 }
	 */
	class MyActionListener5 implements ActionListener{
		@Override
		//작성버튼 클릭시
		public void actionPerformed(ActionEvent e) {



			frame1=new JFrame("작성");
			frame1.setLocation(500, 400);
			frame1.setSize(400,400);

			Container contentPane = frame1.getContentPane();
			//income = new JCheckBox("수입");
			//expense = new JCheckBox("지출");

			frame1.setLayout(new FlowLayout());

			CheckboxGroup group = new CheckboxGroup();
			Checkbox income = new Checkbox("수입",group,false);
			Checkbox exepense = new Checkbox("지출",group,false);

			contentPane.add(income);
			contentPane.add(exepense);

			Choice ch1 = new Choice();
			ch1.addItem("외식");
			ch1.addItem("카페/간식");             /////////////// 여러개중에 한개 선택 (ex 항목)
			ch1.addItem("술/유흥");
			ch1.addItem("생활");
			ch1.addItem("쇼핑");
			ch1.addItem("미용");
			ch1.addItem("교통");
			ch1.addItem("문화");

			Choice ch2 = new Choice();
			ch2.addItem("2016");   ch2.addItem("2017");   ch2.addItem("2018");

			Choice ch3 = new Choice();
			ch3.addItem("1");   ch3.addItem("2");   ch3.addItem("3");
			ch3.addItem("4");   ch3.addItem("5");   ch3.addItem("6");
			ch3.addItem("7");   ch3.addItem("8");   ch3.addItem("9");
			ch3.addItem("10");   ch3.addItem("11");   ch3.addItem("12");

			Choice ch4 = new Choice();
			ch4.addItem("1");   ch4.addItem("2");   ch4.addItem("3");
			ch4.addItem("4");   ch4.addItem("4");   ch4.addItem("6");
			ch4.addItem("7");   ch4.addItem("8");   ch4.addItem("9");
			ch4.addItem("10");   ch4.addItem("11");   ch4.addItem("12");
			ch4.addItem("13");   ch4.addItem("14");   ch4.addItem("15");
			ch4.addItem("16");   ch4.addItem("17");   ch4.addItem("18");
			ch4.addItem("19");   ch4.addItem("20");   ch4.addItem("21");
			ch4.addItem("22");   ch4.addItem("23");   ch4.addItem("24");
			ch4.addItem("25");   ch4.addItem("26");   ch4.addItem("27");
			ch4.addItem("28");   ch4.addItem("29");   ch4.addItem("30");
			ch4.addItem("31");   

			//frame1.add(income);
			//frame1.add(expense);
			contentPane.add(ch2,BorderLayout.CENTER);
			contentPane.add(ch3,BorderLayout.EAST);
			contentPane.add(ch4,BorderLayout.SOUTH);
			contentPane.add(ch1,BorderLayout.NORTH);

			//JButton yes = new JButton();
			//yes.setSize(20,10);
			//yes.setLocation(30,30);


			/*jscroll1 = new JScrollPane(jtext);
    jscroll1.setSize(100,100);
    jscroll1.setLocation(10,100);*/
			//frame1.add();

			//jtext.setBounds(10,200,30,21);
			//jtext.setLocation(30,30);
			//jtext.setColumns(10);

			frame1.setVisible(true);

			// frame1.add(jtext);

		}


	}
	class MyActionListener6 implements ActionListener{
		@Override
		//수정버튼 클릭시
		public void actionPerformed(ActionEvent e) {

		}

	}

	class RemoveActionListener implements ActionListener{
		//@Override
		//삭제버튼 클릭시
		JTable table;

		RemoveActionListener(JTable table){
			this.table = table;
		}

		public void actionPerformed(ActionEvent e){
			int row = table.getSelectedRow();
			DBConnection db = new DBConnection();

			if(row==-1)
				return;

			db.remove(row);

			DefaultTableModel model = (DefaultTableModel)table.getModel();
			model.removeRow(row);

			win.change("panel01");
		}
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
			//win.change("panel03");
			new DrawChart2();
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
	//private JPasswordField listField;
	private JPanelTest win;

	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;

	private JTable jTable2;
	private JScrollPane jScrollPane2;

	public JPanel04(JPanelTest win) {
		setLayout(null);
		this.win=win;

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

		TodayWork db = new TodayWork();

		String [][] data2 ;
		String [] title = {"날짜","메모1","메모2","메모3"};

		data2 = new String[20][4];

		for(int i=0;i<20;i++)
			for(int j=0;j<4;j++)
				data2[i][j] = db.arr2[i][j];

		jTable2 = new JTable(data2, title);
		jTable2.setFillsViewportHeight(true);
		jTable2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		jScrollPane2 = new JScrollPane(jTable2);
		jScrollPane2.setSize(550,450);
		jScrollPane2.setLocation(140,90); //가로,세로
		add(jScrollPane2);

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
			//win.change("panel03");

			new DrawChart2();
		}
	}
	class MyActionListener4 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			win.change("panel04");
		}
	}
}

class DrawChart2 extends JFrame {
	int[] data = {30,10,5,10,10,10,15,10}; // 차트의 값 저장배열
	int[] arcAngle = new int[8]; 

	Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.GREEN, Color.YELLOW, Color.CYAN, Color.PINK};

	String[] itemName = {"외식", "카페·간식", "술·유흥", "생활", "쇼핑", "미용", "교통", "문화생활"};

	Container con;

	DrawChart2(){ // 생성자
		ChartPanel chartPanel = new ChartPanel(); // 차트패널
		//chartPanel.setLocation(100, 100);
		chartPanel.validate();
		//chartPanel.setVisible(true);
		setSize(600, 500);
		add(chartPanel);

		setVisible(true);

		int sum=0; // 초기값 0

		for(int i=0;i<data.length;i++)
			sum+=data[i];
		//if(sum == 0) return;		

		for(int i=0;i<data.length;i++){ 
			arcAngle[i] = (int)Math.round((double)data[i]/(double)sum*360);
			chartPanel.repaint(); // 차트패널의 PAINT호출
		}
	}

	class ChartPanel extends JPanel{ // 차트 표시 패널

		public void paintComponent(Graphics g){

			super.paintComponent(g);//부모 패인트호출

			int startAngle = 0;

			for(int i=0;i<data.length;i++){
				g.setColor(color[i]);
				g.drawString(itemName[i]+""+Math.round(arcAngle[i]*100/360)+"%", 400,50 + i*50);
			}

			for(int i=0;i<data.length;i++){
				g.setColor(color[i]);
				g.fillArc(150,100,200,200,startAngle,arcAngle[i]);
				startAngle = startAngle + arcAngle[i];
			}
		}
	}

}



class JPanel03 extends JPanel{
	private JPasswordField listField;
	private JPanelTest win;

	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;

	public JPanel03(JPanelTest win) {
		setLayout(null);
		this.win=win;

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
			new DrawChart2();

			//win.change("panel03");
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

	private JTable jTable2;
	private JScrollPane jScrollPane2;

	public JPanel02(JPanelTest win) {
		setLayout(null);
		this.win=win;

		/*
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
		 */


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

		DBConnection db = new DBConnection();
		int n=0;

		String [] colName = {"날짜","금액"};
		String [][] data1 = new String[20][2];

		for(int i=0; i<20; i++) {
			if((db.arr[i][4]).equals("0")) {	//수입이면
				data1[n][0] = db.arr[i][1];
				data1[n][1] = db.arr[i][3];
				n++;
			}
		}

		DefaultTableModel model = new DefaultTableModel(colName, 0);
		JTable table = new JTable(model);

		n = 0;
		while(data1[n][0]!=null) {
			//String arr[] = new String[3];
			model.addRow(data1[n]);
			n++;
		}

		jScrollPane2 = new JScrollPane(table);
		jScrollPane2.setSize(250, 200);
		jScrollPane2.setLocation(140, 90);
		add(jScrollPane2);


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
			//win.change("panel03");

			new DrawChart2();

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
		win.setSize(800,650);
		win.setVisible(true);
	}

}
