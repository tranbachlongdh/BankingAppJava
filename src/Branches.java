import java.util.*;

public class Branches {
	private static int count = 0;
	private String id;
	private String name;
	private String address;
	private ArrayList<Customers> customersList;
	
	
	public Branches(String name, String address) {
		this(name, address, new ArrayList<Customers>());
	}
	
	public Branches(String name, String address, ArrayList<Customers> customersList) {
		this.id = "BR" + Integer.toString(count);
		this.name = name;
		this.address = address;
		this.customersList = customersList;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Customers> getCustomersList() {
		return customersList;
	}
	
	public void modify(String name, String address) {
		this.setName(name);
		this.setAddress(address);
	}
	
	public void listCustomer() {
		System.out.println("You have " + customersList.size() + " customer(s) in branch " + id + " - " + name);
		for (int i=0; i<customersList.size();i++) {
			System.out.println(customersList.get(i).getId() + ": " + customersList.get(i).getName() + " - " + customersList.get(i).getEmail() + " - " + customersList.get(i).getBalance());
		}
	}
	
	public void addCustomer(Customers customer) {
		customersList.add(customer);
		System.out.println("1 customer has been added.");
	}

	public void modifyCustomer(String id, String name, String email) {
		int position = searchCusID(id);
		if (position>=0) {
			modifyCustomer(position, name, email);
		} else {
			System.out.println("Customer's ID: " + id + " is not found.");
		}
	}
	
	private void modifyCustomer(int position, String name, String email) {
		customersList.get(position).modify(name, email);
		System.out.println("Customer's info has been updated!!!");
	}
	
	public void remove(String id) {
		int position = searchCusID(id);
		if (position>=0) {
			remove(position);
		} else {
			System.out.println("Customer's ID: " + id + " is not found.");
		}
	}
	private void remove(int index) {
		customersList.remove(index);
		System.out.println("1 Customer has been removed!!!");
	}

	
	public int searchCusName(String name) {
		for (int i=0; i<customersList.size();i++) {
			if(customersList.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}
	public int searchCusID(String id) {
		for (int i=0; i<customersList.size();i++) {
			if(customersList.get(i).getId().equals(id.toUpperCase())) {
				return i;
			}
		}
		return -1;
	}
	
	public int searchByNameOrID(String searchString) {
		int position = searchCusID(searchString);
		if (position>=0) return position;
		else {
			position = searchCusName(searchString);
			return position;
		}
	}
	
}
