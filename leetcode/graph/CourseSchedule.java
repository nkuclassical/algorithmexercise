package graph;

import java.util.HashSet;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] pre) {
        HashSet<Integer>set=new HashSet();
        boolean[]explored=new boolean[numCourses];
        for(int i=0;i<pre.length;i++){
            int cour=pre[i][0];
            if(!explored[cour]){
                if(!findCircle(pre,cour,explored,set))return false;
            }
        }
        return true;
    }
    public boolean findCircle(int[][]pre,int target, boolean[]explored,HashSet<Integer>set){
        if(set.contains(target))return false;
        set.add(target);
        for(int[]pairs:pre){
            if(pairs[1]==target&&!explored[pairs[0]]){
                if(findCircle(pre,pairs[0],explored,set)==false)return false;
            }
        }
        explored[target]=true;
        set.remove(target);
        return true;
    }
}
