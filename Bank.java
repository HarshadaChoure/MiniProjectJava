package BankingApplication;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class Bank 
{
	 Scanner sc = new Scanner(System.in);
	 HashMap<Integer, Account> data = new HashMap<Integer, Account>();
	 
	 public void getAccount(Account acc)throws Exception 
	 {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("-------------------------------------------------------------");
				System.out.println("1) View Balance");
				System.out.println("2) Deposit Amount");
				System.out.println("3) Withdraw Amount");
				System.out.println("4) Exit");
				System.out.println("-------------------------------------------------------------");
				System.out.print("Choice: ");
				int selection = sc.nextInt();
				switch (selection) {
				case 1:
					System.out.println(" Account Balance: "+acc.getBalance());
					break;
				case 2:
					acc.depositInput();
					break;
				case 3:
					acc.withdrawInput();
					break;
					
				case 4:
					end = true;
					break;
				default:
					System.out.println("Invalid Choice.");
				}
			} catch (Exception e) {
				System.out.println("Invalid Choice.");
				sc.next();
			}
		}
	}
	public void login() throws Exception {
		boolean end = false;
		int accountNumber = 0;
		int pin = 0;
		while (!end) {
			try {
				System.out.print("Enter your Account number: ");
				accountNumber = sc.nextInt();
				System.out.print("Enter your PIN number: ");
				pin = sc.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					Account acc = (Account) pair.getValue();
					if (data.containsKey(accountNumber) && pin == acc.getPin()) {
						getAccount(acc);
						end = true;
						break;
					}
				}
				if (!end) {
					System.out.println("Wrong Account Number or Pin Number");
				}
			} catch (Exception e) {
				System.out.println("Invalid Character.( Only Numbers.)");
			}
		}
	}

	public void createAccount() throws Exception {
		int acc_no = 0;
		boolean end = false;
		while (!end) {
			try {
				System.out.println("Enter your Account number ");
				acc_no = sc.nextInt();
				Iterator it = data.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry pair = (Map.Entry) it.next();
					if (!data.containsKey(acc_no)) {
						end = true;
					}
				}
				if (!end) {
					System.out.println("This Account number is already registered");
				}
			} catch (Exception e) {
				System.out.println("Invalid Choice.");
				sc.next();
			}
		}
		System.out.println("Enter PIN to be registered");
		int pin = sc.nextInt();
		data.put(acc_no, new Account(acc_no, pin));
		System.out.println("Your new account has been successfuly created!");
		System.out.println(" login you Account");
		login();
	}

	public void menu() throws Exception {
		data.put(2000, new Account(2000, 2000,  20000));
		boolean end = false;
		while (!end) {
			try {
				System.out.println(" 1. Create Account");
				System.out.println(" 2. Login");
				System.out.println("-------------------------------------------------------------");
				System.out.print("Choice: ");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					createAccount();
					end = true;
					break;
					
				case 2:
					login();
					end = true;
					break;
					
				default:
					System.out.println("Invalid Choice.");
				}
			} catch (Exception e) {
				System.out.println("Invalid Choice.");
				sc.next();
			}
		}
		System.out.println("----Thank You for using this Banking Application.----");
		sc.close();
		System.exit(0);
	}
}	