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
public class OperatingSystemsFactory {
    public static OperatingSystem getOS(String OSType) {
        switch(OSType) {
            case "ANDROID" : return new Android();
            case "IOS" : return new IOS();
            case "WINDOWS" : return new Windows();
            default : return null;
        }
    }
}
