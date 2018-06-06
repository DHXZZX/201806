package com.dhxz.springtest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Serializable{
    private static final long serialVersionUID = -5889835083572809460L;

    private String accessKey;
    private String refreshKey;

    private String domainId;
    private String clientId;
    private String clientPrincipal;
    private String clientName;
    private String deviceId;
    private String devicePlatform;

    private List<String> requestScopes;
    private List<String> approvedScopes;

    private long issuedTime;
    private long expireTime;
}
