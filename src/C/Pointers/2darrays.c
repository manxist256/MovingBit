#include<stdio.h>

int main() {
    int A[2][3];
    A[0][0] = 5;
    A[0][1] = 11;
    A[0][2] = 23;
    A[1][0] = 46;
    A[1][1] = 89;
    A[1][2] = 93;
    int *p = A;
    printf("%d\n", A);
    printf("%d\n", p);
    printf("%d\n", A + 1);
    printf("%d\n", *p);
    printf("%d\n", *(p + 1));
    printf("%d\n", *(p + 2));
    printf("%d\n", *(A + 1));
    printf("%d\n", *(A + 2));
    printf("%d\n", **A);
    printf("%d\n", **(A + 1));
    return 0;
}