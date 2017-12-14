//패널전환

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

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
	

	
	jTable1 = new JTable();
	jTable1.setFillsViewportHeight(true);
	jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	jScrollPane1 = new JScrollPane(jTable1);
	jScrollPane1.setSize(550,450);
	jScrollPane1.setLocation(140,90); //가로,세로
	add(jScrollPane1);
	
	
	
	jButton1.addActionListener(new MyActionListener1());
	jButton2.addActionListener(new MyActionListener2());
	jButton3.addActionListener(new MyActionListener3());
	jButton4.addActionListener(new MyActionListener4());
	writeBtn.addActionListener(new MyActionListener5());
	changeBtn.addActionListener(new MyActionListener6());
	eraseBtn.addActionListener(new MyActionListener7());
	
	 } 

/*private void JTableTest() {
		// TODO Auto-generated method stub
		
	}
*/

class MyActionListener5 implements ActionListener{
	@Override
	//작성버튼 클릭시
	public void actionPerformed(ActionEvent e) {
		
		
		//Container contentPane = frame1.getContentPane();
		JPanel Panel1 = new JPanel();
		JPanel Panel2 = new JPanel();
		frame1=new JFrame("작성");
		frame1.setLocation(200, 150);
		frame1.setSize(400,400);
		frame1.setLayout(null);
		//Container contentPane = frame1.getContentPane();
		
	
		CheckboxGroup group = new CheckboxGroup();
		Checkbox income = new Checkbox("수입",group,false);
		Checkbox expense = new Checkbox("지출",group,false);
		

		Choice cate = new Choice();
		cate.addItem("외식");
		cate.addItem("카페/간식");             /////////////// 여러개중에 한개 선택 (ex 항목)
		cate.addItem("술/유흥");
		cate.addItem("생활");
		cate.addItem("쇼핑");
		cate.addItem("미용");
		cate.addItem("교통");
		cate.addItem("문화");
		
		Choice year = new Choice();
		year.addItem("2016");	year.addItem("2017");	year.addItem("2018");
		
		Choice month = new Choice();
		month.addItem("1");	month.addItem("2");	month.addItem("3");
		month.addItem("4");	month.addItem("5");	month.addItem("6");
		month.addItem("7");	month.addItem("8");	month.addItem("9");
		month.addItem("10");month.addItem("11");month.addItem("12");
		
		Choice date = new Choice();
		date.addItem("1");	date.addItem("2");	date.addItem("3");
		date.addItem("4");	date.addItem("4");	date.addItem("6");
		date.addItem("7");	date.addItem("8");	date.addItem("9");
		date.addItem("10");	date.addItem("11");	date.addItem("12");
		date.addItem("13");	date.addItem("14");	date.addItem("15");
		date.addItem("16");	date.addItem("17");	date.addItem("18");
		date.addItem("19");	date.addItem("20");	date.addItem("21");
		date.addItem("22");	date.addItem("23");	date.addItem("24");
		date.addItem("25");	date.addItem("26");	date.addItem("27");
		date.addItem("28");	date.addItem("29");	date.addItem("30");
		date.addItem("31");	
		
		
		
		income.setBounds(290,7,40,30);
		frame1.add(income);
		expense.setBounds(330,7,40,30);
		frame1.add(expense);
		
		year.setLocation(10,10);
		frame1.add(year);
		
		JLabel year1= new JLabel("년");
		year1.setBounds(70,13,20,20);
		frame1.add(year1);
		
		month.setLocation(100,10);
		frame1.add(month);
		
		JLabel month1= new JLabel("월");
		month1.setBounds(150,13,20,20);
		frame1.add(month1);
		
		date.setLocation(190,10);
		frame1.add(date);
		
		JLabel date1= new JLabel("일");
		date1.setBounds(240,13,20,20);
		frame1.add(date1);
		
		JLabel cate1= new JLabel("항목");
		cate1.setBounds(10,37,40,50);
		frame1.add(cate1);
		
		cate.setLocation(50,50);
		frame1.add(cate);
		
		JLabel label1= new JLabel("금액");
		label1.setBounds(190,37,50,50);
		frame1.add(label1);
		
		JTextField won = new JTextField();
		won.setBounds(230,50,100,25);
		frame1.add(won);
		
		JLabel label2 = new JLabel("비고");
		label2.setBounds(10,75,50,50);
		frame1.add(label2);
		
		JTextArea bigo = new JTextArea();
		JScrollPane scrollpane = new JScrollPane(bigo);
		scrollpane.setBounds(10,120,365,200);
		frame1.add(scrollpane);
		
		JButton no = new JButton("취소");
		no.setSize(60,25);
		no.setLocation(120,330);
		frame1.add(no);
		
		JButton yes = new JButton("확인");
		yes.setSize(60,25);
		yes.setLocation(190,330);
		frame1.add(yes);
		
		
		
		frame1.setVisible(true);
		
		
		
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
	
		
		no.addActionListener(new ActionListener(){
			//작성창 취소
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
			}
		});
		
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			// 내용넣기
			}
		});
		
	}
	
}

class MyActionListener6 implements ActionListener{
	@Override
	//수정버튼 클릭시
	public void actionPerformed(ActionEvent e) {
		
	}
			
}
	 
class MyActionListener7 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
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
	
	public int[] cat = {30, 15, 5, 10, 10, 10, 10, 10};
	public int[] data = {0,0,0,0,0,0,0,0};
	public int[] arcAngle = new int[8]; 
	public Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.GREEN, Color.YELLOW, Color.CYAN, Color.PINK};
	String[] itemName = {"외식", "카페·간식", "술·유흥", "생활", "쇼핑", "미용", "교통", "문화생활"};
	public JPanel03(JPanelTest win) {
		setLayout(null);
		this.win=win;
		
		
		
		/*
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
		*/
		class ChartPanel extends JPanel{
			 public void paintComponent(Graphics g){

		         super.paintComponent(g);//부모 패인트호출

		         int startAngle = 0;

		         for(int i=0;i<data.length;i++){
		            g.setColor(color[i]);
		            g.drawString(itemName[i]+""+Math.round(arcAngle[i]*100/360)+"%", 50+i*100,20);
		         }

		         for(int i=0;i<data.length;i++){
		            g.setColor(color[i]);
		            g.fillArc(150,50,200,200,startAngle,arcAngle[i]);
		            startAngle = startAngle + arcAngle[i];
		         }
		      }
		}
		
		
		
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
		
		

		
		
		ChartPanel chartPanel = new ChartPanel();
		drawChart();
		
		chartPanel.setLocation(100,100);
		add(chartPanel);
		
		
		
	}

	
	
		
	
	private void drawChart() {
		int sum=0;
		InfoStatic inf = new InfoStatic();
		
		 for(int i=0;i<data.length;i++){ // 데이터 값만큼 루프
	         data[i] = inf.cat[i];
	         sum+=data[i];
	      }
	      if(sum == 0) 
	         return;

	      for(int i=0;i<data.length;i++){ 
	         arcAngle[i] = (int)Math.round((double)data[i]/(double)sum*360);
	         //chartPanel.repaint(); // 차트패널의 PAINT호출
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

