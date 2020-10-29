import java.io.*;
import java.util.*;

class Specie implements Comparable<Specie> {
	public String name;
	public Integer count;
	public Specie(String name, int count) {
		this.name = name;
		this.count = count;
	}
	@Override
	public int compareTo(Specie other) {
		if (this.name.equals(other.name))
			return this.count.compareTo(other.count);
		return this.name.compareTo(other.name);
	}
}
class Main { // phải để tên class là Main
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		while (T-- > 0) {
			TreeSet<Specie> species = new TreeSet<>();
			int total = 0;
			while (sc.hasNextLine()) {
				String s = sc.nextLine();
				if (s.isEmpty())
					break;
				total++;
				Specie node = new Specie(s, 0);
				Specie cur = species.higher(node);
				if (cur == null || !cur.name.equals(s)) {
					cur = node;
					species.add(node);
				}
				cur.count++;
			}
			for (Specie specie : species)
				System.out.format("%s %.4f\n", specie.name, 100.0 * specie.count / total);
			if (T > 0)
				System.out.println();
		}
	}
}
//O(N∗log(N)
