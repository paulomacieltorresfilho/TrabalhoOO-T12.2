package Controller;

import java.util.ArrayList;

import Model.Movie;

public class MovieController implements Entity{
	ArrayList<Movie> films = new ArrayList<Movie>();
	
	public MovieController() {		
		//Dados aleatorios
		for(int i=0; i < 5; i++) {
			Movie aux = new Movie(i, "nome-"+(i+1), "qualquercoisa", "A��o", (120+i));
			this.films.add(aux);
		}
		//end
	}
	
	public ArrayList<Movie> getFilms() {
		return films;
	}

	@Override
	public void register(int pos, Object film) {
		films.add(pos, (Movie) film);		
	}

	@Override
	public void update(int pos, Object film) {
		films.remove(pos);
		films.add(pos, (Movie) film);	
		
	}
	public void update(ArrayList<Movie> films) {
		this.films = films;
	}

	@Override
	public String[] view() {
		String[] filmsName = new String[1000];	
		for(int i = 0; i < films.size(); i++) {
			Movie aux;
			
			aux = films.get(i);
			filmsName[i] = aux.getName();
		}
		return filmsName;
		
	}
	@Override
	public void delete(int pos) {
		films.remove(pos);
	}

	
}