package com.app.domain.usecase;

import com.app.domain.models.OptionChoice;

public interface OptionChoiceUseCase extends BaseUseCase<OptionChoice>{
    public void deleteAllByProductOptionId(String id);
}
