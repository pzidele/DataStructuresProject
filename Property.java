package project;

import java.time.LocalDate;
import java.util.Stack;

public class Property {
	
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

	
	
}
