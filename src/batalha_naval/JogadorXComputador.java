package batalha_naval;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class JogadorXComputador extends JFrame {

	private JTextField field[];
	private static final long serialVersionUID = 1L;
	private JLabel contentPane;
	private JTextField txtLetra;
	private JTextField txtNumero;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JogadorXComputador frame = new JogadorXComputador();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JogadorXComputador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 451);
		contentPane = new JLabel(new ImageIcon(JogadorXComputador.class.getResource("/batalha_naval/mar.jpg")));
		contentPane.setBackground(Color.BLUE);
		contentPane.setBounds(0, 0, 400, 400);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitulo = new JLabel("BATALHA NAVAL");
		lbTitulo.setForeground(new Color(255, 0, 0));
		lbTitulo.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbTitulo.setBounds(180, 11, 275, 57);
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
		// ----------------------------------------------------BOTAO------------------------
		JButton btnBomba = new JButton("");
		btnBomba.setIcon(new ImageIcon(JogadorXComputador.class.getResource("/batalha_naval/Sem título.png")));
		btnBomba.setBounds(348, 300, 111, 83);
		contentPane.add(btnBomba);		

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
		btnBomba.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int numero = Integer.parseInt(txtLetra.getText());
				if (numero < 1 || numero > 225) {
					JOptionPane.showMessageDialog(null, "Por favor digite um numero entre 1 e 255");
				} else {
					mudaValor(numero);
				}
				txtLetra.setText("");
			}
		});

		montaTabela();
	}

	public void mudaValor(int posicao) {
		field[posicao - 1].setText("H");
		field[posicao - 1].setBackground(Color.RED);
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
}