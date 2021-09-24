package View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.*;

public class Menu implements ActionListener {
	private JFrame menu = new JFrame("Menu do Cinema");
	private JLabel title = new JLabel("Cinema Opções");
	private static JButton btMovie = new JButton("Filmes");
	private static JButton btSession = new JButton("Sessões");
	private static JButton btTicket = new JButton("Ingressos");
	private static JButton btSnack = new JButton("Lanches");
	
	private static MovieController movieData = new MovieController();
	private static SnackController snackData = new SnackController();
	private static SessionController sessionData = new SessionController(movieData.getMovies());
	
	public Menu() {
		title.setFont(new Font("Arial", Font.BOLD, 18));
		title.setBounds(120,10,150,30);
		btMovie.setBounds(140,50,100,30);
		btSession.setBounds(140,100,100,30);
		btTicket.setBounds(140,150,100,30);
		btSnack.setBounds(140,200,100,30);
		
		menu.add(title);
		menu.add(btMovie);
		menu.add(btSession);
		menu.add(btTicket);
		menu.add(btSnack);
		
		menu.setLayout(null);
		menu.setSize(400,300);
		//menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menu.setVisible(true);
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		
		btMovie.addActionListener(menu);
		btSession.addActionListener(menu);
		btSnack.addActionListener(menu);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == btMovie) {
			new MovieScreen(movieData, sessionData);
		}
		if (src == btSession) {
			new SessionScreen(sessionData, movieData);
		}
		if (src == btSnack) {
			new SnackScreen(snackData);
		}
		
	}
}