package Project;

interface livingspecies{
	public String getendanger();
	public String getendemic() ;
	public void setendanger(String endangerspecies) ;
	public void setendemic(String endemicspecies) ;
	public void count();
}
	  
public class Species implements livingspecies {
    private String endangerspecies;
    private String endemicspecies;
    public int countofendangerspecies;
    public int countofendemicspecies;

    public Species(int countofendangerspecies, int countofendemicspecies){
		this.countofendangerspecies = countofendangerspecies;
        this.countofendemicspecies = countofendemicspecies;
	}
	
    public String getendanger() {
        return endangerspecies;
    }

    public String getendemic() {
        return endemicspecies;
    }

    public void setendanger(String endangerspecies) {
        this.endangerspecies = endangerspecies;
    }

    public void setendemic(String endemicspecies) {
        this.endemicspecies = endemicspecies;
    }

    public void count() {
        if (countofendangerspecies > countofendemicspecies)
            System.out.println("This sanctuary contains more endanger species");
        else
            System.out.println("This sanctuary contains more endemic species");
    }
}