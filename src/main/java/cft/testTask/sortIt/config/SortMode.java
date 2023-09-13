package cft.testTask.sortIt.config;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum SortMode {
    ASC("-a", (a, b) -> a <= b ? true : false),
    DESC("-d", (a, b) -> a <= b ? false : true);

    final String code;

    final public BiFunction<Integer, Integer, Boolean> compareFunc;

    SortMode(String code, BiFunction<Integer, Integer, Boolean> compare) {
        this.code = code;
        this.compareFunc = compare;
    }

    public static SortMode getSortModeByCode(String code) {
        return Stream.of(SortMode.values())
                .filter(sortMode -> sortMode.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("no supported mode " + code));
    }

}
