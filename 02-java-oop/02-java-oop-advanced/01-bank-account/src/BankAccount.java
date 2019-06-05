import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    public static int numberOfAccounts;
    public static double totalMoney;
    
    public BankAccount() {
        accountNumber = generateAccountNumber();
        checkingBalance = 0;
        savingsBalance = 0;
        numberOfAccounts++;
    }
    
    public String generateAccountNumber() {
    	Random rand = new Random();
    	String accountNumber = "";
    	for (int i = 0; i <10; i++) {
        	int n = rand.nextInt(10);
    		accountNumber += n;
    	}
    	System.out.println("The account number is: "+accountNumber);
    	return accountNumber;
    }
    
    public double getCheckingBalance() {
    	return this.checkingBalance;
    }
    
    public void depositMoney(String targetAccount, double amountToDeposit) {
    	if (targetAccount == "checking") {
    		this.checkingBalance += amountToDeposit;
    	}
    	else if (targetAccount == "savings") {
    		this.savingsBalance += amountToDeposit;
    	}
    	else {
    		System.out.println("To make a deposit, please type in either 'checking' or 'savings' (surrounded by double quotes!) and your desired amount to deposit, separated by a comma.");
    	}
    }
    
    public double getSavingsBalance() {
    	return this.savingsBalance;
    	
    }
    
    public void withdrawlMoney(double amountToWithdraw) {
    	if (this.checkingBalance - amountToWithdraw < 0) {
    		System.out.println("Insufficient funds! You poor hobo.");
    	}
    	else {
    		this.checkingBalance -= amountToWithdraw;
    		String s = String.format("%.2f", this.checkingBalance);
    		System.out.println("You have succesfully withdrawn $"+s+" dollars from your account. Your account balance is now: "+this.checkingBalance);
    	}
    }
    
    public double seeAccountTotals() {
    	double total = this.checkingBalance + this.savingsBalance;
    	String s = String.format("%.2f", total);
    	System.out.println("Wow, big shot over here! Your accounts have a total of $"+s+" in them.");
    	return total;
    }
    
}
