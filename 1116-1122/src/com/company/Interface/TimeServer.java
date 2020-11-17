package com.company.Interface;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author progmatic
 */
public class TimeServer {

    private static final List<TimeAware> TIME_AWARES = new ArrayList<>();
    private static final int PERIOD_IN_SEC = 10;

    static{
        TIME_AWARES.add(new LazyGuy());
        TIME_AWARES.add(new HungryGuy());
    }

    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for (TimeAware timeAware : TIME_AWARES) {
                    timeAware.currentTime(LocalDateTime.now());
                }
            }
        };
        Timer timer = new Timer();
        Date startAt = new Date();
        timer.scheduleAtFixedRate(task, startAt, PERIOD_IN_SEC*1000);
    }

}

