package com.jt.service;

import com.jt.mapper.RightsMapper;
import com.jt.pojo.Rights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightServiceImpl implements RightsService{
    @Autowired
    private RightsMapper rightsMapper;

    /**
     * 业务: 只查询1-2级数据
     * 难点: 如何封装1级数据下的2级
     * 作业: 利用关联查询实现1-2菜单的封装
     * @return
     */
    @Override
    public List<Rights> getRightsList() {
        //1.查询一级菜单数据 level=1|parent_id=0
        int parentId = 0;
        List<Rights> oneList = rightsMapper.findByParentId(parentId);
        //2.如何查询每一个一级下的二级?
        for (Rights oneRights : oneList) {
            int oneId = oneRights.getId();
            List<Rights> twoList = rightsMapper.findByParentId(oneId);
            oneRights.setChildren(twoList);
        }
        return oneList;
    }





    /*@Override
    public List<Rights> getRightsList() {
        //1.查询一级菜单数据 level=1|parent_id=0
        int parentId = 0;
        List<Rights> oneList = rightsMapper.findByParentId(parentId);
        //2.如何查询每一个一级下的二级?
        for (Rights oneRights : oneList){
            int oneId = oneRights.getId();
            List<Rights> twoList = rightsMapper.findByParentId(oneId);
            oneRights.setChildren(twoList);
        }
        return oneList;
    }*/
}
