import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		
		
		//System.out.println("날짜 : "+date+" 금액 : "+money+" 항목 : "+category);
	}

}
