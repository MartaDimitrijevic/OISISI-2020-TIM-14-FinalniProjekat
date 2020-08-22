package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Izvestaj extends JPanel{

	public Izvestaj() {
	}

	public void meniIzvestaja(JPanel panCenterIzv) {
		panCenterIzv.setVisible(true);
		panCenterIzv.setBackground(new Color(230, 255, 251));

		System.out.println("print: izvestaj");
		
		JPanel izvestajPanel = new JPanel();
		BoxLayout menuPanelGlue = new BoxLayout(izvestajPanel, BoxLayout.Y_AXIS);
		izvestajPanel.setLayout(menuPanelGlue);
		izvestajPanel.setBackground(new Color(230, 255, 251));

		JPanel naslovIzv = new JPanel();
		naslovIzv.setLayout(new BorderLayout());
		naslovIzv.setBackground(new Color(230, 255, 251));

		JPanel labelaIzvestaj = new JPanel();
		JLabel lblTopIzv = new JLabel("Izvestaj");
		labelaIzvestaj.setBackground(new Color(230, 255, 251));
		lblTopIzv.setFont(new Font("Ariel", 0, 48));
		labelaIzvestaj.add(lblTopIzv);

		labelaIzvestaj.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelaIzvestaj.add(lblTopIzv);

		JPanel odjavaIzv = new JPanel();
		odjavaIzv.setBackground(new Color(230, 255, 251));
		JButton btnOdjavaIzv = new JButton("Odjava");
		btnOdjavaIzv.setFont(new Font("Arial", 0, 23));
		btnOdjavaIzv.setBackground(new Color(106, 183, 139));
		btnOdjavaIzv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
			
				LogIn logInScreen = new LogIn();
				logInScreen.setVisible(true); 
			}
		});
		odjavaIzv.add(btnOdjavaIzv);

		naslovIzv.add(labelaIzvestaj, BorderLayout.WEST);
		naslovIzv.add(odjavaIzv, BorderLayout.EAST);

		JPanel ukuProdLek = new JPanel();
		ukuProdLek.setBackground(new Color(230, 255, 251));
		GridLayout receptiLayout = new GridLayout(1, 3);
		receptiLayout.setHgap(20);
		ukuProdLek.setLayout(receptiLayout);

		JButton btn6Izv = new JButton();
		btn6Izv.setText("<html> <center> Ukupna prodaja <br> svih lekova </center> </html> \n");
		btn6Izv.setFont(new Font("Arial", 0, 20));
		btn6Izv.setBackground(new Color(187, 230, 212));
		ukuProdLek.add(btn6Izv);

		JButton btn7Izv = new JButton();
		btn7Izv.setText("<html> <center> Ukupna prodaja svih <br> lekova odabranog proizvodjaca </center> </html> \n");
		btn7Izv.setFont(new Font("Arial", 0, 20));
		btn7Izv.setBackground(new Color(187, 230, 212));
		ukuProdLek.add(btn7Izv);

		JButton btn8Izv = new JButton();
		btn8Izv.setText(
				"<html> <center> Ukupna prodaja svih lekova koje <br> je odabrani apotekar prodao </center> </html> \n");
		btn8Izv.setFont(new Font("Arial", 0, 20));
		btn8Izv.setBackground(new Color(187, 230, 212));
		ukuProdLek.add(btn8Izv);

		izvestajPanel.add(naslovIzv, BorderLayout.NORTH);
		izvestajPanel.add(ukuProdLek, BorderLayout.CENTER);

		JPanel bottomPanelIzv = new JPanel();
		bottomPanelIzv.setBackground(new Color(230, 255, 251));
		
		panCenterIzv.add(izvestajPanel, BorderLayout.NORTH);
		panCenterIzv.add(bottomPanelIzv, BorderLayout.CENTER);
	}
}
