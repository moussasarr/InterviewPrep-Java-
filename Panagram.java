public class Panagram {

 public static void main(String[] args) {
	 char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			 'x', 'y', 'z'
	 };
	 String sentenceString = "The quick red fox jumps over the lazy brown dog";
	 char[] sentenceToTest = toCharArray(sentenceString);
     int numOfMissingLetters = 0;
     char[] missingLetters = new char[26];
	 for(int i = 0; i < alphabet.length; i++) {
		// System.out.println(isFound('\n', sentenceToTest));
		 if(!isFound(alphabet[i], sentenceToTest)) {
			 missingLetters[numOfMissingLetters] = alphabet[i];
			 numOfMissingLetters ++;
		 }
	 }
	 if(numOfMissingLetters == 0) {
		 System.out.println("\'"+ sentenceString.toString() +"\'"+ ' ' + "is an Anagram");
	 }
 }

 static Boolean isFound(char letter, char[] aSentence) {
	 Boolean found = false;
	 int iterator = 0;
	 while(!found) {
		 if(letter == aSentence[iterator]) {
			 found = true;
		 }

		 if(iterator == aSentence.length -1 ) {
			 break;
		 }
		 iterator++;
	 }
	 return found;
 }


 static char[] toCharArray(String sentence){
	 int sentenceLength = sentence.length();
	 char[] returnArray = new char[sentenceLength];
	 for(int i = 0; i < sentenceLength; i++) {
		returnArray[i] = sentence.charAt(i);
	 }
	 return returnArray;
 }








}
