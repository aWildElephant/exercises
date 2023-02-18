package fr.awildelephant.exercises.givechange;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class GiveChangeTest {

    private final GiveChange giveChange = new GiveChange();

    @ParameterizedTest
    @MethodSource("changeCases")
    void testOptimal(long value, Change expected) {
        assertThat(giveChange.optimalChange(value)).isEqualTo(expected);
    }

    private static Stream<Arguments> changeCases() {
        return Stream.of(
                Arguments.of(-1, null),
                Arguments.of(1, null),
                Arguments.of(2, new Change(1, 0, 0)),
                Arguments.of(3, null),
                Arguments.of(4, new Change(2, 0, 0)),
                Arguments.of(5, new Change(0, 1, 0)),
                Arguments.of(6, new Change(3, 0, 0)),
                Arguments.of(7, new Change(1, 1, 0)),
                Arguments.of(8, new Change(4, 0, 0)),
                Arguments.of(9, new Change(2, 1, 0)),
                Arguments.of(10, new Change(0, 0, 1)),
                Arguments.of(11, new Change(3, 1, 0)),
                Arguments.of(12, new Change(1, 0, 1)),
                Arguments.of(13, new Change(4, 1, 0)),
                Arguments.of(14, new Change(2, 0, 1)),
                Arguments.of(15, new Change(0, 1, 1)),
                Arguments.of(16, new Change(3, 0, 1)),
                Arguments.of(17, new Change(1, 1, 1)),
                Arguments.of(18, new Change(4, 0, 1)),
                Arguments.of(19, new Change(2, 1, 1)),
                Arguments.of(20, new Change(0, 0, 2)),
                Arguments.of(21, new Change(3, 1, 1)),
                Arguments.of(22, new Change(1, 0, 2)),
                Arguments.of(23, new Change(4, 1, 1)),
                Arguments.of(24, new Change(2, 0, 2)),
                Arguments.of(25, new Change(0, 1, 2)),
                Arguments.of(69, new Change(2, 1, 6)),
                Arguments.of(666, new Change(3, 0, 66)),
                Arguments.of(Long.MAX_VALUE, new Change(1, 1, 922337203685477580L))
        );
    }

    @ParameterizedTest
    @MethodSource("integersFrom4To1000")
    void testReturnedChangeIsEqualToValue(long value) {
        final Change change = giveChange.optimalChange(value);
        final long returnedValue = change.getCoin2() * 2 + change.getBill5() * 5 + change.getBill10() * 10;

        assertThat(returnedValue).isEqualTo(value);
    }

    private static Stream<Arguments> integersFrom4To1000() {
        return LongStream.rangeClosed(4, 1000).mapToObj(Arguments::of);
    }
}