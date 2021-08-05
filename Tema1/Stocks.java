import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Stocks {
	public static void main(String[] args) {
		MyScanner sc = new MyScanner();
		double N = sc.nextDouble();
		double B = sc.nextDouble();
		double L = sc.nextDouble();
		double lost = 0, cost = 0, profit = 0;
		ArrayList<Actiune> bursa = new ArrayList<>();
		//construiesc lista de actiuni
		for (int i = 0; i < N; i++) {
			bursa.add(new Actiune(sc.nextDouble(), sc.nextDouble(), sc.nextDouble()));
		}
		//sortez descrescator actiunile
		Collections.sort(bursa);
		//parcurg lista si iau elemente pana nu mai am bani sau pierderea devine
		//prea mare
		for (Actiune act : bursa) {
			if (lost + act.pierdere <= L && cost + act.cost <= B) { 
				//cresc pofitul
				profit = profit + act.profit;
				//cresc pierderea
				lost = lost + act.pierdere;
				//cresc costul
				cost = cost + act.cost;
			}
		}
		//printez profitul final
		System.out.println(profit);
	}
}
//clasa ce reprezinta o actiune
class Actiune implements Comparable<Actiune> {
	double cost;//cosrul
	double pierdere;//pierderea posibila
	double profit;//profitulposibil
	//trend = raportul dintre profit si pierdere
	double trend;

	public Actiune(double cost, double pierdere, double  profit) {
		this.cost = cost;
		this.profit = profit - cost;
		this.pierdere = cost - pierdere;
		this.trend = this.profit / this.pierdere;
	}
	//o sa sortez descrescator folosind parametrul trend
	@Override
	public int compareTo(Actiune o) {
		return -Double.compare(this.trend,o.trend);
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
