package com.codingdojo.bankaccount;
import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private Double checkings;
	private Double savings;
	// class member static - numberOfAccounts
	private static Integer numberOfAccounts = 0;
	// class member static - total amount in bank
	private static Double totalMoney = 0.00;
	
	
	public BankAccount() {
		this.accountNumber = generateAccountNumber();
		this.checkings = 0.00;
		this.savings = 0.00;
		numberOfAccounts++;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public Double getCheckings() {
		return checkings;
	}
	
	public void setCheckings(Double checkings) {
		this.checkings = checkings;
	}
	
	public Double getSavings() {
		return savings;
	}
	
	public void setSavings(Double savings) {
		this.savings = savings;
	}
	
	public static Integer getNumberOfAccounts() {
		return numberOfAccounts;
	}
	
	public static Double getTotalMoney() {
		return totalMoney;
	}
	
	public void deposit(String accountType, Double amount) {
		if (accountType.equals("checkings")) {
			// deposit money into the checking account
			this.checkings += amount;
			totalMoney += amount;
		} else if (accountType.equals("savings")) {
			this.savings += amount;
			totalMoney += amount;
		} else {
			System.out.println("You dont't have the right account type.");
		}
	}
	
	public void withdraw(String accountType, Double amount) {
		if (accountType.equals("checkings")) {
			if (amount >= this.checkings) {
				System.out.println("Get rich.");
			} else {
				this.checkings -= amount;
				totalMoney -= amount;
			}
		} else if (accountType.equals("savings")) {
			if (amount >= this.savings) {
				System.out.println("Or die trying.");
			} else {
				this.savings -= amount;
				totalMoney -= amount;
			}
		} else {
			System.out.println("You dont't have the right account type.");
		}
	}
	
	private String generateAccountNumber() { 
		Random rand = new Random();
		String account = "";
		for (int i = 0; i < 10; i++) {
			account += String.valueOf(rand.nextInt(10));
		}
		return account;
	}
}