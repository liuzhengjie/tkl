package com.tingkelai.api.sys;

import com.tingkelai.domain.dict.DictCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 系统用户信息相关api
 *
 * @author liuzhengjie
 * @date 2018-11-27 11:41:26
 * @version 1.0
 */
@Api(value = "sys", description = "系统相关api")
public interface SysDictApi<VO> {

    @ApiOperation(value = "获取用户数据字典分类列表", nickname = "sysDictCategoryListGet", response = List.class,
            notes = "每个公司都有自己的数据字典", tags={ "sys/dict", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dict/category/list",
            method = RequestMethod.GET)
    List<DictCategory> sysDictCategoryListGet();

    @ApiOperation(value = "删除数据字典分类", nickname = "sysDictCategoryDelete", notes = "", tags={ "sys/dict", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dict/category",
            params = {"id"},
            method = RequestMethod.DELETE)
    Map<String, String> sysDictCategoryDelete();


    @ApiOperation(value = "获取数据字典分类信息", nickname = "sysDictCategoryGet", notes = "",
            response = DictCategory.class, tags={ "sys/dict", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dict/category",
            method = RequestMethod.GET)
    DictCategory sysDictCategoryGet();

    @ApiOperation(value = "添加数据字典分类", nickname = "sysDictCategoryPost", notes = "",
            response = Map.class, tags={ "sys/dict", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dict/category",
            params = {"id", "name", "code", "remarks"},
            method = RequestMethod.POST)
    Map<String, String> sysDictCategoryPost(VO vo);


    @ApiOperation(value = "修改数据字典分类", nickname = "sysDictCategoryPut", notes = "",
            response = Map.class, tags={ "sys/dict", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dict/category",
            params = {"id", "name", "code", "remarks"},
            method = RequestMethod.PUT)
    Map<String, String> sysDictCategoryPut(VO vo);


    @ApiOperation(value = "删除数据字典分类项", nickname = "sysDictCategoryItemDelete", notes = "", tags={ "sys/dict", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dict/category/item",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> sysDictCategoryItemDelete(VO vo);


    @ApiOperation(value = "获取数据字典分类项信息", nickname = "sysDictCategoryItemGet", notes = "", tags={ "sys/dict", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dict/category/item",
            method = RequestMethod.GET)
    ResponseEntity<Void> sysDictCategoryItemGet(VO vo);


    @ApiOperation(value = "获取指定数据字典分类的所有分类项", nickname = "sysDictCategoryItemListPost", notes = "", tags={ "sys/dict", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dict/category/item/list",
            method = RequestMethod.POST)
    ResponseEntity<Void> sysDictCategoryItemListPost(VO vo);


    @ApiOperation(value = "添加数据字典分类项", nickname = "sysDictCategoryItemPost", notes = "", tags={ "sys/dict", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dict/category/item",
            method = RequestMethod.POST)
    ResponseEntity<Void> sysDictCategoryItemPost(VO vo);


    @ApiOperation(value = "修改数据字典分类项", nickname = "sysDictCategoryItemPut", notes = "", tags={ "sys/dict", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/sys/dict/category/item",
            method = RequestMethod.PUT)
    ResponseEntity<Void> sysDictCategoryItemPut(VO vo);
}

