package model;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MyTableModel implements TableModel {

	private Object[] columns;
	private Object[][] data;
	
	public MyTableModel() {
		// TODO Auto-generated constructor stub
	}
	
	public MyTableModel(Object[] columns, Object[][] data) {
		this.columns = columns;
		this.data = data;
	}
	

	public Object[] getColumns() {
		return columns;
	}

	public void setColumns(Object[] columns) {
		this.columns = columns;
	}

	public Object[][] getData() {
		return data;
	}

	public void setData(Object[][] data) {
		this.data = data;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	@Override
	public int getRowCount() {
		return data.length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	@Override
	public int getColumnCount() {
		return data[0].length;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnName(int)
	 */
	@Override
	public String getColumnName(int columnIndex) {
		return (String) columns[columnIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getColumnClass(int)
	 */
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return data[0][columnIndex].getClass();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#isCellEditable(int, int)
	 */
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.table.TableModel#setValueAt(java.lang.Object, int, int)
	 */
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		data[rowIndex][columnIndex] = aValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.table.TableModel#addTableModelListener(javax.swing.event.
	 * TableModelListener)
	 */
	@Override
	public void addTableModelListener(TableModelListener l) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.swing.table.TableModel#removeTableModelListener(javax.swing.event
	 * .TableModelListener)
	 */
	@Override
	public void removeTableModelListener(TableModelListener l) {

	}

}
