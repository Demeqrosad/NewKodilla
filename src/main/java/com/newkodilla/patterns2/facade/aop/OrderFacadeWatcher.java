package com.newkodilla.patterns2.facade.aop;

import com.newkodilla.patterns2.facade.api.OrderDTO;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class OrderFacadeWatcher
{
    private static final Logger LOGGER = LoggerFactory.getLogger(com.newkodilla.patterns2.aop.calculator.Watcher.class);

    @Before("execution(* com.newkodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(theOrder, theUser)")
    public void logEvent(OrderDTO theOrder, Long theUser)
    {
        LOGGER.info("New order of " + theOrder.getItems().size() + " items, from User: " + theUser.toString());
    }
}
