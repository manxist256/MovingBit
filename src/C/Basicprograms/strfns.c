#include<stdio.h>
#include<string.h>

int main() {
    char s1[11], s2[11];
    scanf("%s", s1);
    strcpy(s2, s1);
    printf("%s\n", s1);
    printf("%s\n", s2);
    printf("%d\n", strlen(s1));
    strcat(s1, s2);
    printf("%s\n", s1);
    return 0;
}