package BankingApplication;
import java.util.*;
public class Account {

	private long accountNumber;
	private int pin;
	private double balance = 0;

	Scanner sc = new Scanner(System.in);
	public Account() 
	{
		
	}

	public Account(long accountNumber, int pin)
	{
		this.accountNumber = accountNumber;
		this.pin = pin;
	}

	public Account(long accountNumber, int pin, double balance)
	{
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
	}  
	public int setCustomerNumber(int accountNumber) 
	{
		this.accountNumber = accountNumber;
		return accountNumber;
	}

	public long getaccountNumber()
	{
		return accountNumber;
	}
	public int setpin(int pin) 
	{
		this.pin = pin;
		return pin;
	}

	public int getPin()
	{
		return pin;
	}

	public double getBalance()
	{
		return balance;
	}

	
	public double calcDeposit(double amount)
	{
		balance = (balance + amount);
		return balance;
	}
	public double calcWithdraw(double amount)
	{
		balance = (balance - amount);
		return balance;
	}

	public void depositInput() 
	{
		boolean end = false;
		while (!end) {
			try {
				System.out.println("Current Account Balance: " + balance);
				System.out.print("Amount you want to deposit into your Account: ");
				double amount = sc.nextDouble();

				if ((balance + amount) >= 0 && amount >= 0)
				{
					calcDeposit(amount);
					System.out.println("Current Account Balance: " + balance);
					end = true;
				} else
				{
					System.out.println("Your Balance is less than you Amount.");
				}
			} catch (Exception e) 
			{
				System.out.println("Invalid Choice.");
				sc.next();
			
			}
		}
	}

public void withdrawInput()
{
	boolean end = false;
	while (!end) {
		try {
			System.out.println("Current  Account Balance: " + balance);
			System.out.print("Amount you want to withdraw from  Account: ");
			double amount = sc.nextDouble();
			if(balance>=2000 ) 
			{
				
			if ((balance - amount) >= 0 && amount >= 0) 
			{
				calcWithdraw(amount);
				System.out.println("Current  Account Balance: " + balance);
				end = true;
			} else
			{
				System.out.println(" Your Balance is less than you Amount .");
			}
			}else
			{
				System.out.println(" Current  Account Balance is less than 2000.");
				end=true;
			}
			
		} catch (Exception e) {
			System.out.println("Invalid Choice.");
			sc.next();
		}
	}
}

@Override
public String toString() {
	return "Account [accountNumber=" + accountNumber + ", pin=" + pin + ", balance=" + balance + ", sc=" + sc
			+ ", getaccountNumber()=" + getaccountNumber() + ", getPin()=" + getPin() + ", getBalance()=" + getBalance()
			+ "]";
}

}