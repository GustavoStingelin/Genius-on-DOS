package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public abstract class Model {

    public abstract void save();

    public void save(String[] aStrings, String filePath) {
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(filePath, true));
            Stream<String> streamStrings = Arrays.stream(aStrings);
            streamStrings = streamStrings.map(s -> s.replace(";", ""));
            streamStrings = streamStrings.map(s -> s.concat(";"));
            aStrings = streamStrings.toArray(String[]::new);
            String line = "";
            for (String string : aStrings) {
                line = line.concat(string);
            }
            buffWrite.append(line + "\n");
            buffWrite.close();
            System.out.println("Salvo com sucesso!");
        } catch (Exception e) {
            System.out.println("Não foi possível salvar...");
            System.err.println(e.getMessage());
        } finally {
            Scanner kb = new Scanner(System.in);
            kb.nextLine();
        }
    }
}
