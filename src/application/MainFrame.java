package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Korisnik;
import model.TipKorisnika;

public class MainFrame extends JFrame {

	public MainFrame(Korisnik korisnik) {

		setSize(1300, 730);
//		setBounds(300, 100, 1300, 800);	
		setTitle(korisnik.getTip().toString() + " OISISI-2020-TIM-14");

		JPanel panLeft = new JPanel();
		BoxLayout panel = new BoxLayout(panLeft, BoxLayout.Y_AXIS);
		panLeft.setLayout(panel);
		panLeft.setBackground(new Color(154, 255, 197));
//		panLeft.setPreferredSize(new Dimension(140, 30));
		this.add(panLeft);

		ImageIcon icon1 = new ImageIcon("images/lekovi.png");
		JButton btn1 = new JButton("Lekovi", icon1);
		btn1.setBackground(new Color(154, 255, 197));
		btn1.setFont(new Font("Arial", 0, 20));
		btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		panLeft.add(btn1);

		ImageIcon icon2 = new ImageIcon("images/recepti1.png");
		JButton btn2 = new JButton("Recepti", icon2);
		btn2.setBackground(new Color(154, 255, 197));
		btn2.setFont(new Font("Arial", 0, 20));
		btn2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn2.setHorizontalTextPosition(SwingConstants.CENTER);
		panLeft.add(btn2);

		ImageIcon icon3 = new ImageIcon("images/korisnik1.png");
		JButton btn3 = new JButton("Korisnici", icon3);
		btn3.setBackground(new Color(154, 255, 197));
		btn3.setFont(new Font("Arial", 0, 20));
		btn3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn3.setHorizontalTextPosition(SwingConstants.CENTER);
		panLeft.add(btn3);

		ImageIcon icon4 = new ImageIcon("images/izvestaj1.png");
		JButton btn4 = new JButton("Izvestaj", icon4);
		btn4.setFont(new Font("Arial", 0, 20));
		btn4.setBackground(new Color(154, 255, 197));
		btn4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn4.setHorizontalTextPosition(SwingConstants.CENTER);
		panLeft.add(btn4);

		ImageIcon icon5 = new ImageIcon("images/korpa1.png");
		JButton btn5 = new JButton("Korpa", icon5);
		btn5.setFont(new Font("Arial", 0, 20));
		btn5.setBackground(new Color(154, 255, 197));
		btn5.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn5.setHorizontalTextPosition(SwingConstants.CENTER);
		panLeft.add(btn5);

		JPanel panCenter = new JPanel(new BorderLayout(20, 20));
		panCenter.setBackground(new Color(230, 255, 251));

		switch (korisnik.getTip()) {
		case Admin: {
			btn1.setVisible(true);
			btn2.setVisible(true);
			btn3.setVisible(true);
			btn4.setVisible(true);
			btn5.setVisible(false);
			break;
		}
		case Apotekar: {
			btn1.setVisible(true);
			btn2.setVisible(true);
			btn3.setVisible(false);
			btn4.setVisible(false);
			btn5.setVisible(true);
			break;
		}
		case Lekar: {
			btn1.setVisible(true);
			btn2.setVisible(true);
			btn3.setVisible(false);
			btn4.setVisible(false);
			btn5.setVisible(false);
			break;
		}
		}
		System.out.println(korisnik.getTip());
		
		add(panLeft, BorderLayout.WEST);
		add(panCenter, BorderLayout.CENTER);

		
	}
}
