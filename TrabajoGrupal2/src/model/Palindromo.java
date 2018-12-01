package model;

public class Palindromo {

	private String insertedWord;
	String reversed = "";
	
	public Palindromo(String inputWord) {
/*		super();*/
		this.setInsertedWord(inputWord);
	}

	public String getInsertedWord() {
		return insertedWord;
	}

	public void setInsertedWord(String insertedWord) {
		this.insertedWord = insertedWord;
	}
}
