import java.util.HashMap;
import java.util.Map;

public class Dominos{
     //s30
    //o(n) and o(1) 
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> map = new HashMap<>();
        int target = 0;
        for(int i = 0;i <tops.length; i++){
            map.put(tops[i], map.getOrDefault(tops[i],0)+1);
            if(tops.length == map.get(tops[i])){
                target = tops[i];
                break;
            }

            map.put(bottoms[i], map.getOrDefault(bottoms[i],0)+1);
            if(bottoms.length == map.get(bottoms[i])){
                target = bottoms[i];
                break;
            }
        }
        int topRot = 0, bottomRot = 0;
        for(int i = 0; i < tops.length; i++){
            if(tops[i] != target && bottoms[i] != target){
                return -1;
            }
            else if(tops[i] != target){
                topRot++;
            }else if(bottoms[i] != target){
                bottomRot++;
            }
        }



        return Math.min(topRot, bottomRot);
    }
}