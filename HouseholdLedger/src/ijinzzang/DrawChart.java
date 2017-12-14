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
			//user���̺��� �÷����� �ҷ��´�

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
			//user���̺��� �÷����� �ҷ��´�

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
			}	//���̺��� �׸���� ���

		}catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}


	}

}

public class DrawChart extends JFrame {
	Container con; // �����̳� ����
	int[] data = {0,0,0,0,0,0,0,0}; // ��Ʈ�� �� ����迭
	int[] arcAngle = new int[8]; 

	Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.GREEN, Color.YELLOW, Color.CYAN, Color.PINK};

	String[] itemName = {"�ܽ�", "ī�䡤����", "��������", "��Ȱ", "����", "�̿�", "����", "��ȭ��Ȱ"};

	ChartPanel chartPanel = new ChartPanel(); // ��Ʈ�г�

	public static void main(String[] args) {
		new DrawChart();
	}
	
	public DrawChart(){ // ������
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
			chartPanel.repaint(); // ��Ʈ�г��� PAINTȣ��
		}

	}
	
	class ChartPanel extends JPanel{ // ��Ʈ ǥ�� �г�

		public void paintComponent(Graphics g){

			super.paintComponent(g);//�θ� ����Ʈȣ��

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