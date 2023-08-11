package com.ecommerce.product.controller;
import com.ecommerce.product.model.Product;
import com.ecommerce.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    ProductRepository croductRepository;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getPelangganAll(){
        List<Product> pelangganData = croductRepository.findAll();

        if(!pelangganData.isEmpty()){
            return new ResponseEntity<>(pelangganData,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<List<Product>> getPelangganById(@PathVariable("id") int id){
        List<Product> pelangganData = croductRepository.findById(id);

        if(!pelangganData.isEmpty()){
            return new ResponseEntity<>(pelangganData,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/product")
    public ResponseEntity<Product> createPelanggan(@RequestBody Product product) {
        try {
            Product _pelanggan = croductRepository.save(new Product(product.getNama(),product.getHarga(),product.getStok()));
            return new ResponseEntity<>(_pelanggan, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updatePelanggan(@PathVariable("id") int id, @RequestBody Product product) {
        List<Product> pelangganlData = croductRepository.findById(id);

        if (!pelangganlData.isEmpty()) {
            Product _pelanggan = pelangganlData.get(0);
            _pelanggan.setNama(product.getNama());
            _pelanggan.setHarga(product.getHarga());
            _pelanggan.setStok(product.getStok());
            return new ResponseEntity<>(croductRepository.save(_pelanggan), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity<HttpStatus> deletePelanggan(@PathVariable("id") int id) {
        try {
            croductRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/product")
    public ResponseEntity<HttpStatus> deletePelangganAll() {
        try {
            croductRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
