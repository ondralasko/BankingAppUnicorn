package cz.demo.BankingApp.constant;



public enum Operation {
    U ("UPDATE"),
    N ("NEW");

    String type;
    Operation(String type){
        this.type=type;
    }

}
