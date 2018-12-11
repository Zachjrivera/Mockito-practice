package com.zach.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zach.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

}
