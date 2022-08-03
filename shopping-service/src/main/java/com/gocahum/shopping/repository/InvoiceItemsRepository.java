package com.gocahum.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gocahum.shopping.entity.InvoiceItem;

public interface InvoiceItemsRepository extends JpaRepository< InvoiceItem, Long>{

}
