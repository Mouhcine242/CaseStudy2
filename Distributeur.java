package Classes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Distributeur implements ActionListener {
	int caisse ;
	Controleur c = new Controleur();
	User user ;
	JFrame fr = new JFrame();
	JButton b = new JButton("OK");
	JRadioButton b1  = new JRadioButton("Thé");
	JRadioButton b2 = new JRadioButton("Café Noir");
	JRadioButton b3 = new JRadioButton("Café au Lait");
	JRadioButton b4 = new JRadioButton("Café Sucré");
	JRadioButton b5 = new JRadioButton("Café sans Sucre");
	ButtonGroup bg=new ButtonGroup();    
	
	Distributeur(){
		fr.setLayout(new BorderLayout());
		fr.setContentPane(new JLabel(new ImageIcon("C:\\Users\\hp\\Desktop\\captures\\café.jpg")));
		fr.setLayout(new FlowLayout());
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(550,550);
		fr.setLayout(null);
		fr.setLocationRelativeTo(null);
		fr.setLayout(null);
		fr.setVisible(true);
		b.setBounds(220,300,80,30);
		b.addActionListener(this);
		b1.setBounds(100, 50, 100, 30);
		b2.setBounds(100, 100, 100, 30);
		b3.setBounds(100, 150, 100, 30);
		b4.setBounds(100, 200, 100, 30);
		b5.setBounds(100,250 ,100,30);
		b.setBackground(Color.LIGHT_GRAY);
		bg.add(b1);
		bg.add(b2);
		bg.add(b3);
		bg.add(b4);
		bg.add(b5);
		fr.add(b);
		fr.add(b1);
		fr.add(b2);
		fr.add(b3);
		fr.add(b4);
		fr.add(b5);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(b1.isSelected()) {
			if(user.monny< 5) {
				JOptionPane.showMessageDialog(fr, "Le Prix de Thé est 5DH",null, JOptionPane.WARNING_MESSAGE);
			}
			if(user.monny >= 5) {
				JOptionPane.showMessageDialog(fr, "Votre Boisson est prét",null, JOptionPane.PLAIN_MESSAGE);
				this.caisse+=5;
				c.nbThe++;
				if(user.monny > 5) {
					int change = user.monny - 5 ;
					JOptionPane.showMessageDialog(fr, "Votre Boisson est prét et Voila votre rest"+ change,null, JOptionPane.PLAIN_MESSAGE);
				}
			}
			
		}
		if(b2.isSelected() || b3.isSelected() || b4.isSelected() || b5.isSelected()) {
			if(user.monny < 10) {
				JOptionPane.showMessageDialog(fr, "Le Prix de Café est 10DH",null, JOptionPane.WARNING_MESSAGE, null);
			}
			if(user.monny >= 10) {
				this.caisse+=10;
				c.nbCafe++;
				JOptionPane.showMessageDialog(fr, "Votre Boisson est prét",null, JOptionPane.PLAIN_MESSAGE);
				if(user.monny > 10) {
					int change = user.monny - 10;
					JOptionPane.showMessageDialog(fr, "Votre Boisson est prét et Voila votre rest"+ change, null, JOptionPane.PLAIN_MESSAGE);
				}
			}
		}
		
	}
	

}













