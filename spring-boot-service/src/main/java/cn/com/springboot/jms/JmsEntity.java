package cn.com.springboot.jms;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author shenjies88
 */
@Data
@AllArgsConstructor
public class JmsEntity {

    private String to;

    private String body;

    @Override
    public String toString() {
        return String.format("Email{to=%s, body=%s}", getTo(), getBody());
    }
}
