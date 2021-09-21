package Model;

public class Movie {

	private int id;
	private String name;
	private String synopsis;
	private String genre;
	private int duration;


	//constructor
	public Movie(int id, String name, String synopsis, String genre, int duration) {
		this.id = id;
		this.name = name;
		this.synopsis = synopsis;
		this.genre = genre;
		this.duration = duration;
	}
	
	//Gets & Sets
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

}
