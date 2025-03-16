package com.example.do_an;
//ji
public class FoodItem {
    private String tittle;
    public String description;
    private  String image;

    public FoodItem(String tittle, String description, String image) {
        this.tittle = tittle;
        this.description = description;
        this.image = image;
    }

    public FoodItem(String tittle, String image) {
        this.tittle = tittle;
        this.image = image;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
