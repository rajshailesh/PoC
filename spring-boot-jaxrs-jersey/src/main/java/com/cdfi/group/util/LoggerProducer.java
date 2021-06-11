package com.cdfi.group.util;

import org.springframework.beans.factory.InjectionPoint;
import org.springframework.stereotype.Component;


import javax.ws.rs.Produces;
import java.util.logging.Logger;
@Component
public class LoggerProducer {

    // ======================================
    // =              Producers             =
    // ======================================

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
