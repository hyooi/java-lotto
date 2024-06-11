package lotto.utils;

import lotto.entity.Number;

import java.util.List;
import java.util.stream.Collectors;

public class CommonUtils {
    public static List<Number> intListToNumberList(List<Integer> list) {
        return list.stream()
                .map(Number::of)
                .collect(Collectors.toList());
    }
}
