package com.system.rateLimiter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WindowRateLimiter implements RateLimiter {
    private int reqAllowed;
    private int timeInSec; // in sec

    private HashMap<Integer, List<Integer>> reqMapping;


    public WindowRateLimiter(int req, int time) {
        this.reqAllowed = req;
        this.timeInSec = time;
        reqMapping = new HashMap<>();
    }

    public int getReqAllowed() {
        return reqAllowed;
    }

    public void setReqAllowed(int reqAllowed) {
        this.reqAllowed = reqAllowed;
    }

    public int getTimeInSec() {
        return timeInSec;
    }

    public void setTimeInSec(int timeInSec) {
        this.timeInSec = timeInSec;
    }

    @Override
    public boolean rateLimit(int customerId) {
        long currentTime = System.currentTimeMillis();
        int windowSize = timeInSec*1000;
        List<Integer> reqList = reqMapping.get(customerId);
        int currentReqWindow = (int)currentTime/windowSize;
        boolean isAllowed = true;
        if(reqMapping.containsKey(customerId) && reqList.size() >= reqAllowed ) {
            Integer reqWindow = reqList.get(reqList.size()-reqAllowed);
            if(reqWindow == currentReqWindow) {
                isAllowed = false;
            } else {
                reqList.add(currentReqWindow);
            }
        } else {
            reqMapping.put(customerId, Arrays.asList(new Integer[]{currentReqWindow}));
        }

        System.out.println(
                "Request for customer: "+ customerId + " at " + currentTime+ "-> Allowed: "+ isAllowed
        );
        return isAllowed;
    }
}