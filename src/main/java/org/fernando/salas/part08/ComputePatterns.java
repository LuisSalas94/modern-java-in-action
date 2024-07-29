package org.fernando.salas.part08;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComputePatterns {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        //replacement patterns
        Map<String, String> favouriteMovies = new HashMap<>();
        favouriteMovies.put("Raphael", "Star Wars");
        favouriteMovies.put("Olivio", "james bond");
        favouriteMovies.replaceAll((friend, movie) -> movie.toUpperCase());
        //System.out.println(favouriteMovies);

//        Map<String, String> family = Map.ofEntries(
//                Map.entry("Teo", "Star Wars"), Map.entry("Cristina", "James Bond"));
//        Map<String, String> friends = Map.ofEntries(Map.entry("Raphael", "Star Wars"));
//
//        Map<String, String> everyone = new HashMap<>(family);
//        everyone.putAll(friends);
//        System.out.println(everyone);

        // merge
        Map<String, String> family = Map.ofEntries(
                Map.entry("Teo", "Star Wars"), Map.entry("Cristina", "James Bond"));
        Map<String, String> friends = Map.ofEntries(
                Map.entry("Raphael", "Star Wars"), Map.entry("Cristina", "Matrix"));

        Map<String, String> everyone = new HashMap<>(family);
        friends.forEach((k, v) -> everyone.merge(k, v, (movie1, movie2) -> movie1 + " & " + movie2));
        System.out.println(everyone);

        Map<String, Long> moviesToCount = new HashMap<>();
        String movieName = "James Bond";
        Long count = moviesToCount.get(movieName);
        if (count == null) {
            moviesToCount.put(movieName, 1L);
        } else {
            moviesToCount.put(movieName, count + 1);
        }
        System.out.println("Count for " + movieName + ": " + moviesToCount.get(movieName));
    }
}
