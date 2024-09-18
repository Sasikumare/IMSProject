package com.example.IMSProject.repository;

import com.example.IMSProject.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
