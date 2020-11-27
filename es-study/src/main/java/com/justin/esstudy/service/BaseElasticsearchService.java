package com.justin.esstudy.service;

import java.io.IOException;

public interface BaseElasticsearchService {

    /**
     * 判断某个索引是否存在
     * @param idxName 索引名称
     * @return
     */
    boolean indexExist(String idxName) throws IOException;
}
