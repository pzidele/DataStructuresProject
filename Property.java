package project;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Stack;

public class Property implements Comparator {
	
	private int propertyID;
	private LocalDate dateListed;
	private int agencyID;
	private int agentID;
	private PropertyType propertyType;
	private PropertyStatus propertyStatus;
	private Stack<Transaction> transactions;
	
	public Property(int propertyID, LocalDate dateListed, int agencyID, int agentID, PropertyType propertyType,
			PropertyStatus propertyStatus, Stack<Transaction> transactions) {
		this.propertyID = propertyID;
		this.dateListed = dateListed;
		this.agencyID = agencyID;
		this.agentID = agentID;
		this.propertyType = propertyType;
		this.propertyStatus = propertyStatus;
		this.transactions = transactions;
	}
	
	
	// 5, 6, 10
	
	public Property(int propertyID, LocalDate dateListed, int agencyID, PropertyType propertyType,
			PropertyStatus propertyStatus, Stack<Transaction> transactions) {
		
		this(propertyID, dateListed, agencyID, 0, propertyType, propertyStatus, transactions);

//		this.propertyID = propertyID;
//		this.dateListed = dateListed;
//		this.agencyID = agencyID;
//		this.propertyType = propertyType;
//		this.propertyStatus = propertyStatus;
//		this.transactions = transactions;
	}
	
	public Property(int propertyID, LocalDate dateListed, int agencyID, int agentID, PropertyType propertyType,
			PropertyStatus propertyStatus, Stack<Transaction> transactions, int transactionID, LocalDate transactionDate,
			double dollarAmount, TransactionType transactionType) {
		this(propertyID, dateListed, agencyID, agentID, propertyType, propertyStatus, transactions);

		Transaction transaction = new Transaction(transactionID, transactionDate, dollarAmount, transactionType, propertyID);
		transactions.push(transaction);
	}
	
	public void setAgentID(int agentID) {
		this.agentID = agentID;
	}
	
	public PropertyStatus getPropertyStatus() {
		return propertyStatus;
	}
	
	public Stack<Transaction> getTransactions() {
		return transactions;
	}
	
	
	
	//public void set

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Property [propertyID=");
		builder.append(propertyID);
		builder.append(", dateListed=");
		builder.append(dateListed);
		builder.append(", agencyID=");
		builder.append(agencyID);
		builder.append(", agentID=");
		builder.append(agentID);
		builder.append(", propertyType=");
		builder.append(propertyType);
		builder.append(", propertyStatus=");
		builder.append(propertyStatus);
		builder.append(", transactions=");
		builder.append(transactions);
		builder.append("]");
		return builder.toString();
	}


	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return 0;
	}


	

	
	
}
