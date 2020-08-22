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

import model.Korisnik;
import model.TipKorisnika;

public class ReceptiMeni extends JPanel{

	public ReceptiMeni() {}
	
	public void meniRecepata(JPanel panCenterRec, Korisnik korisnik){
		
		panCenterRec.setVisible(true);
		panCenterRec.setBackground(new Color(230, 255, 251));
		
		JPanel receptiPanel = new JPanel();
		BoxLayout menuPanelGlueRec = new BoxLayout(receptiPanel, BoxLayout.Y_AXIS);
		receptiPanel.setLayout(menuPanelGlueRec);
		receptiPanel.setBackground(new Color(230, 255, 251));

		JPanel naslovRec = new JPanel();
		naslovRec.setLayout(new BorderLayout());
		naslovRec.setBackground(new Color(230, 255, 251));

		JPanel labelaRecepti = new JPanel();
		JLabel lblTopRec = new JLabel("Recepti");
		labelaRecepti.setBackground(new Color(230, 255, 251));
		lblTopRec.setFont(new Font("Ariel", 0, 48));
		labelaRecepti.add(lblTopRec);

		JPanel odjavaRec = new JPanel();
		odjavaRec.setBackground(new Color(230, 255, 251));
		JButton btnOdjavaRec = new JButton("Odjava");
		btnOdjavaRec.setFont(new Font("Arial", 0, 23));
		btnOdjavaRec.setBackground(new Color(106, 183, 139));
		btnOdjavaRec.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
			
				LogIn logInScreen = new LogIn();
				logInScreen.setVisible(true); 
			}
		});

		odjavaRec.add(btnOdjavaRec);
		
		naslovRec.add(labelaRecepti, BorderLayout.WEST);
		naslovRec.add(odjavaRec, BorderLayout.EAST);
		
		receptiPanel.add(naslovRec, BorderLayout.NORTH);
//		
		JPanel recepti = new JPanel();
		recepti.setBackground(new Color(230, 255, 251));
		GridLayout receptiLayout = new GridLayout(1, 3);
		receptiLayout.setHgap(50);
		recepti.setLayout(receptiLayout);
		
		JPanel sortiranjeRec = new JPanel();
		JPanel pretragaRec = new JPanel();
		JPanel kreiranjeRec = new JPanel();
		
		sortiranjeRec.setVisible(false);
		pretragaRec.setVisible(false);
		kreiranjeRec.setVisible(false);

		JPanel bottomPanelRec = new JPanel();
		bottomPanelRec.setBackground(new Color(230, 255, 251));
		
		JButton btn6 = new JButton("Prikaz recepata");
		btn6.setFont(new Font("Arial", 0, 27));
//		btn6.setBackground(new Color(230, 255, 251));
		btn6.setBackground(new Color(187, 230, 212));
		btn6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				ReceptPrikaz receptiPrikaz = new ReceptPrikaz();
				receptiPrikaz.sortiranjeRecepata(sortiranjeRec, bottomPanelRec);
				sortiranjeRec.setVisible(true);
				pretragaRec.setVisible(false);
				kreiranjeRec.setVisible(false);
				
			}
		});
		recepti.add(btn6);
		
		JButton btn7 = new JButton("Pretraga recepata");
		btn7.setFont(new Font("Arial", 0, 27));
//		btn7.setBackground(new Color(230, 255, 251));
		btn7.setBackground(new Color(187, 230, 212));
		btn7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				ReceptPretraga receptiPretraga = new ReceptPretraga();
				receptiPretraga.pretragaRecepata(pretragaRec, bottomPanelRec);
				pretragaRec.setVisible(true);
				sortiranjeRec.setVisible(false);
				kreiranjeRec.setVisible(false);
			}
		});
		recepti.add(btn7);

		JButton btn8 = new JButton("Kreirati novi recept");
		btn8.setFont(new Font("Arial", 0, 27));
		btn8.setBackground(new Color(187, 230, 212));
		btn8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				ReceptKreiranje receptiKreiranje = new ReceptKreiranje();
				receptiKreiranje.kreiranjeRecepata(kreiranjeRec, korisnik);
				kreiranjeRec.setVisible(true);
				sortiranjeRec.setVisible(false);
				pretragaRec.setVisible(false);
			}
		});
		if(korisnik.getTip().equals(TipKorisnika.Lekar))
			recepti.add(btn8);
		
		receptiPanel.add(recepti, BorderLayout.CENTER);		
		receptiPanel.add(sortiranjeRec, BorderLayout.SOUTH);
		receptiPanel.add(pretragaRec, BorderLayout.SOUTH);
		
		bottomPanelRec.add(kreiranjeRec, BorderLayout.CENTER);
		
		panCenterRec.add(receptiPanel, BorderLayout.NORTH);
		panCenterRec.add(bottomPanelRec, BorderLayout.CENTER);
	}
}
