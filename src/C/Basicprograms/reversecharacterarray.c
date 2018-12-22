#include<stdio.h>
int main() {
    char array[10];
    for (int i = 0; i < 10; i++) {
        scanf("%c", &array[i]);
    }
    for (int i = 9; i >= 0; i--) {
        printf("%c ", array[i]);
    }
    return 0;
}