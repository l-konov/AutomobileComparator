/*
 * Приложение для сравнения стоимости владения различными автомобилями за год.
 * Учитываются годовой расход топлива, стоимость ТО, стоимость налога, стоимость страховки ОСАГО
 */
package ru.leonid;

import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class AutomobileComparator implements Comparator<Car>{
    
    @Override
    public int compare(Car a, Car b) {
        int aCost = Cost.getCost(a);
        int bCost = Cost.getCost(b);
        if(aCost > bCost) return 1;
        else if(aCost == bCost) return 0;
        else return -1;
    }    

    public static void main(String[] args) {
        SortedSet<Car> cars = new TreeSet<>(new AutomobileComparator());
        
        //////
        ////////////////////////////
        // название автомобиля, лошадиные силы, тип топлива, расход, стоимость ТО
        //////////////////////////////////
        cars.add(new Car("Peugeot 206", 75, Car.petrolType.BENZIN, 6.5,  35000));
        cars.add(new Car("VolksWagen Touareg", 174, Car.petrolType.DIESEL, 9.9,  26689));
        cars.add(new Car("Mazda CX-7", 238, Car.petrolType.BENZIN, 11.5));
        cars.add(new Car("Landrover Freelander II", 190, Car.petrolType.DIESEL, 7));
        cars.add(new Car("Volvo XC90 I R", 185, Car.petrolType.DIESEL, 9));
        cars.add(new Car("Volvo XC70 II", 185, Car.petrolType.DIESEL, 8.3));
        cars.add(new Car("Audi Q5", 211, Car.petrolType.BENZIN, 8.5));
        cars.add(new Car("Hundai SantaFe II R", 197, Car.petrolType.DIESEL, 7.2));
        cars.add(new Car("Toyota RAV4 III XA30", 152, Car.petrolType.BENZIN, 8.6));
        cars.add(new Car("Renault Koleos", 150, Car.petrolType.BENZIN, 7.9));
        /////////////////////////////////////////////////////////
        
        
        // вывод таблицы автомобилей
        Iterator<Car> it = cars.iterator();
        System.out.println("Р\t ТО\t Н\t ОСАГО");
        System.out.println("-----------------------");
        while(it.hasNext()){
            Car c = it.next();
            System.out.println(c.getName() + " " + c.getMotorPower() + " л.с.");
            System.out.println(Cost.getFuelConsumption(c) 
                    + "\t" + c.getMaintenanceCost() 
                    + "\t" + Cost.getTax(c) 
                    + "\t" + Cost.getInsuranceCost(c));
            System.out.println("-------Σ " + Cost.getCost(c));
        }   
    }
}
