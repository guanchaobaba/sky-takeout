package com.sky.service.impl;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DishServiceImpl implements DishService {

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private DishFlavorMapper dishFlavorMapper;

    /**
     * 新增菜品，同时保存对应的口味数据
     *
     * @param dishDTO
     */
    @Override
    @Transactional
    public void saveWithFlavor(DishDTO dishDTO) {
        log.info("开始处理新增菜品请求：{}", dishDTO);
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);

        // 保存菜品数据
        dishMapper.insert(dish);
        // 获取菜品id
        Long dishId = dish.getId();

        // 保存口味数据
        List<DishFlavor> flavors = dishDTO.getFlavors();
        if (flavors != null && flavors.size() > 0) {
            for (DishFlavor flavor : flavors) {
                flavor.setDishId(dishId);
            }
            //向口味表中插入n条数据
            dishFlavorMapper.insertBatch(flavors);
        }
    }
}
