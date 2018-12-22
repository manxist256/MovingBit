#include<stdio.h>

int main() {
    int A[5];
    A[0] = 2; A[1] = 4; A[2] = 6; A[3] = 8; A[4] = 10;
    int *p = A;
    printf("%d\n", p);
    printf("%d\n", &A);
    printf("%d\n", A + 1);
    printf("%d\n", *p);
    printf("%d\n", *(p + 1));
    printf("%d\n", *A);
    printf("%d\n", *(A + 1));
    return 0;
}
