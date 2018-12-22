#include<stdio.h>

int main() {
    int a = 999;
    int *p = &a;
    printf("%d\n", *p);
    printf("%d\n", p);
    char *pp = (char*)p;
    printf("%d\n", *(pp+0));
    printf("%d\n", *(pp + 1));
    printf("%d\n", pp);
    return 0;
}
