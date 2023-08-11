package com.ecommerce.customer.model;
import javax.persistence.*;
@Entity
@Table(name = "pelanggan")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "hp")
    private String hp;

    public Customer(){};

    public Customer(String nama, String hp){
        this.nama=nama;
        this.hp=hp;
    }

    public int getId(){
        return id;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama=nama;
    }

    public String getHp(){
        return hp;
    }

    public void setHp(String hp){
        this.hp=hp;
    }
}
