package pl.paweln.dp.behavioral.state.exercise;

import java.util.ArrayList;
import java.util.List;

public class CombinationLock
{
    private int [] combination;
    public String status;

    private List<Integer> list = new ArrayList<>();

    public CombinationLock(int[] combination)
    {
        this.combination = combination;
        this.status = "LOCKED";
    }

    public void enterDigit(int digit)
    {
        this.list.add(digit);
        verifyCode();
    }

    private void verifyCode() {
        StringBuilder buffer = new StringBuilder();
        for (Integer i : this.list)
            buffer.append(i.toString());
        this.status = buffer.toString();

        if (combination.length == this.list.size()) {
            for (int i = 0; i < combination.length; i++) {
                if (combination[i] != this.list.get(i)) {
                    this.status = "ERROR";
                    return;
                }
            }
            this.status = "OPEN";
        }
    }
}
