package pdp30a;

import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class astrolavos {
	public static void main(String[] args) throws Exception {
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
		long start = System.nanoTime();
		Scanner in = new Scanner(new File("astrolavos.in"));
		int l = in.nextInt();
		int[] m = new int[l];
		for (int i = 0; i < l; i++)
			m[i] = in.nextInt();
		int n = in.nextInt()*m[0];
		DecimalFormat df = new DecimalFormat("#.000");
		FileWriter out = new FileWriter(new File("astrolavos.out"));
		out.write(
				(df.format((double)n/(double)m[in.nextInt()-1])) + " " +
				(df.format((double)n/(double)m[in.nextInt()-1])) + " " +
				(df.format((double)n/(double)m[in.nextInt()-1])) + " " +
				(df.format((double)n/(double)m[in.nextInt()-1])) + " " +
				(df.format((double)n/(double)m[in.nextInt()-1]))
		);
		in.close();
		out.close();
		System.out.println((double)(System.nanoTime()-start)/1000000000);
        System.out.println("KB: " + (double) (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024);
	}
}
//6 10 15 30 20 30 60 30 2 3 4 5 6
//6 100 95 90 85 80 75 366 2 3 4 5 6