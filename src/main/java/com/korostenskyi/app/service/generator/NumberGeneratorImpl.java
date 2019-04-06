package com.korostenskyi.app.service.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumberGeneratorImpl implements NumberGenerator {

    private Long minValue;
    private Long maxValue;

    private Long generatedNumber;

    public NumberGeneratorImpl() {
    }

    public Long getMinValue() {
        return minValue;
    }

    @Autowired
    public void setMinValue(Long minValue) {
        this.minValue = minValue;
    }

    public Long getMaxValue() {
        return maxValue;
    }

    @Autowired
    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public Long getGeneratedNumber() {
        return generatedNumber;
    }

    public void setGeneratedNumber(Long generatedNumber) {
        this.generatedNumber = generatedNumber;
    }

    @Override
    public void generateNumber() {

        Long generatedNumber = getMinValue() + (long) (Math.random() * (getMaxValue() - getMinValue()));

        setGeneratedNumber(generatedNumber);
    }

    @Override
    public byte generateWinner() {
        return (byte) (Math.random() * 2 + 1);
    }
}
