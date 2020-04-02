
public class Token {
	public int value=-1;

	public Token(int value) {
		super();
		this.value = value;
	}
	
	public Token() {
		super();
		this.value = -1;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
