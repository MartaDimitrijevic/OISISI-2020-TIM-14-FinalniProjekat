package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import action.LekoviAkcija;
import action.ReceptiAkcija;
import model.Korisnik;

public class LekoviDodavanje extends JPanel {
	public LekoviDodavanje() {
		
	}
		public void dodavanjeLekova(JPanel dodavanjeLek, Korisnik korisnik) {
				
			dodavanjeLek.setVisible(true);
			dodavanjeLek.setLayout(new BorderLayout());
			dodavanjeLek.setBackground(new Color(230, 255, 251));
			
			JPanel parameterTextPanDodaj = new JPanel();
			parameterTextPanDodaj.setBackground(new Color(250, 255, 251));
			BoxLayout parameterTextPanGlueLek = new BoxLayout(parameterTextPanDodaj, BoxLayout.Y_AXIS);
			parameterTextPanDodaj.setLayout(parameterTextPanGlueLek);
			
			JPanel parameterPan1Dodaj = new JPanel();
			parameterPan1Dodaj.setBackground(new Color(230, 255, 251));
			JLabel SifraLabelDodaj = new JLabel("  Sifra :");
			SifraLabelDodaj.setFont(new Font("Ariel", 0, 30));
			
			JTextField textArea1Dodaj = new JTextField(30);
			textArea1Dodaj.setFont(new Font("Serif", Font.ITALIC, 16));

			parameterPan1Dodaj.add(SifraLabelDodaj);
			parameterPan1Dodaj.add(textArea1Dodaj);
			parameterTextPanDodaj.add(parameterPan1Dodaj);
			
			JPanel parameterPan4Dodaj = new JPanel();
			parameterPan4Dodaj.setBackground(new Color(230, 255, 251));
			JLabel ImePanDodaj = new JLabel("             Ime leka :");
			ImePanDodaj.setFont(new Font("Ariel", 0, 30));
			
			JTextField textArea4Dodaj = new JTextField(30);
			textArea4Dodaj.setFont(new Font("Serif", Font.ITALIC, 16));

			parameterPan4Dodaj.add(ImePanDodaj);
			parameterPan4Dodaj.add(textArea4Dodaj);
			parameterTextPanDodaj.add(parameterPan4Dodaj);
			
			JPanel parameterPan5Dodaj = new JPanel();
			parameterPan5Dodaj.setBackground(new Color(230, 255, 251));
			JLabel ProizPanDodaj = new JLabel("       Proizvodjac :");
			ProizPanDodaj.setFont(new Font("Ariel", 0, 30));

			JTextField textArea5Dodaj = new JTextField(30);
			textArea5Dodaj.setFont(new Font("Serif", Font.ITALIC, 16));

			parameterPan5Dodaj.add(ProizPanDodaj);
			parameterPan5Dodaj.add(textArea5Dodaj);
			parameterTextPanDodaj.add(parameterPan5Dodaj);
			
			JPanel parameterPan6Dodaj = new JPanel();
			parameterPan6Dodaj.setBackground(new Color(230, 255, 251));
			JLabel CenaPanDodaj = new JLabel("          Cena leka :");
			CenaPanDodaj.setFont(new Font("Ariel", 0, 30));

			JTextField textArea6Dodaj = new JTextField(30);
			textArea6Dodaj.setFont(new Font("Serif", Font.ITALIC, 16));

			parameterPan6Dodaj.add(CenaPanDodaj);
			parameterPan6Dodaj.add(textArea6Dodaj);
			parameterTextPanDodaj.add(parameterPan6Dodaj);
			
			JPanel btnDodaj = new JPanel();
			btnDodaj.setBackground(new Color(230, 255, 251));
			JButton btnPrh = new JButton("Dodaj");
			btnPrh.setFont(new Font("Arial", 0, 30));
			btnPrh.setBackground(new Color(0, 204, 255));
			btnPrh.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String ime = textArea4Dodaj.getText();
					String proizvodjac = textArea5Dodaj.getText();
					String cena = textArea6Dodaj.getText();
					LekoviAkcija dodavanje = new LekoviAkcija();
					dodavanje.dodajLek( ime, proizvodjac, cena, korisnik);
				}
			});
			
			btnDodaj.add(btnPrh);
			btnDodaj.setLayout(new FlowLayout(FlowLayout.CENTER));

			dodavanjeLek.add(parameterTextPanDodaj, BorderLayout.CENTER);
			dodavanjeLek.add(btnDodaj, BorderLayout.SOUTH);
			}


}
