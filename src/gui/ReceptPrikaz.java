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
import model.Recept;

public class ReceptPrikaz extends JPanel {

	public ReceptPrikaz() {
	}

	public void sortiranjeRecepata(JPanel sortiranjeRec, JPanel bottomPanelRec) {
		revalidate();
		repaint();

		sortiranjeRec.setVisible(true);
		sortiranjeRec.setLayout(new BorderLayout());
		sortiranjeRec.setBackground(new Color(230, 255, 251));

		JPanel sortirajPanelRec = new JPanel();
		JLabel lblSortRec = new JLabel("Sortiraj po :");
		sortirajPanelRec.setBackground(new Color(230, 255, 251));
		lblSortRec.setFont(new Font("Ariel", 0, 23));
		sortirajPanelRec.add(lblSortRec);

		JPanel raddioButtonsRecPrik = new JPanel();
		GridLayout raddioLayoutRecPrik = new GridLayout(1, 3);
//		raddioLayout.setHgap(2);
		raddioButtonsRecPrik.setBackground(new Color(230, 255, 251));
		raddioButtonsRecPrik.setLayout(raddioLayoutRecPrik);
		
		String fileName = "kreiraniRecepti.txt";

		ReceptiAkcija receptiAkcija = new ReceptiAkcija();
		ArrayList<Recept> sviRecepti = receptiAkcija.ucitajRecepte(fileName);

		JPanel tablePanelPret = new JPanel();
		
		JPanel tablePanelPrik = new JPanel();
		JTable receptiPrikazTabela = getReceptiPrikazTabela(sviRecepti);
		receptiPrikazTabela.setRowHeight(40);
		JScrollPane scroll = new JScrollPane(receptiPrikazTabela);
		scroll.getViewport().setPreferredSize(new Dimension(1000, 400));

		JRadioButton radBtn1RecPrik = new JRadioButton("Sifri");
		radBtn1RecPrik.setActionCommand("Sifri");
		radBtn1RecPrik.setFont(new Font("Arial", 0, 23));
		radBtn1RecPrik.setBackground(new Color(230, 255, 251));
		radBtn1RecPrik.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				System.out.println(receptiPrikazTabela.getRowCount());
				
				revalidate();
				repaint();
				tablePanelPret.setVisible(false);
				tablePanelPrik.setVisible(true);
				
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(receptiPrikazTabela.getModel());
				class IntComparator implements Comparator {
		            public int compare(Object o1, Object o2) {
		                Integer int1 = (Integer)o1;
		                Integer int2 = (Integer)o2;
		                return int1.compareTo(int2);
		            }

		            public boolean equals(Object o2) {
		                return this.equals(o2);
		            }
		        }

				sorter.setComparator(0, new IntComparator());
				receptiPrikazTabela.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				 
				int columnIndexToSort = 0;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
				 
				sorter.setSortKeys(sortKeys);
				sorter.setSortable(1, false);
				sorter.setSortable(2, false);
				sorter.sort();
			}
		});

		JRadioButton radBtn2RecPrik = new JRadioButton("Lekaru");
		radBtn2RecPrik.setFont(new Font("Arial", 0, 23));
		radBtn2RecPrik.setBackground(new Color(230, 255, 251));
		radBtn2RecPrik.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				System.out.println(receptiPrikazTabela.getRowCount());

				revalidate();
				repaint();
				tablePanelPret.setVisible(false);
				tablePanelPrik.setVisible(true);
				
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(receptiPrikazTabela.getModel());
				receptiPrikazTabela.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				 
				int columnIndexToSort = 1;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));
				 
				sorter.setSortKeys(sortKeys);
				sorter.setSortable(0, false);
				sorter.setSortable(2, false);
				sorter.sort();
			}
		});

		JRadioButton radBtn3RecPrik = new JRadioButton("Datumu");
		radBtn3RecPrik.setFont(new Font("Arial", 0, 23));
		radBtn3RecPrik.setBackground(new Color(230, 255, 251));
		radBtn3RecPrik.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				System.out.println(receptiPrikazTabela.getRowCount());
				
				revalidate();
				repaint();
				tablePanelPret.setVisible(false);
				tablePanelPrik.setVisible(true);
				
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(receptiPrikazTabela.getModel());
				receptiPrikazTabela.setRowSorter(sorter);
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

		sortirajPo.add(radBtn1RecPrik);
		sortirajPo.add(radBtn2RecPrik);
		sortirajPo.add(radBtn3RecPrik);

		String radioText = "";

		if (radBtn1RecPrik.isSelected()) {
			radioText = radBtn1RecPrik.getText();
		}
		if (radBtn2RecPrik.isSelected()) {
			radioText = radBtn2RecPrik.getText();
		}
		if (radBtn3RecPrik.isSelected()) {
			radioText = radBtn3RecPrik.getText();
		}

		raddioButtonsRecPrik.add(radBtn1RecPrik);
		raddioButtonsRecPrik.add(radBtn2RecPrik);
		raddioButtonsRecPrik.add(radBtn3RecPrik);

		sortiranjeRec.add(sortirajPanelRec, BorderLayout.WEST);
		sortiranjeRec.add(raddioButtonsRecPrik, BorderLayout.CENTER);

		tablePanelPrik.add(scroll, BorderLayout.CENTER);
		tablePanelPrik.setVisible(false);
		
		bottomPanelRec.add(tablePanelPrik, BorderLayout.CENTER);
		
	}

	private JTable getReceptiPrikazTabela(ArrayList<Recept> receptiLista) {
		JTable tabela = new JTable();
		DefaultTableModel model = new DefaultTableModel(new Object[] { "Sifra", "Lekar", "Datum i vreme" }, 0);
		for (Recept recept : receptiLista) {
			model.addRow(new Object[] { recept.getSifra(), recept.getLekar(), recept.getDatumIvreme() });
		}
		tabela.setModel(model);
		return tabela;

	}
}
