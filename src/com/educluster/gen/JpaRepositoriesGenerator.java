package com.educluster.gen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JpaRepositoriesGenerator {

    String master_package = "com.educluster.persistence";
    String repo_folder = "repo";
    String model_folder = "model";
    String output_folder = "output";

    public static void main(String[] args) {
        JpaRepositoriesGenerator repositoriesGenerator = new JpaRepositoriesGenerator();
        repositoriesGenerator.generateClasses("User", "Customer");
    }

    private void generateClasses(String... names) {
        for (String name : names) {
            writeFile(name, getData(name));
        }
    }

    private String getData(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("package ");
        sb.append(master_package);
        sb.append(".");
        sb.append(repo_folder);
        sb.append(";import org.springframework.data.jpa.repository.JpaRepository;");
        sb.append("import org.springframework.data.rest.core.annotation.RepositoryRestResource;");
        sb.append("import com.radicalz.persistence.model.");
        sb.append(name);
        sb.append(";@RepositoryRestResource(collectionResourceRel = \"");
        sb.append(name.toLowerCase());
        sb.append("s\", path = \"");
        sb.append(name.toLowerCase());
        sb.append("s\")public interface ");
        sb.append(name);
        sb.append("Repository extends JpaRepository<");
        sb.append(name);
        sb.append(", Integer>{}");
        return sb.toString();
    }

    private void writeFile(String name, String data) {
        try {
            File file = new File(output_folder + "\\" + name + "Repository.java");
            try (FileWriter fileWriter = new FileWriter(file); BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                bufferedWriter.write(data);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
