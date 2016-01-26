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

import models.Quote;
import ninja.FilterWith;
import ninja.Result;
import ninja.Results;
import ninja.appengine.AppEngineFilter;
import antlr.StringUtils;

import com.google.inject.Singleton;

import dao.QuoteDao;

@Singleton
@FilterWith(AppEngineFilter.class)
public class ApplicationController {
	
	private final static String INDEX = "views/ApplicationController/index.ftl.html";
	
	@Inject
	QuoteDao quoteDao;

	public Result index() {
		return Results.html();
	}
	
	public Result refresh() {		
		Quote quote = quoteDao.getQuote("HSBC");
		
		return Results.html().render("price", getQuotePrice(quote));
	}

	private String getQuotePrice(Quote quote) {
		if (quote == null) {
			System.out.println("quote is null");
			return "N/A";
		}
		
		return String.valueOf(quote.price);		
	}
	
	
	
}
