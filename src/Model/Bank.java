package Model;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

public class Bank {

    private String name;
    private ArrayList<User> users;
    private ArrayList<Account> accounts;

    /**
     * Generate a new universally unique ID for the user
     * @return the universal unique identify (uuid)
     */
    public String getNewUserUUID(){

        //inits
        String uuid;

        Random rng = new Random();
        int len = 6;
        boolean nonUnique = false;

        //continue looping until we get a unique ID
        do{

            uuid = "";
            for(int i=0; i<len; i++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            //check to make sure it is unique
            nonUnique = false;
            for(User u : this.users){

                if(uuid.compareTo(u.getUUID()) == 0){
                  nonUnique = true;
                  break;
                }

            }

            //generate the number

        }while(nonUnique);

        return uuid;

    }

    /**
     * Generate a new universally unique ID for an account
     * @return the uuid
     */

    public String getNewAccountUUID(){

        //inits
        String uuid;

        Random rng = new Random();
        int len = 10;
        boolean nonUnique = false;

        //continue looping until we get a unique ID
        do{

            uuid = "";
            for(int i=0; i<len; i++){
                uuid += ((Integer)rng.nextInt(10)).toString();
            }

            //check to make sure it is unique
            nonUnique = false;
            for(Account a : this.accounts){

                if(uuid.compareTo(a.getUUID()) == 0){
                    nonUnique = true;
                    break;
                }

            }

            //generate the number

        }while(nonUnique);

        return uuid;
    }

    /**
     * Add an account for the user
     * @param anAcct the account to add
     */

    public void addAccount(Account anAcct){
        this.accounts.add(anAcct);

    }
    /**
     *
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param pin the user's pin
     * @return the new User object
     * @throws NoSuchAlgorithmException
     */
    public User addUser(String firstName, String lastName, String pin) throws NoSuchAlgorithmException {

        //Create a new User object and add it to our list
        User newUser = new User(firstName, lastName, pin, this);
        this.users.add(newUser);

        //Create savings account for the user
        Account newAccount = new Account("Savings", newUser, this);

        //Create a savings account for the user and to User and Bank accounts lists
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);

        return newUser;


    }
}
