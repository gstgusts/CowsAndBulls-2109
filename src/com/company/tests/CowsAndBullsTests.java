package com.company.tests;

import com.company.CowsAndBulls;
import org.junit.Test;
import static org.junit.Assert.*;

public class CowsAndBullsTests {
    @Test
    public void guess_if_1_bull() {
        var cbl = new CowsAndBulls(8444);
        var result = cbl.guess(8123);
        assertEquals(1, result.getBulls());
    }

    @Test
    public void guess_if_2_bull() {
        var cbl = new CowsAndBulls(8484);
        var result = cbl.guess(8183);
        assertEquals(2, result.getBulls());
    }

    @Test
    public void guess_if_1_bull_and_1_cow() {
        var cbl = new CowsAndBulls(8123);
        var result = cbl.guess(8344);

        assertEquals(1, result.getBulls());
        assertEquals(1, result.getCows());
    }

    @Test
    public void guess_if_1_bull_and_1_cow_bull_and_cow_same_number() {
        var cbl = new CowsAndBulls(8283);
        var result = cbl.guess(8818);

        assertEquals(1, result.getBulls());
        assertEquals(1, result.getCows());
    }

    @Test
    public void guess_if_2_bull_and_2_cow() {
        var cbl = new CowsAndBulls(8123);
        var result = cbl.guess(8321);

        assertEquals(2, result.getBulls());
        assertEquals(2, result.getCows());
    }

    @Test
    public void guess_if_0_bull_and_0_cow() {
        var cbl = new CowsAndBulls(1234);
        var result = cbl.guess(5678);

        assertEquals(0, result.getBulls());
        assertEquals(0, result.getCows());
    }

    @Test
    public void guess_if_2_bull_and_2_cow_3844_8344() {
        var cbl = new CowsAndBulls(3844);
        var result = cbl.guess(8344);

        assertEquals(2, result.getBulls());
        assertEquals(2, result.getCows());
    }

    @Test
    public void guess_if_2_bull_2303_3333() {
        var cbl = new CowsAndBulls(2303);
        var result = cbl.guess(3333);

        assertEquals(2, result.getBulls());
        assertEquals(0, result.getCows());
    }
}
