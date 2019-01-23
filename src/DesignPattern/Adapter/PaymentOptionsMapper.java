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
// Maps payment options from paystation model to data model.
public class PaymentOptionsMapper {
    public List<DataPaymentOption> mapPaymentOptions(List<PaystationPaymentOption> list) {
        List<DataPaymentOption> paymentOptions = new ArrayList<>();
        for (PaystationPaymentOption po : list) {
            DataPaymentOption dpo = new DataPaymentOption();
            dpo.paymentOptionId = po.instrumentId;
            paymentOptions.add(dpo);
        }
        return paymentOptions;
    } 
}
