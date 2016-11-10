package com.educluster.gen;

import com.educluster.ctrl.FileManager;

public class JpaModelWrapperConverter {

    FileManager fileManager;

    public JpaModelWrapperConverter() {
        fileManager = new FileManager();
    }

    public void generateModelsWithWCForInputFiles() {
        fileManager.getInputFileNameList().forEach((name) -> {
            fileManager.writeFile("model", name, "", getContent(name));
        });
    }

    private String getContent(String name) {
        String content = fileManager.readFile(name);
        content = content.replace("boolean ", "Boolean ");
        content = content.replace("byte ", "Byte ");
        content = content.replace("char ", "Char ");
        content = content.replace("short ", "Short ");
        content = content.replace("int ", "Integer ");
        content = content.replace("float ", "Float ");
        content = content.replace("double ", "Double ");
        return content;
    }
}
