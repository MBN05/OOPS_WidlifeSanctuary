package Project;

interface Nutritive{
	public void display();
}

public class Food implements Nutritive {
    public String foodfromtrees;
    public String foodbyman;

    public Food(String foodfromtrees, String foodbyman) {
        this.foodfromtrees = foodfromtrees;
        this.foodbyman = foodbyman;
    }
	public void display(){
		System.out.println("organic food items are:" + foodfromtrees);
        System.out.println("Manmade food items are:" + foodbyman);
	}
}