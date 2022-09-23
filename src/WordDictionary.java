/**
 * @Author diaopx
 * @Date 2022/9/23 14:14
 * <p>
 * 211.添加与搜索单词  数据结构设计
 **/
public class WordDictionary {

    class Trie {
        boolean isEnd;
        Trie[] children;

        public Trie() {
            isEnd = false;
            children = new Trie[26];
        }
    }

    Trie root;

    public void insert(String word) {
        Trie cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    public boolean dfs(String word, int idx, Trie cur) {
        if (idx == word.length()) {
            return cur.isEnd;
        }
        char ch = word.charAt(idx);
        if (ch != '.' && cur.children[ch - 'a'] != null) {
            if (dfs(word, idx + 1, cur.children[ch - 'a'])) {
                return true;
            }
        }
        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (cur.children[i] != null && dfs(word, idx + 1, cur.children[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public WordDictionary() {
        root = new Trie();

    }

    public void addWord(String word) {
        insert(word);
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
}
