package Controller;

import java.util.ArrayList;

import Model.Movie;

public class MovieController implements Entity{
	ArrayList<Movie> films = new ArrayList<Movie>();
	
	public MovieController() {		
		//Dados aleatorios
		ArrayList<Movie> films = new ArrayList<Movie>();
		for(int i=0; i < 5; i++) {
			Movie aux = new Movie(i, "nome-"+i, "qualquercoisa", "A��o", (120+i));
			films.add(aux);
		}
		//end
		this.films = films;
	}
	
	public ArrayList<Movie> getFilms() {
		return films;
	}

	@Override
	public void register(int pos, Object film) {
		films.add(pos, (Movie) film);		
	}

	@Override
	public void update(int option, Object e) {
		// TODO Auto-generated method stub	
	}
	public void update(ArrayList<Movie> films) {
		this.films = films;
	}

	@Override
	public String[] view(String[] filmsName) {
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
