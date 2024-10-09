package edu.uoc.test.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntFunction;

public class FunctionUtils {

    // Función periódica (x mod 4)^2
    public static final IntFunction<Integer> periodicFunction =  x -> (int) Math.pow(x % 4, 2);

    public static List<Integer> generateValues(IntFunction<Integer> function, int count) {
        List<Integer> values = new ArrayList<>();
        for (int x = 1; x <= count; x++) {
            values.add(function.apply(x));
        }
        return values;
    }
}