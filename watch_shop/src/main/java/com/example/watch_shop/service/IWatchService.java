package com.example.watch_shop.service;

import com.example.watch_shop.model.Watch;
import com.example.watch_shop.repository.PostCommentSummary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface IWatchService {
    List<Watch> findAll();
    List<PostCommentSummary> getQuantitySell();

    Page<Watch> findAllWatch(String name, Pageable pageable);

    Watch findByIdWatch(int idWatch);

    void save(Watch watch);

    //    void delete(int id);
    void delete(int isDelete);

    Page<Watch> findAll(PageRequest pageRequest);

    Page<Watch> findByType(Integer id, PageRequest pageRequest);

    Watch findById(Integer id);

    Page<Watch> findByName(String name, PageRequest pageRequest);

    void updateQuantity(Integer qtt, Integer id);
}
