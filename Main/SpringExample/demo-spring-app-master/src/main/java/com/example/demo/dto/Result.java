package com.example.demo.dto;

public class Result {
    private String resultBody;

    public Result() {
    }

    public Result(String resultBody) {
        this.resultBody = resultBody;
    }

    public String getResultBody() {
        return resultBody;
    }

    public void setResultBody(String resultBody) {
        this.resultBody = resultBody;
    }
}
