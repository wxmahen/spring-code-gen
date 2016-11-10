package com.educluster.run;

import com.educluster.gen.JpaModelWrapperConverter;
import com.educluster.gen.JpaRepositoriesGenerator;

public class Starter {

    public static void main(String[] args) {
        new JpaRepositoriesGenerator().generateReposForInputFiles();
        new JpaModelWrapperConverter().generateModelsWithWCForInputFiles();
    }
}
