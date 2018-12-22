#include<stdio.h>

int main() {
    int *p = (int*) malloc(sizeof(int));
    printf("%d\n", *p);
    int *q = (int*) calloc(1, sizeof(int));
    printf("%d\n", *q);
    return 0;
}
