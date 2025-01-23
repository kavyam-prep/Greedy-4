import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FormString{
    //tc - o(m + nlogm) sc - o(m)
    public int shortestWay(String source, String target) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int i = 0, j = 0; 
        int n = source.length(), m = target.length();
        for(int k = 0; k < n; k++){
            if(!map.containsKey(source.charAt(k))){
                map.put(source.charAt(k), new ArrayList<>());
            }
            map.get(source.charAt(k)).add(k);
        }
        int count = 0;
        while(j < m){
            char s = source.charAt(i);
            char t = target.charAt(j);
            if(!map.containsKey(t)) return -1;
            if(s == t){
                i++;
                j++;
                if(j == m) return count+1;
            }else{
                List<Integer> targetLoc = map.get(t);
                // int idx = binarySearch(targetLoc, i); 
                // using lib bs 
                int idx = Collections.binarySearch(targetLoc, i);
                if(idx < 0){
                    idx = -idx-1;
                }

                //all rest is same
                if(idx == targetLoc.size()){
                    //one round done 
                    count++;
                    i = 0;
                }else{
                    i = targetLoc.get(idx);
                    if(j == m) return count +1;
                }
            }
            if(i == n){
                count++;
                i= 0;
            }
        }
        return -1;
    }

    public int binarySearch(List<Integer> list, int target){
        int lo = 0, hi = list.size()-1;
        while(lo <= hi){
            int mid = lo + ( hi-lo)/2;
            if(list.get(mid) == target) return mid;
            else if(list.get(mid) > target){
                hi = mid -1;
            }else{
                lo = mid+1;
            }
        }
        return lo;
    }


    //tc - o(m*n) sc - o(n)
    // public int shortestWay(String source, String target) {
    //     Set<Character> set = new HashSet<>();
    //     int i = 0, j = 0; 
    //     for(char c: source.toCharArray()){
    //         set.add(c);
    //     }
    //     int count = 0;
    //     int n = source.length(), m = target.length();
    //     while(j < m){
    //         char s = source.charAt(i);
    //         char t = target.charAt(j);
    //         if(!set.contains(t)) return -1;
    //         if(s == t){
    //             i++;
    //             j++;
    //             if(j == m) return count+1;
    //         }else{
    //             i++;
    //         }
    //         if(i == n){
    //             i = 0;
    //             count++;
    //         }
    //     }
    //     return -1;
    // }
}