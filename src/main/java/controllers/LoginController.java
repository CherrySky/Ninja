package controllers;

import javax.inject.Inject;

import models.Contact;
import ninja.Context;
import ninja.FilterWith;
import ninja.Result;
import ninja.Results;
import ninja.appengine.AppEngineFilter;
import services.GreetingService;

import com.google.inject.Singleton;

@Singleton
@FilterWith(AppEngineFilter.class)
public class LoginController {
	
	@Inject
    GreetingService greeter;
	
	public Result index() {
		return Results.html();
	}
	
	public Result injection(Context context) {
		System.out.println("greeter: " + greeter.hashCode());
        return Results.json().render(greeter.hello());
    }

	public Result postContactForm(Context context, Contact contact) {

		System.out.println(contact);

		return Results.html();
	}
}
