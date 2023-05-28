package org.nartov.utils;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class UniqueNumberGenerator {

    private AtomicLong counter = new AtomicLong(0);

    public long nextNumber() {
        return counter.getAndIncrement();
    }
}
