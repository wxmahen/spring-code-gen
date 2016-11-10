package com.educluster.ctrl;

import com.educluster.props.Properties;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static String OUTPUT_FOLDER = "output";
    public static String INPUT_FOLDER = "input";

    private String[] getInputFileList() {
        return getFileList(INPUT_FOLDER);
    }

    public List<String> getInputFileNameList() {
        String[] files = getInputFileList();
        List<String> file_list = new ArrayList<>();
        for (String file : files) {
            file_list.add(file.split("\\.")[0]);
        }
        return file_list;
    }

    private String[] getFileList(String folder) {
        return new File(folder).list();
    }

    public void writeFile(String folder, String name, String ext, String data) {
        try {
            File file = new File(OUTPUT_FOLDER + "\\" + folder + "\\" + name + ext + ".java");
            try (FileWriter fileWriter = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(data);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FOLDER + "\\" + file + ".java"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            return sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
