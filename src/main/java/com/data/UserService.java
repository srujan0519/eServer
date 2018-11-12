package com.data;

import com.model.User;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import org.json.JSONObject;

import java.util.*;

public class UserService extends BaseService {
    MongoCollection users =database.getCollection("users");
    //ArrayList <ArrayList> usersList = new ArrayList<>();
   static ArrayList <HashMap> usersList = new ArrayList<>();
    public List getAllItems(){
        if (!usersList.isEmpty()) {
            usersList.clear();
        }//List list = null;
        try (MongoCursor<Document> cur = users.find().iterator()) {

            while (cur.hasNext()) {
               // singleUser.clear();
                Document doc = cur.next();
                Set docKeys = doc.keySet();
                Collection docValues = doc.values();
                Iterator keysItr = docKeys.iterator();
                Iterator valuesItr = docValues.iterator();
                HashMap <String,String> singleUser = new HashMap<>();
                singleUser.clear();
                while(keysItr.hasNext())
                {
                    if(valuesItr.hasNext()) {
                        singleUser.put(keysItr.next().toString(), valuesItr.next().toString());
                    }
                }
                usersList.add(singleUser);
                //list = new ArrayList(keysItr.next().toString(),doc.values());
               // userList.add(userList);
            }
            //usersList.add(usersList);
        }
        return usersList;
    }

    public void addNewUser(User user) throws Exception{
        String phn = null;
        ArrayList<String> phnList = new ArrayList<>();
        getAllItems();
        for(int j=0;j<usersList.size();j++){
            HashMap susr = usersList.get(j);
            phn = susr.get("phone").toString();
            phnList.add(phn);
        }

        if (!phnList.contains(user.getPhone())) {
            Document document = new Document()
                    .append("email", user.getEmail())
                    .append("name", user.getName())
                    .append("role", user.getRole())
                    .append("password", user.getPassword())
                    .append("phone", user.getPhone());
            users.insertOne(document);
            System.out.println("Document inserted successfully");
        }
        else{
        throw new Exception("Phone number already exists");
        }
    }
}
