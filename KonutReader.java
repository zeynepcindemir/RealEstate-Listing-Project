package com.example.myrealestateproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class KonutReader {
    public static HashMap<String, ArrayList<String>> konutMap = new HashMap<>();

    // method to read from txt file and to add Konut's to konutMap
    public static void readAndBuilt() {
        ArrayList<String> lines = new ArrayList<>();

        try {
            File file = new File("C:\\Users\\zcindemir\\IdeaProjects\\MyRealEstateProject\\src\\main\\java\\com\\example\\myrealestateproject\\FinalKonutlar.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String line : lines) {
            String[] parts = line.split(", ");
            String[] values = new String[15];

            for (int i = 0; i < parts.length; i++) {
                values[i] = parts[i];
            }

            /*
            values[0] = parts[0]; // isim
            values[1] = parts[1]; // butce
            values[2] = parts[2]; // oda sayisi
            values[3] = parts[3]; // isitma tipi
            values[4] = parts[4]; // semtin demografik yapisi
            values[5] = parts[5]; // hayat standardi
            values[6] = parts[6]; // suc orani
            values[7] = parts[7]; // bina tipi
            values[8] = parts[8]; // kacinci katta oldugu
            values[9] = parts[9]; // manzarasi
            values[10] = parts[10]; // semtteki okullarin kalitesi
            values[11] = parts[11]; // en yakin alisveris merkezine olan uzaklik
            values[12] = parts[12]; // en yakin hastaneye olan uzaklik
            values[13] = parts[13]; // en yakin okula olan uzaklik
            values[14] = parts[14]; // en yakin toplu tasima kanalina olan uzaklik
             */
            konutMap.put(values[0], new ArrayList<String>(14));


            for (int i = 1; i < values.length; i++) {
                konutMap.get(parts[0]).add(values[i]);
            }
        }

    }

    // method to add each Konut object to konutPriorityQueue
    public static void updateData() {

        for (String key : konutMap.keySet()) {
            Konut yeniKonut = new Konut(konutMap.get(key), key);
            SceneController.getInstance().konutPriorityQueue.insert(yeniKonut);
        }
    }
}
