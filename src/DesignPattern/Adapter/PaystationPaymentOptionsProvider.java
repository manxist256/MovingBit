/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DesignPattern.Adapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mankank
 */
// payment option provider that contacts downstream service.
public class PaystationPaymentOptionsProvider {
    public List<PaystationPaymentOption> getPaymentOptions() {
        ArrayList<PaystationPaymentOption> paymentOptions = new ArrayList<>();
        // down-stream service call to get payment options list
        //mocking data
        PaystationPaymentOption po1 = new PaystationPaymentOption();
        po1.instrumentId = 6;
        PaystationPaymentOption po2 = new PaystationPaymentOption();
        po2.instrumentId = 12;
        paymentOptions.add(po1);
        paymentOptions.add(po2);
        return paymentOptions;
    }
}
