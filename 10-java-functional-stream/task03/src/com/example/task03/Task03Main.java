package com.example.task03;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }
    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {
        Iterator<? extends T> iterator = stream.iterator();

        // your implementation here
        if (!iterator.hasNext()) {
            minMaxConsumer.accept(null, null);
            return;
        }

        T temp = iterator.next();
        T min = temp;
        T max = temp;

        while(iterator.hasNext()){
            temp = iterator.next();
            if(order.compare(temp,max) > 0)
                max = temp;
            if(order.compare(temp,min) < 0)
                min = temp;
        }

        minMaxConsumer.accept(min, max);
    }
}