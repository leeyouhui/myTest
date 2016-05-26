package mongo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoDBJDBC {
	public static String mongoUrl = "192.168.6.132:27017";
//	1.
//	public static void main(String[] args) {
//		//连接mongo服务
//		MongoClient mongoClient = new MongoClient(mongoUrl);
//		//连接数据库
//		MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
//		System.out.println("Connect to database successfully");
//	}
	
//	2.
//	public static void main(String[] args) {
//		//连接到MongoDB服务 如果是远程连接可以替换“localhost”为服务器所在IP地址  
//        //ServerAddress()两个参数分别为 服务器地址 和 端口  
//        ServerAddress serverAddress = new ServerAddress("192.168.6.132",27017);  
//        List<ServerAddress> addrs = new ArrayList<ServerAddress>();  
//        addrs.add(serverAddress);  
//          
//        //MongoCredential.createScramSha1Credential()三个参数分别为 用户名 数据库名称 密码  
//        MongoCredential credential = MongoCredential.createScramSha1Credential("username", "databaseName", "password".toCharArray());  
//        List<MongoCredential> credentials = new ArrayList<MongoCredential>();  
//        credentials.add(credential);  
//          
//        //通过连接认证获取MongoDB连接  
//        MongoClient mongoClient = new MongoClient(addrs,credentials);  
//          
//        //连接到数据库  
//        MongoDatabase mongoDatabase = mongoClient.getDatabase("databaseName");  
//        System.out.println("Connect to database successfully");
//	}
	public static void main(String[] args) {
		// 连接到 mongodb 服务
	      MongoClient mongoClient = new MongoClient( "192.168.6.132" , 27017 );
	         
	       
	      // 连接到数据库
	      MongoDatabase mongoDatabase = mongoClient.getDatabase("mycol");  
	      System.out.println("Connect to database successfully");
	      // 创建集合
//	      mongoDatabase.createCollection("test");
	      // 获取集合
	      MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("test");
	      //插入文档
	      Document document = new Document();
	      document.append("name", "lll");
	      document.append("age", 22);
	      document.append("msg", "aaaaa");
	      List<Document> documents = new ArrayList<Document>();  
	      documents.add(document);
//	      mongoCollection.insertOne(document);
//	      mongoCollection.insertMany(documents);
	      
	      //更新文档
	      mongoCollection.updateMany(Filters.eq("name", "lll"), new Document("$set",new Document("name","kkk")));
	      
	      //删除文档
	      mongoCollection.deleteOne(Filters.eq("name", "kkk"));
	      mongoCollection.deleteMany(Filters.eq("name", "lll"));
	      
	      // 查询所有文档
	      FindIterable<Document> findIterable = mongoCollection.find();
	      MongoCursor<Document> mongoCursor = findIterable.iterator();
	      while(mongoCursor.hasNext()){
	    	  Document document1 = mongoCursor.next();
	    	  System.out.println(document1);
	    	  System.out.println(document1.getString("name"));
	      }
	      
	      System.out.println("操作成功");
	}
}
