#include<stdio.h>

int main() {
    char array[26];
    for (int i = 65; i < 91; i++) {
        array[i - 65] = (char)i;
    }
    for (int i = 0; i < 26; i++) {
        printf("%c ", array[i]);
    }
}
