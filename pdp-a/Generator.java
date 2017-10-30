package pdp30a;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Generator {
	public static void main(String[] args) throws Exception {
		FileWriter out = new FileWriter(new File("astrolavos.in"));
		out.write("1000\r\n");
		Random r = new Random();
		for (int i = 0; i < 999; i++)
			out.write((r.nextInt(99996)+5) + " ");
		out.write(
				(r.nextInt(99996)+5) +
				"\r\n3660000 2 250 500 750 1000");
		out.close();
	}
}
