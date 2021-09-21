package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import Controller.SnackController;
import Model.Snack;

public class SnackScreenDetails 
extends ScreenDetailsBase
implements ActionListener{
	
	private SnackController snacksDate;
	private ArrayList<Snack> snacks;
	private int pos;
	
	public SnackScreenDetails(SnackController snacksDate, int pos) {
		super();
		this.pos = pos;
		this.snacksDate = snacksDate;
		snacks = snacksDate.getSnacks();
		Snack snack = snacks.get(pos);
			
		l1.setText(snack.getName());
		l2.setText(String.valueOf(snack.getPrice()));
		l3.setText(String.valueOf(snack.getStockQuantity()));
		l4.setVisible(false);
		l5.setVisible(false);
		
		
		menu.setTitle("Detalhes do lanche");
		lL1.setText("Nome: ");
		lL2.setText("Pre�o: ");
		lL3.setText("Em estoque: ");
		lL4.setVisible(false);
		lL5.setVisible(false);
		
		save.addActionListener(this);
		remove.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == save) {
			try {
				Snack s = new Snack(
						l1.getText(),
						Double.valueOf(l2.getText()),
						Integer.valueOf(l3.getText())
						);
				this.snacksDate.delete(pos);
				this.snacksDate.register(pos, s);
				messageSave();	
				
			} catch (Exception e1) {
				massageErroRegister();
			}
		}
		if(src == remove) {
			this.snacksDate.delete(pos);
			messageRemove();
		}
	}
	
}
