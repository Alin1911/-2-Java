import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ridge {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		double N = sc.nextDouble();
		double cost = 0;
		int i;
		ArrayList<Varf> creste = new ArrayList<>();
		//construiesc lista de varfuri montane
		for (i = 0; i < N; i++) {
			creste.add(new Varf(sc.nextDouble(),sc.nextDouble()));
		}
		//parcurg muntii
		for (i = 0; i < N - 1 ; i++) {
			//daca doi munti au inaltimea elgala
			if (creste.get(i).punct == creste.get(i + 1).punct) {
				//caut muntele cu costul mai mic
				if (creste.get(i).cost < creste.get(i + 1).cost) {
					//scad inaltimea muntelui cu 1 si cresc costul
					creste.get(i).punct--;
					cost += creste.get(i).cost;
				} else {
					//scad inaltimea muntelui cu 1 si cresc costul
					creste.get(i + 1).punct--;
					cost += creste.get(i + 1).cost;
				}

			}
		}
		//printez costul total
		System.out.println((long)cost);
	}
}
//clasa ce reprezinta un varf montan
class Varf implements Comparable<Varf> {
	double punct;//inatimea
	double cost;//costul
	
	public Varf(double punct, double cost) {
		this.punct = punct;
		this.cost = cost;
	}

	@Override
	public int compareTo(Varf o) {
		if (this.punct == o.punct) {
			return 1;
		} else {
			return Double.compare(this.punct, o.punct);
		}
	}
}

class MyScanner {
	BufferedReader br;
	StringTokenizer st;

	public MyScanner() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}