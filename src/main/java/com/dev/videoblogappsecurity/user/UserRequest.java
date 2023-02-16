package com.dev.videoblogappsecurity.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {

    private String username;
    private String password;
    private String fullname;
}
