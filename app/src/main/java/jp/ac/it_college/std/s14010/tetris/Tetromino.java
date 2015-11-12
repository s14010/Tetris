package jp.ac.it_college.std.s14010.tetris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Created by s14010 on 15/11/12.
 */
public class Tetromino {
    private int x;
    private int y;
    private Type type;

    public enum Type {
        I(1), O(2), S(3), Z(4), J(5), L(6), T(7), Dummy(0);

        private static LinkedList<Type> queue = new LinkedList<>();
        private static Random random = new Random();
        private static final int SHUFFLE_COUNT = 100;
        private final int id;

        public enum Orientation {
            Right, Down, Left, Up;
        }

        Type(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public static Type nextType() {
            if (queue.size() == 0) {
                generateQueue();
            }
            return queue.remove();
        }

        public static void generateQueue() {
            queue.addAll(Arrays.asList(I,O,S,Z,J,L,T));
            for (int i = 0; i < SHUFFLE_COUNT; i++) {
                int src = random.nextInt(queue.size());
                int dst = random.nextInt(queue.size());
                Type tmp = queue.get(src);
                queue.set(src, queue.get(dst));
                queue.set(dst, tmp);
            }
        }

    }

}
