package ijinzzang;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodayWork extends DBConnection{

	String[][] arr2;

	public TodayWork() {
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
	
	public void inquiry(){	//DB�� ����� ������ �ҷ����� �Լ�
		ResultSet rs = null;
		int i = 0;
		arr = new String[20][4];
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT date, str1, str2, str3 FROM work");
			//user���̺��� �÷����� �ҷ��´�

			while(rs.next()) {
				String date = rs.getString("date");
				String str1 = rs.getString("str1");
				String str2 = rs.getString("str2");
				String str3 = rs.getString("str3");
				
				arr[i][0] = date;
				arr[i][1] = str1;
				arr[i][2] = str2;
				arr[i++][3] = str3;
			}	//���̺��� �׸���� ���

			rs.close();
		}catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}
	}
	
	public void insert() {
		String date = null;
		String str1 = null;
		String str2 = null;
		String str3 = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try{
			System.out.print("��¥�� �Է��ϼ��� : ");
			date = in.readLine();
			System.out.print("�޸�1�� �Է��ϼ��� : ");
			str1 = in.readLine();
			System.out.print("�޸�2�� �Է��ϼ��� : ");
			str2 = in.readLine();
			System.out.print("�޸�3�� �Է��ϼ��� : ");
			str3 = in.readLine();
		}catch(Exception e) {
			System.out.println("�Է� ����");
		}

		try {	//�Է��� �����͸� DB�� user���̺� ����
			String sql = "INSERT INTO work(date, str1, str2, str3)";
			sql += "VALUES(" + "'"+ date + "','" + str1 + "','" + str2 + "','" + str3 + "');";
			st.executeUpdate(sql);

		}catch(SQLException e) {
			System.out.println("SQLException : "+ e.getMessage());
		}
	}
	
	public void print() {
		int i = 0;
		
		while(arr[i][0]!=null) {
			System.out.print("��¥ : " + arr[i][0]);
			System.out.print(" , ����1 : " + arr[i][1]);
			System.out.print(" , ����2 : " + arr[i][2]);
			System.out.println(" , ����3 : " + arr[i][3]);
			i++;
		}
	}
	
	public static void main(String[] args) {
		TodayWork t = new TodayWork();
		
		try {
			t.inquiry();
			t.print();
			t.insert();
		}catch(Exception e) {
			System.out.println("DB ���� �Ұ�");
		}

	}
}
