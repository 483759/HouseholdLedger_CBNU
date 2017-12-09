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
	}
	
	public void inquiry(){	//DB에 저장된 정보를 불러오는 함수
		ResultSet rs = null;
		int i = 0;
		arr = new String[20][4];
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT date, str1, str2, str3 FROM work");
			//user테이블의 컬럼들을 불러온다

			while(rs.next()) {
				String date = rs.getString("date");
				String str1 = rs.getString("str1");
				String str2 = rs.getString("str2");
				String str3 = rs.getString("str3");
				
				arr[i][0] = date;
				arr[i][1] = str1;
				arr[i][2] = str2;
				arr[i++][3] = str3;
			}	//테이블의 항목들을 출력

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
			System.out.print("날짜를 입력하세요 : ");
			date = in.readLine();
			System.out.print("메모1를 입력하세요 : ");
			str1 = in.readLine();
			System.out.print("메모2를 입력하세요 : ");
			str2 = in.readLine();
			System.out.print("메모3를 입력하세요 : ");
			str3 = in.readLine();
		}catch(Exception e) {
			System.out.println("입력 실패");
		}

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
	
	public static void main(String[] args) {
		TodayWork t = new TodayWork();
		
		try {
			t.inquiry();
			t.print();
			t.insert();
		}catch(Exception e) {
			System.out.println("DB 접속 불가");
		}

	}
}
