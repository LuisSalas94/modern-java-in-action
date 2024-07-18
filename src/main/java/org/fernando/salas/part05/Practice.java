package org.fernando.salas.part05;

import java.util.Arrays;
import java.util.List;

public class Practice {
    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // Find all transactions in the year 2011 and sort them by value (small to high)

        // What are all the unique cities where the traders work?

        // Find all traders from Cambridge and sort them by name.

        // Return a string of all traders’ names sorted alphabetically.

        // Are any traders based in Milan?

        // Print the values of all transactions from the traders living in Cambridge.

        // What’s the highest value of all the transactions?

        // Find the transaction with the smallest value.
    }
}
