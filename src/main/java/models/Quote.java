package models;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
@Index
public class Quote {
	
	@Id
	public Long id;	
	public String stockName;	
	public Integer price;
	
	public Quote() {}
	
	public Quote(String stockName) {
		this.stockName = stockName;		
	}

}
