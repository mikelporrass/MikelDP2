package adapter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import domain.Bet;

import domain.Erabiltzailea;


public class ErabiltzaileaModelAdapter extends AbstractTableModel {

	 private final List<Bet> bets;
	    private Erabiltzailea e;
	    private String[] colNames = new String[] {"event", "Question","event date", "price(€)"};
	    
	    
	    public ErabiltzaileaModelAdapter(Erabiltzailea e) {
	        //copy the HashMap data to a sequential data structure
	    	bets=new ArrayList<Bet>(e.getEbets());
	    	this.e=e;
	        
	    } 

	    @Override
	    public String getColumnName(int col) {
	        return colNames[col];
	    }
	    @Override
	    public int getColumnCount() {
	        return 4;
	    }

	    @Override
	    public int getRowCount() {
	        return bets.size();
	    }

	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	       switch(columnIndex) {
	            case 0: return ((Object) bets.get(rowIndex).getResult().getQuestion().getEvent().getDescription());
	            case 1: return ((Object) bets.get(rowIndex).getResult().getQuestion().getQuestion());
	            case 2: return ((Object) bets.get(rowIndex).getResult().getQuestion().getEvent().getEventDate());
	            case 3: return ((Object) bets.get(rowIndex).getPrice());
	           
	            	
	            
	    }
	       return null;
	   }
	}

