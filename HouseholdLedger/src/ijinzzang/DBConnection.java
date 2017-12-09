package ijinzzang;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection{
	static String url = "jdbc:mysql://localhost/info";
	static String user = "root";
	static String pass = "426795";
	int presentid = 0;
	Connection conn = null;
	Statement st = null;
	public String[][] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnection start = new DBConnection();

		try {
			//start.insert();
			start.print();
			start.DBClose();
		}catch(Exception e) {
			System.out.println("DB ���� �Ұ�");
		}
	}
	
	public DBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//����̹� ����
		} catch(ClassNotFoundException e) {
			System.out.println("����̹� �˻� ����!");
		}

		try {
			conn = DriverManager.getConnection(url, user, pass);
			//mysql ������ ����
		} catch(SQLException e) {
			System.out.println("My-SQL ���� ����!");
		}
		
		inquiry();

	}


	public void inquiry(){	//DB�� ����� ������ �ҷ����� �Լ�
		ResultSet rs = null;
		int i = 0;
		arr = new String[20][6];
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT id, date, category, money, sort, note FROM user");
			//user���̺��� �÷����� �ҷ��´�

			while(rs.next()) {
				int id = rs.getInt("id");
				String date = rs.getString("date");
				String ctg = rs.getString("category");
				int money = rs.getInt("money");
				int srt = rs.getInt("sort");
				String note = rs.getString("note");

				arr[i][0] = Integer.toString(id);
				arr[i][1] = date;
				arr[i][2] = ctg;
				arr[i][3] = Integer.toString(money);
				arr[i][4] = Integer.toString(srt);
				arr[i++][5] = note;

				if(presentid<id)
					presentid = id;
			}	//���̺��� �׸���� ���

			rs.close();
		}catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}
	}

	public void insert() throws Exception{	//DB�� �� ������ �����ϴ� �Լ�
		int rs2;
		int id=0;
		int srt=0;
		String date="";
		int money=0;
		String category="";
		String note = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try{
			id = ++presentid;
			System.out.print("��¥�� �Է��ϼ��� : ");
			date = in.readLine();
			System.out.print("�׸��� �Է��ϼ��� : ");
			category = in.readLine();
			System.out.print("�ݾ��� �Է��ϼ��� : ");
			money = Integer.parseInt(in.readLine());
			System.out.print("������ �Է��ϼ���(����-0/����-1) : ");
			srt = Integer.parseInt(in.readLine());
			System.out.print("�޸� �Է��ϼ��� : ");
			note = in.readLine();
		}catch(Exception e) {
			System.out.println("�Է� ����");
		}

		try {	//�Է��� �����͸� DB�� user���̺� ����
			String sql = "INSERT INTO user(id, date, category, money, sort, note)";
			sql += "VALUES(" + "'" + id + "','" + date + "','" + category + "','" + money + "','" + srt + "','" + note + "');";
			st.executeUpdate(sql);

		}catch(SQLException e) {
			System.out.println("SQLException : "+ e.getMessage());
		}
	}
	
	public void print() {
		int i = 0;
		
		while(arr[i][0]!=null) {
			System.out.print("��ȣ-" + arr[i][0]);
			System.out.print(" , ��¥ : " + arr[i][1]);
			System.out.print(" , �׸� : " + arr[i][2]);
			System.out.print(" , �ݾ� : " + arr[i][3]);
			System.out.print(" , �з� : " + (arr[i][4].equals("0")?"����":"����"));
			System.out.println(" , ��� : " + arr[i][5]);
			i++;
		}
	}

	public void DBClose() {
		try {
			st.close();			
			conn.close();
		}catch(Exception e) {
			System.out.println("SQLException : "+ e.getMessage());
		}
	}
}
