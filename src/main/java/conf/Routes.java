/**
 * Copyright (C) 2012 the original author or authors.
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

package conf;

import ninja.AssetsController;
import ninja.Results;
import ninja.Router;
import ninja.application.ApplicationRoutes;
import controllers.ApplicationController;
import controllers.FeedController;
import controllers.LoginController;

public class Routes implements ApplicationRoutes {

	private static final String INDEX = "index";
	
	@Override
	public void init(Router router) {

		// index
		router.GET().route("/").with(ApplicationController.class, INDEX);
		router.GET().route("/hello_world.json").with(ApplicationController.class, "helloWorldJson");
		
		// login
		router.GET().route("/login").with(LoginController.class, INDEX);
		
		// feed
		router.GET().route("/feed").with(FeedController.class, INDEX);


		// /////////////////////////////////////////////////////////////////////
		// Assets (pictures / javascript)
		// /////////////////////////////////////////////////////////////////////
		router.GET().route("/assets/webjars/{fileName: .*}").with(AssetsController.class, "serveWebJars");
		router.GET().route("/assets/{fileName: .*}").with(AssetsController.class, "serveStatic");

		// /////////////////////////////////////////////////////////////////////
		// Index / Catchall shows index page
		// /////////////////////////////////////////////////////////////////////
		router.GET().route("/.*").with(ApplicationController.class, "index");
	}

	private void renderAStaticPageSimplyWithoutAnyController(Router router) {
		// a GET request to "/" will be redirect to "/dashboard"
		router.GET().route("/").with(Results.redirect("/dashboard"));

		// show a static page
		router.GET().route("/dashboard").with(Results.html().template("/dashboard.html"));
	}

	private void regexRoutes(Router router) {
		// matches for instance "/assets/00012", "/assets/12334", ...
		router.GET().route("/assets/\\d*").with(AssetsController.class, "serveDigits");

		// matches for instance "/assets/myasset.xml", "/assets/boing.txt", ...
		router.GET().route("/assets/.*").with(AssetsController.class, "serveArbitrary");
	}

}
