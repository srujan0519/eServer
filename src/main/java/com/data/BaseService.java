package com.data;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class BaseService {
  public  MongoClient mongo = new MongoClient( "localhost" , 27017 );
  public MongoDatabase database = mongo.getDatabase("myDb");
}
