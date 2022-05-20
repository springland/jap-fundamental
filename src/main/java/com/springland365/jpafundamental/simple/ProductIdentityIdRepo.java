package com.springland365.jpafundamental.simple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductIdentityIdRepo extends JpaRepository<ProductIdentityId, Long> {
}
