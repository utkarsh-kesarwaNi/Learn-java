package com.uk.lld.solid;

public class BankAccount {

    public void withdraw(double amount) {
    }
}

class FixedDepositAccount extends BankAccount {

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Cannot withdraw from a fixed deposit early");
    }
}

/*
* Liskov Substitution Principle (LSP) states that objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.
* That requires the objects of your subclasses to behave in the same way as the objects of your superclass.
*
* withdraw(double amount) { . } violates LSP. A caller of BankAccount doesn't expect this exception.
*
*
* SOLUTION
*
* public interface Account {
    BigDecimal getBalance();
}
*
* public interface WithdrawableAccount extends Account {
   void withdraw(BigDecimal amount);
}
*
* public class CheckingAccount implements WithdrawableAccount {
    private BigDecimal balance;

    public CheckingAccount(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount");
        }
        this.balance = this.balance.subtract(amount);
    }
}
*
* public class FixedDepositAccount implements Account {
    private final BigDecimal balance;

    public FixedDepositAccount(BigDecimal initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
}
* */
