
package ru.leonid;


public class Cost {
    
    // рассчёт полной стоимости владения автомобилем за год
    public static int getCost(Car c){
        return (int) (getFuelConsumption(c) 
                    + c.getMaintenanceCost()
                    + getTax(c) + getInsuranceCost(c));        
    }
    
    // Расчёт расхода топлива за год
    public static int getFuelConsumption(Car car){
        double benzin95Cost = 36.59;
        double dieselCost = 34.78;
        double distance = 20000; // средний пробег автомобиля за год
        double litersConsumption = car.getFuelConsumption() * distance / 100; // расход в литрах
        if(car.getPetrol().equals(Car.petrolType.BENZIN)) 
            return (int) (benzin95Cost * litersConsumption); // бензин 95
        else return (int) (dieselCost * litersConsumption); // дизель
    }    
    
    // Налог на лошадиные силы
    public static int getTax(Car car){
        int power = car.getMotorPower();
        if(power <= 100) return power * 12;
        else if(power <= 125) return power * 25;
        else if(power <= 150) return power * 35;
        else if(power <= 175) return power * 45;
        else if(power <= 200) return power * 50;
        else if(power <= 225) return power * 65;
        else if(power <= 250) return power * 75;
        else return power * 150;
    }
    
    // получить стоимость страховки ОСАГО для автомобиля
    public static int getInsuranceCost(Car car){
        int base = 4118; // базовая ставка максимальная
        float experience = (float) 1.8; // водительский стаж
        float territory = 2; // территориальный коэффициент
        float team = 1; // количество допущенных к управлению автомобилем
        float power = (float) getPowerCoef(car.getMotorPower()); // коэффициент мощности двигателя
        float malus = 1; // коэффициент безаварийной езды
        return (int) (base * experience * territory * team * power * malus); 
    }
    
    // получить коэффициент мощности двигателя
    private static double getPowerCoef(int power){
        if(power <= 50) return 0.6;
        else if(power <= 70) return 1;
        else if(power <= 100) return 1.1;
        else if(power <= 120) return 1.2;
        else if(power <= 150) return 1.4;
        else return 1.6;
    }    
}
