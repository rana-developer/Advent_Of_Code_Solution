package com.adventOfCode.task.balanceBot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;


public class BalanceBot {
    static Map<String, List<Integer>> map = new TreeMap<>();
    static String findBot(List<String> data, int value_1, int value_2) {
        Map<String, List<Integer>> map = InstructionReader.instructionProcessor(data);
        List<Integer> list = Arrays.asList(value_1,value_2);
        for (Map.Entry<String, List<Integer>> listEntry : map.entrySet()) {
            if (listEntry.getValue().containsAll(list)) {
                return listEntry.getKey();
            }
        }

        return "NOT FOUND";
    }
    public static void testBalanceBot() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/dataForBalanceBot.txt")));
            List<String> data = reader.lines().collect(Collectors.toList());
            System.out.println("The number of the bot that is responsible for comparing given microchips is " + findBot(data, 61, 17));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
