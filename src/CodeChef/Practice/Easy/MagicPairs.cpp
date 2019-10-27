//
//  MagicPairs.cpp
//  Competitive
//
//  Created by Manikandan KK on 23/10/19.
//  Copyright © 2019 Manikandan KK. All rights reserved.
//

#include <iostream>
using namespace std;

int main() {
    int T;
    cin >> T;
    while (T-- > 0) {
        long N;
        cin >> N;
        int a[N];
        for (int i = 0; i < N; i++) {
            cin >> a[i];
        }
        cout << (N*(N-1))/2 << "\n";
    }
    return 0;
}
