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
import java.util.Comparator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import action.ReceptiAkcija;
import model.MyTableModel;
import model.Recept;

public class ReceptPretraga extends JPanel {

	public ReceptPretraga() {
	}

	DefaultTableModel tableModel = new DefaultTableModel(new Object[] { "Sifra", "Lekar", "JMBG", "Lek" }, 0);
	private TableRowSorter<DefaultTableModel> tableSorter;
	private RowSifraFilter sifraFilter;
	private RowLekarFilter lekarFilter;
	private RowJmbgFilter jmbgFilter;
	private String filterBy = null;

	public void pretragaRecepata(JPanel pretragaRec, JPanel bottomPanelRec) {
		pretragaRec.setVisible(true);
		pretragaRec.setLayout(new BorderLayout());
		pretragaRec.setBackground(new Color(230, 255, 251));

		JPanel pretragaPanelRec = new JPanel();
		JLabel lblPretragaRec = new JLabel("Pretraga po :");
		pretragaPanelRec.setBackground(new Color(230, 255, 251));
		lblPretragaRec.setFont(new Font("Ariel", 0, 23));
		pretragaPanelRec.add(lblPretragaRec);

		JPanel raddioButtonsRecPret = new JPanel();
		GridLayout raddioLayoutRecPret = new GridLayout(1, 4);
		raddioButtonsRecPret.setBackground(new Color(230, 255, 251));
		raddioButtonsRecPret.setLayout(raddioLayoutRecPret);

		String fileName = "kreiraniRecepti.txt";

		ReceptiAkcija receptiAkcija = new ReceptiAkcija();
		ArrayList<Recept> sviRecepti = receptiAkcija.ucitajRecepte(fileName);

		JPanel searchPan = new JPanel();
		searchPan.setBackground(new Color(230, 255, 251));
		JTextField searchTxt = new JTextField(30);

		searchTxt.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				filter(searchTxt.getText(), filterBy);
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				filter(searchTxt.getText(), filterBy);
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				filter(searchTxt.getText(), filterBy);
			}
		});

		searchTxt.setFont(new Font("Ariel", 0, 20));
		searchPan.setLayout(new FlowLayout(FlowLayout.LEFT));
		searchPan.add(searchTxt);

		JPanel tablePanelPrik = new JPanel();

		JPanel tablePanelPret = new JPanel();
		JTable receptiPretragaTabela = getReceptiPretragaTabela(sviRecepti, tableModel);
		receptiPretragaTabela.setRowHeight(40);
		JScrollPane scroll = new JScrollPane(receptiPretragaTabela);
		scroll.getViewport().setPreferredSize(new Dimension(1000, 400));

		JRadioButton radBtn1RecPret = new JRadioButton("Sifri");
		radBtn1RecPret.setFont(new Font("Arial", 0, 23));
		radBtn1RecPret.setBackground(new Color(230, 255, 251));
		radBtn1RecPret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				System.out.println(receptiPretragaTabela.getRowCount());

				revalidate();
				repaint();
				tablePanelPret.setVisible(true);
				searchPan.setVisible(true);

				tableSorter = new TableRowSorter<DefaultTableModel>(tableModel);
				tableSorter.setComparator(0, new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						// Case sensitive.
						return o1.compareTo(o2);
					}
				});
				List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
				sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
				sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
				tableSorter.setSortKeys(sortKeys);
				filterBy = "sifri";
				tableSorter.setRowFilter(constructFilter());
				receptiPretragaTabela.setRowSorter(tableSorter);
			}
		});

		JRadioButton radBtn2RecPret = new JRadioButton("Lekaru");
		radBtn2RecPret.setFont(new Font("Arial", 0, 23));
		radBtn2RecPret.setBackground(new Color(230, 255, 251));
		radBtn2RecPret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				System.out.println(receptiPretragaTabela.getRowCount());

				revalidate();
				repaint();
				tablePanelPret.setVisible(true);
				searchPan.setVisible(true);

				tableSorter = new TableRowSorter<DefaultTableModel>(tableModel);
				tableSorter.setComparator(1, new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						// Case sensitive.
						return o1.compareTo(o2);
					}
				});
				filterBy = "lekar";

				List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
				sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
				sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
				tableSorter.setSortKeys(sortKeys);
				tableSorter.setRowFilter(constructFilterLekar());
				receptiPretragaTabela.setRowSorter(tableSorter);
			}
		});

		JRadioButton radBtn3RecPret = new JRadioButton("JMBG");
		radBtn3RecPret.setFont(new Font("Arial", 0, 23));
		radBtn3RecPret.setBackground(new Color(230, 255, 251));
		radBtn3RecPret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
				System.out.println(receptiPretragaTabela.getRowCount());

				revalidate();
				repaint();
				tablePanelPret.setVisible(true);
				searchPan.setVisible(true);

				tableSorter = new TableRowSorter<DefaultTableModel>(tableModel);
				tableSorter.setComparator(2, new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						// Case sensitive.
						return o1.compareTo(o2);
					}
				});

				filterBy = "jmbg";
				List<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
				sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
				sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
				tableSorter.setSortKeys(sortKeys);
				tableSorter.setRowFilter(constructFilterJmbg());
				receptiPretragaTabela.setRowSorter(tableSorter);
			}
		});

		JRadioButton radBtn4RecPret = new JRadioButton("Leku");
		radBtn4RecPret.setFont(new Font("Arial", 0, 23));
		radBtn4RecPret.setBackground(new Color(230, 255, 251));
		radBtn4RecPret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("akcija " + e.getActionCommand());
			}
		});

		ButtonGroup pretragaPoRec = new ButtonGroup();

		pretragaPoRec.add(radBtn1RecPret);
		pretragaPoRec.add(radBtn2RecPret);
		pretragaPoRec.add(radBtn3RecPret);
		pretragaPoRec.add(radBtn4RecPret);

		String radioText = "";

		if (radBtn1RecPret.isSelected()) {
			radioText = radBtn1RecPret.getText();
		}
		if (radBtn2RecPret.isSelected()) {
			radioText = radBtn2RecPret.getText();
		}
		if (radBtn3RecPret.isSelected()) {
			radioText = radBtn3RecPret.getText();
		}
		if (radBtn4RecPret.isSelected()) {
			radioText = radBtn4RecPret.getText();
		}

		raddioButtonsRecPret.add(radBtn1RecPret);
		raddioButtonsRecPret.add(radBtn2RecPret);
		raddioButtonsRecPret.add(radBtn3RecPret);
		raddioButtonsRecPret.add(radBtn4RecPret);

		pretragaRec.add(pretragaPanelRec, BorderLayout.WEST);
		pretragaRec.add(raddioButtonsRecPret);

		tablePanelPret.add(scroll, BorderLayout.CENTER);
		tablePanelPret.setVisible(false);
		searchPan.setVisible(false);

		bottomPanelRec.add(searchPan, BorderLayout.NORTH);
		bottomPanelRec.add(tablePanelPret, BorderLayout.CENTER);
		
	}

	private JTable getReceptiPretragaTabela(ArrayList<Recept> receptiLista, DefaultTableModel myTableModel) {
		JTable tabela = new JTable();
		for (Recept recept : receptiLista) {
			myTableModel.addRow(
					new Object[] { recept.getSifra(), recept.getLekar(), recept.getJmbg(), recept.getLekKolicina() });
		}
		tabela.setModel(myTableModel);
		return tabela;
	}

	private void filter(String value, String filterBy) {
		switch (filterBy) {
		case "sifri":
			sifraFilter.setValue(value);
			break;
		case "lekar":
			lekarFilter.setValue(value);
			break;
		case "jmbg":
			jmbgFilter.setValue(value);
			break;
		default:
			sifraFilter.setValue("");
			lekarFilter.setValue("");
			jmbgFilter.setValue("");

		}
		tableSorter.sort();
	}

	private RowFilter<DefaultTableModel, Integer> constructFilter() {
		sifraFilter = new RowSifraFilter();

		List<RowFilter<DefaultTableModel, Integer>> filters = new ArrayList<RowFilter<DefaultTableModel, Integer>>(2);
		filters.add(sifraFilter);

		RowFilter<DefaultTableModel, Integer> orFilter = RowFilter.orFilter(filters);
		return orFilter;
	}

	private RowFilter<? super DefaultTableModel, ? super Integer> constructFilterLekar() {
		lekarFilter = new RowLekarFilter();

		List<RowFilter<DefaultTableModel, Integer>> filters = new ArrayList<RowFilter<DefaultTableModel, Integer>>(2);
		filters.add(lekarFilter);

		RowFilter<DefaultTableModel, Integer> orFilter = RowFilter.orFilter(filters);
		return orFilter;
	}

	private RowFilter<DefaultTableModel, Integer> constructFilterJmbg() {
		jmbgFilter = new RowJmbgFilter();

		List<RowFilter<DefaultTableModel, Integer>> filters = new ArrayList<RowFilter<DefaultTableModel, Integer>>(2);
		filters.add(jmbgFilter);

		RowFilter<DefaultTableModel, Integer> orFilter = RowFilter.orFilter(filters);
		return orFilter;
	}

	public class RowSifraFilter extends RowFilter<DefaultTableModel, Integer> {
		private String value;

		@Override
		public boolean include(javax.swing.RowFilter.Entry<? extends DefaultTableModel, ? extends Integer> entry) {
//			System.out.println("entry " + entry.getStringValue(0));

			return entry.getStringValue(0).toLowerCase().contains(getValue().toLowerCase());
		}

		public String getValue() {
			if (value == null) {
				return "";
			}
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public class RowLekarFilter extends RowFilter<DefaultTableModel, Integer> {
		private String value;

		@Override
		public boolean include(javax.swing.RowFilter.Entry<? extends DefaultTableModel, ? extends Integer> entry) {
//			System.out.println("entry " + entry.getStringValue(1));

			return entry.getStringValue(1).toLowerCase().contains(getValue().toLowerCase());
		}

		public String getValue() {
			if (value == null) {
				return "";
			}
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}

	public class RowJmbgFilter extends RowFilter<DefaultTableModel, Integer> {
		private String value;

		@Override
		public boolean include(javax.swing.RowFilter.Entry<? extends DefaultTableModel, ? extends Integer> entry) {
//			System.out.println("entry " + entry.getStringValue(2));

			return entry.getStringValue(2).toLowerCase().contains(getValue().toLowerCase());
		}

		public String getValue() {
			if (value == null) {
				return "";
			}
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
	}
}
