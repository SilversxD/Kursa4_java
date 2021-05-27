package com.example.AgencySold.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Houses {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer id;
        private Integer price,quantity;
        private String name;



        public Houses() {

        }

        public Houses(Integer id, String name, Integer quantity, Integer price) {
            this.id=id;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getQuantity() {
            return quantity;
        }



        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public void setPrice(Integer price){this.price=price;}

        public Integer getPrice(){        return price;        }


    }

