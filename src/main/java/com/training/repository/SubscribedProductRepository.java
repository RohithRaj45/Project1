package com.training.repository;

import org.springframework.data.repository.CrudRepository;

import com.training.entity.SubscribedProduct;

public interface SubscribedProductRepository extends CrudRepository<SubscribedProduct,String> {


}
