

class Solution {
    public boolean isValidSudoku(char[][] board) {
    HashSet<Character> set = new HashSet<>();
    int n = board.length;
    for(int r =0;r<n;r++){
        set.clear();
        for(int c= 0;c<n;c++){
            if(board[r][c] == '.'){
                continue;
            }
            if(set.contains(board[r][c])){
                return false;
            }
            set.add(board[r][c]);
        }
    }
     for(int c =0;c<n;c++){
        set.clear();
        for(int r = 0;r<n;r++){
            if(board[r][c] == '.'){
                continue;
            }
            if(set.contains(board[r][c])){
                return false;
            }
            set.add(board[r][c]);
        }
    }
     for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                set.clear();

                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {

                        int row = i * 3 + r;
                        int col = j * 3 + c;

                        char num = board[row][col];

                        if (num == '.') {
                            continue;
                        }

                        if (set.contains(num)) {
                            return false;
                        }

                        set.add(num);
                    }
                }
            }
        }

        return true;
      
    }

}