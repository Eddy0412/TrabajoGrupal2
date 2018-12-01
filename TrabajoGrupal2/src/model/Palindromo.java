package model;

public class Palindromo {

	private String insertedWord;
	
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
	
	public boolean isPalindromo() {
		 
		String strInvertido="";
 
		   for(int i=insertedWord.length()-1; i >=0; i--) 
		       strInvertido+= insertedWord.charAt(i);

		   if(insertedWord.equals(strInvertido)) 
		     return true; /* es un palindromo */ 
		   
		return false;
		
	}
	
	
}
