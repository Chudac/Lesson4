import java.util.Random;
import java.util.Scanner;

public class Lesson4 {
    final int size = 3;
    char[][] map = new char[size][size];
    final char cNull = '•', player = 'x', cpu1 = 'o', cpu2 = 'W', cpu3 = 'Z';
    Scanner sc = new Scanner(System.in);
    Random r = new Random();

    public static void main(String[] args) {
        Lesson4 g = new Lesson4();
        g.newMap();
        g.printMap();

        while (true) {
            g.playerTurn();
            g.printMap();
            if (g.checkWin(g.player)) {
                System.out.println("Поздравляем! Вы победили!!!");
                break;
            }
            if (g.isMapFull()) {
                System.out.println("Игра окончена. Победила дружба)");
                break;
            }

            g.aiTurn(g.cpu1);
            g.printMap();
            if (g.checkWin(g.cpu1)) {
                System.out.println("Игра окончена. Вы проиграли");
                break;
            }
            if (g.isMapFull()) {
                System.out.println("Игра окончена. Победила дружба");
                break;
            }

        }
    }

    void newMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = cNull;
            }
        }
    }

    void printMap() {
        for (int i = 0; i < size + 1; i++) {
            System.out.print(" " + i + " ");
        }
        System.out.print(">X");
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(" " + (i + 1) + "  ");
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println(i + 1);
        }
        System.out.print(" vY ");
        for (int i = 1; i <= size; i++) System.out.print(i + "  ");
        System.out.println("O\n");
    }

    void playerTurn() {
        int x, y;
        do {
            System.out.println("Ваш ход. Введите координаты >X vY");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = player;
    }

    boolean isCellValid(int x, int y) {
        if (x < 0 || y < 0 || x >= size || y >= size) return false;
        if (map[y][x] == cNull) return true;
        return false;
    }

    boolean checkWin(char c) {
        int countV;
        int countH;
        int countDiagonalA = 0;
        int countDiagonalB = 0;
        for (int i = 0; i <= size - 1; i++) {
            countH = 0;
            countV = 0;
            for (int j = 0; j <= size - 1; j++) {
                if (map[i][j] == c) {
                    countH++;
                    if (countH == size) return true;
                }

                if (map[j][i] == c) {
                    countV++;
                    if (countV == size) return true;
                }
            }

            if (map[i][i] == c) {
                countDiagonalA++;
                if (countDiagonalA == size) return true;
            } else countDiagonalA = 0;

            if (map[i][size - 1 - i] == c) {
                countDiagonalB++;
                if (countDiagonalB == size) return true;
            } else countDiagonalB = 0;
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] == cNull) return false;
            }
        }
        return true;
    }

    void aiTurn(char c) {
        int x = 0, y = 0, countH = 0, countHNull = 0, countV = 0, countVNull = 0, countDiagonalA = 0, countDiagonalB = 0, countDANull = 0, countDBNull = 0;

        System.out.println("Комрьютер ходит [" + c + "]:");
    }
}