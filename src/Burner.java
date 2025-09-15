/**
 * Burner class
 * 
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/15/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public class Burner {
	enum Temperature { BLAZING, HOT, WARM, COLD };
	public static final int TIME_DURATION = 2;
	
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	
	public Burner() {
		this.myTemperature = Temperature.COLD;
		this.mySetting = Setting.OFF;
		this.timer = 0;
	}

	public void plusButton() {
		// TODO Implement method
	}

	public void minusButton() {
		// TODO Implement method
	}

	public void updateTemperature() {
		// TODO Implement method
	}
	
	public void display() {
		// TODO Implement method
	}
}
