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
		arr2 = new String[20][4];
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT date, str1, str2, str3 FROM work");
			//user테이블의 컬럼들을 불러온다

			while(rs.next()) {
				String date = rs.getString("date");
				String str1 = rs.getString("str1");
				String str2 = rs.getString("str2");
				String str3 = rs.getString("str3");
				
				arr2[i][0] = date;
				arr2[i][1] = str1;
				arr2[i][2] = str2;
				arr2[i++][3] = str3;
			}	//테이블의 항목들을 출력

			rs.close();
		}catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}
	}
	
	public void insert(String date, String str1, String str2, String str3) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {	//입력한 데이터를 DB의 user테이블에 삽입
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
			System.out.print("날짜 : " + arr[i][0]);
			System.out.print(" , 문장1 : " + arr[i][1]);
			System.out.print(" , 문장2 : " + arr[i][2]);
			System.out.println(" , 문장3 : " + arr[i][3]);
			i++;
		}
	}
	
	public void remove(int row) {
		String date = arr[row][0];
		String sql = "DELETE FROM work where date = " + date;

		try {
			st.executeUpdate(sql);
		} catch(SQLException e) {
			System.out.println("SQLException : " + e.getMessage());
		}
	}

	
	public static void main(String[] args) {
		TodayWork t = new TodayWork();
		
		try {
			t.inquiry();
			t.print();
		}catch(Exception e) {
			System.out.println("DB 접속 불가");
		}

	}
}
