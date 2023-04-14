package com.example.watch_shop.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer idCustomer;
    @Column(name = "name_customer")
    private String name;
    @Column(name = "date_of_birth")
    private String dayOfBirth;
    @Column(name = "address")
    private String address;
    @Column(name = "email_customer")
    private String email;
    @Column(name = "phone_number")
    private String phone;
    @ManyToOne
    @JoinColumn(name = "id_type_cus")
    private CustomerType customerType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "name_account")
    private Account account;

    public Customer() {
    }

    public Customer(String name, String dayOfBirth, String address, String email, String phone, CustomerType customerType, Account account) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.account = account;
    }

    public Customer(Integer idCustomer, String name, String dayOfBirth, String address, String email, String phone, CustomerType customerType, Account account) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.customerType = customerType;
        this.account = account;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
