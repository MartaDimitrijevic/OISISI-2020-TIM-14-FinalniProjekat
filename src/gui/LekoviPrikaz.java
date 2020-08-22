package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import action.LekoviAkcija;
import action.ReceptiAkcija;
import model.Lekovi;
import model.Recept;

public class LekoviPrikaz extends JPanel {
	
		public LekoviPrikaz() {
			
		}
		
		public void prikazLekova (JPanel prikazLek, JPanel bottomPanelLek) {
			revalidate();
			repaint();

			prikazLek.setVisible(true);
			prikazLek.setLayout(new BorderLayout());
			prikazLek.setBackground(new Color(230, 255, 251));
			
			
			JPanel prikazPanelLek = new JPanel();
			JLabel lblPrikazLek = new JLabel("Sortiraj po :");
			prikazPanelLek.setBackground(new Color(230, 255, 251));
			lblPrikazLek.setFont(new Font("Ariel", 0, 23));
			prikazPanelLek.add(lblPrikazLek);
			
			JPanel raddioButtonsLekPrik = new JPanel();
			GridLayout raddioLayoutLekPrik = new GridLayout(1, 3);
//			raddioLayout.setHgap(2);
			raddioButtonsLekPrik.setBackground(new Color(230, 255, 251));
			raddioButtonsLekPrik.setLayout(raddioLayoutLekPrik);
			
			
			String fileName = "kreiraniLekovi4.txt";
			
			LekoviAkcija lekoviAkcija = new LekoviAkcija();
			ArrayList<Lekovi> sviLekovi = lekoviAkcija.ucitajLekove(fileName);
			
			JPanel tablePanel = new JPanel();
			JTable lekoviPrikazTabela = getLekoviPrikazTabela(sviLekovi);
			lekoviPrikazTabela.setRowHeight(40);
			JScrollPane scroll = new JScrollPane(lekoviPrikazTabela);
			scroll.getViewport().setPreferredSize(new Dimension(1000, 400));
			
			JRadioButton radBtn1LekPrik = new JRadioButton("Imenu");
			radBtn1LekPrik.setActionCommand("Imenu");
			radBtn1LekPrik.setFont(new Font("Arial", 0, 23));
			radBtn1LekPrik.setBackground(new Color(230, 255, 251));
			radBtn1LekPrik.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("akcija " + e.getActionCommand());
					System.out.println(lekoviPrikazTabela.getRowCount());
					revalidate();
					repaint();
					tablePanel.setVisible(true);
				}
			});
			
			
			JRadioButton radBtn2LekPrik = new JRadioButton("Proizvodjacu");
			radBtn2LekPrik.setFont(new Font("Arial", 0, 23));
			radBtn2LekPrik.setBackground(new Color(230, 255, 251));
			radBtn2LekPrik.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("akcija " + e.getActionCommand());
				}
			});
			
			JRadioButton radBtn3LekPrik = new JRadioButton("Ceni");
			radBtn3LekPrik.setFont(new Font("Arial", 0, 23));
			radBtn3LekPrik.setBackground(new Color(230, 255, 251));
			radBtn3LekPrik.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("akcija " + e.getActionCommand());
				}
			});


			ButtonGroup sortirajPo = new ButtonGroup();

			sortirajPo.add(radBtn1LekPrik);
			sortirajPo.add(radBtn2LekPrik);
			sortirajPo.add(radBtn3LekPrik);
			
			
			String radioText = "";

			if (radBtn1LekPrik.isSelected()) {
				radioText = radBtn1LekPrik.getText();
			}
			if (radBtn2LekPrik.isSelected()) {
				radioText = radBtn2LekPrik.getText();
			}
			if (radBtn3LekPrik.isSelected()) {
				radioText = radBtn3LekPrik.getText();
			}
			
			raddioButtonsLekPrik.add(radBtn1LekPrik);
			raddioButtonsLekPrik.add(radBtn2LekPrik);
			raddioButtonsLekPrik.add(radBtn3LekPrik);
			
			prikazLek.add(prikazPanelLek, BorderLayout.WEST);
			prikazLek.add(raddioButtonsLekPrik, BorderLayout.CENTER);

			tablePanel.add(scroll, BorderLayout.CENTER);
			tablePanel.setVisible(false);
			
			bottomPanelLek.add(tablePanel, BorderLayout.CENTER);

		}

		private JTable getLekoviPrikazTabela(ArrayList<Lekovi> lekoviLista) {
			JTable tabela = new JTable();
			DefaultTableModel model = new DefaultTableModel(new Object[] { "Ime", "Sifra",  "Proizvodjac", "Recept","Cena" }, 0);
			for (Lekovi leko : lekoviLista) {
				model.addRow(
						new Object[] {  leko.getIme(), leko.getSifra(), leko.getProizvodjac(), leko.getRecept() , leko.getCena()});
			}
			tabela.setModel(model);
			return tabela;

		}
					
}
		           
