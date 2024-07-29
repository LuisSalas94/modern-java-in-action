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
        //System.out.println(ageOfFriends2);

        // Working with map
        // forEach
        String friend = null;
        for (Map.Entry<String, Integer> entry : ageOfFriends.entrySet()) {
            friend = entry.getKey();
            Integer age = entry.getValue();
            //System.out.println(friend + " is " + age + " years old");
        }

        //ageOfFriends2.forEach((friend2, age) -> System.out.println(friend2 + " is " + age + " years old"));

        // Sorting
        Map<String, String> favouritesMovies = Map.ofEntries(Map.entry("Raphael", "Star Wars"),
                Map.entry("Cristina", "Matrix"),
                Map.entry("Olivia", "James Bond"));
        favouritesMovies
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey()).forEachOrdered(System.out::println);

        // getOrDefault
        /* default V getOrDefault(Object key, V defaultValue)
            Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
            Implementation Requirements:
            The default implementation makes no guarantees about synchronization or atomicity properties of this method. Any implementation providing atomicity guarantees must override this method and document its concurrency properties.
            Parameters:
            key - the key whose associated value is to be returned
            defaultValue - the default mapping of the key
            Returns:
            the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key
            Throws:
            ClassCastException - if the key is of an inappropriate type for this map (optional)
            NullPointerException - if the specified key is null and this map does not permit null keys (optional)
        * */
        Map<String, String> favouritesMovies2 = Map.ofEntries(Map.entry("Raphael", "Star Wars"),
                Map.entry("Olivia", "James Bond"),
                Map.entry("Thibaut", "Inception"),
                Map.entry("Sophia", "Matrix"),
                Map.entry("Ethan", "Lord of the Rings"));
        System.out.println(favouritesMovies2.getOrDefault("Olivia", "Matrix"));
        System.out.println(favouritesMovies2.getOrDefault("Thibaut", "Matrix"));

        // Existing keys
        System.out.println(favouritesMovies.getOrDefault("Raphael", "Unknown")); // Output: Star Wars
        System.out.println(favouritesMovies.getOrDefault("Sophia", "Unknown"));  // Output: Matrix

        // Non-existing keys
        System.out.println(favouritesMovies.getOrDefault("Liam", "Unknown"));    // Output: Unknown
        System.out.println(favouritesMovies.getOrDefault("Emma", "Unknown"));    // Output: Unknown
    }
}
