package com.system.rateLimiter;

public interface RateLimiter {
    boolean rateLimit(int customerId);
}
