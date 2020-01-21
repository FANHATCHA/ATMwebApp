package Model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class User {

    private String firstName;
    private String lastName;
    private String uuid;
    private byte[] pinHash;
    private ArrayList<Account> accounts;

    /**
     *
     * @param firstName the first name of the user
     * @param lastName  the last name of the user
     * @param pin        the user's pin
     * @param theBank    the bank that issues the accout
     * @throws NoSuchAlgorithmException  throw this exception when alog does not exist
     */

    public User(String firstName, String lastName, String pin, Bank theBank) throws NoSuchAlgorithmException {

        this.firstName = firstName;
        this.lastName = lastName;

        //Storing pin's MD5 hash
        MessageDigest md = MessageDigest.getInstance("MD5");
        this.pinHash = md.digest(pin.getBytes());

       //get a unique universal id (uuid) for a user
        this.uuid = theBank.getNewUserUUID();

        //Create an empty list of account
        this.accounts = new ArrayList<>();

        //Print log message
        System.out.printf("New user %s, %s, with ID %s created.\n", firstName, lastName, this.uuid);
    }

    /**
     * Add an account for the user
     * @param anAcct the account to add
     */

    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);

    }

    /**
     * return the user's UUID
     * @return the uuid
     */

    public String getUUID(){
        return this.uuid;
    }
}
