package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;

import Controller.MovieController;
import Controller.SessionController;
import Model.Movie;
import Model.Session;

public class SessionScreenDetails 
extends ScreenDetailsBase
implements ActionListener{
	String[] sessionsIds = new String[1000];	
	private JComboBox<String> films;
	private SessionController sessionData;
	private ArrayList<Session> sessions;
	private int pos;
	
	public SessionScreenDetails(SessionController sessionData, int pos, MovieController filmsData) {
		super();
		this.pos = pos;
		this.sessionData = sessionData;
		sessions = sessionData.getSession();
		Session session = sessions.get(pos);
			
		
		sessionsIds = filmsData.view();
		
		films = new JComboBox<String>(sessionsIds);
		films.setBounds(100, 10, 150,30);
		menu.add(films);
		
		//l1.setText(session.getMovie().getName());
		l1.setVisible(false);
		l2.setText(Character.toString(session.getRoom()));	
		session.getDate();
		l3.setText(String.valueOf(GregorianCalendar.DATE));
		session.getDate();
		l4.setText(String.valueOf(GregorianCalendar.MINUTE));
		l5.setText("das");
		
		menu.setTitle("Detalhes da sess�o");
		lL1.setText("Filme: ");
		lL2.setText("Sala: ");
		lL3.setText("Dia: ");
		lL4.setText("Hor�rio: ");
		lL5.setText(": ");
		
		save.addActionListener(this);
		remove.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == save) {
			try {
				Movie m = new Movie(0, "nome", "sinopse", "genero", 0);
				GregorianCalendar d = new GregorianCalendar(2021,1,1,0,0);
				Session s = new Session(m,d,'a');
				this.sessionData.update(pos, s);
				messageSave();	
				
			} catch (Exception e1) {
				massageErroRegister();
			}
		}
		if(src == remove) {
			this.sessionData.delete(pos);
			messageRemove();
		}
	}

}