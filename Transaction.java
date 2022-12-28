package project;

import java.time.LocalDate;

public class Transaction {

	private int transactionID;
	private LocalDate transactionDate;
	private double dollarAmount;
	private TransactionType transactionType;
	private int propertyID;
	
	public Transaction(int transactionID, LocalDate transactionDate, double dollarAmount,
			TransactionType transactionType, int propertyID) {
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.dollarAmount = dollarAmount;
		this.transactionType = transactionType;
		this.propertyID = propertyID;
	}
	
	
	
}
