#include <stdio.h>

int main()
{
	int test_case;
	int T;

	setbuf(stdout, NULL);
	scanf("%d", &T);

	for (test_case = 1; test_case <= T; ++test_case)
	{
		char ans[27] = { 0, };
		char str[101];
		int idx = 0;
		int cnt[26] = { 0, };
		int i;

		scanf("%s", str);

		while (str[idx] != NULL)
		{
			i = str[idx++] - 'a';

			if (cnt[i] == 0)
			{
				++cnt[i];
			}
			else
			{
				--cnt[i];
			}
		}

		idx = 0;

		for (i = 0; i < 26; ++i)
		{
			if (cnt[i] != 0)
			{
				ans[idx++] = i + 'a';
			}
		}

		if (idx == 0)
		{
			ans[0] = 'G';
			ans[1] = 'o';
			ans[2] = 'o';
			ans[3] = 'd';
		}

		printf("#%d %s\n", test_case, ans);
	}

	return 0;
}
