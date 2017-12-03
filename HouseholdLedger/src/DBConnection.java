import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class DBConnection{

	static String url = "jdbc:mysql://localhost/info";
	static String user = "root";
	static String pass = "426795";

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//드라이버 접속
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 검색 실패!");
		}

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, pass);
			//mysql 계정에 접속
		} catch(SQLException e) {
			System.out.println("My-SQL 접속 실패!");
		}

		java.sql.Statement st = null;	//
		ResultSet rs = null;

		try {	//DB의 user테이블에서 데이터를 가져와 출력
			st = conn.createStatement();
			rs = st.executeQuery("SELECT date, money, category FROM user");

			while(rs.next()) {
				String date = rs.getString("date");
				int money = rs.getInt("money");
				String category = rs.getString("category");

				System.out.print("date : " + date);
				System.out.print(", money : " + money);
				System.out.println(", category : " + category);
			}

			rs.close();
			//st.close();			
			//conn.close();
		}catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}

		int rs2;
		String date="";
		int money=0;
		String category="";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("날짜를 입력하세요 : ");
		try{
			date = in.readLine();
		}catch(Exception e) {
			System.out.println("입력 실패");
		}

		System.out.print("금액을 입력하세요 : ");
		try{
			money = Integer.parseInt(in.readLine());
		}catch(Exception e) {
			System.out.println("입력 실패");
		}

		System.out.print("항목을 입력하세요 : ");
		try{
			category = in.readLine();
		}catch(Exception e) {
			System.out.println("입력 실패");
		}


		try {	//입력한 데이터를 DB의 user테이블에 삽입
			String sql = "INSERT INTO user(date, money, category)";
			sql += "VALUES(" + "'" + date + "','" + money + "','" + category +"');";

			rs2 = st.executeUpdate(sql);
			System.out.println(rs2>0?"등록 성공":"등록 실패");

			st.close();
			conn.close();

		}catch(SQLException e) {
			System.out.println("SQLException : "+ e.getMessage());
		}

	}

	public static void inquiry(Connection conn) throws Exception{
		java.sql.Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT date, money, category FROM user");

			while(rs.next()) {
				String date = rs.getString("date");
				int money = rs.getInt("money");
				String category = rs.getString("category");

				System.out.print("date : " + date);
				System.out.print(", money : " + money);
				System.out.println(", category : " + category);
			}

			rs.close();
			st.close();			
			conn.close();
		}catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}
	}

	public void insert(Connection conn, String date, int money, String category) throws Exception{
		java.sql.Statement st = null;
		int rs;

		String sql = "INSERT INTO user(date, money, category)";
		sql += "VALUES(3, " + "'" + date + "','" + money + "','" + category +"'";

		rs = st.executeUpdate(sql);
		System.out.println(rs>0?"등록 성공":"등록 실패");

		st.close();

	}
}