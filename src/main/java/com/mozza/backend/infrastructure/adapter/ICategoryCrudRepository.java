package com.mozza.backend.infrastructure.adapter;

import com.mozza.backend.domain.model.Category;
import com.mozza.backend.infrastructure.entity.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryCrudRepository extends CrudRepository<CategoryEntity,Long> {


}
