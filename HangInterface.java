/*
HangInterface

created by Alec Reyerson
Nov 2, 2016

Description: A class that will hold basic game logic and states that will be accessed by both client handlers
*/

import java.io.*;
import java.util.*;
import java.lang.*;

public class HangInterface {

	private String word = "";
	private char[] letters = null;
	private char[] guess = null;
	private int chances = 100;
		

	public HangInterface() {}

	private void useChance()
	{
		chances = chances -1;    //Decrements chances
	}

	public char[] guessLetter(char letter)
	{
		for(int i = 0; i<word.length(); ++i)
		{
			if(Character.toLowerCase(letters[i])==Character.toLowerCase(letter))
			{
				guess[i] = letters[i];
			}
		}

		useChance();

		return guess;
	}

	public void setWord(String _word)
	{
		this.word = _word;
		this.letters = word.toCharArray();
		this.guess = new char[word.length()];


		for(int i = 0; i < word.length(); ++i)
		{			
			guess[i] = '_';
		}

		if(word.length()<7)
		{
			this.chances = 6;            //Establishes the number of chances the user will have to guess the word based on the word length
		} 
		else
		{
			this.chances = word.length();
		}

			
	}

	public int getChances()
	{
		return this.chances;
	}

	public boolean isGuessed()
	{
		String guessed = new String(guess).toLowerCase();
		String wordLower = word.toLowerCase();

		if(guessed.equals(wordLower))
		{
			return true;   //If the guess array and letters array are equal then the word has been guessed and isGuessed() returns true
		}
		else
		{
			return false;
		}

	}

	public char[] getGuess()
	{
		return this.guess;
	}

	public String getWord()
	{
		return this.word;
	}


	
}
