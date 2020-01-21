package Model;

import java.util.Date;

public class Transaction {

    private double amount;
    private Date timestamp;
    private String memo;
    private Account inAccount;

    /**
     * Create a new Transaction
     * @param amount the amount transacted
     * @param inAccount the account the transaction belongs to
     */

    public Transaction(double amount, Account inAccount){

        this.amount = amount;
        this.inAccount = inAccount;
        this.timestamp = new Date();
        this.memo = "";

    }

    /**
     * Create a new transaction
     * @param amount the amount transacted
     * @param memo the memo for the transaction
     * @param inAccount the account the transaction belongs to
     */

    public Transaction(double amount, String memo, Account inAccount){

        //Call the two arg constructor first
        this(amount, inAccount);

        this.memo = memo;

    }
}
