#include<stdio.h>

int main() {
    
    int a = 12;
    printf("%d\n", a);
    printf("%d\n", &a);
    int *p = &a;
    printf("%d\n", p);
    printf("%d\n", &p);
    printf("%d\n", *p);
    int **q = &p;
    printf("%d\n", q);
    printf("%d\n", &q);
    printf("%d\n", *q);
    printf("%d\n", **q);
    int ***r = &q;
    printf("%d\n", r);
    printf("%d\n", &r);
    printf("%d\n", *r);
    printf("%d\n", **r);
    printf("%d\n", ***r);
    return 0;    
}