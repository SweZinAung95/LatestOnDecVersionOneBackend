package com.realestate.realestate.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "propertyImage")
public class PropertyImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "name1")
    private String name1;
    @Column(name="type1")
    private  String type1;

    @Column(name = "image1",length = 20000000)
    private  byte[]image1;
    @Column(name = "name2")
    private  String name2;
    @Column(name = "image2",length =  20000000)
    private  byte[]image2;
    @Column(name="type2")
    private  String type2;
    @Column(name = "name3")
    private  String name3;
    @Column(name = "image3",length = 20000000)
    private  byte[]image3;
    @Column(name="type3")
    private  String type3;
    @Column(name = "name4")
    private  String name4;
    @Column(name = "image4",length = 20000000)
    private  byte[]image4;
    @Column(name="type4")
    private  String type4;
    @Column(name = "name5")
    private  String name5;
    @Column(name = "image5",length = 20000000)
    private  byte[]image5;
    @Column(name="type5")
    private  String type5;
    @Column(name = "name6")
    private  String name6;
    @Column(name = "image6",length = 20000000)
    private  byte[]image6;
    @Column(name="type6")
    private  String type6;
    @Column(name = "name7")
    private  String name7;
    @Column(name = "image7",length = 20000000)
    private  byte[]image7;
    @Column(name="type7")
    private  String type7;
    @Column(name = "name8")
    private  String name8;
    @Column(name = "image8",length = 20000000)
    private  byte[]image8;
    @Column(name="type8")
    private  String type8;
    public  PropertyImage(){}

    public PropertyImage(String name1, String type1, byte[] image1,
                         String name2,  String type2,byte[] image2,
                         String name3, String type3, byte[] image3,
                         String name4, String type4,byte[] image4,
                         String name5, String type5, byte[] image5,
                         String name6,String type6, byte[] image6,
                         String name7,  String type7,
                         byte[] image7,
                         String name8, String type8,byte[] image8) {
        this.name1 = name1;
        this.type1 = type1;
        this.image1 = image1;

        this.name2 = name2;
        this.type2 = type2;

        this.image2 = image2;
        this.name3 = name3;
        this.type3 = type3;

        this.image3 = image3;
        this.name4 = name4;
        this.type4 = type4;

        this.image4 = image4;
        this.name5 = name5;
        this.type5 = type5;

        this.image5 = image5;
        this.name6 = name6;
        this.type6 = type6;

        this.image6 = image6;
        this.name7 = name7;
        this.type7 = type7;

        this.image7 = image7;
        this.name8 = name8;
        this.type8 = type8;

        this.image8 = image8;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public byte[] getImage1() {
        return image1;
    }

    public void setImage1(byte[] image1) {
        this.image1 = image1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public byte[] getImage2() {
        return image2;
    }

    public void setImage2(byte[] image2) {
        this.image2 = image2;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public byte[] getImage3() {
        return image3;
    }

    public void setImage3(byte[] image3) {
        this.image3 = image3;
    }

    public String getType3() {
        return type3;
    }

    public void setType3(String type3) {
        this.type3 = type3;
    }

    public String getName4() {
        return name4;
    }

    public void setName4(String name4) {
        this.name4 = name4;
    }

    public byte[] getImage4() {
        return image4;
    }

    public void setImage4(byte[] image4) {
        this.image4 = image4;
    }

    public String getType4() {
        return type4;
    }

    public void setType4(String type4) {
        this.type4 = type4;
    }

    public String getName5() {
        return name5;
    }

    public void setName5(String name5) {
        this.name5 = name5;
    }

    public byte[] getImage5() {
        return image5;
    }

    public void setImage5(byte[] image5) {
        this.image5 = image5;
    }

    public String getType5() {
        return type5;
    }

    public void setType5(String type5) {
        this.type5 = type5;
    }

    public String getName6() {
        return name6;
    }

    public void setName6(String name6) {
        this.name6 = name6;
    }

    public byte[] getImage6() {
        return image6;
    }

    public void setImage6(byte[] image6) {
        this.image6 = image6;
    }

    public String getType6() {
        return type6;
    }

    public void setType6(String type6) {
        this.type6 = type6;
    }

    public String getName7() {
        return name7;
    }

    public void setName7(String name7) {
        this.name7 = name7;
    }

    public byte[] getImage7() {
        return image7;
    }

    public void setImage7(byte[] image7) {
        this.image7 = image7;
    }

    public String getType7() {
        return type7;
    }

    public void setType7(String type7) {
        this.type7 = type7;
    }

    public String getName8() {
        return name8;
    }

    public void setName8(String name8) {
        this.name8 = name8;
    }

    public byte[] getImage8() {
        return image8;
    }

    public void setImage8(byte[] image8) {
        this.image8 = image8;
    }

    public String getType8() {
        return type8;
    }

    public void setType8(String type8) {
        this.type8 = type8;
    }
}
