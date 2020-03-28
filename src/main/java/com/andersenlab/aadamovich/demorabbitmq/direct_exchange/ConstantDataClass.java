package com.andersenlab.aadamovich.demorabbitmq.direct_exchange;

public abstract class ConstantDataClass {

    private ConstantDataClass() {
    }

    public final static String QUEUE_NAME_1 = "error_queue";
    public final static String QUEUE_NAME_2 = "error_info_command_queue";
    public final static String EXCHANGE_NAME = "direct_exchange";
}
