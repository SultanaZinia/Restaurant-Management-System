/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableModel;

/**
 *
 * @author siamzz
 */


import Tools.Table_Columns_Names;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import org.apache.http.NameValuePair;

public class RestaurantTableModel extends AbstractTableModel {
    
    private String[] columnNames = null;
    private Object[][] rowData = null;
    private static int tabbedPanelID;

    public RestaurantTableModel() {
    }
    


    public RestaurantTableModel(int tabbedPanelID, Object[][] rowData){
        this.tabbedPanelID = tabbedPanelID;
        setColumnNames(columnNames);
        setRowData(rowData);
        
    }

   
    public String[] getColumnNames() {
        if(columnNames != null)
                return columnNames;
        else throw new NullPointerException("String[] variable columnNames is null!!");
    }

    public void setColumnNames(String[] columnNames) {
        this.columnNames = Table_Columns_Names.getColumnNames(tabbedPanelID);
    }

    public Object[][] getRowData() {
        if(rowData != null)
        return rowData;
        else throw new NullPointerException("Object[][] variable rowData is null!!");
    }

    public void setRowData(Object[][] rowData) {
        this.rowData = rowData;
        if(this.rowData == null) System.out.println("ROW DATA IS NULL");
    }
    
    
    public static int getTabbedPanelID() {
        return tabbedPanelID;
    }

    public static void setTabbedPanelID(int tabbedPanelID) {
        RestaurantTableModel.tabbedPanelID = tabbedPanelID;
    }
    
    
    @Override
    public int getRowCount() {
        if(getRowData() != null){
            return getRowData().length;
        }
        //Row Data Object[][] array is empty,so row number is zero
        return 0;
    }

    @Override
    public int getColumnCount() {
        if(getColumnNames() != null)
            return getColumnNames().length;
        //columnNames array has not initialized
        return 0;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object[][] data = getRowData();
        if(data != null) return data[row][column];
        return null;
    }

    @Override
    public Class<?> getColumnClass(int i) {
        return String.class;
    }

    @Override
    public String getColumnName(int i) {
        String[] nameOfColumns = getColumnNames();
        if(nameOfColumns != null){
            return nameOfColumns[i];
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int i, int i1) {
        return false;
    }
    
    //MODIFICATION HERE NEEDED,To Send Update Query To Servlet
    @Override
    public void setValueAt(Object value, int row, int col) {
            Object[][] data = getRowData();
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }

    

}
    

