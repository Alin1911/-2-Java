import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Crypto {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		double N = sc.nextDouble();
		double B = sc.nextDouble();
		double upd1 = 0, suma2 = 0, suma3 = 0, monede = 0;
		int i,j;
		//construiesc lista de calculatoare
		ArrayList<Calculator> calculatoare = new ArrayList<>();
		
		for (i = 0; i < N; i++) {
			calculatoare.add(new Calculator(sc.nextDouble(), sc.nextDouble()));
		}
		//sortez crescator lista folosind numarul de monede produse
		Collections.sort(calculatoare);
		//parcurg lista de calculatoare 
		for (j = 1; j < N; j++) {
			//calculez costul pentru un upgrade de 1 moneda
			upd1 = upd1 + calculatoare.get(j - 1).cost;
			//calculez cat costa un update de la caculator j-1 la j
			suma2 = suma3 + (calculatoare.get(j).monede
					- calculatoare.get(j - 1).monede) * upd1;
			//cazul in care costul e mai mare decat B
			if (suma2 > B) {
				//monede raman cele ale caculatorului trecut
				monede = calculatoare.get(j - 1).monede;
				break;
			} else {
				//cazul cand putem face upgrade
				// actualizam suma cheltuita si numarul de monede
				monede = calculatoare.get(j).monede;
				suma3 = suma2;
			}
		}
		//verific daca sa ajuns in cazul cand mai sunt bani dar
		//s-a terminat lista de calculatoare 
		if ((N == j) && (suma3 < B)) {
			upd1 = upd1 + calculatoare.get(j - 1).cost;
		}
		//calculez ce se intampla cu bani ramasi daca se mai pot
		//face upgrade-uri 
		monede += (B - suma3) / upd1;
		//printez rezultatul
		System.out.println((int)monede);
	}
}
// calasa care reprezinta un calculator
class Calculator implements Comparable<Calculator> {
	//numarul de monede pe care il produce
	double monede;
	// costul pentru a creste numarul de monede
	double cost;

	public Calculator(double monede, double cost) {
		this.monede = monede;
		this.cost = cost;
	}

	@Override
	public int compareTo(Calculator o) {
		return Double.compare(this.monede, o.monede);
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