package com.app.infrastructure.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.domain.entity.OptionChoiceEntity;
import com.app.domain.repositories.IOptionChoiceRepository;

public interface OptionChoiceJpaRepository extends JpaRepository<OptionChoiceEntity, UUID>, IOptionChoiceRepository {

}
