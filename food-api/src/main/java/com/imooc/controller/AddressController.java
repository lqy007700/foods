package com.imooc.controller;

import com.imooc.pojo.UserAddress;
import com.imooc.pojo.bo.AddressBO;
import com.imooc.service.AddressService;
import com.imooc.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "地址管理", tags = {"地址管理"})
@RestController
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;


    @ApiOperation(value = "查询用户收货地址列表", notes = "查询用户收货地址列表", httpMethod = "POST")
    @PostMapping("/list")
    public JSONResult list(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId
    ) {
        if (StringUtils.isBlank(userId)) {
            return JSONResult.errorMsg("参数错误");
        }

        List<UserAddress> ua = addressService.queryAll(userId);
        return JSONResult.ok(ua);
    }

    @ApiOperation(value = "新增地址", notes = "查询用户收货地址列表", httpMethod = "POST")
    @PostMapping("/add")
    public JSONResult add(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestBody AddressBO addressBO
    ) {

        JSONResult jsonResult = checkAddress(addressBO);
        if (jsonResult.getStatus() != 200) {
            return jsonResult;
        }

        System.out.println(addressBO);

        addressService.addNewUserAddress(addressBO);
        return JSONResult.ok();
    }

    @ApiOperation(value = "更新地址", notes = "更新地址", httpMethod = "POST")
    @PostMapping("/update")
    public JSONResult update(@RequestBody AddressBO addressBO) {

        JSONResult jsonResult = checkAddress(addressBO);
        if (jsonResult.getStatus() != 200) {
            return jsonResult;
        }
        addressService.updateUserAddress(addressBO);
        return JSONResult.ok();
    }

    @ApiOperation(value = "删除地址", notes = "删除地址", httpMethod = "POST")
    @PostMapping("/delete")
    public JSONResult delete(
            @RequestParam String userId,
            @RequestParam String addressId
    ) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return JSONResult.errorMsg("参数错误");
        }

        addressService.deleteUserAddress(userId, addressId);
        return JSONResult.ok();
    }

    @ApiOperation(value = "设为默认", notes = "设为默认", httpMethod = "POST")
    @PostMapping("/setDefault")
    public JSONResult setDefault(
            @RequestParam String userId,
            @RequestParam String addressId
    ) {
        if (StringUtils.isBlank(userId) || StringUtils.isBlank(addressId)) {
            return JSONResult.errorMsg("参数错误");
        }

        addressService.updateUserAddressToBeDefault(userId, addressId);
        return JSONResult.ok();
    }

    private JSONResult checkAddress(AddressBO addressBO) {
        String receiver = addressBO.getReceiver();
        if (StringUtils.isBlank(receiver)) {
            return JSONResult.errorMsg("收货人不能为空");
        }
        return JSONResult.ok();
    }
}