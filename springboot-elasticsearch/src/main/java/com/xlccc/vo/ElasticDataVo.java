package com.xlccc.vo;

import com.xlccc.elastic.entity.ElasticEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElasticDataVo<T> {
    /**
     * 索引名
     */
    private String idxName ;
    /**
     * 数据存储对象
     */
    private ElasticEntity elasticEntity;
}
