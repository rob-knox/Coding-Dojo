package com.codingdojo.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount b1 = new BankAccount();
		BankAccount b2 = new BankAccount();
		BankAccount b3 = new BankAccount();
		
		System.out.println(b1.getAccountNumber());
		System.out.println(b2.getAccountNumber());
		System.out.println(b3.getAccountNumber());
		
		b1.deposit("checkings", 200.00);
		b2.deposit("savings", 100.00);
		
		System.out.println(b1.getCheckings());
		System.out.println(b2.getSavings());
		
		b1.withdraw("checkings", 50.00);
		System.out.println(b1.getCheckings());
		b1.withdraw("checkings", 175.00);
		
		System.out.println(BankAccount.getTotalMoney());
	}

}
