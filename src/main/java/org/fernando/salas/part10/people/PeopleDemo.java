package org.fernando.salas.part10.people;

import java.util.*;

public class PeopleDemo {
    public static void main(String[] args) {
        List<Person> people = Arrays
                .asList(new Person(20, "Micaela"),
                        new Person(24, "Brenda"),
                        new Person(30, "Sofia"),
                        new Person(19, "Catherine"),
                        new Person(19, "Karem"),
                        new Person(19, "Emma"));

//        Collections.sort(people, new Comparator<Person>() {
//            @Override
//            public int compare(Person o1, Person o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

//        people.forEach(person -> System.out.println(person.getAge()));

        //Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());
        //Collections.sort(people, Comparator.comparing(p -> p.getAge()));
        Collections.sort(people, Comparator.comparing(Person::getAge));

        // Sort the people by age but in reverse order
        Collections.sort(people, Comparator.comparing(Person::getAge).reversed());
        //people.forEach(person -> System.out.println(person.getAge()));

        // people of the same age to be sorted alphabetically
        Collections.sort(people, Comparator.comparing(Person::getAge)
                .thenComparing(Person::getName));
        people.forEach(person -> System.out.println(person.getAge() + " - " + person.getName()));


    }
}
