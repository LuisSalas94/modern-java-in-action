package org.fernando.salas.part05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Transaction> transactions2011 = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList();
        System.out.println("Transactions in the year 2011: " + transactions2011);

        // What are all the unique cities where the traders work?
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();
        System.out.println("Cities: " + cities);

        // Find all traders from Cambridge and sort them by name.
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .toList();
        System.out.println("Traders: " + traders);

        // Return a string of all traders’ names sorted alphabetically.
        List<String> tradersNames = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .toList();
        System.out.println("Traders Name: " + tradersNames);

        // Are any traders based in Milan?
        boolean milanTraders = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println("Milan Traders: " + milanTraders);


        // Print the values of all transactions from the traders living in Cambridge.
        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .forEach(System.out::println);

        // What’s the highest value of all the transactions?
        Optional<Integer> highest = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println("Highest value: " + highest);

        // Find the transaction with the smallest value.
        Optional<Transaction> smallest = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));
        System.out.println("Smallest: " + smallest);

        Optional<Transaction> smallest2 = transactions.stream()
                .reduce((transaction1, transaction2) -> transaction1.getValue() < transaction2.getValue() ? transaction1 : transaction2);
        System.out.println("Smallest2: " + smallest2);
    }
}
