/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

/**
 *
 * @author NgocHao
 */
public class SushiMenuDTO {

    private int id;
    private String name;
    private double price;
    private String shortDes;
    private String detailDes;

    public SushiMenuDTO() {
    }

    public SushiMenuDTO(int id, String name, double price, String shortDes, String detailDes) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.shortDes = shortDes;
        this.detailDes = detailDes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getDetailDes() {
        return detailDes;
    }

    public void setDetailDes(String detailDes) {
        this.detailDes = detailDes;
    }

    
}
