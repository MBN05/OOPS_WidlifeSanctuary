import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.logging.*;
import java.io.*;
import Project.Food;
import Project.Species;
import Project.Nutrients;

class logReport{
private static final Logger l=Logger.getLogger(WS.class.getName());

public void report(String InstituteName,int noofstudents,float time){
	l.info("Institution Name:  "+InstituteName);
	if(time>5)
		l.warning("Maximum allowed time is just 5 hours but your given time is "+time);
	else
		l.info("Visiting hours :  "+time);
	
	if(noofstudents>100)
		l.severe("Number of students exceeds the maximum count");
	else
		l.info("	Number of students : "+noofstudents);
}
}

class SanctuaryThread extends Thread{
	int i;
	java.util.List <String> sanctuaryNames=new ArrayList<String>();
	public SanctuaryThread(java.util.List <String> sanctuaryNames){
		this.sanctuaryNames=sanctuaryNames;
	}
	public void run(){
		for(String s : sanctuaryNames){
			System.out.println("Sanctuary name: "+s);
	try{
		Thread.sleep(1000);
	}
	catch(Exception e){
	}
	}
}
}

class PlaceThread extends Thread{
	int i;
	java.util.List <String> placeNames=new ArrayList<String>();
	public PlaceThread(	java.util.List <String> placeNames){
	this.placeNames=placeNames;
	}
	public void run(){
		for(String p : placeNames){
			System.out.println("Place name: "+p);
	try{
		Thread.sleep(1000);
	}
	catch(Exception e){
	}
}
}
}
		
class Animal extends Species {
    public String sname;
    public String place;

    public Animal(String sname, String place,int countofendangerspecies,int countofendemicspecies) {
        super(countofendangerspecies,countofendemicspecies); 
        this.sname = sname;
        this.place = place;
    }
	public void display(){
		System.out.println("The sanctuary name:" + sname);
        System.out.println("Place of the sanctuary:" + place);
	}
    public void find() {
        count();
    }
}

class People extends Species {
    private int noofCameras;
    public int numberofvisitors;
    public float permittedArea;

    public People(int numberofvisitors, float permittedArea,int countofendangerspecies,int countofendemicspecies) {
		super(countofendangerspecies,countofendemicspecies);
        this.numberofvisitors = numberofvisitors;
        this.permittedArea = permittedArea;
    }
	public void display(){
		System.out.println("Permitted Space:" + permittedArea);
        System.out.println("Number of Visitors:" + numberofvisitors);
	}
	
	public void danger(){
		int cont=countofendangerspecies+countofendemicspecies;
		System.out.println("Total no of animals which are in danger :"+cont);
	}

    public int getvar() {
        return noofCameras;
    }

    public void setvar(int x) {
        noofCameras = x;
    }
}

class Authorities extends Human{
    public String IFOS_officer;
    public String DeputyConservator;
    public String DirectorGeneral;
	public int noofguards;

    public Authorities(String IFOS_officer, String DeputyConservator, String DirectorGeneral,int noofguards,int numberofvisitors,float permittedArea,float donation,float entryfee,int countofendangerspecies,int countofendemicspecies) {
		super(numberofvisitors, permittedArea, donation, entryfee,countofendangerspecies,countofendemicspecies);
        this.IFOS_officer = IFOS_officer;
        this.DeputyConservator = DeputyConservator;
        this.DirectorGeneral = DirectorGeneral;
		this.noofguards = noofguards;
    }
	public void display(){
		System.out.println("IFOS_officer:" + IFOS_officer);
        System.out.println("DeputyConservator:" + DeputyConservator);
        System.out.println("DirectorGeneral:" + DirectorGeneral);
	}
	public void salarycount(float x,float y){
		double s;
		balance(x,y);
		s=salary();
		double wages =(double)(s/noofguards);
		System.out.println("Monthly wages of guards:" + wages);
	}
}

class Human extends People {
    private float foodcost;
    private float medicines;
    public float donation;
    public float entryfee;
	public double save;

    public Human(int numberofvisitors, float permittedArea, float donation, float entryfee,int countofendangerspecies, int countofendemicspecies) {
        super(numberofvisitors, permittedArea,countofendangerspecies,countofendemicspecies);
        this.donation = donation;
        this.entryfee = entryfee;
    }
	public void display(){
		System.out.println("Donation" + donation);
        System.out.println("Entry fee" + entryfee);
	}

