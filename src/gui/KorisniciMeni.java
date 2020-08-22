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
import javax.swing.JPanel;

public class KorisniciMeni extends JPanel{
	
	public KorisniciMeni() {}
		
	public void meniKorisnika(JPanel panCenterKor){
		
		panCenterKor.setVisible(true);
		panCenterKor.setBackground(new Color(230, 255, 251));
		
		JPanel korisniciPanel = new JPanel();
		korisniciPanel.setBackground(new Color(230, 255, 251));
		BoxLayout menuPanelGlueKor = new BoxLayout(korisniciPanel, BoxLayout.Y_AXIS);
		korisniciPanel.setLayout(menuPanelGlueKor);
		
		JPanel naslovKor = new JPanel();
		naslovKor.setLayout(new BorderLayout());
		naslovKor.setBackground(new Color(230, 255, 251));
	
		JPanel labelaKorisnici = new JPanel();
		JLabel lblTopKor = new JLabel("Korisnici");
		lblTopKor.setFont(new Font("Ariel", 0, 48));
		labelaKorisnici.setBackground(new Color(230, 255, 251));
		labelaKorisnici.add(lblTopKor);
	
		JPanel odjavaKor = new JPanel();
		odjavaKor.setBackground(new Color(230, 255, 251));
		JButton btnOdjavaKor = new JButton("Odjava");
		btnOdjavaKor.setFont(new Font("Arial", 0, 23));
		btnOdjavaKor.setBackground(new Color(106, 183, 139));
		btnOdjavaKor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());

				LogIn logInScreen = new LogIn();
				logInScreen.setVisible(true);
			}
		});
		
		odjavaKor.add(btnOdjavaKor);
		
		naslovKor.add(labelaKorisnici, BorderLayout.WEST);
		naslovKor.add(odjavaKor, BorderLayout.EAST);
		
		korisniciPanel.add(naslovKor, BorderLayout.NORTH);
		
		JPanel korisnici = new JPanel();
		korisnici.setBackground(new Color(230, 255, 251));
		GridLayout korisniciLayout = new GridLayout(1, 2);
		korisniciLayout.setHgap(50);
		korisnici.setLayout(korisniciLayout);
		
		JPanel sortiranjeKor = new JPanel();
		JPanel registracijaKor = new JPanel();
		
		sortiranjeKor.setVisible(false);
		registracijaKor.setVisible(false);

		JPanel bottomPanelKor = new JPanel();
		bottomPanelKor.setBackground(new Color(230, 255, 251));
		
		JButton btn1Kor = new JButton("Registracija");
		btn1Kor.setFont(new Font("Arial", 0, 27));
		btn1Kor.setBackground(new Color(187, 230, 212));
		btn1Kor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				KorisnikRegistracija korisnikRegistracija = new KorisnikRegistracija();
				korisnikRegistracija.registracijaKorisnika(registracijaKor);
				registracijaKor.setVisible(true);
				sortiranjeKor.setVisible(false);
			}
		});
		korisnici.add(btn1Kor);
		
		JButton btn2Kor = new JButton("Prikaz svih korisnika");
		btn2Kor.setFont(new Font("Arial", 0, 27));
		btn2Kor.setBackground(new Color(187, 230, 212));
		btn2Kor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				KorisnikPrikaz korisniciPrikaz = new KorisnikPrikaz();
				korisniciPrikaz.sortiranjeKorisnika(sortiranjeKor, bottomPanelKor);
				sortiranjeKor.setVisible(true);
				registracijaKor.setVisible(false);
			}
		});
		korisnici.add(btn2Kor);
		
		korisniciPanel.add(korisnici, BorderLayout.CENTER);
		korisniciPanel.add(sortiranjeKor, BorderLayout.SOUTH);
		
		
		
		bottomPanelKor.add(registracijaKor, BorderLayout.CENTER);
		
		panCenterKor.add(korisniciPanel, BorderLayout.NORTH);
		panCenterKor.add(bottomPanelKor, BorderLayout.CENTER);
	}
}
