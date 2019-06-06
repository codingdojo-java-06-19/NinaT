
public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount person1 = new BankAccount();
		BankAccount person2 = new BankAccount();
		BankAccount person3 = new BankAccount();
        System.out.println(BankAccount.numberOfAccounts);
        person3.depositMoney("checking", 50);
        person3.withdrawlMoney(25);
        person3.withdrawlMoney(26);
        System.out.println(BankAccount.seeAccountTotals());
	}

}
