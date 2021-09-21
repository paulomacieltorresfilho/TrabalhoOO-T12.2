package Controller;

public interface Entity {
	
	public void register(int pos, Object e);
	void update(int option, Object e);
	public String[] view(String[] s);
	public void delete(int pos);
	
}
