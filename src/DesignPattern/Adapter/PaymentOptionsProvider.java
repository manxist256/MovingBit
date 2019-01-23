/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPattern.Adapter;

import java.util.List;

/**
 *
 * @author mankank
 */
//Client
public class PaymentOptionsProvider {
    public static void main(String[] args) {
        PaymentOptionsDataAdapter paymentOptionsViewAdapter = new PaymentOptionsDataAdapter();
        List<DataPaymentOption> paymentOptions = paymentOptionsViewAdapter.getPaymentOptions();
        for (DataPaymentOption po : paymentOptions) {
            System.out.println(po.paymentOptionId);
        }
    }
}
