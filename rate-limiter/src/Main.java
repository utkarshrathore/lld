import com.system.rateLimiter.WindowRateLimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WindowRateLimiter wlr = new WindowRateLimiter(4, 5);
        wlr.rateLimit(123);
        Thread.sleep(999);
        wlr.rateLimit(123);
        Thread.sleep(999);
        wlr.rateLimit(123);
        Thread.sleep(999);
        wlr.rateLimit(123);
        Thread.sleep(999);
        wlr.rateLimit(123);
        Thread.sleep(999);
        wlr.rateLimit(123);
        Thread.sleep(999);
        wlr.rateLimit(123);
        Thread.sleep(999);
        wlr.rateLimit(123);
        Thread.sleep(999);
    }
}