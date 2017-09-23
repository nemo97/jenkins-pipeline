package com;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;



/**
 * Created by Administrator on 9/21/2017.
 */
public class ElasticSearchIndex {

    TransportClient client =  null;

    @Before
    public void before(){

        Settings settings = Settings.builder()
                .put("cluster.name", "elasticsearch")
                //.put("client.transport.sniff", false)
                .build();
        try {

            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.1.148"), 9300));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    @After
    public void after(){


        try {

            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void indexTest(){


        Map<String, Object> json = new HashMap<String, Object>();
        json.put("user","kimchy");
        json.put("postDate",new Date());
        json.put("message","trying out Elasticsearch");

        IndexResponse response = client.prepareIndex("twitter", "tweet")
                .setSource(json)
                .get();


        // Index name
        String _index = response.getIndex();
// Type name
        String _type = response.getType();
// Document ID (generated or not)
        String _id = response.getId();
// Version (if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();
// status has stored current instance statement.
//        RestStatus status = response.status();

        System.out.println(".._index.."+_index+" .._id "+_id+".._version=>"+_version);
    }

}
