package priv.liuchu.toolbox.common;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class Result implements Serializable {

    private static final long serialVersionUID = 8940713503910790931L;

    private final String code;

    private final String msg;

    private final Object result;

    private final String tips;
}
