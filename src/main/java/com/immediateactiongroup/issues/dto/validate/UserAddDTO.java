package com.immediateactiongroup.issues.dto.validate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by beishan on 2017/9/2.
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserAddDTO {
    private String username;
    private String password;
    private Integer role;

}
