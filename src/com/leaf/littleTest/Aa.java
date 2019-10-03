package com.leaf.littleTest;

/**
 * Created by leaf on 16-12-21.
 */
public class Aa {
    private int p1;
    private Integer p2;
    private String p3;
    private Bb p4;

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public Integer getP2() {
        return p2;
    }

    public void setP2(Integer p2) {
        this.p2 = p2;
    }

    public String getP3() {
        return p3;
    }

    public void setP3(String p3) {
        this.p3 = p3;
    }

    public Bb getP4() {
        return p4;
    }

    public void setP4(Bb p4) {
        this.p4 = p4;
    }

    @Override
    public String toString() {
        return "Aa{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3='" + p3 + '\'' +
                ", p4=" + p4 +
                '}';
    }
}
