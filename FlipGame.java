import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by zhangtianlong on 19/8/31.
 */
public class FlipGame {
    static final int MAX = (1 << 16) - 1;
    static final int SIZE = 4;
    static final int[][] SQUARE = {
            {-1,0}, {1, 0},   // 上, 下
            {0, -1}, {0, 1}   // 前, 后
    };
    static final int SQUARE_SIZE = 4;
    boolean[] existed = new boolean[1 << 16];
    int[] xorArray = new int[16];

    public static void main(String[] args) {
        int [][] array = {
                {1,1,1,0},
                {0,1,0,0},
                {1,0,0,0},
                {1,1,0,0}
        };
        int value = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (array[i][j] == 1) {
                    value += 1 << (i * SIZE + j);
                }
            }
        }
        FlipGame flipGame = new FlipGame();
        flipGame.init();
        int result = flipGame.BFS(value);
        if (result >= 0) {
            System.out.println(result);
        } else {
            System.out.println("Impossible");
        }
    }

    boolean judge(int x, int y) {
        if (x >= 0 && x < SIZE && y >= 0 && y < SIZE) {
            return true;
        } else {
            return false;
        }
    }

    void init() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int value = 1 << (i * SIZE + j);
                for (int k = 0; k < SQUARE_SIZE; k++) {
                    int nextX = i + SQUARE[k][0];
                    int nextY = j + SQUARE[k][1];
                    if (judge(nextX, nextY)) {
                        value += 1 << (nextX * SIZE + nextY);
                    }
                }
                xorArray[i * SIZE + j] = value;
            }
        }
    }

    int BFS(int value) {
        Queue<Info> queue = new LinkedBlockingQueue<>();
        Info initNode = new Info(value, 0);
        queue.add(initNode);
        existed[initNode.value] = true;
        while (!queue.isEmpty()) {
            Info head = queue.poll();
            if (head.value == 0 || head.value == MAX) {
                return head.step;
            }

            // 对16个位置都进行搜索
            for (int i = 0; i < 16; i++) {
                Info next = new Info(head.value^xorArray[i], head.step + 1);
                if (!existed[next.value]) {
                    queue.add(next);
                    existed[next.value] = true;
                }
            }
        }
        return -1;
    }
}

class Info {
    // 状态值
    int value;
    // 步数
    int step;

    public Info(int value, int step) {
        this.value = value;
        this.step = step;
    }
}
