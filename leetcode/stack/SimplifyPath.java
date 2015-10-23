package stack;

import java.util.Stack;

public class SimplifyPath {
	public String simplifyPath(String path) {
		String[] paths = path.split(".");
		
		Stack<String> pathcollection = new Stack();
		StringBuilder subpath = new StringBuilder();
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == '.') {
				subpath.append('.');
				for (int j = i + 1; j < path.length(); j++) {
					if (path.charAt(j) == '.') {
						subpath.append('.');
						i++;
					} else
						break;

				}
				if (subpath.length() == 1) {
					if (i == path.length() - 1)
						subpath.delete(0, subpath.length());
					else if (path.charAt(i + 1) != '/')
						continue;
					else
						subpath.delete(0, subpath.length());
				} else if (subpath.length() == 2) {
					if (i == path.length() - 1) {
						subpath.delete(0, subpath.length());
						if (!pathcollection.isEmpty())
							pathcollection.pop();
					} else if (path.charAt(i + 1) != '/') {
						continue;
					} else {
						subpath.delete(0, subpath.length());
						if (!pathcollection.isEmpty())
							pathcollection.pop();
					}
				} else
					continue;

			} else if (path.charAt(i) == '/') {
				if (subpath.length() != 0) {
					pathcollection.add(subpath.toString());
					subpath.delete(0, subpath.length());
				}
				continue;
			} else {
				subpath.append(path.charAt(i));
			}
		}
		if (subpath.length() > 0)
			pathcollection.add(subpath.toString());
		StringBuilder ret = new StringBuilder();
		if (pathcollection.empty())
			return "/";
		while (!pathcollection.empty()) {
			ret.insert(0, "/" + pathcollection.pop());
		}
		return ret.toString();
	}

	public String simplifyPath2(String path) {
		Stack<String> stack = new Stack();
		String[] paths = path.split("/");
		for (int i = 0; i < paths.length; i++) {
			if (paths[i].equals("."))
				continue;
			else if (paths[i].equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else if (!paths[i].isEmpty()) {
				stack.push(paths[i]);
			}
		}

		if (stack.isEmpty())
			return "/";
		else {
			StringBuilder sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.insert(0, "/" + stack.pop());
			}
			return sb.toString();
		}
	}

	public String simplifyPath3(String path) {
		Stack<String> stack = new Stack();
		String[] paths = path.split("/");
		for (int i = 1; i < paths.length; i++) {
			if (paths[i].equals("."))
				continue;
			else if (paths[i].equals("..")) {
				if (stack.isEmpty())
					continue;
				else
					stack.pop();
			} else if (paths[i].length() > 0) {
				stack.push(paths[i]);
			}
		}
		if (stack.isEmpty())
			return "/";
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, "/" + stack.pop());
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		SimplifyPath test = new SimplifyPath();
		// System.out.println(test.simplifyPath2("/a/./b/../../c/"));
		// System.out.println(test.simplifyPath2("/home//foo/"));
		// System.out.println(test.simplifyPath2("/.../"));
		// System.out.println(test.simplifyPath2("/a/j/b/t/e/c/"));
		System.out.println(test.simplifyPath3("/."));
	}
}
