package com.example.etnateraapp.model;

import java.util.List;

public class SportResults {

    private List<SportResult> sportResults;

    public SportResults() {
    }

    public SportResults(List<SportResult> sportResults) {
        this.sportResults = sportResults;
    }

    public List<SportResult> getSportResults() {
        return sportResults;
    }

    public void setSportResults(List<SportResult> sportResults) {
        this.sportResults = sportResults;
    }
}
