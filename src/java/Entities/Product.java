/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author admin
 */
public class Product {

    private int productID;
    private String productName;
    private float price;
    private String imgSrc;
    private String summary;
    private String description;
    private int categoryID;
    private boolean status;

    public Product() {
    }

    public Product(int productID, String productName, float price, String imgSrc, String summary, String description, int categoryID, boolean status) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.imgSrc = imgSrc;
        this.summary = summary;
        this.description = description;
        this.categoryID = categoryID;
        this.status = status;
    }
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
