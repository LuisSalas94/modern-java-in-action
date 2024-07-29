package org.fernando.salas.part08;

import java.util.*;

public class Factory {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<>();
        friends.add("Gabriela");
        friends.add("Claudia");
        friends.add("Brenda");

        List<String> friends2 = Arrays.asList("Ana", "Milagros");
        //friends2.set(0, "Emma");
        //friends2.add("Jenny");

        List<String> friends3 = List.of("Elba", "Catherine", "Tatiana");
        //friends3.add("Day");

        // Set Factory
        Set<String> friends4 = Set.of("Elba", "Catherine", "Milagros");
        //System.out.println(friends4);


        // Map Factory
        Map<String, Integer> ageOfFriends = Map.of("Elba", 30, "Catherine", 22, "Tatiana", 36);
        //System.out.println(ageOfFriends);

        // Map.ofEntries
        Map<String, Integer> ageOfFriends2 = Map.ofEntries(Map.entry("Elba", 30),
                Map.entry("Catherine", 22),
                Map.entry("Tatiana", 36));
        System.out.println(ageOfFriends2);

    }
}
