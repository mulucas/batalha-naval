package batalha_naval;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Inicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Inicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 414);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbBarquinho01 = new JLabel("");
		lbBarquinho01.setHorizontalAlignment(SwingConstants.CENTER);
		lbBarquinho01.setIcon(new ImageIcon(Inicio.class.getResource("/batalha_naval/barquinho.png")));
		lbBarquinho01.setBounds(0, 271, 138, 93);
		contentPane.add(lbBarquinho01);
		
		Panel pnMar = new Panel();
		pnMar.setBackground(Color.BLUE);
		pnMar.setBounds(0, 365, 582, 10);
		contentPane.add(pnMar);
		
		JLabel lbBarquinho02 = new JLabel("");
		lbBarquinho02.setHorizontalAlignment(SwingConstants.CENTER);
		lbBarquinho02.setIcon(new ImageIcon(Inicio.class.getResource("/batalha_naval/59398.png")));
		lbBarquinho02.setBounds(426, 248, 146, 116);
		contentPane.add(lbBarquinho02);
		
		JLabel lbBarquinho03 = new JLabel("");
		lbBarquinho03.setHorizontalAlignment(SwingConstants.CENTER);
		lbBarquinho03.setIcon(new ImageIcon(Inicio.class.getResource("/batalha_naval/59359.png")));
		lbBarquinho03.setBounds(204, 236, 138, 128);
		contentPane.add(lbBarquinho03);
		
		JButton btnJogadorXMaquina = new JButton("Jogador x Maquina");
		btnJogadorXMaquina.setBounds(204, 139, 166, 23);
		contentPane.add(btnJogadorXMaquina);
		
		JButton JogadorXJogador = new JButton("Jogador x Jogador");
		JogadorXJogador.setBounds(204, 173, 166, 23);
		contentPane.add(JogadorXJogador);
		JogadorXJogador.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PosicionarEmbarcacoes embarcacoes = new PosicionarEmbarcacoes("jogador_1");
				embarcacoes.setVisible(true);
				dispose();
			}
		});
	}
}
