package cz.demo.BankingApp.constant;

public enum Operation {
    UPDATE ("U"),
    NEW ("N");

    String type;
    Operation(String type){
        this.type=type;
    }
}
