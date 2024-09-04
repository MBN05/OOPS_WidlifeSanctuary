package Project;

public class Nutrients{
	public void nutrient(int protein, int vitamin){
		int nutrientvalue=protein+vitamin;
		System.out.println("Nutrient value:"+nutrientvalue);
	}
	public void nutrient(int protein, int vitamin,int carbohydrate){
		int nutrientvalue=protein+vitamin-carbohydrate;
		System.out.println("Nutrient value:"+nutrientvalue);
	}
}