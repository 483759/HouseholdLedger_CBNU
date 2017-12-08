import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

class DBMain{
	static String url = "jdbc:mysql://localhost/info";
	static String user = "root";
	static String pass = "426795";
	int presentid = 0;
	int[] cat = {0, 0, 0, 0, 0, 0, 0, 0};
	//int inc = 0;
	//int exp = 0;
	Connection conn = null;
	Statement st = null;

	//enum grp{Din, Caf, Dri, Lif, Sho, Bea, Tra, Lei}

	public DBMain() {
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

	}
	

	public void inquiry() throws Exception{	//DB�� ����� ������ �ҷ����� �Լ�
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT id, date, money, category, note FROM user");
			//user���̺��� �÷����� �ҷ��´�

			while(rs.next()) {
				int id = rs.getInt("id");
				String date = rs.getString("date");
				int money = rs.getInt("money");
				String ctg = rs.getString("category");
				//String note = rs.getString("note");

				System.out.print("id : " + id);
				System.out.print(", date : " + date);
				System.out.print(", money : " + money);
				System.out.println(", category : " + ctg);

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
		String date="";
		int money=0;
		String category="";
		String note = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try{
			id = ++presentid;
			System.out.print("��¥�� �Է��ϼ��� : ");
			date = in.readLine();
			System.out.print("�ݾ��� �Է��ϼ��� : ");
			money = Integer.parseInt(in.readLine());
			System.out.print("�׸��� �Է��ϼ��� : ");
			category = in.readLine();
			System.out.print("�޸� �Է��ϼ��� : ");
			note = in.readLine();
		}catch(Exception e) {
			System.out.println("�Է� ����");
		}

		try {	//�Է��� �����͸� DB�� user���̺� ����
			String sql = "INSERT INTO user(id, date, money, category, note)";
			sql += "VALUES(" + "'" + id + "','" + date + "','" + money + "','" + category + "','" + note + "');";
			st.executeUpdate(sql);

		}catch(SQLException e) {
			System.out.println("SQLException : "+ e.getMessage());
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


public class DBConnection {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBMain start = new DBMain();

		try {
			start.inquiry();
			//start.calculate();
			start.insert();
			start.DBClose();
		}catch(Exception e) {
			System.out.println("DB ���� �Ұ�");
		}
	}
}