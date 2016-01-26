package services.scheduler;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import ninja.lifecycle.Start;
import ninja.scheduler.Schedule;
import dao.QuoteDao;

@Singleton
public class FeedService {
	
	@Inject
    QuoteDao quoteDao;
	
	private int i = 0;
	
	private final static String HSBC = "HSBC";
	
	@Start(order=100)
	@Schedule(delay = 5, initialDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void doStuffEach60Seconds() {
		int value = ++i;
        System.out.println("<<<<<<<<<<<<< i: " + value);
		quoteDao.setQuote(HSBC, value);
		System.out.println("setQuote finished: " + value);
		
    }

}
