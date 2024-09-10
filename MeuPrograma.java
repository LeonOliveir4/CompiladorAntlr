import java.util.Scanner;

public class MeuPrograma {
	public static void main(String args[]) {
		Scanner _scTrx = new Scanner(System.in);
		double a;
		double b;
		boolean c;
		double xbacon;
		boolean d;
		String x;
		String y;
		double z;
		System.out.println("Hello World");
		System.out.println("Fim do programa");
		a = _scTrx.nextDouble();
		_scTrx.nextLine();
		b = _scTrx.nextDouble();
		_scTrx.nextLine();
		x = _scTrx.nextLine();
		c = true;
		d = false;
		b = 2 / 2 + 3 * 2 * 2.5;
		System.out.println(b);
		System.out.println(a);
		if (c && a == b || x == "value" || d || a == b) {
			System.out.println("maior que 5");
		} else {
			System.out.println("menor que 5");
		}
		while (c && a == b && x == "value" || d) {
			System.out.println("maior q leo");
			System.out.println("maior q leo");
			c = _scTrx.nextBoolean();
		}
		do {
			System.out.println("maior q leo");
			a += 1;
		} while (false && true);
		System.out.println("oi agora vamos testar outro");
		if (b >= 0) {
			System.out.println("b positivo");
		} else {
			System.out.println("b negativo");
		}
		_scTrx.close();
	}
}
