package com.josh.interview.facebook;

import com.josh.interview.facebook.models.Person;

import java.util.ArrayList;
import java.util.List;

public class YearWithHighestPopulation {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1997, 2015));
        people.add(new Person(1949, 1992));
        people.add(new Person(1930, 2002));


    }

    private static long peopleAlive(List<Person> people, int year) {
        return people.stream()
                .filter(p -> p.yearBorn <= year && p.yearDied >= year)
                .count();
    }
}
