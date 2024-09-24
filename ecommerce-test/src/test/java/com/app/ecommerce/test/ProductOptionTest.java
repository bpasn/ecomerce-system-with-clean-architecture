package com.app.ecommerce.test;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.OptionChoiceDTO;
import com.app.application.dto.ProductOptionDTO;
import com.app.application.interfaces.ProductOptionService;
import com.app.domain.models.EChoiceEffect;
import com.app.domain.models.EStatusChoice;


@SpringBootTest
class ProductOptionTest {

	@Autowired
	private ProductOptionService productOptionService;

	@Test
	// @Transactional
	// @Rollback
	public void testCreate() {
		List<OptionChoiceDTO> choices = List.of(
				new OptionChoiceDTO("choiceOption1", EChoiceEffect.decreased.name(), new BigDecimal(0.0), EStatusChoice.available.name()),
				new OptionChoiceDTO("choiceOption1", EChoiceEffect.increased.name(), new BigDecimal(12.0), EStatusChoice.suspended.name()));
		ProductOptionDTO productOptionDTO = new ProductOptionDTO(
				"OptionName",
				false,
				false,
				0,
				choices);
		ApiResponse<ProductOptionDTO> saveProductOptionDTO = productOptionService.create(productOptionDTO);
		assertThat(saveProductOptionDTO).isNotNull();
		assertThat(saveProductOptionDTO.getPayload().getOptionName()).isEqualTo("OptionName");
		assertThat(saveProductOptionDTO.getPayload().getChoices()).isNotEmpty();
		assertThat(saveProductOptionDTO.getPayload().getChoices().get(0).getName()).isEqualTo("choiceOption1");
	}

}
