#include<stdio.h>

int main() {
    int a = 1025;
    int *p = &a;
    printf("%d \n", sizeof(p));
    char *pp = &a;
    printf("%d \n", sizeof(pp));
    return 0;
}
