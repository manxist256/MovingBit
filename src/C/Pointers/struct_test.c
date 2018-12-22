#include<stdio.h>

struct Node {
    int age;
    int data;
    struct Node* next;
};

int main() {
   struct Node* newnode = (struct Node*)malloc(sizeof(struct Node));
   newnode->data = 10;
   newnode->age = 43;
   printf("%d\n", newnode);
   printf("%d\n", *newnode);
   printf("%d\n", newnode->data);
   printf("%d\n", (*newnode).data);
   return 0; 
}
