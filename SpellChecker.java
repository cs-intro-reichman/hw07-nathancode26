
public class SpellChecker {


	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
		//System.out.println(levenshtein("spell","SPELL"));

	}

	public static String tail(String str) {
		return str.substring(1);
		// Your code goes here
	}
	public static Boolean check(char a,char b){
		if ( a!=b && a!=b+32 && a!=b-34){
			return false;
		}
		return true;

	}


	public static int levenshtein(String word1, String word2) {

		if(word1.isEmpty()){
			return word2.length();
		}
		if (word2.isEmpty()){
			return word1.length();
		}
		if (check(word1.charAt(0),word2.charAt(0))){
			return levenshtein(tail(word1),tail(word2));
		}
		else{
			return 1+Math.min(levenshtein(tail(word1),word2),Math.min(levenshtein(tail(word1),tail(word2)),levenshtein(word1,tail(word2))));
		}

		// Your code goes here
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i=0;i<3000;i++) {
			dictionary[i] = in.readLine();
		}
		return dictionary;
		// Your code here
	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		String s = null;
		int best_diff=word.length();
		int dif_current=word.length();
		for(int i=1;i<dictionary.length;i++){
			dif_current=levenshtein(word,dictionary[i]);
			int lengthDifference = Math.abs(word.length() - dictionary[i].length());
			if (dif_current<=threshold && dif_current<best_diff){
					s=dictionary[i];
					best_diff=dif_current;
				}
			else if(s!=null && dif_current==best_diff && lengthDifference<Math.abs(word.length()-s.length())){
				s=dictionary[i];
			}
		}
		// Your code goes here
		return (s!=null)?s:word;
	}

}
