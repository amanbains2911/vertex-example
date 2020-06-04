package com.aman.app.vertex_example;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.core.json.Json;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;

/**
 * Hello world!
 *
 */
public class VertexExample 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World of Vertx!" );
        
        //Create vertex
        Vertx vert=Vertx.vertx();
        
        //create Http Server
        HttpServer server=vert.createHttpServer();
        
        //create Router
        Router router=Router.router(vert);
        
        @SuppressWarnings("unused")
		Route handler1=router.post("/getMessage").produces("*/json").handler(routingContext->{
        	HttpServerResponse serverResponse=routingContext.response();
        	serverResponse.setChunked(true).end(Json.encodePrettily(new User(234,"Aman Developer")));
        	serverResponse.write("getMessage \n");
          });
        
            server.requestHandler(router).listen(9090,"127.0.0.1");
        
    }
}
