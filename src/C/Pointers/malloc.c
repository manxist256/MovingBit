#include<stdio.h>

int main() {
    int *p = (int*) malloc(sizeof (int));
    *p = 23;
    printf("%d\n", &p);
    printf("%d\n", p);
    printf("%d\n", *p);
    free(p);
    printf("%d\n", &p);
    printf("%d\n", p);
    printf("%d\n", *p);
    return 0;
}
