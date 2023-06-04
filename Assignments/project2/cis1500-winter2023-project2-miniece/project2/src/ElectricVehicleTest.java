import static org.junit.jupiter.api.Assertions.*;

class ElectricVehicleTest {

    @org.junit.jupiter.api.Test
    void driveDistance() {
        int kilometersToDrive = 10;
        int kilowatHoursInBattery = 30;
        int expectedKilowats = 20;
        ElectricVehicle car = new ElectricVehicle();
        boolean drive = car.driveDistance(kilometersToDrive);
        int actualKilowats = kilowatHoursInBattery - kilometersToDrive;

        assertEquals(expectedKilowats, actualKilowats);

    }

    @org.junit.jupiter.api.Test
    void chargeAmount() {
        int kilowatHoursToCharge = 20;
        int kilowatHoursInBattery = 100;
        int maxKilowatHoursInBattery = 250;
        int expectedCharge = 120;
        ElectricVehicle car = new ElectricVehicle();
        boolean charge = car.chargeAmount(kilowatHoursToCharge);
        int actualCharge = kilowatHoursInBattery + kilowatHoursToCharge;

        assertEquals(expectedCharge, actualCharge);

    }
}