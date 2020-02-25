package com.xlccc.controller;

import com.xlccc.common.ResponseResult;
import com.xlccc.common.enums.ResponseCode;
import com.xlccc.elastic.entity.ElasticEntity;
import com.xlccc.elastic.service.BaseElasticService;
import com.xlccc.vo.ElasticDataVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/elasticMgr")
@RestController
public class ElasticMgrController {
    @Autowired
    private BaseElasticService baseElasticService;


    @PostMapping(value = "/add")
    public ResponseResult add(@RequestBody ElasticDataVo elasticDataVo) {
        ResponseResult response = getResponseResult();
        try {
            if (!StringUtils.isNotEmpty(elasticDataVo.getIdxName())) {
                response.setCode(ResponseCode.PARAM_ERROR_CODE.getCode());
                response.setMsg("索引为空，不允许提交");
                response.setStatus(false);
                log.warn("索引为空");
                return response;
            }
            ElasticEntity elasticEntity = new ElasticEntity();
            elasticEntity.setId(elasticDataVo.getElasticEntity().getId());
            elasticEntity.setData(elasticDataVo.getElasticEntity().getData());
            baseElasticService.insertOrUpdateOne(elasticDataVo.getIdxName(), elasticEntity);
        } catch (Exception ex) {
            response.setCode(ResponseCode.ERROR.getCode());
            response.setMsg(ResponseCode.ERROR.getMsg());
            response.setStatus(false);
            log.error("插入数据异常，metadataVo={},异常信息={}", elasticDataVo.toString(), ex.getMessage());
        }
        return response;
    }

    public ResponseResult getResponseResult() {
        return new ResponseResult();
    }
}
