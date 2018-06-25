/*
 * @(#)OverTimeCalculator.java 1.0 25/06/2018
 *
 * Copyright (c) 2018, The Company. All rights reserved.
 * The Company S/A proprietary/confidential. Use is subject to license terms.
 */

package com.enterprise.bankslip.domain.calculators;

import com.enterprise.bankslip.domain.Bankslip;

import java.time.LocalDate;

/**
 * Implementação da classe {@link FineCalculator} que calcula juros para boletos com mais de 10 dias em atraso.
 *
 * @author Glauber Shibata
 * @Version 1.0.0 18/06/2018
 **/
public class OverTimeCalculator extends AbstractFineCalculator {

    /** {@inheritDoc} **/
    @Override
    public boolean shouldCalculate(final Bankslip bankslip, final LocalDate referenceDate) {
        return bankslip.getOverdueDays(referenceDate) > TEND_DAYS;
    }

    @Override
    protected double getInterestRate() {
        return 0.01d;
    }
}
