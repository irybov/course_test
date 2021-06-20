package ru.parsentev.task_014;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class ReversePhrase {
    private static final Logger log = getLogger(ReversePhrase.class);
    private final String line;

    public ReversePhrase(final String line) {
        this.line = line;
    }

    public String reverse() {
        String[] words = line.split(" ");
        StringBuilder phrase = new StringBuilder();
        for(int i = words.length - 1; i >= 0; i--) {
        	phrase.append(words[i]);
        	if(i>0) {
        		phrase.append(" ");
        	}
        }
        return phrase.toString();
    }
}
