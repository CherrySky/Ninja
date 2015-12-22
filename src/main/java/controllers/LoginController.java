package controllers;

import ninja.FilterWith;
import ninja.Result;
import ninja.Results;
import ninja.appengine.AppEngineFilter;

import com.google.inject.Singleton;

@Singleton
@FilterWith(AppEngineFilter.class)
public class LoginController {

	public Result index() {
		return Results.html();
	}
}
