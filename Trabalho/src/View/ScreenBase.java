package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;


public abstract class ScreenBase {
	protected JFrame menu = new JFrame("");
	protected JLabel title = new JLabel("");
	protected JButton btAdd = new JButton("Adicionar");
	protected JButton btAtt = new JButton("Atualizar");
	protected JList<String> list;
	
	public ScreenBase() {	
		this.list = new JList<String>();
		
		//label
		title.setFont(new Font("Arial", Font.BOLD, 18));
		title.setBounds(120,10,150,30);
		
		menu.add(title);
	
		//button
		btAdd.setBounds(70,177,100,30);
		btAtt.setBounds(200,177,100,30);
		
		menu.add(btAdd);
		menu.add(btAtt);
		
		//list
		this.list.setBounds(20,50,350,120);
		
		menu.add(this.list);
		
		//frame
		menu.setLayout(null);
		menu.setSize(400,250);
		menu.setLocation(0, 250);
		menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menu.setVisible(true);
	}	
}
