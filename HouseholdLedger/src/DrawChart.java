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
		
		System.out.println("���� : " + inc + ", ���� : " + exp);

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

		System.out.print("Sum = ");

		for(i=0;i<cat.length-1;i++)
			System.out.print(cat[i] + " ");
		System.out.println(cat[i]);

	}

}

public class DrawChart extends JFrame {
	Container contentPane; // �����̳� ����
	int[] data = {0,0,0,0,0,0,0,0}; // ��Ʈ�� �� ����迭
	int[] arcAngle = new int[8]; 

	Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE, Color.GREEN, Color.YELLOW, Color.CYAN, Color.PINK};

	String[] itemName = {"�ܽ�", "ī�䡤����", "��������", "��Ȱ", "����", "�̿�", "����", "��ȭ��Ȱ"};

	JTextField[] tf  = new JTextField[8]; // �ؽ�Ʈ�ʵ�
	ChartPanel chartPanel = new ChartPanel(); // ��Ʈ�г�
	//DBMain DB = new DBMain();

	public DrawChart(){ // ������
		setTitle("��Ʈ �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane(); // �����̳� ��
		contentPane.add(new InputPanel(), BorderLayout.NORTH);
		contentPane.add(chartPanel, BorderLayout.CENTER);
		setSize(1000,350);
		setVisible(true);
		drawChart(); // ��Ʈ �޼ҵ� ȣ��	
	}

	void drawChart(){ // ��Ʈ�� �׸���
		int sum=0; // �ʱⰪ 0
		InfoStatic inf = new InfoStatic();

		inf.CalCategory();
		inf.CalClassification();

		for(int i=0;i<data.length;i++){ // ������ ����ŭ ����
			data[i] = inf.cat[i];
			sum+=data[i];
		}
		if(sum == 0) 
			return;

		for(int i=0;i<data.length;i++){ 
			arcAngle[i] = (int)Math.round((double)data[i]/(double)sum*360);
			chartPanel.repaint(); // ��Ʈ�г��� PAINTȣ��
		}
	}

	class InputPanel extends JPanel{ // �Է��г�
		public InputPanel(){
			this.setBackground(Color.LIGHT_GRAY); //���

			for(int i=0;i<tf.length;i++){ // �� ����������ŭ
				tf[i] = new JTextField("0", 5);
				tf[i].addActionListener(new MyActionListener()); //������
				add(new JLabel(itemName[i]));
				add(tf[i]);
			}
		}
	}

	class MyActionListener implements ActionListener{ //�׼Ǹ�����
		public void actionPerformed(ActionEvent e){ //�ؽ�Ʈ�ʵ庯ȭ��
			JTextField t = (JTextField)e.getSource();
			int n;

			try{
				n = Integer.parseInt(t.getText());
			}
			catch(NumberFormatException ex){
				t.setText("0");
				return;
			}
			drawChart(); // ȣ��	
		}
	}

	class ChartPanel extends JPanel{ // ��Ʈ ǥ�� �г�

		public void paintComponent(Graphics g){

			super.paintComponent(g);//�θ� ����Ʈȣ��

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