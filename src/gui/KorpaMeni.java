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

import model.Korisnik;

public class KorpaMeni extends JPanel{

	public KorpaMeni() {}
	
	public void meniKorpa(JPanel panCenterKorp) {
		panCenterKorp.setVisible(true);
		panCenterKorp.setBackground(new Color(230, 255, 251));
		
		System.out.println("print: korpa");
		
		JPanel receptiPanel = new JPanel();
		BoxLayout menuPanelGlueRec = new BoxLayout(receptiPanel, BoxLayout.Y_AXIS);
		receptiPanel.setLayout(menuPanelGlueRec);
		receptiPanel.setBackground(new Color(230, 255, 251));

		JPanel naslovRec = new JPanel();
		naslovRec.setLayout(new BorderLayout());
		naslovRec.setBackground(new Color(230, 255, 251));

		JPanel labelaRecepti = new JPanel();
		JLabel lblTopRec = new JLabel("Korpa");
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
		
		JPanel searchPan = new JPanel();
		searchPan.setBackground(new Color(230, 255, 251));
		JLabel passwordInput = new JLabel("Unesi sifru recepta :");
		passwordInput.setFont(new Font("Ariel", 0, 30));

		JTextField searchTxt = new JTextField(30);
		searchTxt.setFont(new Font("Serif", Font.ITALIC, 25));

		searchPan.setLayout(new FlowLayout(FlowLayout.LEFT));
		searchPan.add(passwordInput);
		searchPan.add(searchTxt);
		
		JPanel bottomPanelRec = new JPanel();
		bottomPanelRec.setBackground(new Color(230, 255, 251));
		
		bottomPanelRec.add(searchPan, BorderLayout.NORTH);	
		
		panCenterKorp.add(naslovRec, BorderLayout.NORTH);
		panCenterKorp.add(bottomPanelRec, BorderLayout.CENTER);
		
		
		}
}
