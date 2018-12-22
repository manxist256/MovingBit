#include<stdio.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* head;

void insert(int data) {
    struct Node* newnode = (struct Node*)malloc(sizeof(struct Node));
    newnode->data = data;
    if (head == NULL) {
        head = newnode;
        return;
    }    
    struct Node* traverse = head;
    while (traverse != NULL) {
        if (traverse->next == NULL) {
            traverse->next = newnode;
            return;
        }
        traverse = traverse->next;
    }
}

void print() {
    struct Node* traverse = head;
    while (traverse != NULL) {
        printf("%d-->", traverse->data);
        traverse = traverse->next;
    }
}

int main() {
    insert(5);
    insert(15);
    insert(25);
    insert(35);
    insert(45);
    print();
    return 0;
}
