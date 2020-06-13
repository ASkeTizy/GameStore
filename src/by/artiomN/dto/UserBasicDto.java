package by.artiomN.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class UserBasicDto implements Serializable {
    private static final long serialVersionUID = -2714582697964101214L;
    private String login;
    private String password;

}
