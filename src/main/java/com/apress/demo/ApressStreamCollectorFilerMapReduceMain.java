package com.apress.demo;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class ApressStreamCollectorFilerMapReduceMain {
    public static void main(String[] args) {
        Stream<String[]> stream = Stream.of(new String[][] {
                {"Hamlet Act 3 Scene 1","To be, or not, to be"},
                {"Romeo & Juliet Act Scene 2","Romeo! Wherefore art thou, Romeo"},
                {"Richard III Act 1 Scene 1","Now is the winter of out discontent"},
                {"Henry IV pt2 Act 3 Scene 2","A man can die but once"},
                {"The Merchant of Venice Act 2 Scene 7","All that glisters is not gold"}

        });
        out.println("Test Begin ==>");

        Map<String, String> asMap = stream
                .peek( q -> out.println(String.format("peek Str = %s: %s", q[0], q[1])))
                .collect(Collectors.toMap(
                        q -> q[0],  //KeyMapper: how to derive the Map Entry's key
                        q -> q[1])); //ValueMapper: how to derive the Map entry's value

        out.println("KeySet and values ==>");
        out.println(asMap.keySet());
        out.println(asMap.values());
        out.println("End KeySet and values ==>");
        out.println(asMap.get("Henry IV pt2 Act 3 Scene 2"));


    }
}
