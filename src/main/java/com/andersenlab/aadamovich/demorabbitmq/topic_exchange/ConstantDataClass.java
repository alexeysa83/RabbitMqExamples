package com.andersenlab.aadamovich.demorabbitmq.topic_exchange;

public abstract class ConstantDataClass {

    private ConstantDataClass() {
    }

    public final static String QUEUE_NAME_1 = "error_*_queue";
    public final static String QUEUE_NAME_2 = "error_#_queue";
    public final static String EXCHANGE_NAME = "topic_exchange";
}
