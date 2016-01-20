import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Electricity_Cost_Applet extends JApplet {
	
	public void init() {
	JTextField computercost = new JTextField(); // This makes a text field, where the user can input numbers.
	JLabel computercost_q = new JLabel ("What is the cost of the computer? (dollars)"); // This displays text, we ask questions with this.

	String[] laptoptype_choices = {"Laptop","Desktop"}; //This defines the choices in the drop down box.
	JComboBox laptoptype = new JComboBox(laptoptype_choices); // This creates a drop down box.
	JLabel laptoptype_q = new JLabel ("Computer type");

	String[] screensize_choices = {"15''", "17''","19''", "20''","21''","22''","24''","30''","32''","37''","42''","50''"};
	JComboBox screensize = new JComboBox(screensize_choices);
	JLabel screensize_q = new JLabel ("Screen size");

	String[] corenumber_choices = {"1 Core","2 Cores","3 Cores","4 Cores","5 Cores","6 Cores","7 Cores","8 Cores"};
	JComboBox corenumber = new JComboBox(corenumber_choices);
	JLabel corenumber_q = new JLabel ("Number of cores");

	String[] brandOfCPU_choices = {"Intel Low End","Intel Mid End","Intel High End","Intel Top End","AMD Low End","AMD Mid End","AMD High End"};
	JComboBox brandOfCPU = new JComboBox(brandOfCPU_choices);
	JLabel brandOfCPU_q = new JLabel ("Brand of CPU");

    String[] ramTypes_choices = {"DDR1 RAM","DDR2 RAM","DDR3 RAM" };
	JComboBox ramTypes = new JComboBox(ramTypes_choices);
	JLabel ramTypes_q = new JLabel ("RAM type");

    String[] hardDrive_choices = {"Solid State Drive SSD","2.5'' Hard Disk Drive HHD","3.5'' Hard Disk Drive HHD" };
	JComboBox hardDrive = new JComboBox(hardDrive_choices);
	JLabel hardDrive_q = new JLabel ("Hard Drive");

    String[] state_choices = {"CA","CT","D.C.","FL","IL","MA","NH","NJ","NC","TX","United States","Canada","Hong Kong","India","Mexico","Singapore","United Kingdom" };
	JComboBox state = new JComboBox(state_choices);
	JLabel state_q = new JLabel ("Where do you live?");

	JTextField computerKeep = new JTextField();
	JLabel computerKeep_q = new JLabel ("How long do you expect to keep the computer? (years)");

	JTextField powerOn = new JTextField();
	JLabel powerOn_q = new JLabel ("How many hours a day do you leave the power on?");
	
	JButton calculate = new JButton("Calculate"); // This creates a button.
	
	JLabel emptyspace = new JLabel (""); //This creates an empty space, so the GUI looks nice.
	JLabel computer_costcalculations = new JLabel (""); //This creates a text. When the calculate button is clicked, the text will change.
	JLabel electricity_costcalculations = new JLabel ("");
	JLabel battery_costcalculations = new JLabel ("");
	JLabel total_costcalculations = new JLabel ("");
	
	// In the original program, we had created a frame in this space. Since this is an applet, we do not need a frame, we can just add the panel directly to the applet.
	// We deleted all the code with frames.
	
	JPanel p = new JPanel(new GridLayout(0,2)); //We must make a panel. The Gridlayout allows us to organize the features in two columns.
	p.add(computercost_q); // On the panel, we add the different features (JLabel, JComboBox, JButton, etc.)
	p.add(computercost);
	p.add(laptoptype_q);
	p.add(laptoptype);
	p.add(screensize_q);
	p.add(screensize);
	p.add(corenumber_q);
	p.add(corenumber);
	p.add(brandOfCPU_q);
	p.add(brandOfCPU);
	p.add(ramTypes_q);
	p.add(ramTypes);
	p.add(hardDrive_q);
	p.add(hardDrive);
	p.add(state_q);
	p.add(state);
	p.add(computerKeep_q);
	p.add(computerKeep);
	p.add(powerOn_q);
	p.add(powerOn);
	p.add(calculate);
	p.add(emptyspace);
	p.add(computer_costcalculations);
	p.add(electricity_costcalculations);
	p.add(battery_costcalculations);
	p.add(total_costcalculations);


	add(p); // We add the panel to the applet.
	
	calculate.addActionListener(new ActionListener () { //When the button is clicked...
		public void actionPerformed (ActionEvent e) {
			String laptoptype_s = laptoptype.getSelectedItem().toString(); // Obtain the answer choice from the drop down box.
			String screensize_s = screensize.getSelectedItem().toString();
			String corenumber_s = corenumber.getSelectedItem().toString();
			String brandOfCPU_s = brandOfCPU.getSelectedItem().toString();
			String ramTypes_s = ramTypes.getSelectedItem().toString();
			String hardDrive_s = hardDrive.getSelectedItem().toString();
			String state_s = state.getSelectedItem().toString();
			
			String computercost_s = computercost.getText();	// Obtain the input in the text field as a string.		
			double computercost_n = Double.parseDouble(computercost_s); // This converts the string into a double.
			computercost_n = ((int)(computercost_n*100))/100.0; // This rounds the variable to the 2nd decimal point.

			String powerOn_s = powerOn.getText();			
			double powerOn_n = Double.parseDouble(powerOn_s);
			
			String computerKeep_s = computerKeep.getText();			
			double computerKeep_n = Double.parseDouble(computerKeep_s);
			
			double watts = 0; // Create a variable and add to this variable when if statements are met.
			double region = 0; //create an empty variable that will be filled with the multiplier based on selected state

			//if statements that connect the dropdown list items to the corresponding watt usage data gathered through research
			//adds to the variable "watts" to generate the sum of all selected choices
			if (laptoptype_s.equals("Desktop")){	
				watts = watts + 120;}
			if (laptoptype_s.equals("Laptop")){
				watts = watts + 35;}
			if (screensize_s.equals("15''")){
				watts = watts + 18;}
			if (screensize_s.equals("17''")){
				watts = watts + 20;}
			if (screensize_s.equals("19''")){
				watts = watts + 22;}
			if (screensize_s.equals("20''")){
				watts = watts + 26;}
			if (screensize_s.equals("21''")){
				watts = watts + 30;}
			if (screensize_s.equals("22''")){
				watts = watts + 40;}
			if (screensize_s.equals("24''")){
				watts = watts + 50;}
			if (screensize_s.equals("30''")){
				watts = watts + 60;}
			if (screensize_s.equals("32''")){
				watts = watts + 70;}
			if (screensize_s.equals("37''")){
				watts = watts + 80;}
			if (screensize_s.equals("42''")){
				watts = watts + 120;}
			if (screensize_s.equals("50''")){
				watts = watts + 150;}
			if (corenumber_s.equals("1 Core")){
				watts = watts + 69;}
			if (corenumber_s.equals("2 Cores")){
				watts = watts + 74.5;}
			if (corenumber_s.equals("3 Cores")){
				watts = watts + 80;}
			if (corenumber_s.equals("4 Cores")){
				watts = watts + 86;}
			if (corenumber_s.equals("5 Cores")){
				watts = watts + 86;}
			if (corenumber_s.equals("6 Cores")){
				watts = watts + 86.5;}
			if (corenumber_s.equals("7 Cores")){
				watts = watts + 86.5;}
			if (corenumber_s.equals("8 Cores")){
				watts = watts + 86.5;}
			if (brandOfCPU_s.equals("Intel Low End")){
				watts = watts + 64;}
			if (brandOfCPU_s.equals("Intel Mid End")){
				watts = watts + 84;}
			if (brandOfCPU_s.equals("Intel High End")){
				watts = watts + 86;}
			if (brandOfCPU_s.equals("Intel Top End")){
				watts = watts + 104;}
			if (brandOfCPU_s.equals("AMD Low End")){
				watts = watts + 80;}
			if (brandOfCPU_s.equals("AMD Mid End")){
				watts = watts + 95;}
			if (brandOfCPU_s.equals("AMD High End")){
				watts = watts + 110;}
			if (ramTypes_s.equals("DDR1 RAM")){
				watts = watts + 4.75;}
			if (ramTypes_s.equals("DDR2 RAM")){
				watts = watts + 3.75;}
			if (ramTypes_s.equals("DDR3 RAM")){
				watts = watts + 2.5;}
			if (hardDrive_s.equals("Solid State Drive SSD")){
				watts = watts + 1.7;}
			if (hardDrive_s.equals("2.5'' Hard Disk Drive HHD")){
				watts = watts + 1.85;}
			if (hardDrive_s.equals("3.5'' Hard Disk Drive HHD")){
				watts = watts + 7.75;}
			
			//sets the region variable equal to a multiplier based on the electricity cost of the selected region
			if (state_s.equals("CA")){
				region = 0.135;}
			if (state_s.equals("CT")){
				region = 0.155;}
			if (state_s.equals("D.C.")){
				region = 0.119;}
			if (state_s.equals("FL")){
				region = 0.104;}
			if (state_s.equals("IL")){
				region = 0.084;}
			if (state_s.equals("MA")){
				region = 0.138;}
			if (state_s.equals("NH")){
				region = 0.142;}
			if (state_s.equals("NJ")){
				region = 0.137;}
			if (state_s.equals("NC")){
				region = 0.0915;}
			if (state_s.equals("TX")){
				region = 0.0855;}
			if (state_s.equals("USA")){
				region = 0.0984;}
			if (state_s.equals("Canada")){
				region = 0.0905;}
			if (state_s.equals("Hong Kong")){
				region = 0.1801;}
			if (state_s.equals("India")){
				region = 0.1;}
			if (state_s.equals("Mexico")){
				region = 0.1928;}
			if (state_s.equals("Singapore")){
				region = 0.2153;}
			if (state_s.equals("United Kingdom")){
				region = 0.2;}
			
			double electricityCost = (watts/1000)*powerOn_n*computerKeep_n*365*region; // This is our formula for the electricity cost.
			electricityCost = ((int)(electricityCost*100))/100.0;
			
			//formula for the battery cost. Divides the intended life of the computer by how often the battery needs to be replaced,
			//rounds up (because you can't have half of a battery), subtracts 1 for the battery that comes with the computer, multiples by the cost of replacement battery
			double batteryCost= 0;
			if (laptoptype_s.equals("Desktop")){
				batteryCost = ((Math.ceil(computerKeep_n/4))-1)*7;}
			if (laptoptype_s.equals("Laptop")){
				batteryCost = ((Math.ceil(computerKeep_n/3))-1)*275;}
			
			double totalCost = computercost_n + electricityCost + batteryCost;
			totalCost = ((int)(totalCost*100))/100.0;
			
			computer_costcalculations.setText("Computer Cost: $" + computercost_n); // Set the text in the JLabel to this.
			electricity_costcalculations.setText("Electricity Cost: $" + electricityCost);
			battery_costcalculations.setText("Battery Cost: $" + batteryCost);
			total_costcalculations.setFont(new Font("Calibri", Font.BOLD, 16));
			total_costcalculations.setText("Total Cost: $" + totalCost);
	
		}
	});
	
	}
	
}
