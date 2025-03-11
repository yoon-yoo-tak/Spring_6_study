package spring6study.config_aop.collectionProperty;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Getter
public class MapProperty {
    @Value("#{${test.profile}}")
    private Map<String, String> map;
}
