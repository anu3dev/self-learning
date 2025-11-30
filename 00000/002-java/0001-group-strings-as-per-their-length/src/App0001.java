import java.util.*;
import java.util.stream.Collectors;

public class App0001 {
    public static void main(String[] args) throws Exception {
        List<String> fruitArrayList = new ArrayList<>(
            Arrays.asList("banana", "apple", "papaya", "pear", "kiwi", "papaya")
        );

        System.out.println(fruitArrayList);



        // remocing duplicate value from array list through hash set.
        Set<String> fruitSet1 = new HashSet<>();

        for(String f : fruitArrayList){
            fruitSet1.add(f);
        }

        System.out.println(fruitSet1);



        // count size of string through hash map.
        Map<Integer, List<String>> fruitMap1 = new HashMap<>();

        for(String f : fruitSet1){
            if(!fruitMap1.containsKey(f.length())){
                fruitMap1.put(f.length(), new ArrayList<>());
            }
            fruitMap1.get(f.length()).add(f);
        }

        System.out.println(fruitMap1);



        // count size of string through lambda.
        Map<Integer, List<String>> fruitMap2 = 
        fruitSet1.stream().collect(Collectors.groupingBy(String :: length));
          
        System.out.println(fruitMap2);
    }
}
