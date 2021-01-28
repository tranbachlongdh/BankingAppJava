import java.util.*;

public class Main {
	private static Scanner scanner = new Scanner(System.in);
	private static Bank myBank = new Bank("Long's Bank");;
	
	public static void mainMenu() {
    	boolean quit = false;
    	int choice = 0;
    	printInstruction();
        while (!quit) {
        	System.out.println("Choose option:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
            	case 0:
            		printInstruction();
            		break;
            	case 1:
            	  	myBank.listBranches();
            	  	break;
            	case 2:
            		addBranch();
            		break;
            	case 3:
            		modifyBranch();
            		break;
            	case 4:
            		removeBranch();
            		break;
            	case 5:
            		switchToBranch();
            		break;
            	case 6:
            		listAllCustomer();
            		break;
            	case 7:
            		searchForBranch();
            		break;
            	case 8:
            		searchForCustomer();
            		break;
            	case 9:
            		System.out.println("Quit application!");
            		quit = true;
            		break;
            	default:
            		System.out.println("Error!");
            }
        }
    }
	
	public static void printInstruction() {
		System.out.println("Main menu: \n"+
							"0: Print list of actions.\n" +
							"1: List all bank's branches.\n" +
							"2: Add a new Bank branch.\n" +
							"3: Update Branch profile.\n" +
							"4: Remove Branch profile.\n" +
							"5: Switch to branch.\n" +
							"6: List all customers.\n" +
							"7: Search for branch.\n" +
							"8: Search for customer.\n" +
							"9: Exit branch.");
	}
	
	public static void printBranchInstruction() {
		System.out.println("Branch menu: \n"+
							"0: Print list of actions.\n" +
							"1: List all customers.\n" +
							"2: Add a new customer.\n" +
							"3: Update customer profile.\n" +
							"4: Add customer's transaction.\n" +
							"5: Remove customer profile.\n" +
							"6: Search for customer.\n" +
							"7: Switch to branch.\n" +
							"8: Exit contact.");
	}
	
	public static void addBranch() {
		System.out.println("Add new branch to system:");
		System.out.print("Branch's name:");
		String name = scanner.nextLine();
		System.out.print("Branch's address:");
		String address = scanner.nextLine();
		addBranch(name, address);
	}
	
	private static void addBranch(String name, String address) {
		myBank.addBranch(new Branches(name, address));
	}
	
	public static void modifyBranch() {
		System.out.print("Branch's ID to be modified:");
		String id = scanner.nextLine();		
		System.out.print("New Branch's name:");
		String name = scanner.nextLine();
		System.out.print("New Branch's address:");
		String address = scanner.nextLine();
		myBank.modifyBranch(id, name, address);
	}
	
	public static void removeBranch() {
		System.out.print("Customer's ID to be removed:");
		String id = scanner.nextLine();	
		myBank.remove(id);
	}
	
	public static void switchToBranch() {
		Branches localBranch;
		myBank.listBranches();
		System.out.print("Please choose which branch you want to switch to:");
		String id = scanner.nextLine();
		int position = myBank.searchBranchID(id);
		if (position>=0) {
			localBranch = myBank.getBranches().get(position);
			branchMenu(localBranch);
		} else {
			System.out.println("Branch's ID: " + id + " is not found.");
		}
	}
	
	public static void listAllCustomer() {
		ArrayList<Branches> branch = myBank.getBranches();
		for (int i=0; i< branch.size(); i++) {
			branch.get(i).listCustomer();
		}
	}

	public static void searchForBranch() {
		System.out.print("Branch's name/ID:");
		String searchString = scanner.nextLine();
		int position = myBank.searchByNameOrID(searchString);
		if (position>=0) {
			System.out.println("Branch's name/ID is found:");
			System.out.println(position +". "+
								myBank.getBranches().get(position).getId() +" - "+
								myBank.getBranches().get(position).getName() +" - "+
								myBank.getBranches().get(position).getAddress());
		} else {
			System.out.println("Branch's Name/ID: " + searchString + " is not found.");
		}
	}
	public static void searchForCustomer() {
		System.out.print("Customer's name/ID:");
		String searchString = scanner.nextLine();
		ArrayList<Branches> branches = myBank.getBranches();
		for (int i=0; i< branches.size(); i++) {
			searchBranchCustomer(branches.get(i), searchString);
		}
	}
	
	private static void branchMenu(Branches branch) {
		boolean quit = false;
    	int choice = 0;
    	printBranchInstruction();
        while (!quit) {
        	System.out.println("Choose option:");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
            	case 0:
            		printBranchInstruction();
            		break;
            	case 1:
            		branch.listCustomer();
            	  	break;
            	case 2:
            		addBranchCustomer(branch);
            		break;
            	case 3:
            		modifyBranchCustomer(branch);
            		break;
            	case 4:
            		addTransaction(branch);
            		break;
            	case 5:
            		removeBranchCustomer(branch);
            		break;
            	case 6:
            		searchBranchCustomer(branch);
            		break;
            	case 7:
            		switchToBranch();
            		System.out.println("Switch to main view.");
            		quit = true;
            		break;
            	case 8:
            		System.out.println("Exit branch view.");
            		quit = true;
            		break;
            	default:
            		System.out.println("Error!");
            }
        }
	}
	
	public static void addBranchCustomer(Branches branch) {
		System.out.println("Add a new customer to branch " + branch.getId() + " - " + branch.getName()+":");
		System.out.print("Customer's name:");
		String name = scanner.nextLine();
		System.out.print("Customer's email:");
		String email = scanner.nextLine();
		branch.addCustomer(new Customers(name, email, branch.getId()));
	}
	
	public static void modifyBranchCustomer(Branches branch) {
		System.out.print("Customer's ID to be modified:");
		String id = scanner.nextLine();		
		System.out.print("New customer's name:");
		String name = scanner.nextLine();
		System.out.print("New customer's email:");
		String email = scanner.nextLine();
		branch.modifyCustomer(id, name, email);
	}
	
	public static void removeBranchCustomer(Branches branch) {
		System.out.print("Customer's ID to be removed:");
		String id = scanner.nextLine();	
		branch.remove(id);
	}
	
	public static void searchBranchCustomer(Branches branch, String searchString) {
		int position = branch.searchByNameOrID(searchString);
		if (position>=0) {
			System.out.println("Customer's name/ID matched:");
			System.out.println(position +". "+
								branch.getCustomersList().get(position).getId() +" - "+
								branch.getCustomersList().get(position).getName() +" - "+
								branch.getCustomersList().get(position).getEmail() +" - $"+
								branch.getCustomersList().get(position).getBalance());
		} else {
			System.out.println("Customer's Name/ID: " + searchString + " is not found in branch " + branch.getId() + " - "+ branch.getName());
		}
	}
	
	public static void searchBranchCustomer(Branches branch) {
		System.out.print("Customer's name/ID:");
		String searchString = scanner.nextLine();
		searchBranchCustomer(branch, searchString);
	}
	
	public static void addTransaction(Branches branch) {
		System.out.print("Customer's name/ID:");
		String searchString = scanner.nextLine();
		int position = branch.searchByNameOrID(searchString);
		if (position>=0) {
			System.out.print("Transaction:");
			branch.getCustomersList().get(position).addTransactions(scanner.nextDouble());
		} else {
			System.out.println("Customer's Name/ID: " + searchString + " is not found.");
		}
	}
	
	//***************************************************************************************************

	public static void main(String[] args) {
		mainMenu();
		
	}
}
