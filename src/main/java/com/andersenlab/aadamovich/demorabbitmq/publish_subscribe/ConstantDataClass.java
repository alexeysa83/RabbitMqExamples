package com.andersenlab.aadamovich.demorabbitmq.publish_subscribe;

public abstract class ConstantDataClass {

    private ConstantDataClass() {
    }

    public final static String QUEUE_NAME_1 = "queue_1";
    public final static String QUEUE_NAME_2 = "queue_2";
    public final static String EXCHANGE_NAME = "fanout_exchange";
}
