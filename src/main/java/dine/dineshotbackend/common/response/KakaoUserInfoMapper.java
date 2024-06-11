package dine.dineshotbackend.common.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class KakaoUserInfoMapper {
    private long id;
    private Map<String,String> properties;

    // Getters and Setters
}

