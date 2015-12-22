package controllers;

import javax.inject.Inject;

import ninja.FilterWith;
import ninja.Result;
import ninja.Results;
import ninja.appengine.AppEngineFilter;
import ninja.cache.NinjaCache;
import services.FeedServiceAction;

import com.google.inject.Singleton;

@Singleton
@FilterWith(AppEngineFilter.class)
public class FeedController {

	@Inject
	FeedServiceAction feedServiceAction;
	
	@Inject
	NinjaCache ninjaCache;
	
	public Result index() {
		return Results.html().render("price", ninjaCache.get("id"));
	}
	
}
