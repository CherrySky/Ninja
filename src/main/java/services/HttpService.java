package services;

import models.HttpResponse;

public interface HttpService {

	HttpResponse query(String url) throws Exception;
}
