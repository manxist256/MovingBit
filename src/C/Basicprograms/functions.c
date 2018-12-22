#include<stdio.h>

int max(int a, int b) {
    return a > b ? a : b;
}

int main() {
    printf("%d", max(10, 23));
    return 0;
}
