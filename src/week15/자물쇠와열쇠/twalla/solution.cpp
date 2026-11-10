#include <string>
#include <vector>
#include <iostream>

using namespace std;

int M, N, B;

vector<vector<int>> rotate(vector<vector<int>> key) {
    vector<vector<int>> nkey(M, vector<int>(M));
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < M; j++) {
            nkey[i][j] = key[j][M - 1 - i];
        }
    }

    return nkey;
}

vector<vector<int>> merge(int bi, int bj, vector<vector<int>> key, vector<vector<int>> board) {
    for (int i = 0; i < M; i++) {
        for (int j = 0; j < M; j++) {
            board[bi + i][bj + j] += key[i][j];
        }
    }

    return board;
}

bool fit(vector<vector<int>> result) {

    // for (int i = 0; i < B; i++) {
    //     for (int j = 0; j < B; j++) {
    //         cout << result[i][j] << " ";
    //     }
    //     cout << endl;
    // }
    // cout << endl;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int sum = result[i + M - 1][j + M - 1];
            if (sum == 2 || sum == 0) {
                return false;
            }
        }
    }

    return true;
}

bool solution(vector<vector<int>> key, vector<vector<int>> lock) {

    M = key.size();
    N = lock.size();
    B = 2 * M + N - 2;

    vector<vector<int>> board(B, vector<int>(B));

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            board[i + M - 1][j + M - 1] = lock[i][j];
        }
    }

//     for (int i = 0; i < B; i++) {
//         for (int j = 0; j < B; j++) {
//             cout << board[i][j] << " ";
//         }
//         cout << endl;
//     }

    for (int i = 0; i < B - M + 1; i++) {
        for (int j = 0; j < B - M + 1; j++) {
            vector<vector<int>> &nkey = key, result;
            for (int k = 0; k < 4; k++) {
                nkey = rotate(nkey);
                result = merge(i, j, nkey, board);
                if (fit(result)) {
                    return true;
                }
            }
        }
    }

    return false;
}