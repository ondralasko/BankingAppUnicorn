package cz.demo.BankingApp.constant;

public enum ProductType {
    ACCOUNT("ACCOUNT"),
    LOAN("LOAN");

    String type;
    ProductType(String type){
        this.type=type;
    }
}
