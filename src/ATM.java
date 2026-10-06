
public class ATM {
	private final BankAccount account = new BankAccount(500);
	
	private void handleTransactions() {
		try {
			account.withdraw(600);
		} catch (NegativeBalanceException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
		}
		
		try {
			account.quickWithdraw(600);
		} catch (NegativeBalanceException e){
			System.out.println(e);
		}
	}
	
	static void main() {
		(new ATM()).handleTransactions();
	}
}