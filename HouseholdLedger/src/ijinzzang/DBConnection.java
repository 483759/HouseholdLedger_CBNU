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
			System.out.println("DB 접속 불가");
		}
	}
	
	public DBConnection() {
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
		
		inquiry();

	}


	public void inquiry(){	//DB에 저장된 정보를 불러오는 함수
		ResultSet rs = null;
		int i = 0;
		arr = new String[20][6];
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT id, date, category, money, sort, note FROM user");
			//user테이블의 컬럼들을 불러온다

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
			}	//테이블의 항목들을 출력

			rs.close();
		}catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}
	}

	public void insert() throws Exception{	//DB에 새 정보를 삽입하는 함수
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
			System.out.print("날짜를 입력하세요 : ");
			date = in.readLine();
			System.out.print("항목을 입력하세요 : ");
			category = in.readLine();
			System.out.print("금액을 입력하세요 : ");
			money = Integer.parseInt(in.readLine());
			System.out.print("구분을 입력하세요(수입-0/지출-1) : ");
			srt = Integer.parseInt(in.readLine());
			System.out.print("메모를 입력하세요 : ");
			note = in.readLine();
		}catch(Exception e) {
			System.out.println("입력 실패");
		}

		try {	//입력한 데이터를 DB의 user테이블에 삽입
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
			System.out.print("번호-" + arr[i][0]);
			System.out.print(" , 날짜 : " + arr[i][1]);
			System.out.print(" , 항목 : " + arr[i][2]);
			System.out.print(" , 금액 : " + arr[i][3]);
			System.out.print(" , 분류 : " + (arr[i][4].equals("0")?"수입":"지출"));
			System.out.println(" , 비고 : " + arr[i][5]);
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
