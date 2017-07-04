package util;

import org.apache.commons.io.input.TailerListenerAdapter;

/**
 * Created by chandanjavaregowda on 02/07/17.
 */
public class MyTailerListener extends TailerListenerAdapter {
    public void handle(String line) {
        System.out.println(line);
    }
}