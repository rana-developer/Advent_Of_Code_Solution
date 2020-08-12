package com.adventOfCode.task.balanceBot;
import java.util.*;
public class InstructionReader {
    static Map<String,Integer> output = new TreeMap();
    public static Map<String, List<Integer>> instructionProcessor(List<String> data) {
        Map<String, List<Integer>> processedData = new TreeMap<>();
        while (!data.isEmpty()) {
            List<String> processedInstructions = new ArrayList<>();
            for (String arr : data) {
                String instruction[] = arr.split(" ");
                if (instruction[0].equals("value")) {
                    List<Integer> list = processedData.containsKey(instruction[5]) ? new ArrayList<>(processedData.get(instruction[5])) : new ArrayList<>(2);
                    list.add(Integer.parseInt(instruction[1]));
                    processedData.put(instruction[5], list);
                    processedInstructions.add(arr);
                } else {
                    List<Integer> list = processedData.containsKey(instruction[1]) ? processedData.get(instruction[1]) : new ArrayList<>();
                    if (list.size() == 2) {
                        Collections.sort(list);
                        if (instruction[5].equals("bot") ) {
                            if(processedData.containsKey(instruction[6]))
                            {
                                List<Integer> item =  new ArrayList<>(processedData.get(instruction[6]));
                                item.add(list.get(0));
                                processedData.put(instruction[6], item);
                            } else
                                processedData.put(instruction[6],Arrays.asList(list.get(0)));
                            } else {
                            output.put(instruction[6],list.get(0)) ;}
                        if (instruction[10].equals("bot") ) {
                            if(processedData.containsKey(instruction[11]))
                            {
                                List<Integer> item =  new ArrayList<>(processedData.get(instruction[11])) ;
                                item.add(list.get(1));
                                processedData.put(instruction[11], item);
                            }else
                                processedData.put(instruction[11],Arrays.asList(list.get(1)));
                        } else {output.put(instruction[11],list.get(1));}
                        processedInstructions.add(arr);
                    }
                }
            }
            data.removeAll(processedInstructions);
        }
        return processedData;
    }
}