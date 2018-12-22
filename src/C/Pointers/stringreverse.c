#include<stdio.h>

int main() {
    char name[20];
    scanf("%s", name);
    char *p = name;
    for (int i = 0; i < strlen(name) - 1; i++) {
        p++;
    }
    for (int i = 0; i < strlen(name); i++) {
        printf("%c", *p);
        p--;
    }
    return 0;
}