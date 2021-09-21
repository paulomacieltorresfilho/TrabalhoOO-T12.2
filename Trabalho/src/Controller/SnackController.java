package Controller;

import java.util.ArrayList;

import Model.Snack;

public class SnackController implements Entity {
	private ArrayList<Snack> snacks;

	public  SnackController() {
		//Dados aleatorios
		ArrayList<Snack> snacks = new ArrayList<Snack>();
		for(int i=0; i < 5; i++) {
			Snack aux = new Snack("Lanche-" + i, i, i);
			checkAvailability(aux);
			snacks.add(aux);
		}
		//end
		this.snacks = snacks;
	}
	
	public ArrayList<Snack> getSnacks() {
		return snacks;
	}

    public void checkAvailability(Snack snack) {
    	if (snack.getStockQuantity() <= 0) {
    		snack.setAvailable(false);
    		snack.setStockQuantity(0);
    	} else {
    		snack.setAvailable(true);
    	}
    }
    
    public void sellSnack(int pos, int quantity) {
    	
        int newQuantity = snacks.get(pos).getStockQuantity() - quantity;
        if (newQuantity >= 0) {
        	snacks.get(pos).setStockQuantity(newQuantity);
        	checkAvailability(snacks.get(pos));
        }
    }
    
    
    
	@Override
	public void register(int pos, Object snack) {
		snacks.add(pos, (Snack) snack);		
	}

	@Override
	public void update(int option, Object e) {
		// TODO Auto-generated method stub	
	}
	public void update(ArrayList<Snack> snacks) {
		this.snacks = snacks;
	}

	@Override
	public String[] view(String[] SnacksName) {
		for(int i = 0; i < snacks.size(); i++) {
			Snack aux;
			
			aux = snacks.get(i);
			SnacksName[i] = aux.getName();
		}
		return SnacksName;
		
	}
	@Override
	public void delete(int pos) {
		snacks.remove(pos);
	}
	
}
