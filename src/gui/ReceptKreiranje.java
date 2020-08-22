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

import action.ReceptiAkcija;
import model.Korisnik;

public class ReceptKreiranje extends JPanel{
	
	public ReceptKreiranje() {}
	
	public void kreiranjeRecepata(JPanel kreiranjeRec, Korisnik korisnik) {
		
		kreiranjeRec.setVisible(true);
		kreiranjeRec.setLayout(new BorderLayout());
		kreiranjeRec.setBackground(new Color(230, 255, 251));
		
		JPanel parameterTextPanKreir = new JPanel();
		parameterTextPanKreir.setBackground(new Color(250, 255, 251));
		BoxLayout parameterTextPanGlueRec = new BoxLayout(parameterTextPanKreir, BoxLayout.Y_AXIS);
		parameterTextPanKreir.setLayout(parameterTextPanGlueRec);

		JPanel parameterPan1Kreir = new JPanel();
		parameterPan1Kreir.setBackground(new Color(230, 255, 251));
		JLabel JMBGLabelKreir = new JLabel("  JMBG pacijenta :");
		JMBGLabelKreir.setFont(new Font("Ariel", 0, 30));

		JTextField textArea1Kreir = new JTextField(30);
		textArea1Kreir.setFont(new Font("Serif", Font.ITALIC, 16));

		parameterPan1Kreir.add(JMBGLabelKreir);
		parameterPan1Kreir.add(textArea1Kreir);
		parameterTextPanKreir.add(parameterPan1Kreir);

		JPanel parameterPan4Kreir = new JPanel();
		parameterPan4Kreir.setBackground(new Color(230, 255, 251));
		JLabel passwordPanKreir = new JLabel("           Naziv leka :");
		passwordPanKreir.setFont(new Font("Ariel", 0, 30));

		JTextField textArea4Kreir = new JTextField(30);
		textArea4Kreir.setFont(new Font("Serif", Font.ITALIC, 16));

		parameterPan4Kreir.add(passwordPanKreir);
		parameterPan4Kreir.add(textArea4Kreir);
		parameterTextPanKreir.add(parameterPan4Kreir);

		JPanel parameterPan5Kreir = new JPanel();
		parameterPan5Kreir.setBackground(new Color(230, 255, 251));
		JLabel quantityPanKreir = new JLabel("       Kolicina leka :");
		quantityPanKreir.setFont(new Font("Ariel", 0, 30));

		JTextField textArea5Kreir = new JTextField(30);
		textArea5Kreir.setFont(new Font("Serif", Font.ITALIC, 16));

		parameterPan5Kreir.add(quantityPanKreir);
		parameterPan5Kreir.add(textArea5Kreir);
		parameterTextPanKreir.add(parameterPan5Kreir);

		JPanel btnKreir = new JPanel();
		btnKreir.setBackground(new Color(230, 255, 251));
		JButton btnPrh = new JButton("Kreiraj");
		btnPrh.setFont(new Font("Arial", 0, 30));
		btnPrh.setBackground(new Color(0, 204, 255));
		btnPrh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String jmbg = textArea1Kreir.getText();
				String lek = textArea4Kreir.getText();
				String kolicina = textArea5Kreir.getText();
				ReceptiAkcija kreiranje = new ReceptiAkcija();
				kreiranje.kreirajRecept(jmbg, lek, kolicina, korisnik);
			}
		});
		
		btnKreir.add(btnPrh);
		btnKreir.setLayout(new FlowLayout(FlowLayout.RIGHT));

		kreiranjeRec.add(parameterTextPanKreir, BorderLayout.CENTER);
		kreiranjeRec.add(btnKreir, BorderLayout.SOUTH);		
	}
}
