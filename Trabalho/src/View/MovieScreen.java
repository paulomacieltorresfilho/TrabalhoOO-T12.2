package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Controller.MovieController;
import Model.Movie;

public class MovieScreen 
extends ScreenBase
implements ActionListener, ListSelectionListener{
	
	String[] filmsName = new String[1000];	
	private static MovieController filmsDate;
	ArrayList<Movie> films;
	
	public MovieScreen(MovieController filmsDate) {
		super();
		MovieScreen.filmsDate = filmsDate;
		films = filmsDate.getFilms();
		filmsName = filmsDate.view(filmsName);
		
		menu.setTitle("Filmes");
		title.setText("Lista de filmes");
		
		list.setListData(filmsName);
		
		btAdd.addActionListener(this);
		btAtt.addActionListener(this);
		list.addListSelectionListener(this);
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting()&& src == list) {
			new MovieScreenDetails(filmsDate, list.getSelectedIndex());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if(src == btAdd) {
			Movie m = new Movie(-1, null, null, null, 0);
			int pos = films.size();
			films.add(pos, m);
			filmsDate.update(films);
			
			new MovieScreenDetails(filmsDate, pos);
		}
		if(src == btAtt) {
			filmsName = new String[1000];
			filmsName = filmsDate.view(filmsName);
			list.setListData(filmsName);

		}
	}
	
}
