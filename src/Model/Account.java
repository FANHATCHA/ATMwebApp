package Model;

import java.util.ArrayList;

public class Account {

    private String name;
    //private double balance;
    private String uuid;
    private User holder;
    private ArrayList<Transaction> transactions;

    /**
     * Create a new Account
     * @param name the name of the account
     * @param holder the User object that hold this account
     * @param theBank the bank that issues the account
     */

    public Account(String name, User holder, Bank theBank){

        this.name = name;
        this.holder = holder;

        //Get the UUID
        this.uuid = theBank.getNewAccountUUID();

        //Init transaction
         this.transactions = new ArrayList<>();

    }

    public String getUUID(){
        return this.uuid;
    }
}
