public class ElectricVehicle {
    public int kilowatHoursInBattery;
    public int maxKilowatHoursInBattery;
    public int kilometersPerKilowatHour;
    public String make;
    public String model;
    public String color;

    public ElectricVehicle() {
        kilowatHoursInBattery = 0;
        maxKilowatHoursInBattery = 0;
        kilometersPerKilowatHour = 0;
        make = "";
        model = "";
        color = "";
    }

    public ElectricVehicle(int kilowatHoursInBattery, int maxKilowatHoursInBattery, int kilometersPerKilowatHour, String make, String model, String color){
        this.kilowatHoursInBattery = kilowatHoursInBattery;
        this.maxKilowatHoursInBattery = maxKilowatHoursInBattery;
        this.kilometersPerKilowatHour = kilometersPerKilowatHour;
        this.make = make;
        this.model = model;
        this.color = color;
    }

    public int getKilowatHoursInBattery() {
        return kilowatHoursInBattery;
    }

    public int getMaxKilowatHoursInBattery() {
        return maxKilowatHoursInBattery;
    }

    public int getKilometersPerKilowatHour() {
        return kilometersPerKilowatHour;
    }
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public boolean driveDistance(int kilometersToDrive){
        if (kilometersToDrive > kilowatHoursInBattery){
            kilowatHoursInBattery -= kilometersToDrive;
            return true;
        }
        else {
            return false;
        }
    }
    public boolean chargeAmount(int kilowatHoursToCharge){
        if (kilowatHoursToCharge < maxKilowatHoursInBattery){
            kilowatHoursInBattery += kilowatHoursToCharge;
            return true;
        }
        else {
            return false;
        }
    }
}
