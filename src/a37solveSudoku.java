/**
 * @Author diaopx
 * @Date 2022/11/16 9:44
 * <p>
 * 37.解数独
 **/
public class a37solveSudoku {

    // 表示每行，每列，每个3*3的块 被占据的值
    boolean[][] row = new boolean[9][9];
    boolean[][] col = new boolean[9][9];
    boolean[][] box = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int index = board[i][j] - '1';
                    row[i][index] = true;
                    col[j][index] = true;
                    box[i / 3 * 3 + j / 3][index] = true;
                }
            }
        }
        dfs(board, 0, 0);
    }
    // 优先向右递归， 递归到行出界 则 说明结束。
    public boolean dfs(char[][] board, int x, int y) {
        if (y == 9) return dfs(board, x + 1, 0);
        if (x == 9) {
            return true;
        }
        if (board[x][y] != '.') return dfs(board, x, y + 1);
        // 判断1-9的数字  是否在行 列 块中出现过
        for (int i = 0; i < 9; i++) {
            int boxIndex = x / 3 * 3 + y / 3;
            if (!row[x][i] && !col[y][i] && !box[boxIndex][i]) {
                row[x][i] = true;
                col[y][i] = true;
                box[boxIndex][i] = true;
                board[x][y] = (char) (i + '1');
                // dfs 返回结果
                if (dfs(board, x, y + 1)) {
                    return true;
                } else {
                    // 回溯
                    row[x][i] = false;
                    col[y][i] = false;
                    box[boxIndex][i] = false;
                    board[x][y] = '.';
                }
            }
        }
        // 该位置判断玩9个数还是没有 true 返回的话说明前面选错
        return false;
    }
}
