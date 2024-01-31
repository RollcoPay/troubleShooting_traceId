package monster.realrestfulman.trpr.entity;

import java.util.HashMap;

public class DataMap extends HashMap<String, String> {

    String order_1_name;
    String order_2_name;

    String order_1_amount;
    String order_2_amount;

    @Override
    public String toString() {
        return "DataMap{" +
                "order_1_name='" + order_1_name + '\'' +
                ", order_2_name='" + order_2_name + '\'' +
                ", order_1_amount='" + order_1_amount + '\'' +
                ", order_2_amount='" + order_2_amount + '\'' +
                '}';
    }
}
