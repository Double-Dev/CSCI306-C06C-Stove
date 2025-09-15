/**
 * Setting enum
 * An enum that relates a string value to a particular setting.
 * 
 * @author Deven Layton
 * @author Joseph Chamberlain
 * Date: 9/15/2025
 * Collaborators: N/A
 * Sources: N/A
 */
public enum Setting {
	OFF("---"), LOW("--+"),	MEDIUM("-++"), HIGH("+++");
	private String value;

	private Setting(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value;
	}
}
