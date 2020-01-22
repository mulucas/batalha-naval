package teste;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GravarNoArquivo {

	public static void main(String[] args) {
		try {
			FileWriter gravacao = new FileWriter("teste");
			BufferedWriter bf = new BufferedWriter(gravacao);
			for (int i = 0; i < 8; i++) {
				bf.write(i+":");
				bf.newLine();
			}
			bf.flush();
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
