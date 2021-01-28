import java.util.*;

public class Customers {
	private static int count = 0;
	private String id;
	private String name;
	private String email;
	private ArrayList<Double> transactionsList;
	private double balance;
	
	public Customers(String name, String email, String branch) {
		this(name, email, branch, 0, new ArrayList<Double>());
	}
	
	public Customers(String name, String email, String branch, double balance, ArrayList<Double> transactionsList) {
		this.id = branch + "CM"+ Integer.toString(count);
		this.name = name;
		this.email = email;
		this.balance = balance;
		this.transactionsList = transactionsList;
		count++;
	}
	
	

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public ArrayList<Double> getTransactions() {
		return transactionsList;
	}
	
	public void listTransactions() {
		System.out.println("You have " + transactionsList.size() + " transaction(s) in your database.");
		for (int i=0; i<transactionsList.size();i++) {
			System.out.println(id + ": " + transactionsList.get(i));
		}
	}
	
	public void addTransactions(double transactions) {
		this.transactionsList.add(transactions);
		this.balance += transactions;
		System.out.println("1 transaction has been added.");
	}

	public void modify(String name, String email) {
		this.setName(name);
		this.setEmail(email);
	}
	
	
	
	
	
}
