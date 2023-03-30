package vn.com.devmaster.services.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorEnum {
    BUILDING_NOT_FOUND("Không tìm thấy trường học", "building_not_found"),
    BUILDING_CODE_EXIST("Code đã tồn tại", "building_code_exist"),
    USER_NOT_FOUND("Tài khoản hoặc mật khẩu không chính xác", "user_not_found");
    private String msg;
    private String code;
}
