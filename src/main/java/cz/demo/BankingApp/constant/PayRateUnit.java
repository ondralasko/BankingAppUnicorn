package cz.demo.BankingApp.constant;

public enum PayRateUnit {
    DAY("DAY"),
    MONTH("MONTH");

    String type;
    PayRateUnit(String type){
        this.type = type;
    }
}
