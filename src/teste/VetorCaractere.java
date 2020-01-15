package teste;

public class VetorCaractere {

	public static void main(String[] args) {
		String g = "ABCDEFGHIJ";
		for (int i = 0; i < g.length(); i++) {
			if(g.charAt(i) == 'D') {
				System.out.println(i +" 3 ou 4");
				break;
			}
		}

	}

}
