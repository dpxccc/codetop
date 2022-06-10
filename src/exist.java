/**
 * @ClassName exist
 * @Author diaopx
 * @Date 2022/6/10 10:17
 **/
public class exist {

    public static void main(String[] args) {
        exist e = new exist();
        char[][] board = {{'a', 'a'}};
        String word = "aaa";
        System.out.println(e.exist1(board, word));
    }

    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int[][] visited;

    public boolean exist1(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = 1;
                    if (dfs(board, word, 1, i, j)){
                        return true;
                    }
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        }

        for (int i = 0; i < dir.length; i++) {
            int nx = x + dir[i][0], ny = y + dir[i][1];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || visited[nx][ny] == 1) {
                continue;
            }
            // 下一个位置是正确的
            if (board[nx][ny] == word.charAt(index)) {
                // 置为访问过了
                visited[nx][ny] = 1;
                // 如果后续也是正确的 则返回true
                if (dfs(board, word, index + 1, nx, ny)) {
                    return true;
                }
                // 回溯为没访问过
                visited[nx][ny] = 0;
            }
        }
        // 遍历了四周都没有答案  则返回false
        return false;
    }
}
