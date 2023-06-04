import static org.junit.jupiter.api.Assertions.*;

class BottleTest {

    @org.junit.jupiter.api.Test
    void drinkSuccessful() {
        int millilitersToDrink = 150;
        int currentVolumeInMilliliters = 300;
        int expectedVolume = 150;

        Bottle lemonade = new Bottle();

        boolean drink = lemonade.drinkAmount(150);
        int volume = currentVolumeInMilliliters - millilitersToDrink;

        assertEquals(expectedVolume, volume);
    }

    @org.junit.jupiter.api.Test
    void checkFill() {
    }
}