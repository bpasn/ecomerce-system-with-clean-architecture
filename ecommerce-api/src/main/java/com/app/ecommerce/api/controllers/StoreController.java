package com.app.ecommerce.api.controllers;

import java.util.List;

import org.hibernate.grammars.hql.HqlParser.SecondContext;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.application.dto.ApiResponse;
import com.app.application.dto.StoreDTO;
import com.app.application.interfaces.StoreService;
import com.app.ecommerce.api.request.StoreRequest;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "${api.prefix.route}/store")
@Tag(name = "Stores", description = "Store management API")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService){
        this.storeService = storeService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<StoreDTO>>> getAll(){
        return ResponseEntity.ok(storeService.findAllByUserEmail());
    }
    @GetMapping("find-one")
    public ResponseEntity<ApiResponse<StoreDTO>> findOne(){
        return ResponseEntity.ok(storeService.findFirstByUserEmailOrderByIdDesc());
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StoreDTO>> findById(@PathVariable String id){
        return ResponseEntity.ok(storeService.getByUserEmailAndId(id));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StoreDTO>> create(@RequestBody StoreRequest body){
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setStoreName(body.storeName());
        return ResponseEntity.ok(storeService.create(storeDTO));
    }
}
