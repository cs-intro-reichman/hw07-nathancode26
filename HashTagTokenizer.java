

public class HashTagTokenizer {

	public static void main(String[] args) {
		String hashtag = args[0];
		String []dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashtag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i=0;i<3000;i++) {
			dictionary[i] = in.readLine();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String []dictionary) {
		int rows=dictionary.length;
		for(int i=0;i<rows;i++){
			String s =dictionary[i];
			if (word.equals(s)){
				return true;
			}
		}
		// Your code here
	return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {

		// Base case: do nothing (return) if hashtag is an empty string.
        if (hashtag.isEmpty()) {
            return;
        }
        int N = hashtag.length();
        for (int i = 1; i <= N; i++) {
			String current=hashtag.substring(0,i);
			if (existInDictionary(current,dictionary)){
				System.out.println(current);
				breakHashTag(hashtag.substring(current.length()),dictionary);
				break;
			}
        }
		breakHashTag("",dictionary);
    }
}
