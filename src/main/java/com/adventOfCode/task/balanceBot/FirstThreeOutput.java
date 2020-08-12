package com.adventOfCode.task.balanceBot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
public class FirstThreeOutput {
    static Map<String, Integer> output = new TreeMap<>();
    public static int getValue(List<String> data)
    {
        InstructionReader.instructionProcessor(data);
        output = InstructionReader.output;
        return output.get("0")*output.get("1")*output.get("2");
    }
    public static void testFirstThreeOutput() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/dataForBalanceBot.txt")));
            List<String> data = reader.lines().collect(Collectors.toList());
            System.out.println("If you multiply together the values of one chip in each of outputs 0, 1, and 2 then answer will be " + getValue(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
