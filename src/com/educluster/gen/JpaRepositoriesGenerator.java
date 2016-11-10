package com.educluster.gen;

import com.educluster.ctrl.FileManager;
import com.educluster.props.Properties;

public class JpaRepositoriesGenerator {

    FileManager fileManager;

    public JpaRepositoriesGenerator() {
        fileManager = new FileManager();
    }

    public void generateReposForInputFiles() {
        fileManager.getInputFileNameList().forEach((name) -> {
            fileManager.writeFile("repo", name, "Repository", getContent(name));
        });
    }

    private String getContent(String name) {
        StringBuilder sb = new StringBuilder();
        sb.append("package ");
        sb.append(Properties.MASTER_PKG);
        sb.append(".");
        sb.append(Properties.REPOSITORY);
        sb.append(";import org.springframework.data.jpa.repository.JpaRepository;");
        sb.append("import org.springframework.data.rest.core.annotation.RepositoryRestResource;");
        sb.append("import com.radicalz.persistence.");
        sb.append(Properties.MODEL);
        sb.append(".");
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
}
