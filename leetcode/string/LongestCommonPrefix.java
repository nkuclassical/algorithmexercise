package string;

public class LongestCommonPrefix {
//	public String longestCommonPrefix(String[] strs) {
//		StringBuilder ret = new StringBuilder();
//		if (strs.length == 0)
//			return ret.toString();
//
//		for (int j = 0; j < strs[0].length(); j++) {
//			char temp = strs[0].charAt(j);
//			for (int i = 1; i < strs.length; i++) {
//				if (j >= strs[i].length() || strs[i].charAt(j) != temp) {
//					return ret.toString();
//				}
//			}
//			ret.append(temp);
//		}
//		return ret.toString();
//	}
//
//	public String commonPrefix(String[] strs) {
//		if (strs == null || strs.length == 0)
//			return null;
//		else if (strs.length == 1)
//			return strs[0];
//		StringBuilder sb = new StringBuilder();
//		for (int i = 0; i < strs[0].length(); i++) {
//			char cur = strs[0].charAt(i);
//			for (int j = 0; j < strs.length; j++) {
//				if (i >= strs[j].length() || strs[j].charAt(i) != cur) {
//					continue;
//				} else {
//					return sb.toString();
//				}
//			}
//			sb.append(cur);
//		}
//		return sb.toString();
//	}
	public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0)return "";
        for(int i=0;i<strs[0].length();i++){
            for(int j=0;j<strs.length;j++){
                if(i>=strs[j].length()||strs[j].charAt(i)!=strs[0].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
