package com.NimapMachineTest.NimapMachineTest.dto;

public record BaseResponse<T>(Integer resultCode, String resultMessage, T data) {
    public BaseResponse(Integer resultCode, String resultMessage) {
        this(resultCode, resultMessage, null);
    }
}