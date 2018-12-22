#include<stdio.h>

int main() {
    int a = 5, b = 10;
    int *p = &a;
    *p = b;
    printf("%d", a);
}

