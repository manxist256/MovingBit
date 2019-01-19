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
public class Client {
    
    public static void main(String[] args) {
        OperatingSystem operatingSystem = OperatingSystemsFactory.getOS("ANDROID");
        operatingSystem.specifications();
    }
}
