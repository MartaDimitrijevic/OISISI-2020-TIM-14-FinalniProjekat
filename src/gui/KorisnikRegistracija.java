package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class KorisnikRegistracija {
public KorisnikRegistracija() {}
	
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
	
		JRadioButton radBtnKorReg2 = new JRadioButton("Apotekar");
		radBtnKorReg2.setFont(new Font("Arial", 0, 23));
		radBtnKorReg2.setBackground(new Color(230, 255, 251));
		
		ButtonGroup registracijaTipaKor = new ButtonGroup( );
		
		registracijaTipaKor.add(radBtnKorReg1);
		registracijaTipaKor.add(radBtnKorReg2);
		
		String radioText = "";
			
		if (radBtnKorReg1.isSelected()) {radioText = radBtnKorReg1.getText(); }
		if (radBtnKorReg2.isSelected()) {radioText = radBtnKorReg2.getText(); }
		
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
