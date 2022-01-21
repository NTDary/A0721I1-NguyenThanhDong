package model;

public class CustomerType {
    private int customer_type_id;
    private String customer_type_name;

    public CustomerType(){};

    public CustomerType(int customer_type_id, String customer_type_name) {
        super();
        this.customer_type_id = customer_type_id;
        this.customer_type_name = customer_type_name;
    };

    public int getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(int customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public String getCustomer_type_name() {
        return customer_type_name;
    }

    public void setCustomer_type_name(String customer_type_name) {
        this.customer_type_name = customer_type_name;
    }
}
