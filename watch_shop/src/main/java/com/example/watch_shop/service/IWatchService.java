package com.example.watch_shop.service;

import com.example.watch_shop.model.Watch;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IWatchService {
    Page<Watch> findAll(PageRequest pageRequest);
    Page<Watch> findByType(Integer id, PageRequest pageRequest);
    Watch findById(Integer id);
}
