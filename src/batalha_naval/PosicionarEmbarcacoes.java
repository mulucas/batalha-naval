package batalha_naval;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PosicionarEmbarcacoes extends JFrame {

	private JTextField field[] = new JTextField[100];;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLetra;
	private JTextField txtNumero;
	private int ordemDosBarcos = 0;
	private String nomeDoArquivo = "";
	
	public PosicionarEmbarcacoes(String jogador) {
		nomeDoArquivo = jogador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBounds(0, 0, 400, 400);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//--------------------------------------------------------------------
		JLabel lbTitulo = new JLabel("posicione as embarcações "+jogador);
		lbTitulo.setForeground(new Color(255, 0, 0));
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbTitulo.setBounds(180, 11, 607, 57);
		contentPane.add(lbTitulo);
		// ------------------------------LETRA - NUMERO------------------------
		JLabel lblLetra = new JLabel("Letra:");
		lblLetra.setForeground(new Color(255, 255, 255));
		lblLetra.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLetra.setBounds(145, 344, 79, 33);
		contentPane.add(lblLetra);

		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setForeground(new Color(255, 255, 255));
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumero.setBounds(145, 293, 79, 33);
		contentPane.add(lblNumero);

		txtLetra = new JTextField();
		txtLetra.setBounds(218, 352, 111, 20);
		contentPane.add(txtLetra);
		txtLetra.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(218, 301, 111, 20);
		contentPane.add(txtNumero);
		//----------------------------------------------------------------------
		JLabel lbColunas = new JLabel(
				"  A       B        C       D       E        F       G        H        I         J");
		lbColunas.setBounds(150, 73, 299, 14);
		contentPane.add(lbColunas);

		JLabel lbsLinhas[] = new JLabel[10];
		int y = 90;
		for (int i = 0; i < lbsLinhas.length; i++) {
			lbsLinhas[i] = new JLabel(i+1+"");
			lbsLinhas[i].setHorizontalAlignment(SwingConstants.RIGHT);
			lbsLinhas[i].setBounds(105, y, 31, 14);
			contentPane.add(lbsLinhas[i]);
			y+=20;
		}
		
		//-------------------------------------------------------------------
		JButton btnPosicionar = new JButton("Posicionar");
		btnPosicionar.setBounds(353, 327, 99, 23);
		contentPane.add(btnPosicionar);
		btnPosicionar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				char letra = txtLetra.getText().charAt(0);
				int numero = Integer.parseInt(txtNumero.getText());
				String g = "ABCDEFGHIJ";
				for (int i = 0; i < g.length(); i++) {
					if(g.charAt(i) == letra) {
						verificaEmbarcacao(Integer.parseInt((numero-1)+""+i));
					}
				}
				//txtLetra.setText("");
				txtNumero.setText("");
			}
		});
		montaTabela();
		montaDescricao();
	}
	//------------------------------------------------------------------------------
	private void verificaEmbarcacao(int posicao) {
		if(ordemDosBarcos<5) {
			field[posicao].setBackground(new Color(255, 0, 0));
			field[posicao].setText("5");
		}else if(ordemDosBarcos<13){
			field[posicao].setText("4");
			field[posicao].setBackground(new Color(0, 255, 0));			
		}else if(ordemDosBarcos<22){
			field[posicao].setText("3");
			field[posicao].setBackground(new Color(0, 255, 255));			
		}else if(ordemDosBarcos<30){
			field[posicao].setText("2");
			field[posicao].setBackground(new Color(255, 255, 0));			
		}
		ordemDosBarcos++;
	}
	//------------------------------------------------------------------------------
	public void montaTabela() {// x + 30 ====== y + 20
		int x = 145, y = 89, aux = 145;
		for (int i = 0; i < field.length; i++) {
			field[i] = new JTextField();
			field[i].setColumns(10);
			field[i].setEditable(false);
			field[i].setBounds(x, y, 28, 20);
			field[i].setBackground(Color.BLUE);
			field[i].setForeground(Color.WHITE);
			contentPane.add(field[i]);
			x += 30;
			if ((i + 1) % 10 == 0) {
				x = aux;
				y += 20;
			}
		}
	}
	//------------------------------------------------------------------------------
	public void montaDescricao() {
		JLabel lblNewLabel = new JLabel("ordens | embarcações| quantidade | nome");
		lblNewLabel.setBounds(499, 73, 250, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnSair = new JButton("");
		btnSair.setBackground(new Color(0, 153, 204));
		btnSair.setIcon(new ImageIcon(PosicionarEmbarcacoes.class.getResource("/batalha_naval/Users-Exit-icon.png")));
		btnSair.setBounds(729, 320, 79, 81);
		contentPane.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Inicio inicio = new Inicio();
				switch (JOptionPane.showConfirmDialog(null, "Deseja voltar ao inicio?")) {
	            case 0:
	                dispose();
	                inicio.setVisible(true);
	                break;
				}
			}
		});
		
		JButton btnConfirmar = new JButton("");
		btnConfirmar.setBackground(new Color(0, 153, 204));
		btnConfirmar.setIcon(new ImageIcon(PosicionarEmbarcacoes.class.getResource("/batalha_naval/Accept-icon.png")));
		btnConfirmar.setBounds(645, 320, 79, 81);
		contentPane.add(btnConfirmar);
		btnConfirmar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ordemDosBarcos<30) {
					JOptionPane.showMessageDialog(null, "Voce ainda nao posicionaou todas as embarcacoes");
				}else {
					gravar(nomeDoArquivo);
					dispose();
					//if (nomeDoArquivo.equals("jogador_1")) {
					//	PosicionarEmbarcacoes embarcacoes = new PosicionarEmbarcacoes("jogador_2");
					//	embarcacoes.setVisible(true);						
					//}else {
						JogadorXComputador computador = new JogadorXComputador();
						computador.setVisible(true);
					//}
				}
				
			}
		});
		// ------------------------------------------------------------------
		JLabel labelsOrdem[] = new JLabel[4];
		int y = 100;
		for (int i = 0; i < labelsOrdem.length; i++) {
			labelsOrdem[i] = new JLabel(i + 1 + "º");
			labelsOrdem[i].setBounds(510, y, 46, 14);
			contentPane.add(labelsOrdem[i]);
			y += 20;
		}
		// ------------------------------------------------------------------
		JLabel labelsCor[] = new JLabel[4];
		y = 100;
		for (int i = 0; i < labelsCor.length; i++) {
			labelsCor[i] = new JLabel();
			labelsCor[i].setOpaque(true);
			labelsCor[i].setBounds(571, y, 25, 14);
			contentPane.add(labelsCor[i]);
			y += 20;
		}

		labelsCor[0].setBackground(new Color(255, 0, 0)); // vermelho
		labelsCor[1].setBackground(new Color(0, 255, 0)); // verde
		labelsCor[2].setBackground(new Color(0, 255, 255));// azul claro
		labelsCor[3].setBackground(new Color(255, 255, 0));// amarelo
		// ------------------------------------------------------------------
		JLabel labelsQuantidades[] = new JLabel[4];
		y = 100;
		for (int i = 0; i < labelsQuantidades.length; i++) {
			labelsQuantidades[i] = new JLabel(i + 1 + "");
			labelsQuantidades[i].setBounds(655, y, 46, 14);
			contentPane.add(labelsQuantidades[i]);
			y += 20;
		}
		// ------------------------------------------------------------------
		String nomes[] = {"Porta avião", "Navio Tanque", "Destroyer", "Submarino"};
		JLabel labelsNomes[] = new JLabel[4];
		y = 100;
		for (int i = 0; i < labelsNomes.length; i++) {
			labelsNomes[i] = new JLabel(nomes[i]);
			labelsNomes[i].setBounds(705, y, 86, 14);
			contentPane.add(labelsNomes[i]);
			y += 20;
		}
	}

	public void gravar(String arquivo){
		try {
			String path = System.getProperty("user.home");
			FileWriter cria = new FileWriter(path + "//"+arquivo+".txt");
			System.out.println(path + "//"+arquivo+".txt");
			BufferedWriter gravarArq = new BufferedWriter(cria);
			for (int i = 0; i < field.length; i++) {
				gravarArq.write(field[i].getText());
				gravarArq.newLine();
			}
			gravarArq.close();
			cria.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
