import java.util.*;

public class Bank {
	private String name;
	private ArrayList<Branches> branchesList;
	
	public Bank(String name) {
		this.name = name;
		this.branchesList = new ArrayList<Branches>();
	}
	
	public Bank(String name, ArrayList<Branches> branches) {
		this.name = name;
		this.branchesList = branches;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Branches> getBranches() {
		return branchesList;
	}
	
	public void listBranches() {
		System.out.println("Your bank has " + branchesList.size() + " branch(es).");
		for (int i=0; i<branchesList.size();i++) {
			System.out.println(branchesList.get(i).getId() + ": " + branchesList.get(i).getName() + " - " + branchesList.get(i).getAddress());
		}
	}
	
	public void addBranch(Branches branch) {
		this.branchesList.add(branch);
		System.out.println("1 Bank branch has been added to your system.");
	}

	//***************************************************************************************************
	
	public void modifyBranch(String id, String name, String address) {
		int position = searchBranchID(id);
		if (position>=0) {
			modifyBranch(position, name, address);
		} else {
			System.out.println("Branch's ID: " + id + " is not found.");
		}
	}
	
	private void modifyBranch(int position, String name, String address) {
		branchesList.get(position).modify(name, address);
		System.out.println("Branch's info has been updated!!!");
	}
	
	public void remove(String id) {
		int position = searchBranchID(id);
		if (position>=0) {
			remove(position);
		} else {
			System.out.println("Branch's ID: " + id + " is not found.");
		}
	}
	private void remove(int index) {
		branchesList.remove(index);
		System.out.println("1 Branch has been removed!!!");
	}

	
	public int searchBranchName(String name) {
		for (int i=0; i<branchesList.size();i++) {
			if(branchesList.get(i).getName().toLowerCase().equals(name.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}
	public int searchBranchID(String id) {
		for (int i=0; i<branchesList.size();i++) {
			if(branchesList.get(i).getId().equals(id.toUpperCase())) {
				return i;
			}
		}
		return -1;
	}
	
	public int searchByNameOrID(String searchString) {
		int position = searchBranchID(searchString);
		if (position>=0) return position;
		else {
			position = searchBranchName(searchString);
			return position;
		}
	}
	
//	public String searchForCustomer(String searchString) {
//		for (int i=0; i<branchesList.size();i++) {
//			int position = branchesList.get(i).searchByNameOrID(searchString);
//			if (position>=0) {
//				return branchesList.get(i).getCustomersList().get(position).getId();
//			}
//		}
//		return null;
//	}

	
	
}
