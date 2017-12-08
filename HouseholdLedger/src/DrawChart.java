import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
class InfoStatic extends DBMain{
	
	
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
  
	
	//DBConnection d = new DBConnection();
	void drawChart(){ // ��Ʈ�� �׸���
		int sum=0; // �ʱⰪ 0
		for(int i=0;i<data.length;i++){ // ������ ����ŭ ����
			data[i] = Integer.parseInt(tf[i].getText());
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