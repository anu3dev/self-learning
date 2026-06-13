import java.util.*;

public class App0002 {
    public static void main(String[] args) throws Exception {
        String str = "anurag";

        // count char of a string
        Map<Character, Integer> charHashMap = new HashMap<>();

        for(Character c : str.toCharArray()){
            if(!charHashMap.containsKey(c)){
                charHashMap.put(c, 1);
            } else {
                charHashMap.put(c, charHashMap.get(c) + 1);
            }
        }

        System.out.println(charHashMap);



        // get unique char
        List<Character> charArrayList = new ArrayList<>();

        for(Map.Entry<Character, Integer> c : charHashMap.entrySet()){
            if(c.getValue() == 1){
                charArrayList.add(c.getKey());
            }
        }

        System.out.println(charArrayList);
    }
}
