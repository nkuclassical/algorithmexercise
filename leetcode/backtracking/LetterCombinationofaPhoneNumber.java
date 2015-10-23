package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationofaPhoneNumber {
	List<String> ret = new ArrayList();

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0)
			return null;
		List<List<Character>> letter = new ArrayList();
		List<Character> button2 = new ArrayList();
		button2.add('a');
		button2.add('b');
		button2.add('c');
		letter.add(button2);
		letter.addAll(new ArrayList(button2));

		List<Character> button3 = new ArrayList();
		button3.add('d');
		button3.add('e');
		button3.add('f');
		letter.add(button3);
		List<Character> button4 = new ArrayList();
		button4.add('g');
		button4.add('h');
		button4.add('i');
		letter.add(button4);
		List<Character> button5 = new ArrayList();
		button5.add('j');
		button5.add('k');
		button5.add('l');
		letter.add(button5);
		List<Character> button6 = new ArrayList();
		button6.add('m');
		button6.add('n');
		button6.add('o');
		letter.add(button6);
		List<Character> button7 = new ArrayList();
		button7.add('p');
		button7.add('q');
		button7.add('r');
		button7.add('s');
		letter.add(button7);
		List<Character> button8 = new ArrayList();
		button8.add('t');
		button8.add('u');
		button8.add('v');
		letter.add(button8);
		List<Character> button9 = new ArrayList();
		button9.add('w');
		button9.add('x');
		button9.add('y');
		button9.add('z');
		letter.add(button9);

		List<List<Character>> curletter = new ArrayList();
		for (int i = 0; i < digits.length(); i++) {
			int cur = digits.charAt(i) - '0';
			if (cur == 1 || cur == 0)
				return ret;
			curletter.add(letter.get(cur - 2));
		}
		helper(curletter, new StringBuilder());
		return ret;
	}

	public void helper(List<List<Character>> letter, StringBuilder prefix) {
		if (letter.size() == 0) {
			ret.add(prefix.toString());
			return;
		}
		List<Character> first = letter.get(0);
		for (int i = 0; i < letter.get(0).size(); i++) {
			prefix.append(letter.get(0).get(i));
			letter.remove(0);
			helper(letter, prefix);
			prefix.deleteCharAt(prefix.length() - 1);
			letter.add(0, first);
		}
	}

	String[][]set={{},{},{"a","b","c"},{"d","e","f"},{"g","h","i"},
			{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
	public List<String>letter(String s){
		List<String>ret=new ArrayList();
		helper(ret,s,new String());
		
		return ret;
	}
	public void helper(List<String>ret,String s,String prefix){
		if(s==null||s.length()==0){
			ret.add(new String(prefix));
			return;
		}
		int index=s.charAt(0)-'0';
		for(int i=0;i<set[index].length;i++){
			helper(ret,s.substring(1),prefix+set[index][i]);
		}
	}
	

	public static void main(String[] args) {
		LetterCombinationofaPhoneNumber test = new LetterCombinationofaPhoneNumber();
//		List<String> result = test.letterCombinations("");
		List<String>result=test.letter("23");
		for (String r : result) {
			System.out.println(r);
		}
	}
}
