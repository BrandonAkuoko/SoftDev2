public class Food {
    private String name;
    private int servings;

    public Food(String name, int servings){
        this.name = name;
        this.servings = servings;
    }

    public String getName() {
        return name;
    }
    public int getServings() {
        return servings;
    }
    @Override
    public String toString() {
        return servings + " servings of " + name;
    }
}
