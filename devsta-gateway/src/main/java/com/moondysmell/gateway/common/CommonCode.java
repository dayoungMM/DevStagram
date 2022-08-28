package com.moondysmell.gateway.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

@Getter
@JsonFormat(shape = Shape.OBJECT)
public enum CommonCode {
    // SUCCESS
    SUCCESS(200, 200, "성공"),
    OAUTH_CHECK_SUCCESS(200, 201, "Oauth 로그인 확인"),
    // FAIL
    FAIL(500, -1, "실패. 알 수 없는 오류"),

    //-1000: USER
    NOT_EXIST_ID(400,-1000, "존재하지 않는 이메일입니다."),
    WRONG_PASSWORD(400, -1001, "비밀번호가 일치하지 않습니다."),
    USER_ALREADY_EXIST(400, -1002, "해당 아이디가 이미 존재합니다."),
    NICKNAME_ALREADY_EXIT(400, -1003 , "중복된 닉네임입니다." ),
    NO_AUTH_TOKEN(400, -1004, "헤더에 Authorization 토큰이 없습니다."),
    INVALID_AUTH_TOKEN(400, -1005, "Authorization 토큰이 유효하지 않습니다.");


    //-2000: MeetUp

    //-3000: Posts

    //-4000: Gateway

    private int status;
    private int code;
    private String message;


    CommonCode(int status, int code, String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }

    public static CommonCode of(int code) {
        return Arrays.stream(values())
                .filter(commonCode -> commonCode.code == code)
                .findAny()
                .orElse(FAIL);
    }
}
