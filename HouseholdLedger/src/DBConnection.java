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
			//드라이버 접속
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패!");
		}

		try {
			conn = DriverManager.getConnection(url, user, pass);
			//mysql 계정에 접속
		} catch(SQLException e) {
			System.out.println("My-SQL 접속 실패!");
		}

	}
	

	public void inquiry() throws Exception{	//DB에 저장된 정보를 불러오는 함수
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT id, date, money, category, note FROM user");
			//user테이블의 컬럼들을 불러온다

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
			}	//테이블의 항목들을 출력

			rs.close();
		}catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}
	}

	public void insert() throws Exception{	//DB에 새 정보를 삽입하는 함수
		int rs2;
		int id=0;
		String date="";
		int money=0;
		String category="";
		String note = "";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try{
			id = ++presentid;
			System.out.print("날짜를 입력하세요 : ");
			date = in.readLine();
			System.out.print("금액을 입력하세요 : ");
			money = Integer.parseInt(in.readLine());
			System.out.print("항목을 입력하세요 : ");
			category = in.readLine();
			System.out.print("메모를 입력하세요 : ");
			note = in.readLine();
		}catch(Exception e) {
			System.out.println("입력 실패");
		}

		try {	//입력한 데이터를 DB의 user테이블에 삽입
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
			System.out.println("DB 접속 불가");
		}
	}
}