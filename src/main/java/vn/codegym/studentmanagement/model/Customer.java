package vn.codegym.studentmanagement.model;

/**
 * Created by IntelliJ IDEA.
 * User: WanBi (anhnb (anhnbt.it@gmail.com))
 * Date: 2024/10/29
 * Time: 13:44
 */
public class Customer {
    private Integer customerNumber;
    private String customerName;
    private String phone;

    public Customer() {
    }

    public Customer(Integer customerNumber, String customerName, String phone) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.phone = phone;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
