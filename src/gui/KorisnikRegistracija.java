package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import action.ReceptiAkcija;
import action.KorisnikAkcija;
import model.TipKorisnika;

public class KorisnikRegistracija {
public KorisnikRegistracija() {}

public static String radioString = "Lekar";
	
	public void registracijaKorisnika(JPanel registracijaKor) {
		registracijaKor.setVisible(true);
		registracijaKor.setLayout(new BorderLayout());
		registracijaKor.setBackground(new Color(230, 255, 251));
		
		JPanel parameterTextPanKor = new JPanel();
		parameterTextPanKor.setBackground(new Color(250, 255, 251));
		BoxLayout parameterTextPanGlueKor = new BoxLayout(parameterTextPanKor, BoxLayout.Y_AXIS);
		parameterTextPanKor.setLayout(parameterTextPanGlueKor);
		
		JPanel parameterPan1Kor = new JPanel();
		parameterPan1Kor.setBackground(new Color(230, 255, 251));
		JLabel nameKor = new JLabel("                    Ime :");
		nameKor.setFont(new Font("Ariel", 0, 30));

		JTextField textArea1Kor = new JTextField(30);
		textArea1Kor.setFont(new Font("Serif", Font.ITALIC, 16));
		
		parameterPan1Kor.add(nameKor);
		parameterPan1Kor.add(textArea1Kor);
		parameterTextPanKor.add(parameterPan1Kor);
		
		JPanel parameterPan2Kor = new JPanel();
		parameterPan2Kor.setBackground(new Color(230, 255, 251));
		JLabel surnameKor = new JLabel("            Prezime :");
		surnameKor.setFont(new Font("Ariel", 0, 30));

		JTextField textArea2Kor = new JTextField(30);
		textArea2Kor.setFont(new Font("Serif", Font.ITALIC, 16));

		parameterPan2Kor.add(surnameKor);
		parameterPan2Kor.add(textArea2Kor);
		parameterTextPanKor.add(parameterPan2Kor);

		JPanel raddioButtonsKorReg = new JPanel();
		GridLayout raddioLayoutKorReg = new GridLayout(1, 3);
		raddioButtonsKorReg.setBackground(new Color(230, 255, 251));
		raddioButtonsKorReg.setLayout(raddioLayoutKorReg);
		
		JPanel parameterPan3Kor = new JPanel();
		parameterPan3Kor.setBackground(new Color(230, 255, 251));
		JLabel typeKor = new JLabel("Tip korisnika :");
		typeKor.setFont(new Font("Ariel", 0, 30));
		
		
		JRadioButton radBtnKorReg1 = new JRadioButton("Lekar");
		radBtnKorReg1.setFont(new Font("Arial", 0, 23));
		radBtnKorReg1.setBackground(new Color(230, 255, 251));
		radBtnKorReg1.setSelected(true);
	
		JRadioButton radBtnKorReg2 = new JRadioButton("Apotekar");
		radBtnKorReg2.setFont(new Font("Arial", 0, 23));
		radBtnKorReg2.setBackground(new Color(230, 255, 251));
		radBtnKorReg2.setSelected(false);
		
		ButtonGroup registracijaTipaKor = new ButtonGroup( );
		
		registracijaTipaKor.add(radBtnKorReg1);
		registracijaTipaKor.add(radBtnKorReg2);
		
	    ActionListener sliceActionListener = new ActionListener() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          AbstractButton aButton = (AbstractButton) actionEvent.getSource();
	          System.out.println("Selected: " + aButton.getText());
	          KorisnikRegistracija.radioString = aButton.getText();
	        }
	      };
	    radBtnKorReg1.addActionListener(sliceActionListener);
	    radBtnKorReg2.addActionListener(sliceActionListener);

		raddioButtonsKorReg.add(typeKor);
		raddioButtonsKorReg.add(radBtnKorReg1);
		raddioButtonsKorReg.add(radBtnKorReg2);
		
		parameterPan3Kor.add(typeKor);
		parameterPan3Kor.add(radBtnKorReg1);
		parameterPan3Kor.add(radBtnKorReg2);
		parameterTextPanKor.add(parameterPan3Kor);
		
		JPanel parameterPan4Kor = new JPanel();
		parameterPan4Kor.setBackground(new Color(230, 255, 251));
		JLabel usernameKor = new JLabel(" Korisnicko ime :");
		usernameKor.setFont(new Font("Ariel", 0, 30));

		JTextField textArea4 = new JTextField(30);
		textArea4.setFont(new Font("Serif", Font.ITALIC, 16));

		parameterPan4Kor.add(usernameKor);
		parameterPan4Kor.add(textArea4);
		parameterTextPanKor.add(parameterPan4Kor);
		
		JPanel parameterPan5Kor = new JPanel();
		parameterPan5Kor.setBackground(new Color(230, 255, 251));
		JLabel passwordKor = new JLabel("                  Sifra :");
		passwordKor.setFont(new Font("Ariel", 0, 30));

		JTextField textArea5Kor = new JTextField(30);
		textArea5Kor.setFont(new Font("Serif", Font.ITALIC, 16));

		parameterPan5Kor.add(passwordKor);
		parameterPan5Kor.add(textArea5Kor);
		parameterTextPanKor.add(parameterPan5Kor);
		
		JPanel btnsKor = new JPanel();
		btnsKor.setBackground(new Color(230, 255, 251));

		JPanel btn1Kor = new JPanel();
		btn1Kor.setBackground(new Color(230, 255, 251));
		JButton btnPrh = new JButton("Registruj");
		btnPrh.setFont(new Font("Arial", 0, 30));
		btnPrh.setBackground(new Color(0, 204, 255));
		btnPrh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String ime = textArea1Kor.getText();
				String prezime = textArea2Kor.getText();
				String korisnickoIme = textArea4.getText();
				String lozinka = textArea5Kor.getText();
				KorisnikAkcija registracija = new KorisnikAkcija();
				try {
					registracija.registracijaKorisnika(ime, prezime, TipKorisnika.valueOf(KorisnikRegistracija.radioString), korisnickoIme, lozinka, false);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btn1Kor.add(btnPrh);

		JPanel btn2Kor = new JPanel();
		btn2Kor.setBackground(new Color(230, 255, 251));
		JButton btnOdbKor = new JButton("Ponisti");
		btnOdbKor.setFont(new Font("Arial", 0, 30));
		btnOdbKor.setBackground(new Color(255, 55, 0));

		btn2Kor.add(btnOdbKor);

		btnsKor.add(btn1Kor);
		btnsKor.add(btn2Kor);

		btnsKor.setLayout(new FlowLayout(FlowLayout.RIGHT));

		registracijaKor.add(parameterTextPanKor, BorderLayout.CENTER);
		registracijaKor.add(btnsKor, BorderLayout.SOUTH);
		
	}
}
