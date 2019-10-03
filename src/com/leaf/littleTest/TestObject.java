package com.leaf.littleTest;

import org.junit.Test;

/**
 * Created by leaf on 16-12-21.
 */
public class TestObject {
    @Test
    public void test(){
        Bb b1 = new Bb();
        b1.setPp1("pp1");
        Bb b2 = new Bb();
        b2.setPp1("pp2");

        Aa a1 = new Aa();
        a1.setP1(1);
        a1.setP2(2);
        a1.setP3("3");
        a1.setP4(b1);
        System.out.println(a1);

        Aa a2 = new Aa();
        a2.setP1(a1.getP1());
        a2.setP2(a1.getP2());
        a2.setP3(a1.getP3());
        a2.setP4(a1.getP4());
        System.out.println(a2);

        b1.setPp1("ppp1");
        System.out.println(a1);
        System.out.println(a2);

        a1.setP1(11);
        a1.setP2(12);
        a1.setP3("13");
        a1.setP4(b2);
        System.out.println(a1);
        System.out.println(a2);

    }
}
