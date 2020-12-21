package pl.paweln.dp.behavioral.memento.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TokenMachine {
    public List<Token> tokens = new ArrayList<>();

    public Memento addToken(int value)
    {
        return this.addToken(new Token(value));
    }

    public Memento addToken(Token token)
    {
        this.tokens.add(token);
        Memento memento = new Memento();
        memento.tokens =
            this.tokens.stream()
                    .map(token1 -> new Token(token1.value))
                    .collect(Collectors.toList());

        return memento;
    }

    public void revert(Memento m)
    {
        this.tokens.clear();
        this.tokens.addAll(m.tokens);
    }
}
