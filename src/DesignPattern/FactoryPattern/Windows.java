/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPattern.FactoryPattern;

/**
 *
 * @author mankank
 */
public class Windows implements OperatingSystem {
    
    @Override
    public void specifications() {
        System.out.println("Windows Operating System");
    }
}
