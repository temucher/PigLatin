import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class PigLatin extends PApplet {


public int result = -1;
public void setup() {
	String lines[] = loadStrings("words.txt");
	System.out.println("there are " + lines.length + " lines");
	for (int i = 0 ; i < lines.length; i++) {
	  System.out.println(pigLatin(lines[i]));
	}
}
public void draw()
{
}
public int findFirstVowel(String sWord)
//precondition: sWord is a valid String of length greater than 0.
//postcondition: returns the position of the first vowel in sWord.  If there are no vowels, returns -1
{
	if(sWord.length()>0) {
		for(int i = 0; i<sWord.length(); i++) {
			if((sWord.charAt(i) == 'a')||(sWord.charAt(i) == 'e')||(sWord.charAt(i) == 'i')||(sWord.charAt(i) == 'o')||(sWord.charAt(i) == 'u')) {
				result = i;
				break;
			}
		}
	}
	return result;
}

public String pigLatin(String sWord)
//precondition: sWord is a valid String of length greater than 0
//postcondition: returns the pig latin equivalent of sWord
{
	if(findFirstVowel(sWord) == -1)
	{
		return sWord + "ay";
	}
	if(findFirstVowel(sWord) == 0) {
		return sWord +"way";
	}
	if(sWord.charAt(0)=='q' && sWord.charAt(1)=='u') {
		return sWord.substring(2,sWord.length()) + "quay";
	}
	if(findFirstVowel(sWord)>0) {
		return sWord.substring(result,sWord.length()) + sWord.substring(0,result) + "ay";
	}
	else
	{
		return "ERROR!";
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "PigLatin" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
