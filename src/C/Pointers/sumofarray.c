#include<stdio.h>

void add(int A[5], int size) {
    int *p = A;
    int result = 0;
    for (int i = 0; i < size; i++) {
        result += (*p);
        p = p + 1;
    }
    printf("%d\n", result);
}

int main() {
    int A[5];
    A[0] = 2; A[1] = 4; A[2] = 6; A[3] = 8; A[4] = 10;
    int size = sizeof(A) / sizeof(int);
    add(A, size);
    return 0;
}