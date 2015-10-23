package hashtable;

import java.util.HashMap;
import java.util.Map.Entry;

public class MaxPointsonaLine {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0)
			return 0;
		int globalMax = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<Double, Integer> map = new HashMap();
			int samePoint = 0;
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y)
						samePoint++;
					else {
						if (map.containsKey((double) Integer.MAX_VALUE))
							map.put((double) Integer.MAX_VALUE,
									map.get((double) Integer.MAX_VALUE) + 1);
						else
							map.put((double) Integer.MAX_VALUE, 2);
					}
				} else {
					double k = (points[i].y - points[j].y)
							/ ((double) (points[i].x - points[j].x));
					if (map.containsKey(k)) {
						map.put(k, map.get(k) + 1);
					} else
						map.put(k, 2);
				}
			}
			int max = 1;
			for (Entry<Double, Integer> entry : map.entrySet()) {
				if (entry.getValue() > max)
					max = entry.getValue();
			}
			max+=samePoint;
			if (max > globalMax)
				globalMax = max;
		}

		return globalMax;
	}

	public static void main(String[] args) {
		MaxPointsonaLine test = new MaxPointsonaLine();
		Point[] points = new Point[4];
		points[0] = new Point(0, 0);
		points[1] = new Point(0, 0);
		points[2] = new Point(1, 1);
		points[3] = new Point(1, 1);

		System.out.println(test.maxPoints(points));
	}
}
