public class Bottle {
    private int maxVolumeInMilliliters;
    private int currentVolumeInMilliliters;
    private String beverageName;

    public Bottle() {
        maxVolumeInMilliliters = 0;
        currentVolumeInMilliliters = 0;
        beverageName = "Lemonade";
    }

    public Bottle(int maxVolumeInMilliliters, int currentVolumeInMilliliters, String beverageName){
        this.maxVolumeInMilliliters = maxVolumeInMilliliters;
        this.currentVolumeInMilliliters = currentVolumeInMilliliters;
        this.beverageName = beverageName;
    }

    public int getMaxVolumeInMilliliters() {

        return maxVolumeInMilliliters;
    }

    public void setMaxVolumeInMilliliters(int maxVolumeInMilliliters) {
        this.maxVolumeInMilliliters = maxVolumeInMilliliters;
    }


    public int getCurrentVolumeInMilliliters() {

        return currentVolumeInMilliliters;
    }

    public int setCurrentVolumeInMilliliters(int currentVolumeInMilliliters){
        return currentVolumeInMilliliters;
    }
    public String getBeverageName() {

        return beverageName;
    }

    public void setBeverageName(String beverageName) {

        this.beverageName = beverageName;
    }

    public boolean drinkAmount(int millilitersToDrink){
        if (millilitersToDrink > currentVolumeInMilliliters){
            return false;
        }
        else{
           millilitersToDrink -= currentVolumeInMilliliters;
           return true;
        }
    }

    public boolean checkFill (int millilitersToFill) {
        if (millilitersToFill > maxVolumeInMilliliters) {
            return false;
        } else {
            millilitersToFill += currentVolumeInMilliliters;
            return true;
        }
    }
}
