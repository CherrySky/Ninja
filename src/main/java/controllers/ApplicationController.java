/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import javax.inject.Inject;

import models.Contact;
import ninja.Context;
import ninja.FilterWith;
import ninja.Result;
import ninja.Results;
import ninja.appengine.AppEngineFilter;
import ninja.session.FlashScope;
import ninja.session.Session;
import services.GreetingService;

import com.google.inject.Singleton;

@Singleton
@FilterWith(AppEngineFilter.class)
public class ApplicationController {

	@Inject
	GreetingService greeter;

	public Result index() {
		return Results.html().render("greeter", greeter.hello());
	}

	public Result helloWorldJson() {

		SimplePojo simplePojo = new SimplePojo();
		simplePojo.content = "Hello World! Hello Json!";

		return Results.json().render(simplePojo);

	}
	
	public Result postContactForm(Context context, Contact contact) {

		System.out.println(contact);

		return Results.html();
	}

	public Result injection(Context context) {
		// return Results.html().render("greeting", greeter.hello());
		System.out.println("greeter: " + greeter.hashCode());
		// return Results.json().render(greeter.hello());
		return Results.html().render(greeter.hello());
	}

	public Result getUserNameFromSession(Session session, FlashScope flashScope) {

		String username = session.get("username");

		// flashScope.success("login.success");
		flashScope.error("login.error");

		return Results.html();
		// return Results.json().render(username);

	}

	

	public static class SimplePojo {

		public String content;

	}
}
