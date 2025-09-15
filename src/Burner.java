/**
 * Burner class
 * Holds the temperature, setting, and timer values for the burner. A burner can be set through its plusButton() and
 * minuxButton() methods. When updateTemperature() is called, the burner's temperature will update based on how
 * long it has been at a particular setting.
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
		switch (this.mySetting) {
		case Setting.OFF:
			mySetting = Setting.LOW;
			break;
		case Setting.LOW:
			mySetting = Setting.MEDIUM;
			break;
		case Setting.MEDIUM:
			mySetting = Setting.HIGH;
			break;
		case Setting.HIGH:
			break;
		}
		timer = TIME_DURATION;
	}

	public void minusButton() {
		switch (this.mySetting) {
		case Setting.HIGH:
			this.mySetting = Setting.MEDIUM;
			break;
		case Setting.MEDIUM:
			this.mySetting = Setting.LOW;
			break;
		case Setting.LOW:
			this.mySetting = Setting.OFF;
			break;
		case Setting.OFF:
			break;
		}
		timer = TIME_DURATION;
	}

	public void updateTemperature() { // Increases, decreases, or stays the same based off of both temp and setting.
		timer--;
		if (timer <= 0) {
			timer = 0;
			switch (this.mySetting) {
			case Setting.OFF:
				if (myTemperature == Temperature.BLAZING) {
					myTemperature = Temperature.HOT;
					timer = TIME_DURATION;
				}
				else if (myTemperature == Temperature.HOT) {
					myTemperature = Temperature.WARM;
					timer = TIME_DURATION;
				}
				else if (myTemperature == Temperature.WARM) {
					myTemperature = Temperature.COLD;
				}
				break;
			case Setting.LOW:
				if (myTemperature == Temperature.COLD) {
					myTemperature = Temperature.WARM;
				}
				else if (myTemperature == Temperature.HOT) {
					myTemperature = Temperature.WARM;
				}
				else if (myTemperature == Temperature.BLAZING) {
					myTemperature = Temperature.HOT;
					timer = TIME_DURATION;
				}
				break;
			case Setting.MEDIUM:
				if (myTemperature == Temperature.COLD) {
					myTemperature = Temperature.WARM;
					timer = TIME_DURATION;
				}
				else if (myTemperature == Temperature.WARM) {
					myTemperature = Temperature.HOT;
				}
				else if (myTemperature == Temperature.BLAZING) {
					myTemperature = Temperature.HOT;
				}
				break;
			case Setting.HIGH:
				if (myTemperature == Temperature.COLD) {
					myTemperature = Temperature.WARM;
					timer = TIME_DURATION;
				}
				else if (myTemperature == Temperature.WARM) {
					myTemperature = Temperature.HOT;
					timer = TIME_DURATION;
				}
				else if (myTemperature == Temperature.HOT) {
					myTemperature = Temperature.BLAZING;
				}
				break;
			}
		}
	}
	
	public void display() {
		System.out.print("[" + this.mySetting + "].....");
		switch (this.myTemperature) {
		case Temperature.BLAZING:
			System.out.println("VERY HOT! DON'T TOUCH");
			break;
		case Temperature.HOT:
			System.out.println("CAREFUL");
			break;
		case Temperature.WARM:
			System.out.println("warm");
			break;
		case Temperature.COLD:
			System.out.println("cooool");
			break;
		}
	}

	public Temperature getTemperature() {
		return myTemperature;
	}
}
