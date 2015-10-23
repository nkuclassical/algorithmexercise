package string;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> ret = new ArrayList();
		List<String> curlist = new ArrayList();
		int len = 0;
		if (maxWidth == 0) {
			for (int i = 0; i < words.length; i++)
				ret.add(words[i]);
			return ret;
		}
		for (int i = 0; i < words.length;) {
			if (words[i].length() == 0) {
				curlist.add(words[i]);
				i++;
				continue;
			}
			if (curlist.isEmpty()) {
				curlist.add(words[i]);
				len += words[i].length();
				i++;
			} else if (len + words[i].length() + 1 <= maxWidth) {
				curlist.add(words[i]);
				len += words[i].length() + 1;
				i++;
			} else {
				StringBuilder sb = new StringBuilder();
				int needblank = maxWidth - len;
				int eachblank, addblank;
				if (curlist.size() > 1) {
					eachblank = needblank / (curlist.size() - 1);
					addblank = needblank % (curlist.size() - 1);
					for (int j = 0; j < addblank; j++) {
						sb.append(curlist.get(j) + "  ");
						for (int t = 0; t < eachblank; t++)
							sb.append(" ");
					}
					for (int j = addblank; j < curlist.size() - 1; j++) {
						sb.append(curlist.get(j) + " ");
						for (int t = 0; t < eachblank; t++)
							sb.append(" ");
					}
					sb.append(curlist.get(curlist.size() - 1));

				} else {
					eachblank = needblank;
					sb.append(curlist.get(0));
					for (int j = 0; j < eachblank; j++)
						sb.append(" ");

				}
				ret.add(sb.toString());
				sb.delete(0, sb.length());
				len = 0;
				curlist.clear();
			}
		}

		if (curlist.size() > 0) {
			StringBuilder sb = new StringBuilder();
			int needblank = maxWidth - len;
			for (int i = 0; i < curlist.size() - 1; i++)
				sb.append(curlist.get(i) + " ");
			sb.append(curlist.get(curlist.size() - 1));
			for (int i = 0; i < needblank; i++)
				sb.append(" ");
			ret.add(sb.toString());

		}
		return ret;
	}

	public static void main(String[] args) {
		TextJustification test = new TextJustification();
		// String[]words=new String[7];
		// String[] words = { "This", "is", "an", "example", "of", "text",
		// "justification." };
		String[] words = { "1" };
		List<String> result = test.fullJustify(words, 2);
		for (String r : result)
			System.out.println(r);
	}
}
