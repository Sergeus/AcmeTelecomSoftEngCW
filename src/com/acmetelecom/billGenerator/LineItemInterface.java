package com.acmetelecom.billGenerator;

import java.math.BigDecimal;

public interface LineItemInterface {

    public String date();

    public String callee();

    public String durationMinutes();

    public BigDecimal cost();
}
