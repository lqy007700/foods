package com.imooc.mapper;

import com.imooc.pojo.vo.ItemsCommentVO;
import com.imooc.pojo.vo.SearchItemsVO;
import com.imooc.pojo.vo.ShopCatVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapperCustom {
    List<ItemsCommentVO> queryItemComments(@Param("paramsMap") Map<String, Object> map);

    List<SearchItemsVO> searchItems(@Param("paramsMap") Map<String, Object> map);

    List<SearchItemsVO> searchItemsByThirdCat(@Param("paramsMap") Map<String, Object> map);

    List<ShopCatVO> queryItemsBySpecIds(@Param("paramsList") List<?> specIdsList);

    int decreaseItemSpecStock(@Param("specId") String specId, @Param("pendingCount") int  pendingCount);
}