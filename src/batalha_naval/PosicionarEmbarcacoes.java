package batalha_naval;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.JButton;

public class PosicionarEmbarcacoes extends JFrame {

	private JTextField field[];
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLetra;
	private JTextField txtNumero;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PosicionarEmbarcacoes frame = new PosicionarEmbarcacoes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PosicionarEmbarcacoes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 834, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBounds(0, 0, 400, 400);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbTitulo = new JLabel("posicione as embarcações");
		lbTitulo.setForeground(new Color(255, 0, 0));
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbTitulo.setBounds(180, 11, 357, 57);
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
		txtLetra.setBounds(220, 301, 111, 20);
		contentPane.add(txtLetra);
		txtLetra.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(220, 351, 111, 20);
		contentPane.add(txtNumero);

		JLabel lbColunas = new JLabel(
				"  A       B        C       D       E        F       G        H        I         J");
		lbColunas.setBounds(150, 73, 299, 14);
		contentPane.add(lbColunas);

		JLabel lbLinha1 = new JLabel("1");
		lbLinha1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLinha1.setBounds(105, 91, 31, 14);
		contentPane.add(lbLinha1);

		JLabel lbLinha2 = new JLabel("2");
		lbLinha2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLinha2.setBounds(105, 110, 31, 14);
		contentPane.add(lbLinha2);

		JLabel lbLinha3 = new JLabel("3");
		lbLinha3.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLinha3.setBounds(105, 130, 31, 14);
		contentPane.add(lbLinha3);

		JLabel lbLinha4 = new JLabel("4");
		lbLinha4.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLinha4.setBounds(105, 150, 31, 14);
		contentPane.add(lbLinha4);

		JLabel lbLinha5 = new JLabel("5");
		lbLinha5.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLinha5.setBounds(105, 170, 31, 14);
		contentPane.add(lbLinha5);

		JLabel lbLinha6 = new JLabel("6");
		lbLinha6.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLinha6.setBounds(105, 190, 31, 14);
		contentPane.add(lbLinha6);

		JLabel lbLinha7 = new JLabel("7");
		lbLinha7.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLinha7.setBounds(105, 210, 31, 14);
		contentPane.add(lbLinha7);

		JLabel lbLinha8 = new JLabel("8");
		lbLinha8.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLinha8.setBounds(105, 230, 31, 14);
		contentPane.add(lbLinha8);

		JLabel lbLinha9 = new JLabel("9");
		lbLinha9.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLinha9.setBounds(105, 250, 31, 14);
		contentPane.add(lbLinha9);

		JLabel lbLinha10 = new JLabel("10");
		lbLinha10.setHorizontalAlignment(SwingConstants.RIGHT);
		lbLinha10.setBounds(105, 270, 31, 14);
		contentPane.add(lbLinha10);

		montaTabela();
		montaDescricao();
	}

	public void mudaValor(int posicao) {

	}

	public void montaTabela() {// x + 30 ====== y + 20
		int x = 145, y = 89, aux = 145;
		field = new JTextField[100];
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

	public void montaDescricao() {
		JLabel lblNewLabel = new JLabel("ordens | embarcações| quantidade | nome");
		lblNewLabel.setBounds(499, 73, 250, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnPosicionar = new JButton("Posicionar");
		btnPosicionar.setBounds(353, 327, 99, 23);
		contentPane.add(btnPosicionar);
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
}
