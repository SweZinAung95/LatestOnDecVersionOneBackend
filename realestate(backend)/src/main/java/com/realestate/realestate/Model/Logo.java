package com.realestate.realestate.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "logoImage")
public class Logo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "logoName")
    private String name;
    @Column(name="logoType")
    private  String type;

    @Column(name = "logo",length = 20000000)
    private  byte[]image;

    public Logo() {
    }

    public Logo(String name, String type, byte[] image) {
        this.name = name;
        this.type = type;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
