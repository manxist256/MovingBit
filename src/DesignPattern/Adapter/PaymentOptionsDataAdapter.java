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
// Adapter that converts paystation model to data layer model : GPO
public class PaymentOptionsDataAdapter {
    public List<DataPaymentOption> getPaymentOptions() {
        PaystationPaymentOptionsProvider poProvider = new PaystationPaymentOptionsProvider();
        List<PaystationPaymentOption> psPaymentOptions = poProvider.getPaymentOptions();
        PaymentOptionsMapper mapper = new PaymentOptionsMapper();
        List<DataPaymentOption> paymentOptions = mapper.mapPaymentOptions(psPaymentOptions);
        return paymentOptions;
    }
}
