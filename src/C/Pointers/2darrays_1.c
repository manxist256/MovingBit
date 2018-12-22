#include<stdio.h>

int main() {
    int A[2][2];
    A[0][0] = 10;
    A[0][1] = 20;
    A[1][0] = 30;
    A[1][1] = 40;
    int *p = A;
    printf("%d\n", *p);
    printf("%d\n", *(p+1));
    printf("%d\n", *(p+2));
    printf("%d\n", *(p+3));
    return 0;
}
