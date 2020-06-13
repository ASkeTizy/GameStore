package by.artiomN.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
public class InputMessageDto implements Serializable {

    private static final long serialVersionUID = 9144557285735230887L;
    private String message;

    @Override
    public String toString() {
        return "InputMessageDto{" +
                "message='" + message + '\'' +
                '}';
    }
}
