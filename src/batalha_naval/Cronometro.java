package batalha_naval;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class Cronometro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel tempo;
	private JButton btnStart;
	private JButton btnPause;
	private JButton btnStop;
	private JPanel pnlButtons;
	private JPanel pnlPrincipal;
	private int segundos;
	private AtualizaLabel myThread;
	private Thread thread;

	public Cronometro() {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Cronometro by d3z@0");
		setSize(270, 120);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setIconImage(new ImageIcon("image/clock.png").getImage());
		pnlPrincipal = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pnlPrincipal.setBounds(30, 30, 30, 30);
		pnlPrincipal.setBorder(BorderFactory.createEtchedBorder());
		tempo = new JLabel("00:00:00");
		tempo.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		btnStart = new JButton("Start");
		btnStart.addActionListener(new StartListener());
		btnPause = new JButton("Pause");
		btnPause.addActionListener(new PauseListener());
		btnStop = new JButton("Stop");
		btnStop.addActionListener(new StopListener());

		pnlButtons = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pnlButtons.setBorder(BorderFactory.createEtchedBorder());
		pnlButtons.add(btnStart);
		pnlButtons.add(btnPause);
		pnlButtons.add(btnStop);

		pnlPrincipal.add(tempo);
		pnlPrincipal.add(pnlButtons);
		getContentPane().add(pnlPrincipal);
	}

	private void segundos() {
		segundos++;
	}

	private String tempoFormatado() {
		segundos();
		int segundo = (segundos % 60);
		int minuto = ((segundos % 3600) / 60);
		int hora = (segundos / 3600);
		return String.format("%02d:%02d:%02d", hora, minuto, segundo);
	}

	private class AtualizaLabel implements Runnable {
		private boolean begin;
		private boolean stop;
		private boolean paused;

		public AtualizaLabel() {
			beginThread(true);
			stopThread(false);
			pausedThread(false);
		}

		private void beginThread(boolean begin) {
			this.begin = begin;
		}

		private boolean isBeginThread() {
			return begin;
		}

		private void stopThread(boolean stop) {
			this.stop = stop;
		}

		private boolean isStopThread() {
			return stop;
		}

		private void pausedThread(boolean paused) {
			this.paused = paused;
		}

		private boolean isPausedThread() {
			return paused;
		}

		@Override
		public void run() {
			while (!isStopThread()) {
				if (!isPausedThread()) {
					if (!isBeginThread()) {
						tempo.setText(tempoFormatado());
					} else {
						beginThread(false);
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			segundos = 0;
		}
	}

	private class StartListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (thread == null) {
				tempo.setText("00:00:00");
				myThread = new AtualizaLabel();
				thread = new Thread(myThread);
				thread.start();
			}
			btnStart.setText("Start");
			myThread.pausedThread(false);
			setIconImage(new ImageIcon("image/clock_play.png").getImage());
		}
	}

	private class PauseListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			myThread.pausedThread(true);
			if (!myThread.isStopThread()) {
				btnStart.setText("Restart");
				setIconImage(new ImageIcon("image/clock_pause.png").getImage());
			}
		}
	}

	private class StopListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!myThread.isStopThread()) {
				thread = null;
				myThread.stopThread(true);
			}
			myThread.beginThread(true);
			btnStart.setText("Start");
			setIconImage(new ImageIcon("image/clock_stop.png").getImage());
		}
	}

	public static void main(String[] args) {
		new Cronometro().setVisible(true);
	}

}
