#include<iostream>
#include<string>

const int MOD = 1000000007;
using namespace std;

int T, N, res;
string s;
int dp[16][10000];

int main() {

    scanf("%d\n", &T);

    for (int tc = 1; tc <= T; ++tc) {
        getline(cin, s);
        N = s.length();

        //첫날 따로 처리
        int req = 1 << (s[0] - 'A');
        for (int i = 1; i < 16; ++i) {
            if ((req & i) >= 1 && (1 & i) >= 1)dp[i][0] = 1;
        }

        //둘째날부터
        for (int day = 1; day < N; ++day) {
            //책임자
            req = 1 << (s[day] - 'A');

            for (int comb = 1; comb < 16; ++comb) {
                dp[comb][day] = 0;
                //책임자가 포함된 조합에 대해
                if ((req & comb) >= 1) {

                    for (int prevComb = 1; prevComb < 16; ++prevComb) {
                        //같은 사람이 한명 이상 포함된 조합을 찾아
                        if ((comb & prevComb) >= 1) {
                            //전날 해당 조합의 경우의 수 더해줌
                            dp[comb][day] = (dp[comb][day] + dp[prevComb][day - 1]) % MOD;
                        }
                    }
                }
            }
        }

        res = 0;
        for (int i = 1; i < 16; ++i) {
            res = (res + dp[i][N - 1]) % MOD;
        }
        printf("#%d %d\n", tc, res);
    }

    return 0;
}
