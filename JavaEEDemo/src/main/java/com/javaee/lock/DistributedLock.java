package com.javaee.lock;

public interface DistributedLock {

    String acquire();

    boolean release(String identifier);
}
