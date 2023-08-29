package com.azhar.bookshop.repository;

import com.azhar.bookshop.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepository extends MongoRepository<Address,String> {
}
