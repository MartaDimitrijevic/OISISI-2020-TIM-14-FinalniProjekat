package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import action.LekoviAkcija;
import action.ReceptiAkcija;
import model.Lekovi;
import model.Recept;

public class LekoviPretraga extends JPanel {
	
	public LekoviPretraga() {
		
	}
	
		public void pretragaLekova(JPanel pretragaLek, JPanel bottomPanelLek) {
			pretragaLek.setVisible(true);
			pretragaLek.setLayout(new BorderLayout());
			pretragaLek.setBackground(new Color(230, 255, 251));
			
			JPanel pretragaPanelLek = new JPanel();
			JLabel lblPretragaLek = new JLabel("Pretraga po :");
			pretragaPanelLek.setBackground(new Color(230, 255, 251));
			lblPretragaLek.setFont(new Font("Ariel", 0, 23));
			pretragaPanelLek.add(lblPretragaLek);
			

			JPanel raddioButtonsLekPret = new JPanel();
			GridLayout raddioLayoutLekPret = new GridLayout(1, 4);
			raddioButtonsLekPret.setBackground(new Color(230, 255, 251));
			raddioButtonsLekPret.setLayout(raddioLayoutLekPret);
			
			String fileName = "kreiraniLekovii4.txt";

			LekoviAkcija lekoviAkcija = new LekoviAkcija();
			ArrayList<Lekovi> sviLekovi = lekoviAkcija.ucitajLekove(fileName);
			
			JPanel searchPan = new JPanel();
			searchPan.setBackground(new Color(230, 255, 251));
			JTextField searchTxt = new JTextField(30);
			searchTxt.setFont(new Font("Ariel", 0, 20));
			searchPan.setLayout(new FlowLayout(FlowLayout.LEFT));
			searchPan.add(searchTxt);
			
			JPanel tablePanel = new JPanel();
			JTable lekoviPretragaTabela = getLekoviPretragaTabela(sviLekovi);
			lekoviPretragaTabela.setRowHeight(40);
			JScrollPane scroll = new JScrollPane(lekoviPretragaTabela);
			scroll.getViewport().setPreferredSize(new Dimension(1000, 400));
			
			JRadioButton radBtn1LekPret = new JRadioButton("Sifri");
			radBtn1LekPret.setFont(new Font("Arial", 0, 23));
			radBtn1LekPret.setBackground(new Color(230, 255, 251));
			radBtn1LekPret.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("akcija " + e.getActionCommand());
					System.out.println(lekoviPretragaTabela.getRowCount());
					revalidate();
					repaint();
					tablePanel.setVisible(true);
					searchPan.setVisible(true);
				}
			});
			
			JRadioButton radBtn2LekPret = new JRadioButton("Imenu");
			radBtn2LekPret.setFont(new Font("Arial", 0, 23));
			radBtn2LekPret.setBackground(new Color(230, 255, 251));
			radBtn2LekPret.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("akcija " + e.getActionCommand());
				}
			});
			
			JRadioButton radBtn3LekPret = new JRadioButton("Proizvodjacu");
			radBtn3LekPret.setFont(new Font("Arial", 0, 23));
			radBtn3LekPret.setBackground(new Color(230, 255, 251));
			radBtn3LekPret.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("akcija " + e.getActionCommand());
				}
			});
			
			JRadioButton radBtn4LekPret = new JRadioButton("Ceni");
			radBtn4LekPret.setFont(new Font("Arial", 0, 23));
			radBtn4LekPret.setBackground(new Color(230, 255, 251));
			radBtn4LekPret.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("akcija " + e.getActionCommand());
				}
			});
			
			ButtonGroup pretragaPoLek = new ButtonGroup();

			pretragaPoLek.add(radBtn1LekPret);
			pretragaPoLek.add(radBtn2LekPret);
			pretragaPoLek.add(radBtn3LekPret);
			pretragaPoLek.add(radBtn4LekPret);
			
			String radioText = "";

			if (radBtn1LekPret.isSelected()) {
				radioText = radBtn1LekPret.getText();
			}
			if (radBtn2LekPret.isSelected()) {
				radioText = radBtn2LekPret.getText();
			}
			if (radBtn3LekPret.isSelected()) {
				radioText = radBtn3LekPret.getText();
			}
			if (radBtn4LekPret.isSelected()) {
				radioText = radBtn4LekPret.getText();
			}
			
			raddioButtonsLekPret.add(radBtn1LekPret);
			raddioButtonsLekPret.add(radBtn2LekPret);
			raddioButtonsLekPret.add(radBtn3LekPret);
			raddioButtonsLekPret.add(radBtn4LekPret);
			
			pretragaLek.add(pretragaPanelLek, BorderLayout.WEST);
//			pretraga.add(raddioButtons, BorderLayout.CENTER);
			pretragaLek.add(raddioButtonsLekPret);
			
			tablePanel.add(scroll, BorderLayout.CENTER);
			tablePanel.setVisible(false);
			searchPan.setVisible(false);
			
			bottomPanelLek.add(searchPan, BorderLayout.NORTH);
			bottomPanelLek.add(tablePanel, BorderLayout.CENTER);

		}
		private JTable getLekoviPretragaTabela(ArrayList<Lekovi> lekoviLista) {
			JTable tabela = new JTable();
			DefaultTableModel model = new DefaultTableModel(new Object[] { "Sifra", "Ime", "Proizvodjac", "Recept","Cena" }, 0);
			for (Lekovi leko : lekoviLista) {
				model.addRow(
						new Object[] { leko.getSifra(), leko.getIme(), leko.getProizvodjac(), leko.getRecept() , leko.getCena()});
			}
			tabela.setModel(model);
			return tabela;

		}





}
