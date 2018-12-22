#include<stdio.h>

void increment(int *p) {
    *p = 20;
}

int main() {
    int a = 10;
    int *p = &a;
    increment(p);
    printf("%d", a);
    return 0;
}

