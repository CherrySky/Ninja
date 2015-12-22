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

import ninja.appengine.AppEngineModule;
import services.FeedServiceAction;
import services.GreetingService;
import services.GreetingServiceImpl;
import services.HttpClientService;
import services.HttpService;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

@Singleton
public class Module extends AbstractModule {
    

    protected void configure() {
    	bind(GreetingService.class).to(GreetingServiceImpl.class);
    	bind(HttpService.class).to(HttpClientService.class);
    	
    	bind(FeedServiceAction.class);
    	
    	install(new AppEngineModule());
    }

}
