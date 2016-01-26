package dao;

import javax.inject.Inject;

import models.Quote;

import com.google.inject.Provider;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;

public class QuoteDao {

	@Inject
    Provider<Objectify> objectify;
	
	public Quote getQuote(String stockName) {
		return objectify.get().load().type(Quote.class).filter("stockName", stockName).first().now();
	}
	
	public void setQuote(String stockName, Integer price) {
		Objectify ofy = ObjectifyService.ofy();
		Quote quote = new Quote(stockName);
		quote.price = price;
		ofy.save().entities(quote).now();
	}
	
}
