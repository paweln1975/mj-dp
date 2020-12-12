package pl.paweln.dp.structural.flyweight.exercise;

import java.util.ArrayList;
import java.util.List;

public class Sentence
{
    private String plainText;
    private List<WordToken> tokens = new ArrayList<>();

    public Sentence(String plainText)
    {
        this.plainText = plainText;
    }

    public WordToken getWord(int index)
    {
        for (WordToken token : tokens) {
            if (token.index == index) {
                return token;
            }
        }

        WordToken wordToken = new WordToken();
        wordToken.index = index;
        this.tokens.add(wordToken);
        return wordToken;
    }

    @Override
    public String toString()
    {
        String[] words = this.plainText.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for(WordToken token: tokens) {
                if (i == token.index && token.capitalize) {
                    s = s.toUpperCase();
                }
            }
            sb.append(s);
            if (i < words.length-1) sb.append(" ");
        }
        return sb.toString();
    }

    class WordToken
    {
        public boolean capitalize;
        public int index;
    }
}