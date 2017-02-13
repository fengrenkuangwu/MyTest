package com.leaf.exceptionTest;

import org.junit.Test;

/**
 * Created by pekall on 17-1-18.
 */
public class ExceptionTest {

    @Test
    public void test(){
        String str = ex();
        System.out.println("-----------"+str);
    }

    private String ex(){
        String a  = "haha";
        String b = "";
        try{
            b=a.substring(0,5);
        }catch (Exception e){
            return e.getMessage();
        }
        return b;
    }
}
