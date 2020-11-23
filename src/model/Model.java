package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public abstract class Model<T> {

    public abstract void save();
    public abstract List<T> load();
    public abstract void truncate();

    public static void save(String[] aStrings, String filePath) {
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

    public static List<String> load(String filePath) {
        try {
            List<String> list = new ArrayList<>();
            BufferedReader buffRead = new BufferedReader(new FileReader(filePath));
			String line = buffRead.readLine();
			while (line != null) {
                list.add(line);
                line = buffRead.readLine();
			}
            buffRead.close();
            return list;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void truncate(String filePath) {
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(filePath));
            buffWrite.write("");
            buffWrite.close();
            //System.out.println("Limpo com sucesso!");
        } catch (Exception e) {
            System.out.println("Não foi possível limpar...");
            System.err.println(e.getMessage());
        }
    }
}
