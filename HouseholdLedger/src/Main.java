import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date="";
		int money=0;
		String category="";
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("��¥�� �Է��ϼ��� : ");
		try{
			date = in.readLine();
		}catch(Exception e) {
			System.out.println("�Է� ����");
		}
		
		System.out.print("�ݾ��� �Է��ϼ��� : ");
		try{
			money = Integer.parseInt(in.readLine());
		}catch(Exception e) {
			System.out.println("�Է� ����");
		}
		
		System.out.print("�׸��� �Է��ϼ��� : ");
		try{
			category = in.readLine();
		}catch(Exception e) {
			System.out.println("�Է� ����");
		}
		
		
		//System.out.println("��¥ : "+date+" �ݾ� : "+money+" �׸� : "+category);
	}

}
