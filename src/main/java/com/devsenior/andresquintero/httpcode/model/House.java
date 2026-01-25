package com.devsenior.andresquintero.httpcode.model;

public class House {

    private String color;
    
    private Integer numWindows;
    
    private String address;
    
    private Boolean haveGarage;

     public static HouseBuilder builder() {
        return new HouseBuilder();

     }
    private  House(String address, String color, Boolean haveGarage, Integer numWindows) {
        this.address = address;
        this.color = color;
        this.haveGarage = haveGarage;
        this.numWindows = numWindows;
    }

    public House() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNumWindows() {
        return numWindows;
    }

    public void setNumWindows(Integer numWindows) {
        this.numWindows = numWindows;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getHaveGarage() {
        return haveGarage;
    }

    public void setHaveGarage(Boolean haveGarage) {
        this.haveGarage = haveGarage;
    }

public static class  HouseBuilder{
     private String color;
    private Integer numWindows;
     private String address;
     private Boolean haveGarage = Boolean.FALSE;

     public HouseBuilder color(String color) {
        this.color = color;
        return this;
    }

        public HouseBuilder numWindows(Integer numWindows) {
            this.numWindows = numWindows;
            return this;
        }

        public HouseBuilder address(String address) {
            this.address = address;
            return this;
        }

        public HouseBuilder haveGarage(Boolean haveGarage) {
            this.haveGarage = haveGarage;
            return this;
        }

        public House build() {
            return new House(address, color, haveGarage, numWindows);
        }

}

    }


