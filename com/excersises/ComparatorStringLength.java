package com.excersises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorStringLength {

    /**
     *
     * Give the syntax of a lambda for Comparator<String> that orders strings by length.
     */

    public static void main(String[] args) {

        List<String> data = Arrays.asList("Ab", "xyz", "pq5c", "yuuui", "j111hg", "rtyuiop[pojhbert");
        System.out.println(
                data.stream()
                .sorted(Comparator.comparing(n -> n.length()))
                .collect(Collectors.toList())
        );

    }
}
