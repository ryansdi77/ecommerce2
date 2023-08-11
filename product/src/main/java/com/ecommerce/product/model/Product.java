package com.ecommerce.product.model;
import javax.persistence.*;
@Entity
@Table(name = "produk")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idproduk")
    private int id;

    @Column(name = "nama")
    private String nama;

    @Column(name = "harga")
    private int harga;

    @Column(name = "stok")
    private int stok;

    public Product(){};

    public Product(String nama, int harga, int stok){
        this.nama=nama;
        this.harga=harga;
        this.stok=stok;
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

    public int getHarga(){
        return harga;
    }

    public void setHarga(int harga){
        this.harga=harga;
    }

    public int getStok(){
        return stok;
    }

    public void setStok(int stok){
        this.stok=stok;
    }
}
