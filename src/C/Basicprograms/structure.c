#include<stdio.h>
#include<string.h>

struct Person {
    int age;
    char name[100];
};

int main() {
    struct Person person;
    person.age = 100;
    strcpy(person.name, "kbk");
    printf("%d  \n", person.age);
    printf("%s \n", person.name);
    return 0;
}
