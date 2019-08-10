package model;

public class CodeReview {
    private int id;
    private int userId;
    private String input;
    private String output;

    public CodeReview(String input){
        this.input = input;
    }

    public CodeReview(String input, String output){
        this.input = input;
        this.output = output;
    }

    public CodeReview(int id, String input, String output){
        this.id = id;
        this.input = input;
        this.output = output;
    }

    public CodeReview(int id, int userId, String input){
        this.id = id;
        this.userId = userId;
        this.input = input;
    }
}
