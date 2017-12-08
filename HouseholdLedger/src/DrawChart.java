import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class InfoStatic extends DBMain{

	int[] cat = {0, 0, 0, 0, 0, 0, 0, 0};
	int inc = 0;
	int exp = 0;

	void CalClassification() {
		ResultSet rs = null;
		String[] grp = {"Dining", "Cafe/Nosh", "Drink", "Life", "Shopping", "Beauty", "Traffic", "Leisure"};
		int i = 0;

		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT sort, money FROM user");
			//user테이블의 컬럼들을 불러온다

			while(rs.next()) {
				int money = rs.getInt("money");
				int srt = rs.getInt("sort");

				if(srt==1)
					exp += money;
				else
					inc += money;	

			}
		}catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}
		
		System.out.println("수입 : " + inc + ", 지출 : " + exp);

	}

	void CalCategory() {
		ResultSet rs = null;
		String[] grp = {"Dining", "Cafe/Nosh", "Drink", "Life", "Shopping", "Beauty", "Traffic", "Leisure"};
		int i = 0;

		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT money, category FROM user");
			//user테이블의 컬럼들을 불러온다

			while(rs.next()) {
				int money = rs.getInt("money");
				String ctg = rs.getString("category");

				//System.out.print("money : " + money);
				//System.out.println(", category : " + ctg);

				if(ctg.equals(grp[0]))
					cat[0] += money;
				else if(ctg.equals(grp[1]))
					cat[1] += money;
				else if(ctg.equals(grp[2]))
					cat[2] += money;
				else if(ctg.equals(grp[3]))
					cat[3] += money;
				else if(ctg.equals(grp[4]))
					cat[4] += money;
				else if(ctg.equals(grp[5]))
					cat[5] += money;
				else if(ctg.equals(grp[6]))
					cat[6] += money;
				else if(ctg.equals(grp[7]))
					cat[7] += money;
			}	//테이블의 항목들을 출력

		}catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}

		System.out.print("Sum = ");

		for(i=0;i<cat.length-1;i++)
			System.out.print(cat[i] + " ");
		System.out.println(cat[i]);

	}

}

public class DrawChart extends JFrame {
	Container contentPane; // 컨테이너 생성
	int[] data = {0,0,0,0,0,0,0,0}; // 차트의 값 저장배열
	int[] arcAngle = new int[8]; 

	Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.GREEN, Color.YELLOW, Color.CYAN, Color.PINK};

	String[] itemName = {"외식", "카페·간식", "술·유흥", "생활", "쇼핑", "미용", "교통", "문화생활"};

	JTextField[] tf  = new JTextField[8]; // 텍스트필드
	ChartPanel chartPanel = new ChartPanel(); // 차트패널
	//DBMain DB = new DBMain();

	public DrawChart(){ // 생성자
		setTitle("차트 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane(); // 컨테이너 갯
		contentPane.add(new InputPanel(), BorderLayout.NORTH);
		contentPane.add(chartPanel, BorderLayout.CENTER);
		setSize(1000,350);
		setVisible(true);
		drawChart(); // 차트 메소드 호출	
	}

	void drawChart(){ // 차트를 그린다
		int sum=0; // 초기값 0
		InfoStatic inf = new InfoStatic();

		inf.CalCategory();
		inf.CalClassification();

		for(int i=0;i<data.length;i++){ // 데이터 값만큼 루프
			data[i] = inf.cat[i];
			sum+=data[i];
		}
		if(sum == 0) 
			return;

		for(int i=0;i<data.length;i++){ 
			arcAngle[i] = (int)Math.round((double)data[i]/(double)sum*360);
			chartPanel.repaint(); // 차트패널의 PAINT호출
		}
	}

	class InputPanel extends JPanel{ // 입력패널
		public InputPanel(){
			this.setBackground(Color.LIGHT_GRAY); //배경

			for(int i=0;i<tf.length;i++){ // 현 가진갯수만큼
				tf[i] = new JTextField("0", 5);
				tf[i].addActionListener(new MyActionListener()); //리스너
				add(new JLabel(itemName[i]));
				add(tf[i]);
			}
		}
	}

	class MyActionListener implements ActionListener{ //액션리스너
		public void actionPerformed(ActionEvent e){ //텍스트필드변화시
			JTextField t = (JTextField)e.getSource();
			int n;

			try{
				n = Integer.parseInt(t.getText());
			}
			catch(NumberFormatException ex){
				t.setText("0");
				return;
			}
			drawChart(); // 호출	
		}
	}

	class ChartPanel extends JPanel{ // 차트 표시 패널

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

	public static void main(String[] args) {
		new DrawChart();
	}
}