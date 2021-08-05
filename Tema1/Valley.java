import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Valley {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		double N = sc.nextDouble();
		Munte v;
		double diff = 0, timp = 0;
		int i;
		//construiesc lista de munti
		ArrayList<Munte> vale = new ArrayList<>();

		for (i = 0; i < N; i++) {
			vale.add(new Munte(sc.nextDouble()));
		}
		//caut adancimea vaii
		v = Collections.min(vale);
		//cazul in care minumul e la inceput
		if (vale.indexOf(v) == 0) {
			//construim un nou minim
			diff = vale.get(1).punct - vale.get(0).punct ;
			timp += diff;
			// scadem diferenta pentru crearea minimul avand indexul 1
			vale.get(1).punct -= diff;
			v = vale.get(1);
		}
		//cazul in care minimul se afla la final
		if (vale.indexOf(v) == (int)N - 1) {
			//construim un nou minim
			diff = vale.get((int)N - 2).punct - vale.get((int)N - 1).punct ;
			timp += diff;
			//scadem diferenta pentru a construi minimul pe indexul N-2
			vale.get((int)N - 2).punct -= diff;
			v = vale.get((int)N - 2);
		}
		//j reprezinta indexul elemntului minim
		int j = vale.indexOf(v);
		//parcurg sufixul vaii
		for (i = (int)N - 1; i > j; i--) {
			//calculez diferenta dintre doi munti consecutivi
			diff = vale.get(i - 1).punct - vale.get(i).punct;
			// vreific daca munti sunt ordonati crescatoor
			if (diff > 0) {
				//reduc din inaltimea muntelui i-1
				timp = timp + diff;
				vale.get(i - 1).punct -= diff;
			}
		}
		//parcurg prefixul vaii
		for (i = 0; i < j ; i++) {
			//calculez diferenta dintre doi munti consecutivi
			diff = vale.get(i + 1).punct - vale.get(i).punct;
			// vreific daca munti sunt ordonati descrescator
			if (diff > 0) {
				//reduc din inaltimea muntelui i+1
				timp = timp + diff;
				vale.get(i + 1).punct -= diff;
			}
		}
		//printez timpul final
		System.out.println((long)timp);

	}

}
//clasa ce reprezinta un munte
class Munte implements Comparable<Munte> {
	double punct;//inaltimea muntelui

	public Munte(double punct) {
		this.punct = punct;
	}

	@Override
	public int compareTo(Munte o) {
		return Double.compare(this.punct, o.punct);
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