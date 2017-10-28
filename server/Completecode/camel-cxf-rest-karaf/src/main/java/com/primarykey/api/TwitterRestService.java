package com.primarykey.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;



/**
 * Rest interface exposed to the consumers.
 * @author ravisha
 *
 */
@Path("/twitter")
@Consumes(value = "application/xml,application/json,text/plain")
@Produces(value = "application/xml,application/json,text/plain")
public interface TwitterRestService {
  /**
    * The GET twitter service.
    */
   @GET
   @Path("/{id}")
   String getTweet(@PathParam("id") int orderId);
   

   @GET
   @Path("/search/{id}")
   String searchTweet(@PathParam("id") String searchTweet);
   
   
   @GET
   @Path("/timeline")
   String getTimeLine();
   
   
   @GET
   @Path("/retweet")
   String getReTweet();
   
   @GET
   @Path("/screenname")
   String getScreenName();
   
   
   @GET
   @Path("/usercategories")
   String getSuggestedUserCategories();
   
   @GET
   @Path("/trends")
   String getAvaialbleTrends();
   

   @GET
   @Path("/followerids")
   String getFollowersIds();
   
   @GET
   @Path("/savedSearch")
   String getSavedSearches();
   
   
   
 }

