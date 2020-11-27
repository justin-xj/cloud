package com.justin.esstudy.service.impl;

import com.justin.esstudy.service.BaseElasticsearchService;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BaseElasticsearchServiceImlp implements BaseElasticsearchService {

    @Autowired
    private RestHighLevelClient highLevelClient;

    @Override
    public boolean indexExist(String idxName) throws IOException {
        GetIndexRequest request = new GetIndexRequest(idxName);
        request.local(false);
        request.humanReadable(true);
        request.includeDefaults(false);
        request.indicesOptions(IndicesOptions.lenientExpandOpen());
        return highLevelClient.indices().exists(request, RequestOptions.DEFAULT);
    }
}
