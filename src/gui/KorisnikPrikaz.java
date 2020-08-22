package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import action.ReceptiAkcija;
import model.Korisnik;
import model.Recept;
import action.KorisnikAkcija;

public class KorisnikPrikaz extends JPanel {

	public KorisnikPrikaz() {
	}

	public void sortiranjeKorisnika(JPanel sortiranjeKor, JPanel bottomPanelKor) {
		revalidate();
		repaint();

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

		String fileName = "korisnik.txt";

		KorisnikAkcija registracijaKorisnika = new KorisnikAkcija();
		ArrayList<Korisnik> sviKorisnici = registracijaKorisnika.ucitajKorisnike(fileName);


		JPanel tablePanKorPrik = new JPanel();
		JTable prikazKorisniciTabela = getPrikazKorisnikaTabela(sviKorisnici);
		prikazKorisniciTabela.setRowHeight(40);
		JScrollPane scroll = new JScrollPane(prikazKorisniciTabela);
		scroll.getViewport().setPreferredSize(new Dimension(1000, 400));

		JRadioButton radBtnKorPrik1 = new JRadioButton("Ime korisnika");
		radBtnKorPrik1.setFont(new Font("Arial", 0, 23));
		radBtnKorPrik1.setBackground(new Color(230, 255, 251));
		radBtnKorPrik1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				System.out.println(prikazKorisniciTabela.getRowCount());

				revalidate();
				repaint();
				tablePanKorPrik.setVisible(true);

				TableRowSorter<TableModel> sorter = new TableRowSorter<>(prikazKorisniciTabela.getModel());
				class IntComparator implements Comparator {
					public int compare(Object o1, Object o2) {
						String int1 = (String) o1;
						String int2 = (String) o2;
						return int1.compareTo(int2);
					}

					public boolean equals(Object o2) {
						return this.equals(o2);
					}
				}

				sorter.setComparator(0, new IntComparator());
				prikazKorisniciTabela.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();

				int columnIndexToSort = 0;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

				sorter.setSortKeys(sortKeys);
				sorter.setSortable(1, false);
				sorter.setSortable(2, false);
				sorter.sort();
			}
		});

		JRadioButton radBtnKorPrik2 = new JRadioButton("Prezime korisnika");
		radBtnKorPrik2.setFont(new Font("Arial", 0, 23));
		radBtnKorPrik2.setBackground(new Color(230, 255, 251));

		radBtnKorPrik2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				System.out.println(prikazKorisniciTabela.getRowCount());

				revalidate();
				repaint();
				tablePanKorPrik.setVisible(true);

				TableRowSorter<TableModel> sorter = new TableRowSorter<>(prikazKorisniciTabela.getModel());
				prikazKorisniciTabela.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();

				int columnIndexToSort = 1;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

				sorter.setSortKeys(sortKeys);
				sorter.setSortable(0, false);
				sorter.setSortable(2, false);
				sorter.sort();
			}
		});

		JRadioButton radBtnKorPrik3 = new JRadioButton("Tip korisnika");
		radBtnKorPrik3.setFont(new Font("Arial", 0, 23));
		radBtnKorPrik3.setBackground(new Color(230, 255, 251));

		radBtnKorPrik3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				System.out.println(prikazKorisniciTabela.getRowCount());

				revalidate();
				repaint();
				tablePanKorPrik.setVisible(true);

				TableRowSorter<TableModel> sorter = new TableRowSorter<>(prikazKorisniciTabela.getModel());
				prikazKorisniciTabela.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();

				int columnIndexToSort = 2;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

				sorter.setSortKeys(sortKeys);
				sorter.setSortable(0, false);
				sorter.setSortable(1, false);
				sorter.sort();
			}
		});

		ButtonGroup sortirajPo = new ButtonGroup();

		sortirajPo.add(radBtnKorPrik1);
		sortirajPo.add(radBtnKorPrik2);
		sortirajPo.add(radBtnKorPrik3);

		String radioText = "";

		if (radBtnKorPrik1.isSelected()) {
			radioText = radBtnKorPrik1.getText();
		}
		if (radBtnKorPrik2.isSelected()) {
			radioText = radBtnKorPrik2.getText();
		}
		if (radBtnKorPrik3.isSelected()) {
			radioText = radBtnKorPrik3.getText();
		}

		raddioButtonsKorPrik.add(radBtnKorPrik1);
		raddioButtonsKorPrik.add(radBtnKorPrik2);
		raddioButtonsKorPrik.add(radBtnKorPrik3);

		sortiranjeKor.add(sortirajPanelKor, BorderLayout.WEST);
		sortiranjeKor.add(raddioButtonsKorPrik, BorderLayout.CENTER);

		tablePanKorPrik.add(scroll, BorderLayout.CENTER);
		tablePanKorPrik.setVisible(false);
		
		bottomPanelKor.add(tablePanKorPrik, BorderLayout.CENTER);
	}

	private JTable getPrikazKorisnikaTabela(ArrayList<Korisnik> korisniciLista) {
		JTable tabela = new JTable();
		DefaultTableModel model = new DefaultTableModel(new Object[] { "Ime", "Prezime", "Tip korisnika" }, 0);
		for (Korisnik korisnik : korisniciLista) {
			model.addRow(new Object[] { korisnik.getIme(), korisnik.getPrezime(), korisnik.getTip() });
		}
		tabela.setModel(model);
		return tabela;

	}
}
