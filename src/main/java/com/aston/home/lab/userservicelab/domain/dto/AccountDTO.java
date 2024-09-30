package com.aston.home.lab.userservicelab.domain.dto;

public record AccountDTO(
        Long id,
        String userId,
        Long cashAccount,
        Boolean status) {
}
