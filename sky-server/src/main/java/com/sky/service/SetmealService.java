package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.SetmealVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SetmealService {

    void saveWithFlavor(SetmealDTO setmealDTO);

    PageResult pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    SetmealVO getByIdWithFlavor(Long id);

    void updateWithFlavor(SetmealDTO setmealDTO);

    void startOrStop(Integer status, Long id);

    void deleteBatch(List<Long> ids);
}
