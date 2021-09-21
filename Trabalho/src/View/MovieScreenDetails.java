package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Controller.MovieController;
import Model.Movie;

public class MovieScreenDetails 
extends ScreenDetailsBase
implements ActionListener{

	private MovieController filmsDate;
	private ArrayList<Movie> films;
	private int pos;
	
	public MovieScreenDetails(MovieController filmsDate, int pos) {
		super();
		this.pos = pos;
		this.filmsDate = filmsDate;
		films = filmsDate.getFilms();
		Movie film = films.get(pos);
			
		l1.setText(String.valueOf(film.getId()));
		l2.setText(film.getName());
		l3.setText(film.getSynopsis());
		l4.setText(film.getGenre());
		l5.setText(String.valueOf(film.getDuration()));
		
		menu.setTitle("Detalhes do filme");
		lL1.setText("Id: ");
		lL2.setText("Nome: ");
		lL3.setText("Sinopse: ");
		lL4.setText("G�nero: ");
		lL5.setText("Dura��o: ");
		
		save.addActionListener(this);
		remove.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == save) {
			try {
				Movie m = new Movie(
						Integer.valueOf(l1.getText()),
						l2.getText(),
						l3.getText(),
						l4.getText(),
						Integer.valueOf(l5.getText())
						);
				this.filmsDate.delete(pos);
				this.filmsDate.register(pos, m);
				messageSave();	
				
			} catch (Exception e1) {
				massageErroRegister();
			}
		}
		if(src == remove) {
			this.filmsDate.delete(pos);
			messageRemove();
		}
	}

}
