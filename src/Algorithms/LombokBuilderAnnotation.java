/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

/**
 *
 * @author mankank
 */
class DebitCard {
    
    int a, b;
    String s;
    
    public static DebitCard builder() {
        return new DebitCard();
    }

    public DebitCard a(int a) {
        this.a = a;
        return this;
    }
    
    public DebitCard b(int b) {
        this.b = b;
        return this;
    }
    
    public DebitCard s(String s) {
        this.s = s;
        return this;
    }
    
    public DebitCard build() {
        return this;
    }
    
}
public class LombokBuilderAnnotation {
    public static void main(String[] args) {
        DebitCard card = DebitCard.builder()
                .a(4)
                .b(10)
                .s("h")
                .build();
    }
}
