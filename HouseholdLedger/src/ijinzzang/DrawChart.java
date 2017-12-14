package ijinzzang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class InfoStatic extends DBConnection{

	int[] cat = {0, 0, 0, 0, 0, 0, 0, 0};
	int inc = 0;
	int exp = 0;
	String[] grp = {"Dining", "Cafe/Nosh", "Drink", "Life", "Shopping", "Beauty", "Traffic", "Leisure"};

	void CalClassification() {
		ResultSet rs = null;
		
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


	}

}

public class DrawChart extends JFrame {
	Container con; // 컨테이너 생성
	int[] data = {0,0,0,0,0,0,0,0}; // 차트의 값 저장배열
	int[] arcAngle = new int[8]; 

	Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.GREEN, Color.YELLOW, Color.CYAN, Color.PINK};

	String[] itemName = {"외식", "카페·간식", "술·유흥", "생활", "쇼핑", "미용", "교통", "문화생활"};

	ChartPanel chartPanel = new ChartPanel(); // 차트패널

	public static void main(String[] args) {
		new DrawChart();
	}
	
	public DrawChart(){ // 생성자
		chartPanel.validate();
		setSize(600, 500);
		add(chartPanel);
		
		setVisible(true);
		
		int sum = 0;
		InfoStatic inf = new InfoStatic();
		
		inf.CalCategory();
		inf.CalClassification();
		
		for(int i=0;i<data.length;i++) {
			data[i] = inf.cat[i];
			sum+=data[i];
		}
		if(sum == 0) return;		

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
				g.fillArc(150,50,200,200,startAngle,arcAngle[i]);
				startAngle = startAngle + arcAngle[i];
			}
		}
	}
	

}