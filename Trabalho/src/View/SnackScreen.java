package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import Controller.SnackController;
import Model.Snack;

public class SnackScreen 
extends ScreenBase
implements ActionListener, ListSelectionListener {
	private JButton btBuy = new JButton("comprar");
	
	String[] snacksName = new String[1000];
	private static SnackController snackDate;
	ArrayList<Snack> snacks;
	
	
	public SnackScreen(SnackController snackDate) {
		super();
		SnackScreen.snackDate = snackDate;
		snacks = snackDate.getSnacks();
		snacksName = snackDate.view(snacksName);
		
		menu.setTitle("Lanches");
		title.setText("Lista de Lanches");
		
		list.setListData(snacksName);
		
		btAdd.setBounds(30,177,100,30);
		btBuy.setBounds(140,177,100,30);
		btAtt.setBounds(250,177,100,30);
		menu.add(btBuy);
		
		btAdd.addActionListener(this);
		btAtt.addActionListener(this);
		list.addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting()&& src == list) {
			new SnackScreenDetails(snackDate, list.getSelectedIndex());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();

		if(src == btAdd) {
			Snack s = new Snack(null, 0, 0);
			int pos = snacks.size();
			snacks.add(pos, s);
			snackDate.update(snacks);
			
			new SnackScreenDetails(snackDate, pos);
		}
		if(src == btAtt) {
			snacksName = new String[1000];
			snacksName = snackDate.view(snacksName);
			list.setListData(snacksName);

		}
	}
}