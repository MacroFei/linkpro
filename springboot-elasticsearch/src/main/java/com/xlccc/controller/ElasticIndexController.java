package com.xlccc.controller;

import com.alibaba.fastjson.JSON;
import com.xlccc.common.ResponseResult;
import com.xlccc.common.enums.ResponseCode;
import com.xlccc.elastic.service.BaseElasticService;
import com.xlccc.vo.IdxVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("/elastic")
@RestController
public class ElasticIndexController {
    @Autowired
    BaseElasticService baseElasticService;

    @GetMapping(value = "/")
    public ResponseResult index(String index) {
        return new ResponseResult();
    }

    @PostMapping(value = "/createIndex")
    public ResponseResult createIndex(@RequestBody IdxVo idxVo) {
        ResponseResult response = new ResponseResult();

        try {
            if (!baseElasticService.isExistsIndex(idxVo.getIdxName())) {
                String idxSql = JSON.toJSONString(idxVo.getIdxSql());
                log.warn("idxName={}. idxSql={}", idxVo.getIdxName(), idxSql);
                baseElasticService.createIndex(idxVo.getIdxName(), idxSql);
            } else {
                response.setStatus(false);
                response.setCode(ResponseCode.DUPLICATEKEY_ERROR_CODE.getCode());
                response.setMsg("索引已经存在，不允许创建");
            }
        } catch (Exception e) {
            response.setStatus(false);
            response.setCode(ResponseCode.ERROR.getCode());
            response.setMsg(ResponseCode.ERROR.getMsg());
        }
        return response;
    }


    @GetMapping(value = "/exist/{index}")
    public ResponseResult indexExist(@PathVariable(value = "index") String index) {
        ResponseResult response = new ResponseResult();

        try {
            if (!baseElasticService.isExistsIndex(index)) {
                log.error("index={},不存在", index);
                response.setCode(ResponseCode.RESOURCE_NOT_EXIST.getCode());
                response.setMsg(ResponseCode.RESOURCE_NOT_EXIST.getMsg());
            } else {
                response.setMsg("索引已经存在，" + index);
            }
        } catch (Exception e) {
            response.setCode(ResponseCode.NETWORK_ERROR.getCode());
            response.setMsg(ResponseCode.NETWORK_ERROR.getMsg());
            response.setStatus(false);
        }

        return response;
    }

    @GetMapping(value = "del/{index}")
    public ResponseResult indexDel(@PathVariable(value = "index") String index) {
        ResponseResult response = new ResponseResult();

        try {
            baseElasticService.deleteIndex(index);
        } catch (Exception e) {
            response.setCode(ResponseCode.NETWORK_ERROR.getCode());
            response.setMsg("调用ElasticSearch 失败");
            response.setStatus(false);
        }
        return response;

    }
}
