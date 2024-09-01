package com.app.ecommerce.test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.app.application.dto.OptionChoiceDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;
import com.app.domain.entity.EChoiceEffect;
import com.app.domain.entity.EStatusChoice;

import jakarta.transaction.Transactional;

@SpringBootTest
class ProductOptionTest {

	@Autowired
	private ProductOptionService productOptionService;

	@Test
	// @Transactional
	// @Rollback
	public void testCreate() {
		List<OptionChoiceDTO> choices = List.of(
				new OptionChoiceDTO("choiceOption1", EChoiceEffect.decreased.name(), 0.0, EStatusChoice.available.name()),
				new OptionChoiceDTO("choiceOption1", EChoiceEffect.increased.name(), 12.0, EStatusChoice.suspended.name()));
		ProductOptionDTO productOptionDTO = new ProductOptionDTO(
				"OptionName",
				false,
				false,
				0,
				choices);
		ProductOptionDTO saveProductOptionDTO = productOptionService.create(productOptionDTO);
		assertThat(saveProductOptionDTO).isNotNull();
		assertThat(saveProductOptionDTO.getOptionName()).isEqualTo("OptionName");
		assertThat(saveProductOptionDTO.getChoices()).isNotEmpty();
		assertThat(saveProductOptionDTO.getChoices().get(0).getName()).isEqualTo("choiceOption1");
	}

}
