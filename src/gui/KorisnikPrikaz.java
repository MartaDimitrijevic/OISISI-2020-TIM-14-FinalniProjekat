package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class KorisnikPrikaz extends JPanel{
	
	public KorisnikPrikaz() {}
	
	public void sortiranjeKorisnika(JPanel sortiranjeKor) {
		sortiranjeKor.setVisible(true);
		sortiranjeKor.setLayout(new BorderLayout());
		sortiranjeKor.setBackground(new Color(230, 255, 251));
		
		JPanel sortirajPanelKor = new JPanel();
		JLabel lblSortKor = new JLabel("Sortiraj po :");
		sortirajPanelKor.setBackground(new Color(230, 255, 251));
		lblSortKor.setFont(new Font("Ariel", 0, 23));
		sortirajPanelKor.add(lblSortKor);
		
		JPanel raddioButtonsKorPrik = new JPanel();
		GridLayout raddioLayoutKorPrik = new GridLayout(1, 3);
		raddioButtonsKorPrik.setBackground(new Color(230, 255, 251));
		raddioButtonsKorPrik.setLayout(raddioLayoutKorPrik);
		
		JRadioButton radBtnKorPrik1 = new JRadioButton("Ime korisnika");
		radBtnKorPrik1.setFont(new Font("Arial", 0, 23));
		radBtnKorPrik1.setBackground(new Color(230, 255, 251));
	
		JRadioButton radBtnKorPrik2 = new JRadioButton("Prezime korisnika");
		radBtnKorPrik2.setFont(new Font("Arial", 0, 23));
		radBtnKorPrik2.setBackground(new Color(230, 255, 251));
	
		JRadioButton radBtnKorPrik3 = new JRadioButton("Tip korisnika");
		radBtnKorPrik3.setFont(new Font("Arial", 0, 23));
		radBtnKorPrik3.setBackground(new Color(230, 255, 251));
		
		ButtonGroup sortirajPo = new ButtonGroup( );
		
		sortirajPo.add(radBtnKorPrik1);
		sortirajPo.add(radBtnKorPrik2);
		sortirajPo.add(radBtnKorPrik3);
		
		String radioText = "";
			
		if (radBtnKorPrik1.isSelected()) {radioText = radBtnKorPrik1.getText(); }
		if (radBtnKorPrik2.isSelected()) {radioText = radBtnKorPrik2.getText(); }
		if (radBtnKorPrik3.isSelected()) {radioText = radBtnKorPrik3.getText(); }
		
		raddioButtonsKorPrik.add(radBtnKorPrik1);
		raddioButtonsKorPrik.add(radBtnKorPrik2);
		raddioButtonsKorPrik.add(radBtnKorPrik3);
		
		sortiranjeKor.add(sortirajPanelKor, BorderLayout.WEST);
		sortiranjeKor.add(raddioButtonsKorPrik, BorderLayout.CENTER);
//		sortiranjeRec.add(raddioButtons);
	}
}
