package com.unicode;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hello on 27-10-2017.
 */

public class Response {

    String _links;
    String count;

    @SerializedName("players")
    List<Post> postList;
}
