package Main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void compareAvg(int[]... arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int[] currentArr = arr[i];
            int currentAVG = Arrays.stream(currentArr).sum() / currentArr.length;
            map.put(i, currentAVG);
        }
        Integer maxAVG = map.values().stream().max(Integer::compare).get();
        if (map.values().stream().filter(x -> x.equals(maxAVG)).count() == arr.length) {
            System.out.println("Средние значения равны");
        }else {
            map.entrySet().stream()
                    .filter(x->x.getValue().equals(maxAVG))
                    .forEach(x -> System.out.printf("список №%d имеет наибольшее среднее значение  = %d\n", x.getKey()+1, x.getValue()));
        }

    }


}
