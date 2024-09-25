package com.app.infrastructure.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.app.infrastructure.entity.OptionChoiceEntity;

public interface OptionChoiceJpaRepository extends JpaRepository<OptionChoiceEntity,String>{
    public void deleteAllByProductOptionId(String productOptionId);
}
