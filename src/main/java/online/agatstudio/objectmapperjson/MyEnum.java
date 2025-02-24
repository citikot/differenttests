package online.agatstudio.objectmapperjson;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public enum MyEnum {

    ELEMENT1("Value1", 1, true, "Info1"),
    ELEMENT2("Value2", 2, false, "Info2"),
    ELEMENT3("Value3", 3, true, "Info3");

    private String stringValue;
    private int intValue;
    private boolean booleanValue;
    private String additionalInfo;

    MyEnum(String stringValue, int intValue, boolean booleanValue, String additionalInfo) {
        this.stringValue = stringValue;
        this.intValue = intValue;
        this.booleanValue = booleanValue;
        this.additionalInfo = additionalInfo;
    }

    // Геттеры для полей (опционально)
    public String getStringValue() {
        return stringValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public boolean isBooleanValue() {
        return booleanValue;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

//    @Override
//    @JsonValue
//    public String toString() {
//        return "{" +
//                "'stringValue':'" + stringValue + '\'' +
//                ", 'intValue':" + intValue +
//                ", 'booleanValue':" + booleanValue +
//                ", 'additionalInfo':'" + additionalInfo + '\'' +
//                '}';
//    }
}

