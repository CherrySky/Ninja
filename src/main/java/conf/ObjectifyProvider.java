package conf;

import models.Quote;

import com.google.inject.Provider;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.Closeable;

public class ObjectifyProvider implements Provider<Objectify> {
    
	private static Closeable session;
	
    @Override
    public Objectify get() {
        return ObjectifyService.ofy();
    }
    
    static {
        ObjectifyService.register(Quote.class);
        
        
        System.out.println("<<<<<<<<<<<<< run from static 1");
        setup();
        System.out.println("<<<<<<<<<<<<< run from static 2");
    }

	public static void setup() {
		System.out.println("<<<<<<<<<<<<< run setup");
        //session = ObjectifyService.begin();
		
		Objectify ofy = ObjectifyService.ofy();
		Quote quote = ofy.load().type(Quote.class).first().now();
		
		
		if (quote == null) {
			System.out.println("<<<<<<<<<<<<< add new Quote");
			Quote q = new Quote("HSBC");
			ofy.save().entities(q).now();
			System.out.println("<<<<<<<<<<<<< finished new Quote");
		}
	}
    
    
    
}