package com.data;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;

public class TestConncetion {
    String userName;
 public TestConncetion(String userName)
 {
     this.userName = userName;
 }

    //public static void main( String args[] ) {
public String checkCon(){
        // Creating a Mongo client
        MongoClient mongo = new MongoClient( "localhost" , 27017 );

        // Creating Credentials
        MongoCredential credential;
        credential = MongoCredential.createCredential(userName, "ecart",
                "srujan".toCharArray());
        System.out.println("Connected to the database successfully");



        // Accessing the database
        MongoDatabase database = mongo.getDatabase("myDb");
      //  System.out.println("Credentials ::"+ credential);
    return   "Credentials ::"+ credential;
}
}
