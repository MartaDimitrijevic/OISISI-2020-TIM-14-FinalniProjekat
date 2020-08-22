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
import model.Korisnik;

public class LekoviIzmena extends JPanel{
	public LekoviIzmena() {
		
	}
	
	public void izmenaLekova(JPanel izmenaLek, Korisnik korisnik) {
		
		izmenaLek.setVisible(true);
		izmenaLek.setLayout(new BorderLayout());
		izmenaLek.setBackground(new Color(230, 255, 251));
		
		JPanel parameterTextPanIzmeni = new JPanel();
		parameterTextPanIzmeni.setBackground(new Color(250, 255, 251));
		BoxLayout parameterTextPanGlueLek = new BoxLayout(parameterTextPanIzmeni, BoxLayout.Y_AXIS);
		parameterTextPanIzmeni.setLayout(parameterTextPanGlueLek);
		
		JPanel parameterPan1Izmeni = new JPanel();
		parameterPan1Izmeni.setBackground(new Color(230, 255, 251));
		JLabel SifraLabelIzmeni = new JLabel("  Sifra :");
		SifraLabelIzmeni.setFont(new Font("Ariel", 0, 30));
		
		JTextField textArea1Dodaj = new JTextField(30);
		textArea1Dodaj.setFont(new Font("Serif", Font.ITALIC, 16));

		parameterPan1Izmeni.add(SifraLabelIzmeni);
		parameterPan1Izmeni.add(textArea1Dodaj);
		parameterTextPanIzmeni.add(parameterPan1Izmeni);
		
		JPanel parameterPan4Izmeni = new JPanel();
		parameterPan4Izmeni.setBackground(new Color(230, 255, 251));
		JLabel ImePanIzmeni = new JLabel("              Novo ime :");
		ImePanIzmeni.setFont(new Font("Ariel", 0, 30));
		
		JTextField textArea4Dodaj = new JTextField(30);
		textArea4Dodaj.setFont(new Font("Serif", Font.ITALIC, 16));

		parameterPan4Izmeni.add(ImePanIzmeni);
		parameterPan4Izmeni.add(textArea4Dodaj);
		parameterTextPanIzmeni.add(parameterPan4Izmeni);
		
		JPanel parameterPan5Izmeni = new JPanel();
		parameterPan5Izmeni.setBackground(new Color(230, 255, 251));
		JLabel ProizPanIzmeni = new JLabel("    Novi Proizvodjac :");
		ProizPanIzmeni.setFont(new Font("Ariel", 0, 30));

		JTextField textArea5Dodaj = new JTextField(30);
		textArea5Dodaj.setFont(new Font("Serif", Font.ITALIC, 16));

		parameterPan5Izmeni.add(ProizPanIzmeni);
		parameterPan5Izmeni.add(textArea5Dodaj);
		parameterTextPanIzmeni.add(parameterPan5Izmeni);
		
		JPanel parameterPan6Izmeni = new JPanel();
		parameterPan6Izmeni.setBackground(new Color(230, 255, 251));
		JLabel CenaPanIzmeni = new JLabel("          Nova cena :");
		CenaPanIzmeni.setFont(new Font("Ariel", 0, 30));

		JTextField textArea6Dodaj = new JTextField(30);
		textArea6Dodaj.setFont(new Font("Serif", Font.ITALIC, 16));

		parameterPan6Izmeni.add(CenaPanIzmeni);
		parameterPan6Izmeni.add(textArea6Dodaj);
		parameterTextPanIzmeni.add(parameterPan6Izmeni);
		
		JPanel btnIzmeni = new JPanel();
		btnIzmeni.setBackground(new Color(230, 255, 251));
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
				LekoviAkcija izmena = new LekoviAkcija();
				izmena.dodajLek( ime, proizvodjac, cena, korisnik);
			}
		});
		btnIzmeni.add(btnPrh);
		btnIzmeni.setLayout(new FlowLayout(FlowLayout.CENTER));

		izmenaLek.add(parameterTextPanIzmeni, BorderLayout.CENTER);
		izmenaLek.add(btnIzmeni, BorderLayout.SOUTH);
		}

}
