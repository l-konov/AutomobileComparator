/*
 * Класс автомобиля
 */
package ru.leonid;


public class Car{
    
    enum petrolType {BENZIN, DIESEL}; 
    
    private petrolType petrol; // тип топлива
    private int motorPower; // в лошадиных силах
    private String name; // производитель и марка автомобиля
    private double fuelConsumption; // расход топлива
    private int maintenanceCost;
    
     
    public Car(String name, int motorPower, petrolType petrol, double fuelConsumption, int maintenanceCost) {
        this.petrol = petrol;
        this.motorPower = motorPower;
        this.name = name;
        this.fuelConsumption = fuelConsumption;
        this.maintenanceCost = maintenanceCost;
    }    
    
    // стоимость ТО задана по умолчанию 20000
    public Car(String name, int motorPower, petrolType petrol, double fuelConsumption) {
        this.petrol = petrol;
        this.motorPower = motorPower;
        this.name = name;
        this.fuelConsumption = fuelConsumption;
        this.maintenanceCost = 35000;
    }        
    
    public petrolType getPetrol() {
        return petrol;
    }    
    
    public int getMotorPower() {
        return motorPower;
    }

    public String getName() {
        return name;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }
    
    public int getMaintenanceCost() {
        return maintenanceCost;
    }      
}
