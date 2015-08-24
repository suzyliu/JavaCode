public enum Suit{
	Club(0),Diamond(1),Heart(2),Spade(3);
	private int value;
	private int Suit(int v) {value = v;}
	
	public int getValue(){ return value;}
// 	public static Suit getSuitFromValue(int value){}
}

public abstract class Card {

	private boolean available = true;

	protected int faceValue;
	protected Suit suit;

	public Card(int c, Suit s){

		faceValue = c;
		Suit = s;
	}
	public abstract int value();
	public Suit suit(){ return suit;}
	public boolean isAvailable(){ return available; }
	public void makeUnavailable(){ available = false; };
	public void makeAvailable(){ available = true; };
	
}