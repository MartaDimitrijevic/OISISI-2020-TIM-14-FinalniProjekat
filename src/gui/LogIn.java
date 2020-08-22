package gui;

import model.Korisnik;
import model.TipKorisnika;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import application.MainFrame;

public class LogIn extends JDialog {

	JTextField ime;
	JPasswordField sifra;
	int i = 0;

	public LogIn() {
		setSize(400, 200);
//		setBounds(300, 100, 450, 350);
		setTitle("Prijava");

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.setBackground(new Color(230, 255, 251));
		panel2.setBackground(new Color(230, 255, 251));

		JLabel imeLab = new JLabel("Korisnicko ime: ");
		JLabel sifraLab = new JLabel("                   Sifra: ");

		ime = new JTextField();
		ime.setPreferredSize(new Dimension(150, 25));
		sifra = new JPasswordField();
		sifra.setPreferredSize(new Dimension(150, 25));

		panel1.add(imeLab);
		panel1.add(ime, "wrap");

		panel2.add(sifraLab);
		panel2.add(sifra, "wrap");

		JButton loginBtn = new JButton();
		loginBtn.setText("Prijava");
		loginBtn.setAlignmentX(CENTER_ALIGNMENT);
		loginBtn.setPreferredSize(new Dimension(80, 25));
		loginBtn.setBackground(new Color(109, 207, 246));

		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
//				Korisnik korisnik = new Korisnik("Tijana", "Matic", TipKorisnika.Admin, "tijanaM", "pass", false);
//				Korisnik korisnik1 = new Korisnik("Pavle", "Vojvodic", TipKorisnika.Admin, "pavleV", "pass", false);
//				Korisnik korisnik2 = new Korisnik("Sara", "Simovic", TipKorisnika.Admin, "saraS", "pass", false);
//				Korisnik korisnik3 = new Korisnik("Petar", "Arsic", TipKorisnika.Admin, "petarA", "pass", false);
//				Korisnik korisnik4 = new Korisnik("Helena", "Velickovic", TipKorisnika.Admin, "helenaV", "pass", false);
//				Korisnik korisnik5 = new Korisnik("Igor", "Janjic", TipKorisnika.Admin, "igorJ", "pass", false);
//				Korisnik korisnik6 = new Korisnik("Marina", "Vukovic", TipKorisnika.Lekar, "marinaV", "pass", false);
//				Korisnik korisnik7 = new Korisnik("Vasilije", "Milovanovic", TipKorisnika.Lekar, "vasilijeM", "pass", false);
//				Korisnik korisnik8 = new Korisnik("Marija", "Petrovic", TipKorisnika.Lekar, "marijaP", "pass", false);
//				Korisnik korisnik9 = new Korisnik("Aleksa", "Stojanov", TipKorisnika.Lekar, "aleksaS", "pass", false);
//				Korisnik korisnik10 = new Korisnik("Sofija", "Radic", TipKorisnika.Lekar, "sofijaR", "pass", false);
//				Korisnik korisnik11 = new Korisnik("Milan", "Avramovic", TipKorisnika.Lekar, "milanA", "pass", false);
//				Korisnik korisnik12 = new Korisnik("Ana", "Delic", TipKorisnika.Apotekar, "anaD", "pass", false);
//				Korisnik korisnik13 = new Korisnik("Dejan", "Mitrovic", TipKorisnika.Apotekar, "dejanM", "pass", false);
//				Korisnik korisnik14 = new Korisnik("Milica", "Markovic", TipKorisnika.Apotekar, "milicaM", "pass", false);
//				Korisnik korisnik15 = new Korisnik("Milos", "Jovanovic", TipKorisnika.Apotekar, "milosJ", "pass", false);
//				Korisnik korisnik16 = new Korisnik("Teodora", "Nikolic", TipKorisnika.Apotekar, "teodoraN", "pass", false);
//				Korisnik korisnik17 = new Korisnik("Dusan", "Ivanovic", TipKorisnika.Apotekar, "dusanI", "pass", false);
//				
//				ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
//				korisnici.add(korisnik);
//				korisnici.add(korisnik1);
//				korisnici.add(korisnik2);
//				korisnici.add(korisnik3);
//				korisnici.add(korisnik4);
//				korisnici.add(korisnik5);
//				korisnici.add(korisnik6);
//				korisnici.add(korisnik7);
//				korisnici.add(korisnik8);
//				korisnici.add(korisnik9);
//				korisnici.add(korisnik10);
//				korisnici.add(korisnik11);
//				korisnici.add(korisnik12);
//				korisnici.add(korisnik13);
//				korisnici.add(korisnik14);
//				korisnici.add(korisnik15);
//				korisnici.add(korisnik16);
//				korisnici.add(korisnik17);
//				
//				try {
//					ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream("korisnik.txt"));
//					
//					for (Korisnik kor : korisnici) {
//			                objectOutput.writeObject(kor);
//			            }
//				} catch (FileNotFoundException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}

				try {
					ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream("korisnik.txt"));

					while (true) {
						Korisnik kor = (Korisnik) objectInput.readObject();

						if (ime.getText().equals(kor.getKorIme())) {
							if (String.valueOf(sifra.getPassword()).equals(kor.getLozinka())) {
//								System.out.println(kor.getIme() + "\t");
//								System.out.print(kor.getPrezime() + "\t");
//								System.out.print(kor.getTip() + "\t");
//								System.out.print(kor.getKorIme() + "\t");
								System.out.print(kor.getLozinka() + "\t");
//								System.out.println(kor.isObrisan() + "\t");

								setVisible(false);
								MainFrame mainFrameScreen = new MainFrame(kor);
								mainFrameScreen.setVisible(true);
								objectInput.close();
								break;
							}
						}
					}
				} catch (EOFException eof) {
					i = i + 1;
					System.out.println("Reached end of file" + i);
					if (i > 2) {
						setVisible(false);
						JOptionPane.showMessageDialog(null, "Korisnicko ime ili lozinka ne postoji.", "Greška", JOptionPane.ERROR_MESSAGE);
					}
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.add(loginBtn);
		buttonPanel.setBackground(new Color(230, 255, 251));

		this.add(panel1, BorderLayout.NORTH);
		this.add(panel2, BorderLayout.CENTER);
		this.add(buttonPanel, BorderLayout.SOUTH);

	}
}
