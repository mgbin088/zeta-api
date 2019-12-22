package xyz.erupt.openApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import xyz.erupt.openApi.impl.SqlOpenApi;
import xyz.erupt.openApi.service.OpenApiService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liyuepeng on 2019-08-14.
 */
@RestController
@RequestMapping("/open-api/sql")
public class OpenSqlApiController {

    @Autowired
    private SqlOpenApi sqlOpenApi;

    @Autowired
    private OpenApiService openApiService;

    /**
     * @param fileName   文件名称
     * @param sqlElement xml中sql元素
     * @param pageSize   数据量
     * @param pageIndex  页码，索引从1开始
     * @return result
     */
    @RequestMapping("/query/{fileName}/{elementName}")
    @ResponseBody
    public Object query(@PathVariable("fileName") String fileName,
                        @PathVariable("elementName") String elementName,
                        HttpServletRequest request) {
        return openApiService.queryByCache(fileName, elementName, sqlOpenApi);
    }

//    @RequestMapping("/modify/{fileName}/{sqlElement}")
//    @ResponseBody
//    @Transactional
//    public Object modify(@PathVariable("fileName") String fileName,
//                         @PathVariable("elementName") String elementName,
//                         HttpServletRequest request) {
//        return openApiService.xmlToQuery(fileName, elementName, request,
//                (element, sql) -> entityManager.createNativeQuery(sql).executeUpdate());
//    }

}