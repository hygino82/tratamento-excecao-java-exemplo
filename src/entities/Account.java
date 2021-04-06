package entities;

import exceptions.BusinessException;

public class Account {
	private int number;
	private String holder;
	private double balance;
	private double withdrawLimit;

	public Account(int number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Account() {

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(double amount) {

		balance += amount;
	}

	public void withdraw(double amount) {
		validate(amount);
		balance -= amount;
	}

	public void validate(double amount) {
		if (getWithdrawLimit() < amount) {
			throw new BusinessException("Erro de saque, valor maior que o limite permitido");
		}
		if (amount > getBalance()) {
			throw new BusinessException("Erro de saque, sem saldo");
		}

	}
}
