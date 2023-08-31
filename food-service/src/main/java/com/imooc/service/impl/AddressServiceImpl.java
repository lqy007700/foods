package com.imooc.service.impl;

import com.imooc.enums.YesOrNo;
import com.imooc.mapper.UserAddressMapper;
import com.imooc.pojo.UserAddress;
import com.imooc.pojo.bo.AddressBO;
import com.imooc.service.AddressService;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserAddressMapper userAddressMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<UserAddress> queryAll(String userId) {
        UserAddress ua = new UserAddress();
        ua.setUserId(userId);

        return userAddressMapper.select(ua);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void addNewUserAddress(AddressBO addressBO) {
        List<UserAddress> uaList = this.queryAll(addressBO.getUserId());
        int isDefault = 1;
        if (uaList == null || uaList.isEmpty()) {
            isDefault = 0;
        }

        UserAddress ua = new UserAddress();
        BeanUtils.copyProperties(addressBO, ua);
        ua.setId(sid.nextShort());
        ua.setIsDefault(isDefault);
        ua.setCreatedTime(new Date());
        ua.setUpdatedTime(new Date());

        userAddressMapper.insert(ua);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddress(AddressBO addressBO) {
        String addressId = addressBO.getAddressId();

        UserAddress ua = new UserAddress();
        BeanUtils.copyProperties(addressBO, ua);

        ua.setId(addressId);
        ua.setUpdatedTime(new Date());
        userAddressMapper.updateByPrimaryKey(ua);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserAddress(String userId, String addressId) {
        UserAddress ua = new UserAddress();
        ua.setId(addressId);
        ua.setUserId(userId);
        userAddressMapper.delete(ua);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void updateUserAddressToBeDefault(String userId, String addressId) {
        UserAddress queryUa = new UserAddress();
        queryUa.setIsDefault(YesOrNo.YES.type);
        queryUa.setUserId(userId);
        List<UserAddress> select = userAddressMapper.select(queryUa);
        for (UserAddress ua : select) {
            ua.setIsDefault(YesOrNo.NO.type);
            userAddressMapper.updateByPrimaryKeySelective(ua);
        }

        UserAddress userAddress = new UserAddress();
        userAddress.setId(addressId);
        userAddress.setUserId(userId);
        userAddress.setIsDefault(YesOrNo.YES.type);
        userAddressMapper.updateByPrimaryKeySelective(userAddress);
    }
}
