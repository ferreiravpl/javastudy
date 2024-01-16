package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String filePath = sc.nextLine();
        Map<String, Integer> voterList = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String personVoter = br.readLine();
            while (personVoter != null) {
                String[] fields = personVoter.split(",");
                String voterName = fields[0];
                int voteQty = Integer.parseInt(fields[1]);
                if (voterList.containsKey(voterName)) {
                    int votesSoFar = voterList.get(voterName);
                    voterList.put(voterName, voteQty + votesSoFar);
                } else {
                    voterList.put(voterName, voteQty);
                }
                personVoter = br.readLine();
            }
            for (String person : voterList.keySet()) {
                System.out.println(person + ": " + voterList.get(person));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sc.close();
    }
}