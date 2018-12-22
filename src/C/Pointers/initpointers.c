#include<stdio.h>

int main() {
    int a = 5;
    printf("%d \n", a);
    printf("%d \n", &a);
    int *p = &a;
    printf("%d \n", p);
    printf("%d \n", &p);
    printf("%d \n", *p);
    return 0;
}
