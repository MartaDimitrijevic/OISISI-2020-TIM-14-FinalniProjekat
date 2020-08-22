package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import model.Korisnik;
import model.TipKorisnika;

public class LekoviMeni extends JPanel{
	
	public LekoviMeni() {}
	
	public void meniLekova(JPanel panCenterLek, Korisnik korisnik) {
		panCenterLek.setVisible(true);
		panCenterLek.setBackground(new Color(230, 255, 251));
		
		JPanel lekoviPanel = new JPanel();
		BoxLayout menuPanelGlueLek = new BoxLayout(lekoviPanel, BoxLayout.Y_AXIS);
		lekoviPanel.setLayout(menuPanelGlueLek);
		lekoviPanel.setBackground(new Color(230, 255, 251));
		
		JPanel naslovLek = new JPanel();
		naslovLek.setLayout(new BorderLayout());
		naslovLek.setBackground(new Color(230, 255, 251));

		JPanel labelaLekovi = new JPanel();
		JLabel lblTopLek = new JLabel("Lekovi");
		labelaLekovi.setBackground(new Color(230, 255, 251));
		lblTopLek.setFont(new Font("Ariel", 0, 48));
		labelaLekovi.add(lblTopLek);
		
		JPanel odjavaLek = new JPanel();
		odjavaLek.setBackground(new Color(230, 255, 251));
		JButton btnOdjavaLek = new JButton("Odjava");
		btnOdjavaLek.setFont(new Font("Arial", 0, 23));
		btnOdjavaLek.setBackground(new Color(106, 183, 139));
		btnOdjavaLek.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
			
				LogIn logInScreen = new LogIn();
				logInScreen.setVisible(true); 
			}
		});

		odjavaLek.add(btnOdjavaLek);
		
		naslovLek.add(labelaLekovi, BorderLayout.WEST);
		naslovLek.add(odjavaLek, BorderLayout.EAST);
		
		lekoviPanel.add(naslovLek, BorderLayout.NORTH);
		
		JPanel lekovi = new JPanel();
		lekovi.setBackground(new Color(230, 255, 251));
		GridLayout lekoviLayout = new GridLayout(1, 4);
		lekoviLayout.setHgap(20);
		lekovi.setLayout(lekoviLayout);
		
		JPanel prikazLek = new JPanel();
		JPanel pretragaLek = new JPanel();
		JPanel dodavanjeLek = new JPanel();
		JPanel izmenaLek = new JPanel();
		
		prikazLek.setVisible(false);
		pretragaLek.setVisible(false);
		dodavanjeLek.setVisible(false);
		izmenaLek.setVisible(false);

		JPanel bottomPanelLek = new JPanel();
		bottomPanelLek.setBackground(new Color(230, 255, 251));
		
		JButton btn6 = new JButton("Prikaz lekova");
		btn6.setFont(new Font("Arial", 0, 27));
		btn6.setBackground(new Color(187, 230, 212));
		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				LekoviPrikaz lekoviPrikaz = new LekoviPrikaz();
				lekoviPrikaz.prikazLekova(prikazLek, bottomPanelLek);
				prikazLek.setVisible(true);
				pretragaLek.setVisible(false);
				dodavanjeLek.setVisible(false);
				izmenaLek.setVisible(false);
				
			}
		});
		lekovi.add(btn6);
		
		JButton btn7 = new JButton("Pretraga lekova");
		btn7.setFont(new Font("Arial", 0, 27));
		btn7.setBackground(new Color(187, 230, 212));
		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				LekoviPretraga lekoviPretraga = new LekoviPretraga();
				lekoviPretraga.pretragaLekova(pretragaLek, bottomPanelLek);
				pretragaLek.setVisible(false);
				prikazLek.setVisible(true);
				dodavanjeLek.setVisible(false);
				izmenaLek.setVisible(false);
			}
		});
		lekovi.add(btn7);

		JButton btn8 = new JButton("Dodavanje lekova");
		btn8.setFont(new Font("Arial", 0, 27));
		btn8.setBackground(new Color(187, 230, 212));
		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				LekoviDodavanje lekoviDodavanje = new LekoviDodavanje();
				lekoviDodavanje.dodavanjeLekova(dodavanjeLek, korisnik);
				dodavanjeLek.setVisible(false);
				pretragaLek.setVisible(false);
				prikazLek.setVisible(true);
				izmenaLek.setVisible(false);
			}
		});
		
		
		JButton btn9 = new JButton("Izmena lekova");
		btn8.setFont(new Font("Arial", 0, 27));
		btn8.setBackground(new Color(187, 230, 212));
		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				LekoviIzmena lekoviIzmena = new LekoviIzmena();
				lekoviIzmena.izmenaLekova(izmenaLek, korisnik);
				izmenaLek.setVisible(false);
				pretragaLek.setVisible(false);
				prikazLek.setVisible(true);
				dodavanjeLek.setVisible(false);
			}
		});
		
		
		if(korisnik.getTip().equals(TipKorisnika.Lekar))
			lekovi.add(btn8);
			lekovi.add(btn9);
		
		lekoviPanel.add(lekovi, BorderLayout.CENTER);		
		lekoviPanel.add(pretragaLek, BorderLayout.SOUTH);
		lekoviPanel.add(pretragaLek, BorderLayout.SOUTH);
		
		bottomPanelLek.add(dodavanjeLek, BorderLayout.CENTER);
		bottomPanelLek.add(izmenaLek, BorderLayout.CENTER);
		
		panCenterLek.add(lekoviPanel, BorderLayout.NORTH);
		panCenterLek.add(bottomPanelLek, BorderLayout.CENTER);
	}
}
