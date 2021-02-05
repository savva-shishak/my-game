package volnovoialgoritm;

import java.util.ArrayList;
import java.util.Random;

public class Navigate {

    public static int[][] propagation(final Point start, Point target, int width, int height, Valid valid) {
        int[][] cells = new int[width][height];
        cells[start.x][start.y] = 1;

        ArrayList<Point> queue = new ArrayList<Point>() {{ add(start); }};

        while (queue.size() > 0) {
            Point current = queue.remove(0);
            int x = current.x;
            int y = current.y;

            if (!valid.isValid(x, y)) {
                cells[x][y] = 0;
                continue;
            }

            if (x == target.x && y == target.y) {
                break;
            }

            if (x < width - 1 && cells[x + 1][y] == 0) {
                queue.add(new Point(x + 1, y));
                cells[x+1][y] = cells[x][y] + 1;
            }
            if (x > 0 && cells[x - 1][y] == 0) {
                queue.add(new Point(x - 1, y));
                cells[x-1][y] = cells[x][y] + 1;
            }
            if (y < height - 1 && cells[x][y + 1] == 0) {
                queue.add(new Point(x, y + 1));
                cells[x][y+1] = cells[x][y] + 1;
            }
            if (y > 0 && cells[x][y - 1] == 0) {
                queue.add(new Point(x, y - 1));
                cells[x][y-1] = cells[x][y] + 1;
            }
        }

        return cells;
    }

    public static ArrayList<Point> immersion(int [][] map, final Point target, int width, int height) {
        ArrayList<Point> path = new ArrayList<Point>() {{add(target);}};
        Point current = target;
        Random random = new Random();

        while (map[current.x][current.y] != 1) {
            current = path.get(path.size() - 1);
            int randomNext = random.nextInt(4);

            int x = current.x;
            int y = current.y;
            int value = map[current.x][current.y];
            int nextX = x, nextY = y;

            if (y > 0 && map[x][y - 1] == value - 1 && randomNext == 0) {
                nextY = y - 1;
            }
            if (x > 0 && map[x - 1][y] == value - 1 && randomNext == 1) {
                nextX = x - 1;
            }

            if (x < width - 1 && map[x + 1][y] == value - 1 && randomNext == 2) {
                nextX = x + 1;
            }

            if (y < height - 1 && map[x][y + 1] == value - 1 && randomNext == 3) {
                nextY = y + 1;
            }


            path.add(new Point(nextX, nextY));
        }

        return path;
    }
}
