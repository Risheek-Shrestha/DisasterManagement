package com.risheek.disastermanagement.dto;

import com.risheek.disastermanagement.entity.Role;
import com.risheek.disastermanagement.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String username;
    private String email;
    private Role role;
    private String associatedZone;

    public static UserResponse from(User user) {


        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .role(user.getRole())
                .associatedZone(user.getAssociatedZone())
                .build();
    }
}