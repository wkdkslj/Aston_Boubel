public class Bowl {
    private int foodAmount;

    public Bowl(int initialFood) {
        if (initialFood < 0) {
            this.foodAmount = 0;
        } else {
            this.foodAmount = initialFood;
        }
    }

    public boolean feedCat(int amount) {
        if (amount <= foodAmount) {
            foodAmount -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
