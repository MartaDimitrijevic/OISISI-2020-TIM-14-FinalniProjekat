package application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Korisnik;
import model.TipKorisnika;
import gui.Izvestaj;
import gui.KorisniciMeni;
import gui.KorpaMeni;
import gui.LekoviMeni;
import gui.ReceptiMeni;
import gui.ReceptPrikaz;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1745616480576316235L;

	public MainFrame(Korisnik korisnik) {

		setSize(1300, 730);
		setTitle(korisnik.getTip().toString() + " OISISI-2020-TIM-14");

		JPanel panLeft = new JPanel();
		BoxLayout panel = new BoxLayout(panLeft, BoxLayout.Y_AXIS);
		panLeft.setLayout(panel);
		panLeft.setBackground(new Color(154, 255, 197));
		
		JPanel panCenterLek = new JPanel(new BorderLayout(20, 20));
		panCenterLek.setBackground(new Color(230, 255, 251));
		
		JPanel panCenterRec = new JPanel(new BorderLayout(20, 20));
		panCenterRec.setBackground(new Color(230, 255, 251));
		
		JPanel panCenterKor = new JPanel(new BorderLayout(20, 20));
		panCenterKor.setBackground(new Color(230, 255, 251));
		
		JPanel panCenterIzv = new JPanel(new BorderLayout(20, 20));
		panCenterIzv.setBackground(new Color(230, 255, 251));
		
		JPanel panCenterKorp = new JPanel(new BorderLayout(20, 20));
		panCenterKorp.setBackground(new Color(230, 255, 251));
		
		ImageIcon icon1 = new ImageIcon("images/lekovi.png");
		JButton btn1 = new JButton("Lekovi", icon1);
		btn1.setBackground(new Color(154, 255, 197));
		btn1.setFont(new Font("Arial", 0, 20));
		btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn1.setHorizontalTextPosition(SwingConstants.CENTER);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				LekoviMeni lekoviProzor = new LekoviMeni();
				lekoviProzor.meniLekova(panCenterLek, korisnik);
				
				remove(panCenterRec);
				remove(panCenterKor);
				remove(panCenterIzv);
				add(panCenterLek);

	            revalidate();
	            repaint();
			}
		});
		panLeft.add(btn1);

		ImageIcon icon2 = new ImageIcon("images/recepti1.png");
		JButton btn2 = new JButton("Recepti", icon2);
		btn2.setBackground(new Color(154, 255, 197));
		btn2.setFont(new Font("Arial", 0, 20));
		btn2.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn2.setHorizontalTextPosition(SwingConstants.CENTER);


		ReceptiMeni receptiProzor = new ReceptiMeni();
		receptiProzor.meniRecepata(panCenterRec, korisnik);
		
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				remove(panCenterLek);
				remove(panCenterKor);
				remove(panCenterIzv);
				remove(panCenterKorp);
                add(panCenterRec);

                revalidate();
                repaint();
			}
		});
		panLeft.add(btn2);
		
		ImageIcon icon3 = new ImageIcon("images/korisnik1.png");
		JButton btn3 = new JButton("Korisnici", icon3);
		btn3.setBackground(new Color(154, 255, 197));
		btn3.setFont(new Font("Arial", 0, 20));
		btn3.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn3.setHorizontalTextPosition(SwingConstants.CENTER);
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				KorisniciMeni korisniciProzor = new KorisniciMeni();
				korisniciProzor.meniKorisnika(panCenterKor);
				
				remove(panCenterLek);
				remove(panCenterRec);
				remove(panCenterIzv);
				remove(panCenterKorp);
                add(panCenterKor);
                revalidate();
                repaint();

			}
		});
		panLeft.add(btn3);

		ImageIcon icon4 = new ImageIcon("images/izvestaj1.png");
		JButton btn4 = new JButton("Izvestaj", icon4);
		btn4.setFont(new Font("Arial", 0, 20));
		btn4.setBackground(new Color(154, 255, 197));
		btn4.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn4.setHorizontalTextPosition(SwingConstants.CENTER);
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				Izvestaj izvestajProzor = new Izvestaj();
				izvestajProzor.meniIzvestaja(panCenterIzv);
				remove(panCenterLek);
                remove(panCenterRec);
                remove(panCenterKor);
                remove(panCenterKorp);
                add(panCenterIzv);
                revalidate();
                repaint();

			}
		});
		panLeft.add(btn4);

		ImageIcon icon5 = new ImageIcon("images/korpa1.png");
		JButton btn5 = new JButton("Korpa", icon5);
		btn5.setFont(new Font("Arial", 0, 20));
		btn5.setBackground(new Color(154, 255, 197));
		btn5.setVerticalTextPosition(SwingConstants.BOTTOM);
		btn5.setHorizontalTextPosition(SwingConstants.CENTER);
		btn5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				KorpaMeni korpaProzor = new KorpaMeni();
				korpaProzor.meniKorpa(panCenterKorp);
				remove(panCenterLek);
                remove(panCenterRec);
                remove(panCenterKor);
                remove(panCenterIzv);
                add(panCenterKorp);
                revalidate();
                repaint();
			}
		});
		panLeft.add(btn5);
		
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
		System.out.print(korisnik.getTip() + "\t");
		System.out.println(korisnik.getIme() + "\t" + korisnik.getPrezime() + "\t");
		
		add(panLeft, BorderLayout.WEST);
//		add(panCenter, BorderLayout.CENTER);
		add(panCenterLek, BorderLayout.CENTER);
		add(panCenterRec, BorderLayout.CENTER);
		add(panCenterKor, BorderLayout.CENTER);
		add(panCenterIzv, BorderLayout.CENTER);
		add(panCenterKorp, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);
	}
}