    public void balance(float x,float y) {
		foodcost=x;
		medicines=y;
        float expense = foodcost + medicines;
        float income = donation + (entryfee * numberofvisitors);
        save = income - expense;
        System.out.println("Expenses:" + expense + "\nIncome:" + income);
        System.out.println("Savings:" + save);
    }
	
	public double salary(){
		double rem=(save*50)/100;
		System.out.println("Remaining amount:"+rem);
		return rem;
	}
		
    public float getfc() {
        return foodcost;
    }

    public float getmed() {
        return medicines;
    }

    public void setfc(float x) {
        foodcost = x;
    }

    public void setmed(float y) {
        medicines = y;
    }
}

class InvalidCountException extends Exception{
public InvalidCountException(String string){
	super(string);
}
}

class InvalidTimeException extends Exception{
public InvalidTimeException(String string){
	super(string);
}
}

public class WS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
String sname = "";
String place = "";
int countofendangerspecies = 0;
int countofendemicspecies = 0;
int numberofvisitors = 0;
float permittedArea = 0.0f;
int cam = 0;
String endangerspecies = "";
String endemicspecies = "";
String foodfromtrees = "";
String foodbyman = "";
String IFOS_officer = "";
String DeputyConservator = "";
String DirectorGeneral = "";
int noofguards = 0;
float donation = 0.0f;
float entryfee = 0.0f;
float x = 0.0f;
float y = 0.0f;
String InstituteName = "";
int noofstudents = 0;
float time = 0.0f;
String ownplace = "";
		try{
			BufferedReader reader = new BufferedReader(new FileReader("Input.txt"));
			sname = reader.readLine();
            place = reader.readLine();
            permittedArea = Float.parseFloat(reader.readLine());
            numberofvisitors = Integer.parseInt(reader.readLine());
            cam = Integer.parseInt(reader.readLine());
            endangerspecies = reader.readLine();
            endemicspecies = reader.readLine();
            countofendangerspecies = Integer.parseInt(reader.readLine());
            countofendemicspecies = Integer.parseInt(reader.readLine());
            foodfromtrees = reader.readLine();
            foodbyman = reader.readLine();
            IFOS_officer = reader.readLine();
            DeputyConservator = reader.readLine();
            DirectorGeneral = reader.readLine();
            noofguards = Integer.parseInt(reader.readLine());
            donation = Float.parseFloat(reader.readLine());
            entryfee = Float.parseFloat(reader.readLine());
            x = Float.parseFloat(reader.readLine());
            y = Float.parseFloat(reader.readLine());
            noofstudents = Integer.parseInt(reader.readLine());
            time = Float.parseFloat(reader.readLine());
			ownplace = reader.readLine();
			reader.close();
		}
		catch(IOException e){
		}
        Animal obj1 = new Animal(sname, place, countofendangerspecies, countofendemicspecies);
		obj1.display();
        obj1.find();
        People obj2 = new People(numberofvisitors, permittedArea,countofendangerspecies,countofendemicspecies);
       	obj2.display();
		obj2.setvar(cam);
        System.out.println("The number of cameras:" + obj2.getvar());
		Species obj6 = new Species(countofendangerspecies,countofendemicspecies);
		obj6.setendanger(endangerspecies);
		obj6.setendemic(endemicspecies);
        System.out.println("The endangerspecies are:" + obj6.getendanger());
        System.out.println("The endemicspecies are:" + obj6.getendemic());
		obj2.danger();
        Food obj3 = new Food(foodfromtrees, foodbyman);
		obj3.display();
        Authorities obj4 = new Authorities(IFOS_officer, DeputyConservator, DirectorGeneral,noofguards,numberofvisitors, permittedArea, donation, entryfee,countofendangerspecies,countofendemicspecies);
		obj4.display();
        Human obj5 = new Human(numberofvisitors, permittedArea, donation, entryfee,countofendangerspecies,countofendemicspecies);
		obj5.display();
        obj5.setfc(x);
        obj5.setmed(y);
        System.out.println("Food cost:" + obj5.getfc());
        System.out.println("Medicine cost:" + obj5.getmed());
		obj4.salarycount(x,y);
		System.out.println("Amount  of nutrients provided to the animal");
		Nutrients obj7= new Nutrients();
		obj7.nutrient(12,12);
		obj7.nutrient(12,12,12);
		try{
			if(noofstudents<0)
				throw new InvalidCountException("Count of students cannot be negative");
				try{
					if(noofstudents>100)
						throw new InvalidCountException("Maximum limit allowed is 100 students");
				}
				catch(InvalidCountException e){
					System.out.println(e);
		       }
		}
		catch(InvalidCountException e){
			 System.out.println("Invalid count "+e);
		}
		try{
			if(time<0)
				throw new InvalidTimeException("Time cannot be less than zero");
				try{
					if(time>5)
						throw new InvalidTimeException("Maximum time allowed is 5hrs");
				}
				catch(InvalidTimeException e){
					System.out.println(e);
		       }
		}
		catch(InvalidTimeException e){
			 System.out.println("Invalid Time "+e);
		}
			java.util.List <String> sanctuaryNames=new ArrayList<String>();
			java.util.List <String> placeNames=new ArrayList<String>();
		for(int i=0;i<5;i++){
			System.out.println("Enter the sanctuary name");
			 String sanc= in.nextLine();
			 sanctuaryNames.add(sanc);
	    }
		for (int i=0;i<5;i++){
            System.out.println("Enter the Place");
            String pname = in.nextLine();
			placeNames.add(pname);
        }
		for(String a : sanctuaryNames)
			a.toUpperCase();
       int index=placeNames.indexOf(ownplace);
	   if(index!=-1)
		System.out.println("The sanctuary you could visit is: "+sanctuaryNames.get(index));
	else
		System.out.println("Oops! no sanctuaries near your place");
		SanctuaryThread obj8=new SanctuaryThread(sanctuaryNames);
		PlaceThread obj9=new PlaceThread(placeNames);
		obj8.start();
		obj9.start();
		logReport obj10 = new  logReport();
		obj10.report(InstituteName,noofstudents,time);
		
	
	JFrame f = new JFrame("Visit Registeration");
	JLabel l1,l2,l3,l4,l5;
	l1 = new JLabel("Institute Name: ");
	l1.setBounds(50,50,150,30);
	l2 = new JLabel("Number of students: ");
	l2.setBounds(50,100,150,30);
	l3 = new JLabel("Average age of children: ");
	l3.setBounds(50,150,150,30);
	f.add(l1);f.add(l2);f.add(l3);
	
	JTextField t1,t2,t3;
	t1= new JTextField(" ");
	t2 = new JTextField(" ");
	t3 = new JTextField(" ");
	t1.setBounds(250,50,150,30);
	t2.setBounds(250,100,100,30);
	t3.setBounds(250,150,100,30);
	f.add(t1);
	f.add(t2);
	f.add(t3);
	
	l4 = new JLabel("Select preferred animals: ");
	l4.setBounds(50,200,190,30);
	f.add(l4);
	JCheckBox c1 = new JCheckBox("Endangered species");
	JCheckBox c2 = new JCheckBox("Endemic species");
	JCheckBox c3 = new JCheckBox("Wild animals");
	c1.setBounds(250,200,150,30);
	c2.setBounds(250,220,150,30);
	c3.setBounds(250,240,150,30);
	f.add(c1);
	f.add(c2);
	f.add(c3);
	
	l5 = new JLabel("Choose animal for study: ");
	l5.setBounds(50,300,200,30);
	f.add(l5);
	Choice c = new  Choice();
	c.setBounds(250,300,150,30);
	c.add("Tiger");
	c.add("Hyena");
	c.add("Giraffe");
	c.add("Rhinoceros");
	f.add(c);
	

	f.setSize(400,400);
	f.setLayout(null);
	f.setVisible(true);
	
	JButton submitButton = new JButton("Submit");
    submitButton.setBounds(200, 350, 100, 30);
    f.add(submitButton);
	
	submitButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String instituteName=t1.getText();
			int num = Integer.parseInt(t2.getText().trim());
			int ag= Integer.parseInt(t3.getText().trim());
			String choice=c.getSelectedItem();
			String selectedAni="";
			if(c1.isSelected())
				selectedAni+="Endangered species";
			if(c2.isSelected())
				selectedAni+=" Endemic species";
			if(c3.isSelected())
				selectedAni+=" Wild species";
			 System.out.println("Institute Name: " + instituteName);
                System.out.println("Number of Students: " + num);
                System.out.println("Selected Animals: " + selectedAni);
				System.out.println("Animal chosen for study: " + choice);
				if(ag<10 && selectedAni.contains("Wild species"))
					System.out.println("Age is under required criteria");
				System.out.println("Thank You!");
				JOptionPane.showMessageDialog(null, "Thank You!");
                   f.dispose();
                   System.exit(0);

				
		}
	});
}
}