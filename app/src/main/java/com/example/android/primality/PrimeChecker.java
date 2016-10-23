package com.example.android.primality;

import java.util.Arrays;

/**
 * Created by Aryan on 06-08-2016.
 */
public class PrimeChecker {
    private int num;
    private boolean val;

    public boolean soe()
    {
        boolean prime[] = new boolean[10000];
        Arrays.fill(prime, true);
        for(int p=2;p*p<=10000-1; p++)
        {
            if (prime[p] == true)
            {
                for (int i=p*2; i<=10000-1; i += p)
                    prime[i] = false;
            }

        }
        return prime[num];
    }
    public int getQuestion()
    {
        num = (int )(Math.random() * 10000);
        if (num <= 0)
            val = false;
        else
            val = soe();
        return num;
    }
    public boolean getValue()
    {
        return val;
    }

}
