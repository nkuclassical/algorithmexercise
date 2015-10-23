package hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		Map<String, Integer> record = new HashMap<String, Integer>();
		List<String> ret = new ArrayList();
		for (int i = 0; i < s.length() - 9; i++) {
			String substring = s.substring(i, i + 10);
			if (record.containsKey(substring)) {
				int tempnum = record.get(substring);
				if (tempnum == 2)
					continue;
				else {
					ret.add(substring);
					record.put(substring, tempnum + 1);
				}
			} else {
				record.put(substring, 1);
			}
		}
		return ret;
	}

	public List<String> findRepeatedDnaSequences2(String s) {
		Set<String> first = new HashSet<String>();
		Set<String> second = new HashSet<String>();
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < s.length() - 9; i++) {
			String substring = s.substring(i, i + 10);
			if (!first.add(substring) && second.add(substring)) {
				ret.add(substring);
			}
		}
		return ret;
	}

	public static void main(String[] args) {
		RepeatedDNASequences test = new RepeatedDNASequences();
		List<String> ret = test
				.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
		for (String item : ret) {
			System.out.println(item);
		}
	}
}
