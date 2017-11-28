import java.util.Scanner;

public class TenTwelve {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int c = 0; c < t; c++) {
			int n = sc.nextInt(), r = 0;
			while (n % 10 != 0 && n > 0) {
				n-=12;
				r++;
			}
			if (n > 0)
				System.out.println(r+(n/10));
			else
				System.out.println(-1);
		}
		sc.close();
	}
}
