package services;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import ninja.cache.NinjaCache;
import ninja.scheduler.Schedule;

import com.google.inject.Singleton;

@Singleton
public class FeedServiceAction implements FeedService {
	
	@Inject
	NinjaCache ninjaCache;

	int i = 0;
	
	@Schedule(delay = 30, initialDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void grepFeed() {
		ninjaCache.set("id", i++, "30s");
    }

}
